package output;

import classify.Classify1;
import exportsentences.Export;
import input.ReadCell;
import input.ReadFileTxt;
import modelsentences.Model1;

import java.util.HashMap;
import java.util.Scanner;

import static pre_process.Convention.*;

public class Output1 extends  Outputt{
    public Output1() {
        super();
    }
    public void run(String name, String date) {
        Classify1 cl = new Classify1();
        Model1 md = new Model1();
        cl.run(name,date);
        HashMap<String, String> hm = cl.getHashMap();
        String address = cl.getAddress();
        String sentences = rf.chooseSentences(rf.readLine(address));
        String modelSentences = md.model(sentences);
        System.out.println(ex.replace(modelSentences, hm));
    }

    public static void main(String[] args) {
        Output1 op = new Output1();
        op.run("VN-INDEX", "21/05/2020");
        }
}

