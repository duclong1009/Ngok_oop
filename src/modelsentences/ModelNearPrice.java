package modelsentences;

import java.util.List;

public class ModelNearPrice extends Model {

    public String modelAsymtoticValue(String str) {
        List<String > list = covertToList(str);
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
        st  = modelAsymtoticValue(st);
        return st;

    }
}
