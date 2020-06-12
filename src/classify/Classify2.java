package classify;

import input.ReadCell;

import static java.lang.Integer.parseInt;

public class Classify2 {
    public static final int INDEX_BEGIN = 3;

    public int TimesIncreasingConsecutive (String name,int indexBegin) {
        int times = 0;
        ReadCell rc = new ReadCell();
        for(int i =indexBegin; i<20 ; i++ ) {
            float a1 = Float.parseFloat(rc.ReadCellData(name,i,1));
            float a2 = Float.parseFloat(rc.ReadCellData(name, i+1,1));
            if(a1>a2) {
                times++;
            }
            else{
                break;
            }
        }
        return times;
    }

    public int TimeReductionConsecutive(String name, int indexBegin ) {
        int times = 0;
        ReadCell rc = new ReadCell();
        for(int i =indexBegin; i<20 ; i++ ) {
            float a1 = Float.parseFloat(rc.ReadCellData(name,i,1));
            float a2 = Float.parseFloat(rc.ReadCellData(name, i+1,1));
            if(a1<a2) {
                times++;
            }
            else{
                break;
            }
        }
        return times;
    }


    public int TimeReductionCon(String name , int indexBegin) {
        int times = 0;
        ReadCell rc = new ReadCell();
        float a1 = Float.parseFloat(rc.ReadCellData(name,indexBegin,1));
        float a2 = Float.parseFloat(rc.ReadCellData(name, indexBegin+1,1));
        if (a1>a2) {
            times =TimeReductionConsecutive(name,indexBegin+1);
        }
        else{
            times = -1;
        }
        return times;

    }


    public int TimeIncreaseCon(String name , int indexBegin) {
        int times = 0;
        ReadCell rc = new ReadCell();
        float a1 = Float.parseFloat(rc.ReadCellData(name,indexBegin,1));
        float a2 = Float.parseFloat(rc.ReadCellData(name, indexBegin+1,1));
        if (a1<a2) {
            times =TimesIncreasingConsecutive(name,indexBegin+1);
        }
        else{
            times = -1;
        }
        return times;

    }


    public static void main(String[] args) {
        Classify2 cl = new Classify2();
        System.out.println("So lần tăng liên tiếp:");
        System.out.println(cl.TimesIncreasingConsecutive("VN-INDEX",INDEX_BEGIN));
        System.out.println("So lần giảm liên tiếp:");
        System.out.println(cl.TimesIncreasingConsecutive("VN-INDEX",INDEX_BEGIN));
        System.out.println("So lần tăng liên tiếp sau 1 lần giảm:");
        System.out.println(cl.TimeIncreaseCon("VN-INDEX",INDEX_BEGIN));
        System.out.println("So lần giảm  liên tiếp sau 1 lần tăng:");
        System.out.println(cl.TimeReductionCon("VN-INDEX",INDEX_BEGIN));
    }



}
