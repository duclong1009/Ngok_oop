package classify;

import static pre_process.Convention.SOLANTANGGIAM;

public class ClassifyTimesChange extends ClassifyBasis {
    public String timesIncreases;
    public String timesReduction;

    public ClassifyTimesChange(){
        super();
    }

    @Override
    public void classify(String name, String  date)
    {
        Integer times1 = 0;
        Integer times2 = 0;
        int indexRow = rc.getRow(name, date);
        for(int index = indexRow; index <indexRow+7; index++) {
            String st = rc.ReadCellData(name, index, 2);
            String[] arr = st.split("\\)|\\(|%");
            double ar1 = Double.parseDouble(arr[0]);
            if(ar1 >0) {
                times1++;
            }
            else if(ar1 <0) {
                times2++;
            }
        }
        this.timesIncreases = times1.toString();
        this.timesReduction = times2.toString();
        this.address = SOLANTANGGIAM;
    }

    @Override
    public void getData(String name,String date) {
        super.getData(name,date);
        this.hm.put("TimesIncreases", timesIncreases);
        this.hm.put("TimesReduction", timesReduction);
    }

    @Override
    public void run(String name,String date) {
        super.run(name,date);
    }
}


