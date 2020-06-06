package exportsentences;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap.*;
import java.util.List;
import java.util.Set;

import modelsentences.ModelSentences;
import pre_process.Export;
import process.Sentences;

public class Export2 extends ModelSentences {

//	@Override
	// nhập vào 1 chuỗi s đã mô hình thay, thay các key có trong câu đã mô hình thành các giá trị của hm
	public String replace(String st, HashMap<String, String> hm ) {
		ReadCellExample rc = new ReadCellExample();
		List<String > list = modeList(st);
		int size = list.size();
		Set<String> keySet = hm.keySet();
		for (int i = 0; i < size; i++) {
			String s = list.get(i);
			for (String key : keySet) {
				if (key.equals(s)) {
					list.set(i, hm.get(key));
				}
			}
		}
		return covertToString(list);
	}



//	@Override
////	public List<String> output(List<String> list) {
////		// TODO Auto-generated method stub
////		return null;
////	}

}
