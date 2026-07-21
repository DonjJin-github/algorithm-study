import re
import subprocess
from pathlib import Path

from lib import config

# "12978. 배달" → ("12978", "배달")
_NUMBERED = re.compile(r"^(\d+)\.\s*(.+)$")


def scan_dirs(root: Path) -> list[Path]:
    if not root.is_dir():
        return []
    return sorted((p for p in root.iterdir() if p.is_dir()), key=lambda p: p.name)


def split_numbered(name: str) -> tuple[str, str]:
    """'번호. 제목' 폴더명 분해. 매칭 안 되면 (name, '')."""
    m = _NUMBERED.match(name)
    if m:
        return m.group(1), m.group(2).strip()
    return name, ""


def scan_baekjoon_tiers() -> dict[str, list[tuple[str, str]]]:
    """백준/<티어>/<번호. 제목> → 티어별 (번호, 제목) 리스트."""
    out: dict[str, list[tuple[str, str]]] = {}
    for tier_dir in scan_dirs(config.BAEKJOON_TIER_DIR):
        items = [split_numbered(p.name) for p in scan_dirs(tier_dir)]
        if items:
            out[tier_dir.name] = items
    return out


def scan_baekjoon_steps() -> dict[str, list[str]]:
    """백준 단계별로 풀어보기/<N. 단계명>/<번호> → 단계별 문제번호 리스트."""
    out: dict[str, list[str]] = {}
    for step_dir in scan_dirs(config.BAEKJOON_STEPS_DIR):
        ids = [p.name for p in scan_dirs(step_dir) if p.name.isdigit()]
        if ids:
            out[step_dir.name] = ids
    return out


def scan_programmers() -> dict[str, list[tuple[str, str]]]:
    """프로그래머스/<레벨>/<번호. 제목> → 레벨별 (번호, 제목) 리스트."""
    out: dict[str, list[tuple[str, str]]] = {}
    for lv_dir in scan_dirs(config.PROGRAMMERS_DIR):
        items = [split_numbered(p.name) for p in scan_dirs(lv_dir)]
        if items:
            out[lv_dir.name] = items
    return out


def scan_codetree() -> dict[str, list[str]]:
    """trail*/<문제명> → 트레일별 문제명 리스트."""
    out: dict[str, list[str]] = {}
    for trail_dir in sorted(config.ROOT.glob(config.CODETREE_TRAIL_GLOB)):
        if not trail_dir.is_dir():
            continue
        names = [p.name for p in scan_dirs(trail_dir)]
        if names:
            out[trail_dir.name] = names
    return out


def _git_log(format_str: str) -> list[str]:
    """git log 호출. 실패 시 빈 리스트."""
    try:
        result = subprocess.run(
            ["git", "log", f"--format={format_str}"],
            capture_output=True,
            text=True,
            encoding="utf-8",
            errors="replace",
            cwd=config.ROOT,
            check=True,
        )
    except (subprocess.CalledProcessError, FileNotFoundError):
        return []
    return result.stdout.splitlines()
