from datetime import date, timedelta

from lib import config, svgcards as sv
from lib.extractor import _git_log
from lib.renderer import compute_platform_counts

ASSETS = config.ROOT / "assets" / "cards"



def _monthly(months=9):
    monthly = {}
    for line in _git_log("%aI %s"):
        parts = line.split(" ", 1)
        if len(parts) < 2:
            continue
        date, subject = parts
        if any(p.match(subject) for p in config.PROBLEM_COMMIT_PATTERNS):
            monthly[date[:7]] = monthly.get(date[:7], 0) + 1
    keys = sorted(monthly)[-months:]
    return [(k, monthly[k]) for k in keys]


def _daily(days=5):
    daily = {}
    for line in _git_log("%aI %s"):
        parts = line.split(" ", 1)
        if len(parts) < 2:
            continue
        commit_date, subject = parts
        if any(p.match(subject) for p in config.PROBLEM_COMMIT_PATTERNS):
            daily[commit_date[:10]] = daily.get(commit_date[:10], 0) + 1
    today = date.today()
    return [((today - timedelta(days=i)).isoformat(), daily.get((today - timedelta(days=i)).isoformat(), 0))
            for i in range(days)]


def render_all() -> bool:
    """전체 현황 카드 SVG 를 assets/cards/ 에 쓴다. attempts 카드 생성 여부를 돌려준다."""
    ASSETS.mkdir(parents=True, exist_ok=True)
    rows = compute_platform_counts()
    total = sum(c for _, c in rows)
    (ASSETS / "platforms.svg").write_text(sv.platforms_card(rows, total), encoding="utf-8")
    (ASSETS / "daily.svg").write_text(sv.daily_card(_daily()), encoding="utf-8")
    (ASSETS / "activity.svg").write_text(sv.activity_card(_monthly()), encoding="utf-8")
    (ASSETS / "attempts.svg").unlink(missing_ok=True)
    return False


def _center(img, alt):
    return f'<div align="center"><img src="./assets/cards/{img}" alt="{alt}"/></div>'


def overview_md(has_attempts: bool):
    parts = [
        _center("platforms.svg", "platforms"),
        _center("daily.svg", "daily activity"),
        _center("activity.svg", "monthly activity"),
    ]
    return "\n<br/>\n".join(parts)
