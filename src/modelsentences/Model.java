package modelsentences;

import java.util.List;

import pre_process.Modeling;

public class Model extends ModelSentences implements Modeling {
	


	@Override
	public String modelName(String st) {
		List<String> list = modeList(st);
		int index = findIndex(list,setNameIndex);
		if(index >= 0 ) {
		list.set(index, "Name");
		}
	    return covertToString(list);
	}

	@Override
	public String modelPrice(String st) {
		int i;
		boolean key = false;
		List<String> list =modeList(st);
		int index = findIndex(list, preCurrentPrice);

		if(index >= 0) {
			for(i = index; i<list.size();i++) {
				if(list.get(i).contains("điểm")) {
					key  = true;
					break;
				}
			}
			if(key) list.set(i-1, CURRENTPRICE);
		}
		return covertToString(list);
	    
	}

	public String modelChange(String st) {
		List<String> list = modeList(st);
		int index = findIndex(list,preState);
		if(index >= 0) {
			list.set(index, CHANGE);
		}
		return covertToString(list);
	}
	public String modelChangePrice( String st) {
		List<String> list = modeList(st);
//		String [] CHANCE1 = {CHANGE};
		int index = findIndex(list,preState);
		int size = list.size();
		int i ;
		boolean key = false;
		if(index >= 0 ) {
			for(i =index;i<size;i++) {
				String s = list.get(i);
				if(s.contains("điểm")) {
					key = true;
					break;
				}
			}
			if(key) {
				list.set(i-1, CHANGEPRICE);
			}
		}
		return covertToString(list);

	}

	public String modelState(String st ) {
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
	
	@Override
	public String modelDate(String st) {
		String[] s = {"/"};
		List<String> list = modeList(st);
		int index = findIndex(list,s);
		if(index >= 0) {
		list.set(index,"Date");
		}
		return covertToString(list);
	}
	
	@Override
	public String model(String st) {
        // TODO Auto-generated method stub
		st = this.modelName(st);
		st = this.modelPrice(st);
		st = this.modelDate(st);
		st = this.modelState(st);
//		st = this.modelChange(st);
		st = this.modelChangePrice(st);
//		st = this.modelPreCurrentPrice(st);
		return st;
		
	
	}

	public static void main(String[] args) {
		Model md = new Model();
		String s = "Vn-Index, vào thời điểm này, tăng 1,69 điểm, lên 509,13 điểm.";
		System.out.println(md.model(s));
	}

//	@Override
//	public void add() {
//		// TODO Auto-generated method stub
//		try {
//			List<String> list = Information.getList(new File("tang.txt"));
//			for (String s:list) {
//				addSentences(modeling(s));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}