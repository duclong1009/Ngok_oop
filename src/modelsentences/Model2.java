package modelsentences;

import java.util.List;
import java.util.Scanner;

public class Model2 extends Model {
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

    public String modelTimes(String str) {
        List<String> list = modeList(str);
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

    public static void main(String[] args) {
        Model2 md = new Model2();
        Scanner sr = new Scanner(System.in);
        while (true) {
            String s = sr.nextLine();
            System.out.println(md.model(s));
        }
    }
}
