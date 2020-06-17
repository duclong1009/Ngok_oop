package modelsentences;

import java.util.List;
import java.util.Scanner;

import pre_process.Modeling;

public class Model extends ModelSentences implements Modeling {
	


	@Override
	public String modelName(String st) {
		List<String> list = covertToList(st);
		int index = findIndex(list,setNameIndex);
		if(index >= 0 ) {
		list.set(index, "Name");
		}
	    return covertToString(list);
	}

	@Override
	public String modelPrice(String st) {
		boolean key1 = false;
		boolean key2 = false;
		List<String> list = covertToList(st);
		int[] index = new int[5];
		index = findIndexArray(list, DIEM);
		for (int k = 0; k < 5; k++) {
			if (index[k] >= 0) {
				key1 = false;
				key2 = false;
				for (int j = index[k]; j >= index[k] - 3; j--) {
					String str = list.get(index[k] - 1);
					key2 = isNumeric(str);
					String s = list.get(j);
					if(isContain(preCurrentPrice, s)) {
						key1 = true;
						break;
					}
				}
				if(key1 && key2) list.set(index[k]-1,CURRENTPRICE);
		    }
	    }
		return covertToString(list);
	    
	}

	public String modelChangePrice( String st) {
		List<String> list = covertToList(st);
		int [] index = new int[5];
		index = findIndexArray(list,DIEM);
		int size = list.size();
		int i ;
		boolean key1 = false;
		boolean key2 = false;
		for (int k = 0; k < 5; k++) {
			if (index[k] >= 0) {
				for (int j = index[k]; j >= index[k] - 3; j--) {
					String str = list.get(index[k] - 1);
					key2 = isNumeric(str);
					String s = list.get(j);
					if(isContain(preState, s)) {
						key1 = true;
						break;
					}
				}
				if(key1 && key2) list.set(index[k]-1,CHANGEPRICE);
			}
		}
		return covertToString(list);

	}

	public String modelState(String st ) {
		String[] s = {"%"};
		List<String> list = covertToList(st);
		int index = findIndex(list,s);
		if(index >= 0) {
			list.set(index, STATE);
		}
		return covertToString(list);
	}

	
	@Override
	public String modelDate(String st) {
		String[] s = {"/"};
		List<String> list = covertToList(st);
		int index = findIndex(list,s);
		if(index >= 0) {
		list.set(index,"Date");
		}
		return covertToString(list);
	}

	public String modelTransactionValue(String str) {
		List<String > list = covertToList(str);
		int index = findIndex(list,TY);
		if(index>=0 ) {
			if(isNumeric(list.get(index-1))) {
				list.set(index-1,"transactionValue");
				list.set(index,"");
			}
		}
		return covertToString(list);
	}

	public String modelTransactionWeight(String str) {
		List<String > list = covertToList(str);
		int index = findIndex(list,TRIEU);
		if(index>=0) {
			if(isNumeric(list.get(index-1))) {
				list.set(index-1,"transactionWeight");
				list.set(index,"");
			}
		}
		return covertToString(list);
	}

	public String model(String st) {
        // TODO Auto-generated method stub
		st = this.modelName(st);
		st = this.modelPrice(st);
		st = this.modelDate(st);
		st = this.modelState(st);
		st = this.modelChangePrice(st);
		st = this.modelTransactionValue(st);
		st = this.modelTransactionWeight(st);
		return st;
	}

	public static void main(String[] args) {
		Model md = new Model();
		Scanner sr = new Scanner(System.in);
		while(true) {
			String s = sr.nextLine();
			System.out.println(md.model(s));
		}
	}
}