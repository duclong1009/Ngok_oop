package classify;

import input.ReadCell;

public class Classify {

    public String classifyChange (String name, String date) {
        ReadCell rc = new ReadCell();
        int indexRow = rc.getRow(name, date);
        String st = rc.ReadCellData(name,indexRow,2);
        String[] arr = st.split("\\)|\\(|%");
        double ar1 = Double.parseDouble(arr[0]);
//        double ar2 = Double.parseDouble(arr[1]);
        if(ar1 > 0 ) {
            return "Tăng";
        }
        else if(ar1 == 0) return  "Cân Bằng";
        else return "Giảm";
    }

//    public boolean checkSenssion(String st, String[] arString ) {
//        int size = arString.length;
//        boolean check = false;
//        for (int i = 0 ; i<size ; i++) {
//            if(st.contains(arString[i])) {
//                check = true;
//            }
//        }
//        return check;
//    }

    public static void main(String[] args) {
        Classify cl  = new Classify();
        System.out.println(cl.classifyChange("VN-INDEX","22/05/2020"));
    }
}
