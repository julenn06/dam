package modeloa;

import java.util.ArrayList;
import java.util.List;

public class Bidaia {

	private String identifikatzailea;
	private String izena;
	private String deskribapena;
	private String bidaiaMota;
	private String dataIrteera;
	private String dataAmaiera;
	private int iraupena;
	private String helmuga;
	private int agentzia;
	private String agentziaIzena;
	private ArrayList<Zerbitzua> Zerbitzuak;

	public Bidaia(String identifikatzailea, String izena, String deskribapena, String bidaiaMota, String dataIrteera,
			String dataAmaiera, int iraupena, String helmuga, List<Zerbitzua> zerbitzuak2, String agentziaIzena) {

		this.identifikatzailea = identifikatzailea;
		this.izena = izena;
		this.deskribapena = deskribapena;
		this.bidaiaMota = bidaiaMota;
		this.dataIrteera = dataIrteera;
		this.dataAmaiera = dataAmaiera;
		this.iraupena = iraupena;
		this.helmuga = helmuga;
		this.Zerbitzuak = new ArrayList<Zerbitzua>();
		this.agentziaIzena = agentziaIzena;
	}

	public Bidaia(String izena, String deskribapena, String bidaiaMota, String dataIrteera, String dataAmaiera,
			int iraupena, String helmuga, int agentzia) {

		this.izena = izena;
		this.deskribapena = deskribapena;
		this.bidaiaMota = bidaiaMota;
		this.dataIrteera = dataIrteera;
		this.dataAmaiera = dataAmaiera;
		this.iraupena = iraupena;
		this.helmuga = helmuga;
		this.agentzia = agentzia;
	}

	public Bidaia(String izena, String deskribapena, String dataIrteera, String dataAmaiera, int IDAgentzia,
			String bidaiaMota, String helmuga) {
		this.izena = izena;
		this.deskribapena = deskribapena;
		this.dataIrteera = dataIrteera;
		this.dataAmaiera = dataAmaiera;
		this.agentzia = IDAgentzia;
		this.bidaiaMota = bidaiaMota;
		this.helmuga = helmuga;
	}

	public String getIdentifikatzailea() {
		return identifikatzailea;
	}

	public void setIdentifikatzailea(String identifikatzailea) {
		this.identifikatzailea = identifikatzailea;
	}

	public String getAgentziaIzena() {
		return agentziaIzena;
	}

	public void setAgentziaIzena(String agentziaIzena) {
		this.agentziaIzena = agentziaIzena;
	}

	public int getAgentzia() {
		return agentzia;
	}

	public void setAgentzia(int agentzia) {
		this.agentzia = agentzia;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getDeskribapena() {
		return deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	public String getBidaiaMota() {
		return bidaiaMota;
	}

	public void setBidaiaMota(String bidaiaMota) {
		this.bidaiaMota = bidaiaMota;
	}

	public String getDataIrteera() {
		return dataIrteera;
	}

	public void setDataIrteera(String dataIrteera) {
		this.dataIrteera = dataIrteera;
	}

	public String getDataAmaiera() {
		return dataAmaiera;
	}

	public void setDataAmaiera(String dataAmaiera) {
		this.dataAmaiera = dataAmaiera;
	}

	public int getIraupena() {
		return iraupena;
	}

	public void setIraupena(int iraupena) {
		this.iraupena = iraupena;
	}

	public String getHelmuga() {
		return helmuga;
	}

	public void setHelmuga(String helmuga) {
		this.helmuga = helmuga;
	}

	public ArrayList<modeloa.Zerbitzua> getZerbitzuak() {
		return Zerbitzuak;
	}

	public void setZerbitzuak(ArrayList<modeloa.Zerbitzua> Zerbitzuak) {
		this.Zerbitzuak = Zerbitzuak;
	}

	@Override
	public String toString() {
		return "Bidaia [identifikatzailea=" + identifikatzailea + ", izena=" + izena + ", deskribapena=" + deskribapena
				+ ", bidaiaMota=" + bidaiaMota + ", dataIrteera=" + dataIrteera + ", dataAmaiera=" + dataAmaiera
				+ ", iraupena=" + iraupena + ", helmuga=" + helmuga + ", agentzia=" + agentzia + ", Zerbitzuak="
				+ Zerbitzuak + "]";
	}

}
