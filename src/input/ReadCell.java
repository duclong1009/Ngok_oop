package input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import exportsentences.Export;
import modelsentences.Model;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static pre_process.Convention.*;

public class ReadCell {
    public String ReadCellData(String name, int vRow, int vColumn) {
        String value = null;          //variable for storing the cell value
        Workbook wb = null;           //initialize Workbook null
        try {
//reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\du_lieu_btl.xlsx");
//constructs an XSSFWorkbook object, by buffering the whole stream into the memory
            wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Sheet sheet = wb.getSheet(name);   //getting the XSSFSheet object at given index
        Row row = sheet.getRow(vRow); //returns the logical row
        Cell cell = row.getCell(vColumn); //getting the cell representing the given column
        value = cell.getStringCellValue();    //getting cell value
        return value;               //returns the cell value
    }
    //Tìm chỉ số với input là ngày và tên của sàn
    public int getRow(String name, String date) {
        ReadCell rc = new ReadCell();
        int indexRow = 0;
        int i = 0;
        while (rc.ReadCellData(name, i, 0) != null) {
            if (date.equals(rc.ReadCellData(name, i, 0))) {
                indexRow = i;
                break;
            } else indexRow = -1;
            i++;
        }
        return indexRow;
    }

    // Tạo HashMap lưu dữ liệu
    public void getData(HashMap<String, String>hm,String name, String date) {
        String ch;
        String valueChange;
        String valueState;
        String prePri;

        // mã hóa column 3
        int indexRow = getRow(name,date);
        String st = ReadCellData(name,indexRow,2);
        String[] arr = st.split("\\)|\\(|%");
        double ar1 = Double.parseDouble(arr[0]);
        double ar2 = Double.parseDouble(arr[1]);
        if(ar1 >= 0) {
            ch="tăng";
            prePri = "đạt";
            valueChange = arr[0];
            valueState = arr[1]+"%";
        }
        else {
            prePri = "còn";
            ch = "giảm";
            ar1 = -ar1;
            ar2 = -ar2;
            valueChange = String.valueOf(ar1);
            valueState = String.valueOf(ar2)+"%";
        }
        // thêm dữ liệu vào kiểu HashMap
        hm.put("Name",name);
        hm.put("Date",ReadCellData(name,indexRow,0));
        hm.put(CURRENTPRICE,ReadCellData(name,indexRow,1));
        hm.put("Change",ch);
        hm.put("ChangePrice",valueChange);
        hm.put("preCurrentPrice",prePri);
        hm.put("State",valueState);

    }


//    public static void main(String[] args) {
//// đọc dữ liệu
//        ReadCell rc = new ReadCell();   //object of the class
//        int indexRow = rc.getRow("VN-INDEX", "20/05/2020");
//        HashMap<String, String> x = new HashMap<String, String>();
//        rc.getData(x,"VN-INDEX", indexRow, 0);
//        System.out.println(indexRow);
//        Set<String> keySet = x.keySet();
//        for (String key : keySet) {
//            System.out.println(key + " - " + x.get(key));
//        }
//        Export ex =new Export();
//        Model md = new Model();
//        //mô hình câu
//        String test = " Chốt phiên giao dịch ngày 11/4, VN-Index giảm hơn 31 điểm (tương đương 2,59%) còn 1.167 điểm.";
//        System.out.println(test);
//        String t = md.model(test);
//        System.out.println(t);
//        // thay thế
//        String m = ex.replace(t,x);
//        System.out.println(m);
//
//
//    }
}
