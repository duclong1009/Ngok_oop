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

    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        ModelConsecutiveChange md = new ModelConsecutiveChange();
        while (true) {
            String s = sr.nextLine();
            System.out.println(md.model(s));

        }
    }
}
