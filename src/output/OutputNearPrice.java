package output;

import classify.ClassifyNearPrice;
import modelsentences.Model1;
import modelsentences.ModelNearPrice;

import java.util.HashMap;

public class OutputNearPrice extends  Outputt{

    public OutputNearPrice()  {
        super();
    }

    @Override
    public void run(String name, String date) {
        ClassifyNearPrice cl = new ClassifyNearPrice();
        ModelNearPrice md = new ModelNearPrice();
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
        OutputNearPrice op = new OutputNearPrice();
        while (true) {
            try {
                op.run("VN-INDEX", "21/05/2020");
            } catch (Exception e) {
                continue;
            }

        }
    }
}

