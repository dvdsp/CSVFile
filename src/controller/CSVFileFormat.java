/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Library;
import java.util.ArrayList;
import model.CSV;
import view.Menu;

/**
 *
 * @author DELL
 */
public class CSVFileFormat extends Menu<String> {
    static String[] mc = {"Develop a program to Stabdardize CSV file with mews: import CSV",
                           "Format Address",
                           "Format Name",
                           "Export CSV",
                           "exit"};
    protected ArrayList<CSV> csv;
    public CSVFileFormat() {
        super("\n\tCSV FILE FORMAT", mc);
        csv = new ArrayList<>();
        csv.add(new CSV("1","NguyEn       ANh a","a@gmail.com","0901230409","CAU giay      - Ha Noi"));
        csv.add(new CSV("2","NGUyen anh  B","b@gmail.com","0901230499","Quan 1-   Ho Chi Minh"));
        csv.add(new CSV("3","nGUYEN Anh C","c@gmail.com","0901239409","Da Lat       - lam DOng"));
        csv.add(new CSV("4","NGUYENn aNh e","d@gmail.com","0901230909","Phu quoc           Kien Giang"));
    }

    @Override
    public void execute(int n) {
        switch(n) {
            case 1: Library.importFile(csv);
                    Library.display(csv);
                    break;
            case 2: Library.formatAddress(csv);
                    Library.display(csv);
                    break;
            case 3:
                    Library.formatName(csv);
                    Library.display(csv);
                    break;
            case 4: Library.exportFile(csv);
                    break;
            case 5: System.exit(0);
        }
    }
    
}
