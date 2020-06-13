package input;

import modelsentences.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static pre_process.Convention.SOLANTANGGIAM;


public class ReadFileTxt {
    //Đọc và chuyển file txt thành list các câu
    public ArrayList<String> readLine(String address) {
        BufferedReader br = null;
//        Model md = new Model();
        ArrayList<String> listSentences = new ArrayList<String>();

        try {
            br = new BufferedReader(new FileReader(address));
//            System.out.println("Đọc nội dung file sử dụng phương thức readLine()");
            String textInALine;
            while ((textInALine = br.readLine()) != null) {
                textInALine = br.readLine();
                listSentences.add(textInALine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listSentences;
    }
    // chọn ngẫu nhiên 1 câu trong list
    public String chooseSentences (ArrayList<String > list) {
        Random rd = new Random();
        int size = list.size();
        int index = rd.nextInt(size);
        String sentence = list.get(index);
        return sentence;
    }

    public static void main(String[] args) {
        ReadFileTxt rf = new ReadFileTxt();
        String t = rf.chooseSentences(rf.readLine(SOLANTANGGIAM));
        System.out.println(t);
    }


}
