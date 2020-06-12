package classify;

import input.ReadCell;

public class ClassifyNumberofIncreases {
    public String timesIncreases;
    public String timesReduction;
    public void classify(String name, String  date)
    {
        Integer times1 = new Integer(0);
        Integer times2 = new Integer(0);
        ReadCell rc = new ReadCell();
        for(int index = 3; index <10; index++) {
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
    }

}
