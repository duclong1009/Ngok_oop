package input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

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
//            FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\du_lieu_btl.xlsx");
            FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\HOSE.xlsx");
//constructs an XSSFWorkbook object, by buffering the whole stream into the memory
            wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheet(name);
            DataFormatter formatter = new DataFormatter();
            value = formatter.formatCellValue(sheet.getRow(vRow).getCell(vColumn));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
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
        hm.put("Date",date);
        hm.put(CURRENTPRICE,ReadCellData(name,indexRow,1));
        hm.put("ChangePrice",valueChange);
        hm.put("State",valueState);
        hm.put("matchingTradeWeight ",ReadCellData(name,indexRow,4));
        hm.put("matchingTradeValue ",ReadCellData(name,indexRow,5));
        hm.put("transactionWeight  ",ReadCellData(name,indexRow,6));
        hm.put("transactionValue  ",ReadCellData(name,indexRow,7));

    }


  public static void main(String[] args) {
      ReadCell rc = new ReadCell();
      String s = rc.ReadCellData("Sheet1",2,1);
      System.out.println(s);


      }
  }

