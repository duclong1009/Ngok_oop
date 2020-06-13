package classify;

import input.ReadCell;

import static java.lang.Integer.parseInt;
import static pre_process.Convention.*;
import static pre_process.Convention.GIAMROITANGLIENTUC_TXT;

public class Classify2 extends ClassifyBasis {
    public static final int INDEX_BEGIN = 3;
    private Integer times;

    public Classify2() {
        super();
        times = new Integer(0);
    }

    public int getTimes() {
        return  this.times;
    }

    public int TimesIncreasingConsecutive (String name,int indexBegin) {
        int time = 0;
        ReadCell rc = new ReadCell();
        for(int i =indexBegin; i<20 ; i++ ) {
            float a1 = Float.parseFloat(rc.ReadCellData(name,i,1));
            float a2 = Float.parseFloat(rc.ReadCellData(name, i+1,1));
            if(a1>a2) {
                time++;
            }
            else{
                break;
            }
        }
        return time;
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

    @Override
    public void classify (String name, String date) {
        if(TimesIncreasingConsecutive(name,INDEX_BEGIN)>0) {
            this.times = TimesIncreasingConsecutive(name,INDEX_BEGIN);
            address = TANGLIENTUC_TXT;
        }
        else if(TimeReductionConsecutive(name,INDEX_BEGIN)>0) {
            this.times =TimeReductionConsecutive(name,INDEX_BEGIN);
            address = GIAMLIENTUC_TXT;
        }
        else if(TimeReductionCon(name,INDEX_BEGIN)>0) {
            times =TimeReductionCon(name,INDEX_BEGIN);
            this.address = TANGROIGIAMLIENTUC_TXT;
        }
        else if(TimeIncreaseCon(name,INDEX_BEGIN)>0) {
            this.times =TimeIncreaseCon(name,INDEX_BEGIN);
            address = GIAMROITANGLIENTUC_TXT;
        }
    }

    @Override
    public void getData(String name, String date) {
        rc.getData(hm,name,date);
        hm.put("TIMES",times.toString());
    }

    @Override
    public void run(String name,String date) {
        super.run(name,date);
    }
}
