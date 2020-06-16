package modelsentences;

import java.util.List;
import java.util.Scanner;

public class ModelTimesChange extends Model{

    public String modelTimesIncreases (String str) {
        List<String> list = covertToList(str);
        int[] index = new int[5];
        index = findIndexArray(list,PHIEN);
//        System.out.println(index);
        for(int k = 0;k<5 ; k++) {
            if(index[k] >= 0) {
                for(int j = index[k]+1 ; j <index[k]+3;j++) {
                    String s = list.get(j);
                    if(isContain(Giam,s)) {
                        list.set(index[k]-1,"TimesReduction");
                    }
                    else if(isContain(Tang,s)) {
                        list.set(index[k]-1,"TimesIncreases");
                    }
                    if(j+1 <list.size()) continue;
                    else break;
                }
            }
        }
        return covertToString(list);
    }

    public String model(String str) {
        String st = super.model(str);
        st = modelTimesIncreases(st);
        return st;
    }
}
