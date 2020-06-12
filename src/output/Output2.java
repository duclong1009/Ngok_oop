package output;

import classify.Classify2;
import modelsentences.Model2;

import java.util.HashMap;
import java.util.Scanner;

import static pre_process.Convention.*;

public class Output2 extends  Outputt{
    public Output2() {
        super();
    }
    public void run (String name,String date) {
        int INDEX_BEGIN = 3;
        Classify2 cl = new Classify2();
        Model2 md = new Model2();
        String address = null;
        Integer times = new Integer(-1);
        if(cl.TimesIncreasingConsecutive(name,INDEX_BEGIN)>0) {
            times = cl.TimesIncreasingConsecutive(name,INDEX_BEGIN);
            address = TANGLIENTUC_TXT;
        }
        else if(cl.TimeReductionConsecutive(name,INDEX_BEGIN)>0) {
            times = cl.TimeReductionConsecutive(name,INDEX_BEGIN);
            address = GIAMLIENTUC_TXT;
        }
        else if(cl.TimeReductionCon(name,INDEX_BEGIN)>0) {
            times = cl.TimeReductionCon(name,INDEX_BEGIN);
            address = TANGROIGIAMLIENTUC_TXT;
        }
        else if(cl.TimeIncreaseCon(name,INDEX_BEGIN)>0) {
            times = cl.TimeIncreaseCon(name,INDEX_BEGIN);
            address = GIAMROITANGLIENTUC_TXT;
        }

        System.out.println(address);
        //Chọn ngẫu nhiên 1 câu trong file
        String sentences = rf.chooseSentences(rf.readLine(address));
        //mô hình câu
        String modelSentences = md.model(sentences);
        // lấy dữ liệu với input là name và date
        HashMap<String, String> hm = new HashMap<String, String>();
        rc.getData(hm,name,date);
        hm.put("TIMES",times.toString());
        //xuất câu đã thay thế
        System.out.println(ex.replace(modelSentences,hm));
    }

    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.println("Nhap ten: ");
        String name = sr.nextLine();
        System.out.println("Nhap ngay: ");
        String date = sr.nextLine();
        Output2 op = new Output2();
        op.run(name,date);
    }


}
