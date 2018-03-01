/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import documentClasses.Csv;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ernesto
 */
public class FileUtils {
    
    
    public FileUtils(){};
    
    String FIRST_LINE_STRING = "Pla d'estudis:";
    
    public String[] getFilePathAndName(JFileChooser fileChooser, String[] extension){
        String[] filePathAndName = {"",""};
        FileFilter filter = null; 
        if (extension != null){ // extension is null if the file to find is a directory
            filter = new FileNameExtensionFilter("Extension file", extension);
            fileChooser.setFileFilter(filter);
            fileChooser.addChoosableFileFilter(filter);
        }else{
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
             filePathAndName[0] = fileChooser.getSelectedFile().toString();
             int slashPosition  = filePathAndName[0].lastIndexOf("/");
             filePathAndName[1] = filePathAndName[0].substring(slashPosition + 1);
        }
        return filePathAndName;
    }
    
        
    public void formatingCsv(String filePath, String csvSeparator){
        String line;
        String[] formatedLine;
        try {
            File file = new File(filePath);
            File tempFile = File.createTempFile("subjects-", ".csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(tempFile);
            while((line = br.readLine()) != null){
                if(line.lastIndexOf(FIRST_LINE_STRING) != line.indexOf(FIRST_LINE_STRING)){
                    
                    line = br.readLine();
                }
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
    
}
