/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documentClasses;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ernesto
 */
public class Csv {
    ArrayList<String[]> csv = null;
    String csvSeparator;
    int totalColumns;
    int totalRows;
    
    public Csv(){}
    
    public Csv(File file, String csvSeparator){
        this.csvSeparator   = csvSeparator;
        totalColumns        = 0;
        totalRows           = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            csv = new ArrayList<String[]>();
            csv = loadCsv(br);
            totalColumns    = csv.get(0).length;
            totalRows       = csv.size();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private ArrayList<String[]> loadCsv(BufferedReader br){
        String line;
        String[] formatedLine;
        ArrayList<String[]> csv = new ArrayList<>();
        try {
            while((line = br.readLine()) != null){
                formatedLine = line.split(csvSeparator);
                csv.add(formatedLine);
            }
        } catch (IOException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return csv;
    };
    
    public String getValue(int column, int row){
        String value = null;
        String[] line;
        if(!csv.isEmpty() || !(totalColumns < column) || !(totalRows < row)){
            line    = csv.get(row);
            value   = line[column];
        }
        return value;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public int getTotalRows() {
        return totalRows;
    }
    
}
