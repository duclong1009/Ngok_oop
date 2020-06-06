package modelsentences;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import input.Information;

import java.util.Iterator;

import pre_process.Convention;
import pre_process.Modeling;
import process.Sentences;

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
		List<String> list =modeList(st);
		int index = findIndex(list, preCurrentPrice);
		if(index >= 0) {
		list.set(index+1, CURRENTPRICE);
		}
		return covertToString(list);
	    
	}

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
		st = this.modelChange(st);
		st = this.modelChangePrice(st);
		st = this.modelPreCurrentPrice(st);
		return st;
		
	
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