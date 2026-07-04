import json
from urllib.error import HTTPError, URLError
from urllib.parse import quote
from urllib.request import Request, urlopen

from lib import config


def _solvedac_level_to_tier(level: int) -> str:
    """solved.ac level (0~30) → 'Silver II' 형태의 표시 이름."""
    if level == 0:
        return "Unrated"
    if 1 <= level <= 30:
        major = config.SOLVEDAC_TIERS[(level - 1) // 5]
        minor = config.SOLVEDAC_SUBTIERS[(level - 1) % 5]
        return f"{major} {minor}"
    return "?"


def _load_cache() -> dict[str, dict]:
    if not config.SOLVEDAC_CACHE_FILE.exists():
        return {}
    try:
        return json.loads(config.SOLVEDAC_CACHE_FILE.read_text(encoding="utf-8"))
    except (json.JSONDecodeError, OSError):
        return {}


def _save_cache(cache: dict[str, dict]) -> None:
    config.SOLVEDAC_CACHE_FILE.write_text(
        json.dumps(cache, ensure_ascii=False, indent=2, sort_keys=True) + "\n",
        encoding="utf-8",
    )


def _fetch_batch(ids: list[str]) -> dict[str, dict]:
    """solved.ac /problem/lookup 배치 조회 (한 번에 최대 100개)."""
    url = "https://solved.ac/api/v3/problem/lookup?problemIds=" + quote(",".join(ids))
    req = Request(url, headers={"User-Agent": "algorithm-readme-builder/1.0"})
    try:
        with urlopen(req, timeout=15) as resp:
            payload = json.load(resp)
    except (URLError, HTTPError, json.JSONDecodeError, OSError):
        return {}
    out = {}
    for p in payload:
        pid = str(p.get("problemId", ""))
        out[pid] = {
            "title": p.get("titleKo", ""),
            "difficulty": _solvedac_level_to_tier(p.get("level", 0)),
            "level": p.get("level", 0),
        }
    return out


def fetch_baekjoon_meta(problem_ids: list[str]) -> dict[str, dict]:
    """백준 문제번호 → {title, difficulty, level}. 캐시 우선, 없으면 배치 API."""
    cache = _load_cache()
    missing = sorted({pid for pid in problem_ids if pid.isdigit() and pid not in cache})
    if missing:
        for i in range(0, len(missing), 100):
            cache.update(_fetch_batch(missing[i:i + 100]))
        _save_cache(cache)
    return {pid: cache[pid] for pid in problem_ids if pid in cache}
