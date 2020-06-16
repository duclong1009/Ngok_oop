package exportsentences;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import input.ReadCell;
import modelsentences.ModelSentences;

public class Export extends ModelSentences {

//	@Override
	// nhập vào 1 chuỗi s đã mô hình, thay các key có trong câu đã mô hình thành các giá trị của hm
	public String replace(String st, HashMap<String, String> hm ) {
		ReadCell rc = new ReadCell();
		List<String > list = covertToList(st);
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
