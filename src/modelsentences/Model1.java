package modelsentences;

import java.util.List;
import java.util.Scanner;

public class Model1 extends Model{

    public String modelTimesIncreases (String str) {
        List<String> list = modeList(str);
        int[] index = new int[5];
        index = findIndexArray(list,PHIEN);
//        System.out.println(index);
        for(int k = 0;k<5 ; k++) {
            if(index[k] >= 0) {
                System.out.println(index[k]);
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

    public static void main(String[] args) {
        Model1 md = new Model1();
        Scanner sr = new Scanner(System.in);
        while (true) {
            String s = sr.nextLine();
            System.out.println(md.model(s));
        }
    }


}
