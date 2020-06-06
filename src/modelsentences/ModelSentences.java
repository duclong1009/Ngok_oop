package modelsentences;

import process.Sentences;

import java.util.ArrayList;
import java.util.List;

public class ModelSentences extends Sentences {
    public int findIndex(List<String> list, String[] temp) {
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
        String[] arr = st.split("\\s+");
        for (String s:arr) {
            list.add(s);
        }
        return list;
    }
}
