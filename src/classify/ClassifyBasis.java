package classify;

import input.ReadCell;

import java.util.HashMap;

public abstract class ClassifyBasis {
    public ReadCell rc;
    protected HashMap<String, String> hm;
    protected String address;

    public ClassifyBasis() {
        rc = new ReadCell();
        hm = new HashMap<String, String>();
    }
    public abstract void classify(String name, String date);
    public void getData(String name, String date) {
             rc.getData(hm,name,date);
    }

    public void run(String name,String date) {
        classify(name,date);
        getData(name,date);
    }

    public String getAddress() {
        return this.address;
    }

    public HashMap<String, String> getHashMap() {
        return this.hm;
    }
}
