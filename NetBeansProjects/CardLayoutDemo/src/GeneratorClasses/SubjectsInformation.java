/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorClasses;

import documentClasses.Csv;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

/**
 *
 * @author ernesto
 * 
 * Store Subjects information from the CSV
 */
public class SubjectsInformation {
    Map<String, Pair<String, Integer>> subjectsInformation;
    String csvSeparator;
    String csvFilePath;
    int SUBJECT_COD_COLUMN      = 12;
    int SUBJECT_COD_MARK_COLUMN = 13;
    int SUBJECT_ENROLLED_COLUMN = 15;
    int SUBJECT_DEGREE_COLUMN   = 1;

    public SubjectsInformation(String csvSeparator, String csvFilePath) {
        this.subjectsInformation = new HashMap<String, Pair<String, Integer>>();
        this.csvSeparator = csvSeparator;
        this.csvFilePath = csvFilePath;
    }
    
    
    public void loadSubejctsInformation(){
        String line1 = "", line2, subCod, subCodMark, degree;
        String[] formatedLine;
        Integer enrolledStudents;
        try {
            File file = new File(csvFilePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
//            while((line = br.readLine()) != null){
//                formatedLine = line.split(csvSeparator);
//                subCod = formatedLine[SUBJECT_COD_COLUMN];
//                subCodMark = formatedLine[SUBJECT_COD_MARK_COLUMN];
//                if(subCod.contains("-") && subCodMark.contains("[")){
//                    degree = formatedLine[SUBJECT_DEGREE_COLUMN];
//                    line = br.readLine();
//                    formatedLine = line.split(csvSeparator);
//                    if(formatedLine[SUBJECT_ENROLLED_COLUMN].matches("^\\d+$")){
//                        enrolledStudents = Integer.parseInt(formatedLine[SUBJECT_ENROLLED_COLUMN]);
//                        subjectsInformation.put(subCod.trim(), new Pair(degree, enrolledStudents));
//                        nextLine = true;
//                    }else{
//                        nextLine = false;
//                    }
//                }
//            }

            while((line2 = br.readLine()) != null){
                formatedLine = line1.split(csvSeparator);
                if(formatedLine.length > 0 && formatedLine.length >= SUBJECT_COD_MARK_COLUMN){
                    subCod = formatedLine[SUBJECT_COD_COLUMN];
                    subCodMark = formatedLine[SUBJECT_COD_MARK_COLUMN];
                    degree = formatedLine[SUBJECT_DEGREE_COLUMN];
                    if(subCod.contains("-") && subCodMark.contains("[")){
                        formatedLine = line2.split(csvSeparator);
                        if(formatedLine.length > 0 && formatedLine.length >= SUBJECT_ENROLLED_COLUMN && formatedLine[SUBJECT_ENROLLED_COLUMN].matches("^\\d+$")){
                            enrolledStudents = Integer.parseInt(formatedLine[SUBJECT_ENROLLED_COLUMN]);
                            subCod = subCod.split("-")[0] + "-" + String.valueOf(Integer.valueOf(subCod.split("-")[1])); //removing the 0 pad in code group
                            subjectsInformation.put(subCod.trim(), new Pair(degree, enrolledStudents));
                        }
                    }                    
                }
                line1 = line2;
            }
           

            br.close(); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex){
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getDegree(String cod, String group){
        if(!this.subjectsInformation.isEmpty() && cod != null && group != null){
            String code = cod + "-" + group;
            if(this.subjectsInformation.containsKey(code)) return this.subjectsInformation.get(code).getKey();
        }
        return null;
    }
    
    public Integer getEnrolledStudents(String cod, String group){
        if(!this.subjectsInformation.isEmpty() && cod != null && group != null){
            String code = cod + "-" + group;
            if(this.subjectsInformation.containsKey(code)) return this.subjectsInformation.get(code).getValue();
        }
        return null;
    }
}
