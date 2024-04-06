package com.athens;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EmailScraping {
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("http://ensat.ac.ma/Portail/liste-des-enseignant-du-departement-gei/").get();
        Element table = doc.select("table").first();
        File file = new File("output.csv");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        int count = 0 ;
        for (Element row : table.select("tr")){
            StringBuilder rowText = new StringBuilder();
            for (Element cell : row.select("td")){
                rowText.append(cell.text()).append(",");
                count ++;
                if (count ==2) break;
            }
            writer.write(rowText.toString());
            writer.write("\n");
        }
        writer.close();
        System.out.println("Data has been extracted ");

    }
}
