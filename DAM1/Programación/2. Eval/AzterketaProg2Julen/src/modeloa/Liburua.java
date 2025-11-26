package modeloa;

public class Liburua {
	private int id;
	private String izenburua;
	private String egilea;
	private String editoriala;
	private String argitaratze_data;

	public Liburua() {
	}

	public Liburua(int id, String izenburua, String egilea, String editoriala, String argitaratze_data2) {
		this.id = id;
		this.izenburua = izenburua;
		this.egilea = egilea;
		this.editoriala = editoriala;
		this.argitaratze_data = argitaratze_data2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIzenburua() {
		return izenburua;
	}

	public void setIzenburua(String izenburua) {
		this.izenburua = izenburua;
	}

	public String getEgilea() {
		return egilea;
	}

	public void setEgilea(String egilea) {
		this.egilea = egilea;
	}

	public String getEditoriala() {
		return editoriala;
	}

	public void setEditoriala(String editoriala) {
		this.editoriala = editoriala;
	}

	public String getArgitaratze_data() {
		return argitaratze_data;
	}

	public void setArgitaratze_data(String argitaratze_data) {
		this.argitaratze_data = argitaratze_data;
	}

	public void ikusiLiburuak() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return id + ";" + izenburua + ";" + egilea + ";" + editoriala + ";" + argitaratze_data + ";";
	}

}
