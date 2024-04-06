package com.athens;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements; // Import Elements class

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup
                    .connect("http://ensat.ac.ma/Portail/")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                    .header("Accept-Language", "*")
                    .get();
            // Correct class name without the dot prefix
            Elements elements = doc.getElementsByClass("home blog wp-custom-logo site-layout-fluid global-layout-right-sidebar enabled-sticky-primary-menu home-content-not-enabled");
            // Loop through the elements and print their text
            File file = new File("dataScraped.txt");
            if (file.createNewFile()) System.out.println("created");
            FileWriter w = new FileWriter(file);

            for (Element element : elements) {

                w.write(element.text());
                System.out.println(element.text());

            }
            w.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
