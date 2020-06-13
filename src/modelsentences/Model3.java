package modelsentences;

import java.util.List;
import java.util.Scanner;

public class Model3 extends Model {

    public String modelNearPrice(String str) {
        List<String > list = modeList(str);
        int[] index = findIndexArray(list,DIEM);
        for(int j = 0;j <5;j++) {
            if(index[j]>=0) {
                for(int i = index[j]-3; i< index[j];i++) {
                    if(i>=0) {
                        String s = list.get(i);
                        if (isContain(nearPrice, s)) {
                            if(isNumeric(list.get(index[j]-1)))
                                list.set(index[j]-1,"NEARPRICE");
                        }
                    }
                }
            }
        }
        return covertToString(list);
    }

    public String model(String str) {
        String st  = super.model(str);
        st  = modelNearPrice(st);
        return st;

    }



    public static void main(String[] args) {
        Model3 md =  new Model3();
        Scanner sr = new Scanner(System.in);
        while(true) {
            String s = sr.nextLine();
            System.out.println(md.model(s));
        }
    }
}
