#!/usr/bin/env python3
"""README 자동 생성기.

폴더 구조와 git 커밋 로그를 스캔해 README.md 를 빌드한다. 별도 메타데이터
파일 없이 동작하며, 백준 문제 제목·난이도는 solved.ac API 로 조회해
scripts/.solvedac-cache.json 에 캐시한다.

  python3 scripts/generate_readme.py            # README.md 재생성
  python3 scripts/generate_readme.py --check    # 최신 상태인지 검사만
"""

from __future__ import annotations

import argparse
import re
import sys
from pathlib import Path

# scripts 디렉토리를 sys.path 에 추가해 lib 패키지를 찾을 수 있게 함
sys.path.insert(0, str(Path(__file__).resolve().parent))

from lib import cardgen, config
from lib.renderer import (
    render_baekjoon_steps,
    render_baekjoon_tiers,
    render_codetree,
    render_programmers,
)


def build(template: str) -> str:
    has_attempts = cardgen.render_all()

    replacements = {
        "<!--AUTOGEN:OVERVIEW_CARDS-->": cardgen.overview_md(has_attempts),
        "<!--AUTOGEN:BAEKJOON_TIERS-->": render_baekjoon_tiers(),
        "<!--AUTOGEN:BAEKJOON_STEPS-->": render_baekjoon_steps(),
        "<!--AUTOGEN:PROGRAMMERS-->": render_programmers(),
        "<!--AUTOGEN:CODETREE-->": render_codetree(),
    }

    output = template
    missing = [m for m in replacements if m not in output]
    if missing:
        raise RuntimeError(f"템플릿에 마커가 없음: {missing}")
    for marker, content in replacements.items():
        output = output.replace(marker, content)

    # 템플릿 최상단의 메타 주석은 README 독자에게 의미가 없으므로 제거.
    output = re.sub(r"^\s*<!--[\s\S]*?-->\s*\n+", "", output, count=1)
    return output


def main() -> int:
    parser = argparse.ArgumentParser(description="README.md 자동 생성")
    parser.add_argument("--strict", action="store_true", help="경고 발생 시 종료 코드 1")
    parser.add_argument("--check", action="store_true",
                        help="현재 README.md 와 빌드 결과가 동일한지만 확인")
    args = parser.parse_args()

    template = config.TEMPLATE_FILE.read_text(encoding="utf-8")
    output = build(template)

    if config.warnings:
        print("[경고]", file=sys.stderr)
        for w in config.warnings:
            print(f"  - {w}", file=sys.stderr)

    if args.check:
        current = config.OUTPUT_FILE.read_text(encoding="utf-8") if config.OUTPUT_FILE.exists() else ""
        if current != output:
            print(
                "[에러] README.md 가 폴더 상태와 일치하지 않음. "
                "`python3 scripts/generate_readme.py` 를 실행해 재생성하세요.",
                file=sys.stderr,
            )
            return 1
        print("✓ README.md 가 최신 상태입니다.", file=sys.stderr)
    else:
        config.OUTPUT_FILE.write_text(output, encoding="utf-8")
        print(f"✓ {config.OUTPUT_FILE.relative_to(config.ROOT)} 갱신됨 ({len(output)} bytes)", file=sys.stderr)

    return 1 if (args.strict and config.warnings) else 0


if __name__ == "__main__":
    sys.exit(main())
