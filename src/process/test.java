package process;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String html = "https://vnexpress.net/vn-index-len-sat-nguong-900-diem-4111893.html";
        Document doc = Jsoup.parse(html);
        Element text = doc.body();
        doc.clone();
        System.out.println(text.attr("<body>"));
        System.out.println(text);

    }
}
