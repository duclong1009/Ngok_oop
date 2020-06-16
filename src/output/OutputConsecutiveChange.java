package output;

import classify.ClassifyConsecutiveChange;
import modelsentences.ModelConsecutiveChange;

import java.util.HashMap;

public class OutputConsecutiveChange extends  Outputt{

    public OutputConsecutiveChange() {
        super();
    }

    @Override
    public void run(String name, String date) {
        ClassifyConsecutiveChange cl = new ClassifyConsecutiveChange();
        ModelConsecutiveChange md = new ModelConsecutiveChange();
        cl.run(name,date);
        HashMap<String, String> hm = cl.getHashMap();
        String address = cl.getAddress();
        String sentences = rf.chooseSentences(rf.readLine(address));
        String modelSentences = md.model(sentences);
        System.out.println(ex.replace(modelSentences, hm));
    }

    public static void main(String[] args) {
        OutputConsecutiveChange op = new OutputConsecutiveChange();
        while (true) {
            try {
                op.run("VN-INDEX", "21/05/2020");
            } catch (Exception e) {
                continue;
            }

        }
    }
}

