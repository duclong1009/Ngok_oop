package modelsentences;

import java.util.List;
import java.util.Scanner;

public class ModelConsecutiveChange extends Model {

    public String modelTimes(String str) {
        List<String> list = covertToList(str);
        int index = findIndex(list, PHIEN);
        if (index >= 0) {
            String s;
            s= list.get(index - 1);
            if (isNumeric(s)) {
                list.set(index - 1, "TIMES");
            }
            else {
                for(int j = index; j < index+4;j++) {
                    s = list.get(j);
                    if(isNumericb(s)) {
                        list.set(j,"TIMES");
                    }
                }
            }
        }
        return covertToString(list);
    }

    public String model(String str) {
        String st = super.model(str);
        st = modelTimes(st);
        return st;
    }
}
