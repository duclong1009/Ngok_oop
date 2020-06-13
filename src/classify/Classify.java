package classify;

import input.ReadCell;

import static pre_process.Convention.GIAM_TXT;
import static pre_process.Convention.TANG_TXT;

public class Classify extends ClassifyBasis{
    public Classify() {
        super();
    }

    @Override
    public void classify(String name, String date) {
        int indexRow = rc.getRow(name, date);
        String st = rc.ReadCellData(name,indexRow,2);
        String[] arr = st.split("\\)|\\(|%");
        double ar1 = Double.parseDouble(arr[0]);
        if(ar1 > 0 ) {
            address = TANG_TXT;
        }
        else address = GIAM_TXT;
    }

    @Override
    public void run(String name, String date) {
        super.run(name,date);
    }
}
