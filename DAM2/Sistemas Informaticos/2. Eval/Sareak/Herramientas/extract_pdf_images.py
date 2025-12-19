from __future__ import annotations

import json
from pathlib import Path

import fitz  # PyMuPDF


def main() -> None:
    pdf_path = Path(r"C:\Users\in2dm3-d.ELORRIETA\Downloads\my_info\Cisco Packet Tracer.pdf")
    out_dir = Path(r"C:\Users\in2dm3-d.ELORRIETA\Downloads\my_info\public\img\cisco_packet_tracer_es")

    if not pdf_path.exists():
        raise SystemExit(f"PDF not found: {pdf_path}")

    out_dir.mkdir(parents=True, exist_ok=True)

    doc = fitz.open(pdf_path)

    manifest: dict[str, object] = {
        "source": str(pdf_path),
        "pages": doc.page_count,
        "images": [],
    }

    extracted_count = 0

    for page_index in range(doc.page_count):
        page = doc.load_page(page_index)
        page_number = page_index + 1

        images = page.get_images(full=True)
        page_entries = []

        # De-dup by xref within page
        seen_xref: set[int] = set()

        for img_i, img in enumerate(images, start=1):
            xref = int(img[0])
            if xref in seen_xref:
                continue
            seen_xref.add(xref)

            info = doc.extract_image(xref)
            ext = info.get("ext", "bin")
            image_bytes = info["image"]

            file_name = f"p{page_number:02d}_img{img_i:02d}.{ext}"
            file_path = out_dir / file_name
            file_path.write_bytes(image_bytes)

            rel_path = f"public/img/cisco_packet_tracer_es/{file_name}"
            entry = {
                "page": page_number,
                "xref": xref,
                "ext": ext,
                "path": rel_path,
                "width": info.get("width"),
                "height": info.get("height"),
            }
            page_entries.append(entry)
            extracted_count += 1

        # Only record pages that have at least one image
        if page_entries:
            manifest["images"].extend(page_entries)

    manifest_path = out_dir / "manifest.json"
    manifest_path.write_text(json.dumps(manifest, ensure_ascii=False, indent=2), encoding="utf-8")

    print(f"pages: {doc.page_count}")
    print(f"extracted images: {extracted_count}")
    print(f"output dir: {out_dir}")
    print(f"manifest: {manifest_path}")


if __name__ == "__main__":
    main()
