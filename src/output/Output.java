package output;

import classify.Classify;
import modelsentences.Model;
import java.util.HashMap;

public class Output extends  Outputt {
    public Output() {
        super();
    }

    @Override
    public void run(String name, String date) {
        Classify cl = new Classify();
        Model md = new Model();
        cl.run(name, date);
        HashMap<String, String> hm = cl.getHashMap();
        String address = cl.getAddress();
        String sentences = rf.chooseSentences(rf.readLine(address));
        String modelSentences = md.model(sentences);
        System.out.println(ex.replace(modelSentences, hm));
    }

    public static void main(String[] args) {
        Output op = new Output();
        while (true) {
            try {
                op.run("VN-INDEX", "21/05/2020");
            } catch (Exception e) {
                continue;
            }

        }
    }
}

