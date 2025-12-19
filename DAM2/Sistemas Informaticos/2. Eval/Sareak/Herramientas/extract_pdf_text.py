from __future__ import annotations

from pathlib import Path

from pypdf import PdfReader


def main() -> None:
    pdf_path = Path(r"C:\Users\in2dm3-d.ELORRIETA\Downloads\my_info\Cisco Packet Tracer.pdf")
    if not pdf_path.exists():
        raise SystemExit(f"PDF not found: {pdf_path}")

    out_path = pdf_path.with_suffix(".extracted.txt")

    reader = PdfReader(str(pdf_path))
    chunks: list[str] = []
    for i, page in enumerate(reader.pages, start=1):
        text = (page.extract_text() or "").strip("\n")
        chunks.append(f"\n\n===== PAGE {i} =====\n\n{text}\n")

    out_path.write_text("".join(chunks), encoding="utf-8")
    print(f"wrote: {out_path}")
    print(f"pages: {len(reader.pages)}")
    print(f"bytes: {out_path.stat().st_size}")


if __name__ == "__main__":
    main()
