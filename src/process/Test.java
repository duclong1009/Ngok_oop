package process;

import modelsentences.ModelBlock07;

public class Test {
	public static void main(String [] args) {		
		ModelBlock07 md = new ModelBlock07();
		String  s = "Chốt phiên giao dịch ngày hôm nay (17/1), VN-Index giảm gần 30 điểm, tương đương 2,7% còn 1.034,7 điểm.";
		System.out.println(s);
	    System.out.println(md.model(s));
	    

	}
}


		
		
	    
		
		
		
	


