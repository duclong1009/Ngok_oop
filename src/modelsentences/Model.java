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

public class Model extends Sentences implements Modeling {
	
	public int findIndex(List<String> list,String[] temp) {
		int index = -1;
		for(int i =0;i<list.size();i++) {
			String s = list.get(i);
			for(int j = 0; j<temp.length;j++) {
				if(s.contains(temp[j])) return index =i;
			}
		}
		return index;
	}
	
	public String covertToString(List<String > st) {
		String temp ="";
		for(int i = 0;i <st.size();i++) {
			String s = st.get(i);
			temp = temp.concat(s)+" ";
		}
		return temp;
		
	}
	
	public List<String> modeList(String st) {
		List<String> list = new ArrayList<String>();
		String[] arr = st.split(" ");
		for (String s:arr) {
			list.add(s);
		}
		return list;
	}

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

		
	


