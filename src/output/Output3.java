package output;

import classify.Classify1;
import classify.Classify2;
import classify.Classify3;
import exportsentences.Export;
import input.ReadCell;
import input.ReadFileTxt;
import modelsentences.Model1;
import modelsentences.Model2;
import modelsentences.Model3;

import java.util.HashMap;
import java.util.Scanner;

import static pre_process.Convention.*;

public class Output3 extends  Outputt{
    public Output3() {
        super();
    }
    public void run(String name, String date) {
        Classify3 cl = new Classify3();
        Model3 md = new Model3();
        cl.run(name,date);
        if(cl.nearPrice>0) {
            HashMap<String, String> hm = cl.getHashMap();
            String address = cl.getAddress();
            String sentences = rf.chooseSentences(rf.readLine(address));
            String modelSentences = md.model(sentences);
            System.out.println(ex.replace(modelSentences, hm));
        }
    }

    public static void main(String[] args) {
        Output3 op = new Output3();
        op.run("VN-INDEX", "21/05/2020");
    }
}

