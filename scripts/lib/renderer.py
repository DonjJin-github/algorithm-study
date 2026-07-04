from itertools import groupby

from lib import config
from lib.client import fetch_baekjoon_meta
from lib.extractor import (
    _git_log,
    scan_baekjoon_steps,
    scan_baekjoon_tiers,
    scan_codetree,
    scan_programmers,
)

_TIERS = {"Bronze": 0, "Silver": 1, "Gold": 2, "Platinum": 3, "Diamond": 4, "Ruby": 5}
_ROMAN = {"I": 1, "II": 2, "III": 3, "IV": 4, "V": 5}


def _diff_key(d: str):
    """'Silver II' 같은 난이도 문자열 → 오름차순 정렬키."""
    parts = (d or "").strip().split()
    if parts and parts[0] in _TIERS:
        roman = _ROMAN.get(parts[1], 3) if len(parts) > 1 else 3
        return (0, _TIERS[parts[0]] * 5 + (5 - roman), d)
    return (9, 9, d)


def _details(summary: str, table: str) -> str:
    return f"<details>\n<summary>{summary}</summary>\n\n{table}\n\n</details>"


def render_baekjoon_tiers() -> str:
    """백준/<티어> 폴더 → 티어별 접이식 표. 난이도는 solved.ac 세부 티어."""
    sections = scan_baekjoon_tiers()
    if not sections:
        return "_백준 폴더가 없습니다._"

    all_ids = [pid for items in sections.values() for pid, _ in items if pid.isdigit()]
    meta = fetch_baekjoon_meta(all_ids)

    order = {"Bronze": 0, "Silver": 1, "Gold": 2, "Platinum": 3, "Diamond": 4, "Ruby": 5}
    blocks: list[str] = []
    for tier in sorted(sections, key=lambda t: order.get(t, 9)):
        rows_data = []
        for pid, title in sections[tier]:
            m = meta.get(pid)
            diff = m["difficulty"] if m else tier
            if not title:
                title = m["title"] if m else "_TODO_"
            rows_data.append((pid, title, diff))
        rows_data.sort(key=lambda x: (_diff_key(x[2]), int(x[0]) if x[0].isdigit() else 0))
        rows = "\n".join(f"| [{p}](https://www.acmicpc.net/problem/{p}) | {t} | {d} |"
                         for p, t, d in rows_data)
        blocks.append(_details(
            f"📁 <b>{tier}</b> · {len(rows_data)}문제",
            f"| 번호 | 제목 | 난이도 |\n| --- | --- | --- |\n{rows}",
        ))
    return "\n".join(blocks)


def render_baekjoon_steps() -> str:
    """백준 단계별로 풀어보기/<단계>/<번호> → 단계별 접이식 표. 제목은 solved.ac."""
    sections = scan_baekjoon_steps()
    if not sections:
        return "_단계별 폴더가 없습니다._"

    all_ids = [pid for ids in sections.values() for pid in ids]
    meta = fetch_baekjoon_meta(all_ids)

    def step_key(name: str):
        head = name.split(".", 1)[0]
        return int(head) if head.isdigit() else 999

    blocks: list[str] = []
    for step in sorted(sections, key=step_key):
        rows_data = []
        for pid in sections[step]:
            m = meta.get(pid)
            if not m:
                config.warnings.append(f"백준 단계별/{step}/{pid} solved.ac 조회 실패")
            rows_data.append((pid, m["title"] if m else "_TODO_", m["difficulty"] if m else "-"))
        rows_data.sort(key=lambda x: _diff_key(x[2]))
        rows = "\n".join(f"| [{p}](https://www.acmicpc.net/problem/{p}) | {t} | {d} |"
                         for p, t, d in rows_data)
        blocks.append(_details(
            f"📁 <b>{step}</b> · {len(rows_data)}문제",
            f"| 번호 | 제목 | 난이도 |\n| --- | --- | --- |\n{rows}",
        ))
    return "\n".join(blocks)


def render_programmers() -> str:
    """프로그래머스/<레벨> → 레벨별 접이식 표."""
    sections = scan_programmers()
    if not sections:
        return "_프로그래머스 폴더가 없습니다._"

    blocks: list[str] = []
    for level in sorted(sections):
        items = sorted(sections[level], key=lambda x: int(x[0]) if x[0].isdigit() else 0)
        rows = "\n".join(
            f"| [{p}](https://school.programmers.co.kr/learn/courses/30/lessons/{p}) | {t} |"
            for p, t in items
        )
        blocks.append(_details(
            f"📁 <b>Level {level}</b> · {len(items)}문제",
            f"| 문제 번호 | 제목 |\n| --- | --- |\n{rows}",
        ))
    return "\n".join(blocks)


def _summarize_attempts(seq: list[str]) -> str:
    """['Wrong Answer','Passed'] → '❌ → ✅' (연속 동일 상태는 ×N 압축)."""
    parts: list[str] = []
    for status, group in groupby(seq):
        count = sum(1 for _ in group)
        sym = config.ATTEMPT_SYMBOLS.get(status, status)
        parts.append(f"{sym}×{count}" if count > 1 else sym)
    return " → ".join(parts)


def _codetree_commit_stats() -> dict[str, dict]:
    """코드트리 커밋([Passed]/[Wrong Answer]…) → 문제명: {시도열, 최종 ms, mb}."""
    stats: dict[str, dict] = {}
    for line in reversed(_git_log("%s")):  # 오래된 → 최신
        m = config.CODETREE_COMMIT_PATTERN.match(line)
        if not m:
            continue
        status, name, ms, mb = m.groups()
        e = stats.setdefault(name.strip(), {"seq": [], "ms": None, "mb": None})
        e["seq"].append(status)
        if status == "Passed" and ms is not None:
            e["ms"], e["mb"] = int(ms), int(mb)
    return stats


def render_codetree() -> str:
    """trail* 폴더 → 트레일별 접이식 표 + 커밋 기반 시도·시간·메모리."""
    sections = scan_codetree()
    if not sections:
        return "_코드트리(trail) 폴더가 없습니다._"

    stats = _codetree_commit_stats()
    blocks: list[str] = []
    for trail, names in sections.items():
        rows: list[str] = []
        for name in names:
            e = stats.get(name.strip())
            if e and e["seq"]:
                tries = _summarize_attempts(e["seq"])
                t = f"{e['ms']}ms" if e["ms"] is not None else "-"
                mem = f"{e['mb']}MB" if e["mb"] is not None else "-"
            else:
                tries, t, mem = "✅", "-", "-"
            rows.append(f"| {name} | {tries} | {t} | {mem} |")
        blocks.append(_details(
            f"<b>{trail.capitalize()}</b> · {len(names)}문제",
            "| 문제 | 시도 | 시간 | 메모리 |\n| --- | --- | ---: | ---: |\n" + "\n".join(rows),
        ))

    detail = "\n\n".join(blocks)
    return detail


def compute_platform_counts() -> list[tuple[str, int]]:
    """플랫폼별 문제 수 (폴더 스캔 기준)."""
    bj = sum(len(v) for v in scan_baekjoon_tiers().values()) + \
         sum(len(v) for v in scan_baekjoon_steps().values())
    pg = sum(len(v) for v in scan_programmers().values())
    ct = sum(len(v) for v in scan_codetree().values())
    return [("BaekJoon", bj), ("Programmers", pg), ("Codetree", ct)]
