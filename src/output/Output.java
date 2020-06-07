package output;

import classify.Classify;
import exportsentences.Export;
import input.ReadCell;
import input.ReadFileTxt;
import modelsentences.Model;

import java.util.HashMap;
import java.util.Scanner;

import static pre_process.Convention.GIAM_TXT;
import static pre_process.Convention.TANG_TXT;

public class Output {
    public void export (String name, String date) {
        Export ex = new Export();
        ReadFileTxt rf = new ReadFileTxt();
        ReadCell rc = new ReadCell();
        Classify cl = new Classify();
        Model md = new Model();
        String address = null;
        // phân loại là phiên giao dịch tăng hay giảm
        String change = cl.classifyChange(name,date);
        if(change.equals("Tăng")) {
            address = TANG_TXT;
        }
        else if(change.equals("Giảm")) {
            address = GIAM_TXT;
        }
        //Chọn ngẫu nhiên 1 câu trong file
        String sentences = rf.chooseSentences(rf.readLine(address));
        //mô hình câu
        String modelSentences = md.model(sentences);
        // lấy dữ liệu với input là name và date
        HashMap<String, String> hm = new HashMap<String, String>();
        rc.getData(hm,name,date);
        //xuất câu đã thay thế
        System.out.println(ex.replace(modelSentences,hm));
    }

    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.println("Nhap ten: ");
        String name = sr.nextLine();
        System.out.println("Nhap ngay: ");
        String date = sr.nextLine();
        Output op = new Output();
        op.export(name,date);
    }
}
