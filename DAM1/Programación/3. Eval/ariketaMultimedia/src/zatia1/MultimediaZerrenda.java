package zatia1;

class MultimediaZerrenda {
	private Multimedia[] zerrenda;
	private int zenbat;

	public MultimediaZerrenda(int tamaina) {
		zerrenda = new Multimedia[tamaina];
		zenbat = 0;
	}

	public int size() {
		return zenbat;
	}

	public boolean add(Multimedia m) {
		if (zenbat < zerrenda.length) {
			zerrenda[zenbat++] = m;
			return true;
		}
		return false;
	}

	public Multimedia get(int position) {
		if (position >= 0 && position < zenbat) {
			return zerrenda[position];
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < zenbat; i++) {
			sb.append(zerrenda[i].toString()).append("\n");
		}
		return sb.toString();
	}
}