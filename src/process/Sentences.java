package process;

import java.util.ArrayList;
import java.util.List;



public class Sentences {
	protected List<String> listModel = new ArrayList<>();
	
	public void getList(List<String > t ) {
		this.listModel = t;
	}
	public String getIndex(int index) {
		return listModel.get(index);
	}
	public void setIndex(int index,String st) {
		listModel.set(index, st);
	}
	public void addSentences(String st) {
		listModel.add(st);
	}
	public int size() {
		return listModel.size();
	}
}
