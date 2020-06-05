package pre_process;


public interface Modeling extends Convention{
	
	public abstract String modelName(String st);
	public abstract String modelDate(String st);
	public abstract String modelPrice(String st);
	public String model(String st);
//	public void add();
	
}
