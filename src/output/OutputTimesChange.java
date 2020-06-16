package output;

import classify.ClassifyTimesChange;
import modelsentences.ModelTimesChange;

import java.util.HashMap;

public class OutputTimesChange extends  Outputt{

    public OutputTimesChange() {
        super();
    }

    @Override
    public void run(String name, String date) {
        ClassifyTimesChange cl = new ClassifyTimesChange();
        ModelTimesChange md = new ModelTimesChange();
        cl.run(name,date);
        HashMap<String, String> hm = cl.getHashMap();
        String address = cl.getAddress();
        String sentences = rf.chooseSentences(rf.readLine(address));
        String modelSentences = md.model(sentences);
        System.out.println(ex.replace(modelSentences, hm));
    }

    public static void main(String[] args) {
        OutputTimesChange op = new OutputTimesChange();
        while (true) {
            try {
                op.run("VN-INDEX", "21/05/2020");
            } catch (Exception e) {
                continue;
            }

        }
    }
}

