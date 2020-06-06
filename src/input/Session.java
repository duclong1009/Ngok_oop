package input;




public class Session {//Phien giao dich
	private String nameIndex;//Ten chi so
	private String day;//Ngay giao dich
	private float change;//Bien dong so voi ngay hom truoc
	private float state;//Trang thai so voi hom truoc do(tang giam,....)
	private String price;//Gia
	private String matchingTradeWeight;//Khoi luong giao dich khop lenh
	private String matchingTradeValue;//Gia tri giao dich khop lenh
	private String transactionWeight;//Khoi luong giao dich thoa thuan
	private String transactionValue;//Gia tri giao dich thoa thuan
	public static final float TANGMANH = 1.5f;
	public static final float TANG = 1.0f;
	public static final float TANGNHE = 0.5f;
	public static final float GIAMMANH = -1.5f;
	public static final float GIAM = -1.0f;
	public static final float GIAMNHE = -0.5f;
	
	
	public String getNameIndex() {
		return nameIndex;
	}
	public void setNameIndex(String nameIndex) {
		this.nameIndex = nameIndex;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public float getState() {
		return state;
	}
	public void setState(float state) {
		this.state = state;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPrice() {
		return price;
	}
	public String getMatchingTradeWeight() {
		return matchingTradeWeight;
	}
	public void setMatchingTradeWeight(String matchingTradeWeight) {
		this.matchingTradeWeight = matchingTradeWeight;
	}
	public String getMatchingTradeValue() {
		return matchingTradeValue;
	}
	public void setMatchingTradeValue(String matchingTradeValue) {
		this.matchingTradeValue = matchingTradeValue;
	}
	public String getTransactionWeight() {
		return transactionWeight;
	}
	public void setTransactionWeight(String transactionWeight) {
		this.transactionWeight = transactionWeight;
	}
	public String getTransactionValue() {
		return transactionValue;
	}
	public void setTransactionValue(String transactionValue) {
		this.transactionValue = transactionValue;
	}
	public float getChange() {
		return change;
	}
	public void setChange(float change) {
		this.change = change;
	}
	
	
}
