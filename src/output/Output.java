package output;

import classify.Classify;
import classify.Classify1;
import exportsentences.Export;
import input.ReadCell;
import input.ReadFileTxt;
import modelsentences.Model;
import modelsentences.Model1;

import java.util.HashMap;
import java.util.Scanner;

import static pre_process.Convention.*;

public class Output extends  Outputt{
    public Output() {
        super();
    }
    public void run(String name, String date) {
        Classify cl = new Classify();
        Model md = new Model();
        cl.run(name,date);
        HashMap<String, String> hm = cl.getHashMap();
        String address = cl.getAddress();
        String sentences = rf.chooseSentences(rf.readLine(address));
        String modelSentences = md.model(sentences);
        System.out.println(ex.replace(modelSentences, hm));
    }

    public static void main(String[] args) {
        Output op = new Output();
        op.run("VN-INDEX", "21/05/2020");
    }
}

