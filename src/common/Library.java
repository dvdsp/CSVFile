/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.CSV;

/**
 *
 * @author DELL
 */
public class Library {
    static final String COMMA_DELIMITER = ",";
    static final String NEW_LINE_SEPARATOR = "\n";
    
    
    public static void importFile(ArrayList<CSV> ls) {
        Scanner sc = new Scanner(System.in);
        String line = "";
        BufferedReader fileReader = null;
        System.out.println("Enter path: ");
        String filename = sc.nextLine().trim();
        try {
            fileReader = new BufferedReader(new FileReader(filename));
            while ((line = fileReader.readLine()) != null) {

                String[] splitCSV = line.split(COMMA_DELIMITER);
                ls.add(new CSV(splitCSV[0], splitCSV[1],
                        splitCSV[2], splitCSV[3], splitCSV[4]));

            }
            System.err.println("Import: Done");
        } catch (FileNotFoundException e) {
            //ignore
        } catch (IOException e) {
            //ignore
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    //ignore
                }
            }
        }
    }
    
    public static void formatAddress(ArrayList<CSV> ls) {
        for (int i = 0; i < ls.size(); i++) {
            String address = ls.get(i).getAddress().trim();
            address = address.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = address.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0)))
                        .append(arr[j].substring(1)).append(" ");
            }
            ls.get(i).setAddress(sb.toString().trim());
        }
        System.out.println("Format Status: Done");
    }
    
    public static void formatName(ArrayList<CSV> ls) {
        for (int i = 0; i < ls.size(); i++) {
            String name = ls.get(i).getName().trim();
            name = name.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = name.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0)))
                        .append(arr[j].substring(1)).append(" ");
            }
            ls.get(i).setName(sb.toString().trim());
        }
        System.out.println("Format Status: Done");
    }
    
    public static void exportFile(ArrayList<CSV> ls) {
        Scanner sc = new Scanner(System.in);
        FileWriter fileWriter = null;
        System.out.print("Enter Path: ");
        String fileName = sc.nextLine();
        try {
            fileWriter = new FileWriter(fileName);
            for (CSV listCSV : ls) {
                fileWriter.append(String.valueOf(listCSV.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getEmail()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getPhone()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getAddress()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.err.println("Export Done!!!");
        } catch (IOException ex) {
            //ignore
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                //ignore
            }
        }
    }

    public static void display(ArrayList<CSV> csvList) {
        for (int i = 0; i < csvList.size(); i++) {
            System.out.format("%s,%s,%s,%s,%s\n", csvList.get(i).getId(),
                    csvList.get(i).getName(), csvList.get(i).getEmail(), csvList.get(i).getPhone(),
                    csvList.get(i).getAddress());
        }
    }
    
    
    
    
    
    
    
    
}
