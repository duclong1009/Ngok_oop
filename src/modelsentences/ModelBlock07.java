package modelsentences;

import java.util.List;

public class ModelBlock07 extends Model{
	public String modelState(String st) {
		List<String> list = modeList(st);
		int index = findIndex(list,preState);
		if(index >= 0) {
		list.set(index, CHANGE);
		}
		return covertToString(list);
	}
	public String modelChangePrice( String st) {
		List<String> list = modeList(st);
		String [] CHANCE1 = {CHANGE};
		int index = findIndex(list,CHANCE1);
		int size = list.size();
		int i ;
		boolean test = false;
		if(index >= 0 ) {
		for(i =index;i<size;i++) {
			String s = list.get(i);
			if(s.contains("điểm")) {
				test = true;
				break;
			}
		}
		if(test) {
		list.set(i-1, CHANGEPRICE);
		}
		}
		return covertToString(list);
		
	}
	
	public String modelChange(String st ) {
		String[] s = {"%"};
		List<String> list = modeList(st);
		int index = findIndex(list,s);
		if(index >= 0) {
		list.set(index, STATE);
		}
		return covertToString(list);
	}
	
	public String modelPreCurrentPrice (String st ) {
		List<String> list = modeList(st);
		int index = findIndex(list,preCurrentPrice);
		if(index >= 0) {
			list.set(index, "preCurrentPrice");
		}
		return covertToString(list);
	}
	
	public String model(String st) {
       st = super.model(st);
       st = this.modelState(st);
       st = this.modelChange(st);
       st = this.modelChangePrice(st);
       st = this.modelPreCurrentPrice(st);
	   return st;
	}

}
