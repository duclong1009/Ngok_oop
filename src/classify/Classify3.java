package classify;

import static pre_process.Convention.DATMOC_TXT;

public class Classify3 extends ClassifyBasis {
    public Integer nearPrice;

    public  Classify3() {
        super();
        nearPrice = new Integer(0);
    }

    @Override
    public void classify (String name,String date) {
        int indexRow = rc.getRow(name, date);
        String st = rc.ReadCellData(name, indexRow, 1);
        Float value =  Float.parseFloat(st);
        float value1 = (float)(value/100.0);
        int valueInt = (int) value1;
        float valueFloat = value - valueInt*100;
        if(valueFloat>50.0) {
            nearPrice = (valueInt+1)*100;
            address = DATMOC_TXT;
        }
    }

    @Override
    public void getData(String name, String date) {
        super.getData(name, date);
        hm.put("NEARPRICE",nearPrice.toString());
    }
}
