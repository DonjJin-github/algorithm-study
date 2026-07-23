import re
from pathlib import Path

# 공통 프로젝트 루트 경로
LIB_DIR = Path(__file__).resolve().parent
ROOT = LIB_DIR.parent.parent

TEMPLATE_FILE = ROOT / "scripts" / "static_sections.md"
OUTPUT_FILE = ROOT / "README.md"
SOLVEDAC_CACHE_FILE = ROOT / "scripts" / ".solvedac-cache.json"

# 저장소 최상위 폴더 → 플랫폼 매핑
BAEKJOON_TIER_DIR = ROOT / "백준"
BAEKJOON_STEPS_DIR = ROOT / "백준 단계별로 풀어보기"
PROGRAMMERS_DIR = ROOT / "프로그래머스"
CODETREE_TRAIL_GLOB = "trail*"  # trail2, trail4, ...

# 커밋 메시지에서 "문제 풀이 커밋"으로 집계할 패턴들 (월별 활동 카드)
PROBLEM_COMMIT_PATTERNS = [
    re.compile(r"^\[(?:Passed|Wrong Answer|Time Limit Exceed|WIP)\]"),          # 코드트리
    re.compile(r"^\[(?:Bronze|Silver|Gold|Platinum|Diamond|Ruby)\b[^\]]*\]"),   # BaekjoonHub 백준
    re.compile(r"^\[level\s*\d+\]", re.IGNORECASE),                             # BaekjoonHub 프로그래머스
]

# 코드트리 커밋: "[Passed] 문제명 (12ms, 3MB)" → status, 이름, ms, mb (perf 는 선택)
CODETREE_COMMIT_PATTERN = re.compile(
    r"^\[(Passed|Wrong Answer|Time Limit Exceed|WIP)\]\s+(.+?)\s*"
    r"(?:\((\d+)\s*ms,\s*(\d+)\s*MB\))?\s*$"
)

ATTEMPT_SYMBOLS = {
    "Passed": "✅",
    "Wrong Answer": "❌",
    "Time Limit Exceed": "⏱️",
    "WIP": "🚧",
}

# solved.ac 난이도 매핑
SOLVEDAC_TIERS = ["Bronze", "Silver", "Gold", "Platinum", "Diamond", "Ruby"]
SOLVEDAC_SUBTIERS = ["V", "IV", "III", "II", "I"]

# 경고 수집용 전역 리스트
warnings: list[str] = []
