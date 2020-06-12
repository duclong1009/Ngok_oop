package output;

import classify.Classify;
import classify.ClassifyNumberofIncreases;
import exportsentences.Export;
import input.ReadCell;
import input.ReadFileTxt;
import modelsentences.Model;
import modelsentences.ModelNumberOfIncreases;

import java.util.HashMap;
import java.util.Scanner;

import static pre_process.Convention.*;

public class OutputNumberOfIncreases {
    public void run(String name, String date) {
        Export ex = new Export();
        ReadFileTxt rf = new ReadFileTxt();
        ReadCell rc = new ReadCell();
        ClassifyNumberofIncreases cl = new ClassifyNumberofIncreases();
        ModelNumberOfIncreases md = new ModelNumberOfIncreases();
        cl.classify(name,date);
        String address = SOLANTANGGIAM;
        // phân loại là phiên giao dịch tăng hay giảm
        System.out.println(address);
        //Chọn ngẫu nhiên 1 câu trong file
        String sentences = rf.chooseSentences(rf.readLine(address));
        System.out.println(sentences);
        //mô hình câu
        String modelSentences = md.model(sentences);
        System.out.println(modelSentences);
        // lấy dữ liệu với input là name và date
        HashMap<String, String> hm = new HashMap<String, String>();
        rc.getData(hm, name, date);
        hm.put("TimesIncreases", cl.timesIncreases);
        hm.put("TimesReduction", cl.timesReduction);
        //xuất câu đã thay thế
        System.out.println(ex.replace(modelSentences, hm));
        System.out.println(hm);


    }

    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.println("Nhap ten: ");
        String name = sr.nextLine();
        System.out.println("Nhap ngay: ");
        String date = sr.nextLine();
        OutputNumberOfIncreases op = new OutputNumberOfIncreases();
        op.run(name, date);
    }
}
