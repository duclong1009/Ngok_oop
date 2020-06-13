package output;

import classify.Classify1;
import classify.Classify2;
import exportsentences.Export;
import input.ReadCell;
import input.ReadFileTxt;
import modelsentences.Model1;
import modelsentences.Model2;

import java.util.HashMap;
import java.util.Scanner;

import static pre_process.Convention.*;

public class Output2 extends  Outputt{
    public Output2() {
        super();
    }
    public void run(String name, String date) {
        Classify2 cl = new Classify2();
        Model2 md = new Model2();
        cl.run(name,date);
        HashMap<String, String> hm = cl.getHashMap();
        String address = cl.getAddress();
        String sentences = rf.chooseSentences(rf.readLine(address));
        String modelSentences = md.model(sentences);
        System.out.println(ex.replace(modelSentences, hm));
    }

    public static void main(String[] args) {
        Output2 op = new Output2();
        op.run("VN-INDEX", "21/05/2020");
    }
}

