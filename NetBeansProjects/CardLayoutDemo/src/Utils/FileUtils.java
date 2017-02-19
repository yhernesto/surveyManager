/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ernesto
 */
public class FileUtils {
    
    public FileUtils(){};
    
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
    
    
}
