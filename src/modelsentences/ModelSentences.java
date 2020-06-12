package modelsentences;

import process.Sentences;

import java.util.ArrayList;
import java.util.List;

public class ModelSentences extends Sentences {
    public boolean isNumericb(String str) {
        boolean key;
        if(str.contains("một")||str.contains("hai")||str.contains("ba")||str.contains("bốn")||str.contains("tư")||str.contains("năm")||str.contains("sáu")||str.contains("bảy")||str.contains("tám")||str.contains("chín")) {
            key = true;
        }
        else {
            key = false;
        }
        return key;

    }

    public boolean isNumeric(String str) {
            if (str.contains("0") || str.contains("1") || str.contains("2") || str.contains("3") || str.contains("4") || str.contains("5") || str.contains("6") || str.contains("7") || str.contains("8") || str.contains("9"))
                return true;
            else return false;
        }

     public boolean isContain(String[] list,String t ) {
        int size = list.length;
        boolean result = false;
        for(int i = 0;i<size;i++) {
            if(t.contains(list[i])) {
                result = true;
            }
        }
        return result;
     }

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

    public int[] findIndexArray(List<String> list, String[] temp) {
        int[] a = new int[5];
        for(int i = 0;i<5;i++) {
            a[i] = -1;
        }
        int k =0;
        int index = -1;
        for(int i =0;i<list.size();i++) {
            String s = list.get(i);
            for(int j = 0; j<temp.length;j++) {
                if(s.contains(temp[j])) {
                    a[k] = i;
                    k++;
                }
            }
        }
        return a;
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
