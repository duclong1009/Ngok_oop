package output;

import exportsentences.Export;
import input.ReadCell;
import input.ReadFileTxt;
import modelsentences.Model;

public abstract class  Outputt {
    public Export ex;
    public ReadFileTxt rf;
    public ReadCell rc ;

    public Outputt() {
        this.ex = new Export();
        this.rc = new ReadCell();
        this.rf = new ReadFileTxt();
    }

    public abstract void run(String name, String date);

}
