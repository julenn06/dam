package modeloa;

public class BidaiMota {
	
	private String kodBidaiaMota = "";
	private String deskribapenaBidaiMota = "";
	
	
	public BidaiMota(String kodBidaiaMota, String deskribapenaBidaiMota) {
		this.kodBidaiaMota = kodBidaiaMota;
		this.deskribapenaBidaiMota = deskribapenaBidaiMota;
	}


	public String getKodBidaiaMota() {
		return kodBidaiaMota;
	}


	public void setKodBidaiaMota(String kodBidaiaMota) {
		this.kodBidaiaMota = kodBidaiaMota;
	}


	public String getDeskribapenaBidaiMota() {
		return deskribapenaBidaiMota;
	}


	public void setDeskribapenaBidaiMota(String deskribapenaBidaiMota) {
		this.deskribapenaBidaiMota = deskribapenaBidaiMota;
	}


	@Override
	public String toString() {
		return "BidaiMota [kodBidaiaMota=" + kodBidaiaMota + ", deskribapenaBidaiMota=" + deskribapenaBidaiMota + "]";
	}
	
	

}
