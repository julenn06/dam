package modeloa;

public class AgentziaMota {
	
	private String kodAgMota;
	private String motaDeskribapena;
	
	
	public AgentziaMota(String kodAgMota, String deskribapena) {
		this.kodAgMota = kodAgMota;
		this.motaDeskribapena = deskribapena;
	}


	public String getKodAgMota() {
		return kodAgMota;
	}


	public void setKodAgMota(String kodAgMota) {
		this.kodAgMota = kodAgMota;
	}


	public String getMotaDeskribapena() {
		return motaDeskribapena;
	}


	public void setMotaDeskribapena(String motaDeskribapena) {
		this.motaDeskribapena = motaDeskribapena;
	}


	@Override
	public String toString() {
		return "AgentziaMota [kodAgMota=" + kodAgMota + ", motaDeskribapena=" + motaDeskribapena + "]";
	}
	

}
