public class Card {
	private String CCV;
	private String id;
	private String expire_date;
	private String type;
	public Card(String cCV, String id, String expire_date, String type) {
		super();
		CCV = cCV;
		this.id = id;
		this.expire_date = expire_date;
		this.type = type;
	}
	public String getCCV() {
		return CCV;
	}
	public void setCCV(String cCV) {
		CCV = cCV;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExpire_date() {
		return expire_date;
	}
	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Card [CCV=" + CCV + ", id=" + id + ", expire_date=" + expire_date + ", type=" + type + "]";
	}
	
	

}
