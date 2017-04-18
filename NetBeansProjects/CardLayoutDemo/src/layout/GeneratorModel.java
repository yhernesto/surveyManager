/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.util.ArrayList;

/**
 * @author ernesto
 */
public class GeneratorModel implements GeneratorModelInterface{
    int numero;
    String  excelPath;
    String  csvPath;
    String  reportPath;
    ArrayList<String>   proffesors;
    
    public void setExcelPath(String excelPath){
        this.excelPath  = excelPath;
    };
    
    public void setCsvPath(String csvPath){
        this.csvPath    = csvPath;
    };
    
    public void setReportPath(String reportPath){
        this.reportPath = reportPath;
    };

    public String getExcelPath(){
        return this.excelPath;
    }
    
    public ArrayList<String> getProffesors(){
        if(proffesors == null) {
            proffesors = new ArrayList();
            proffesors.add("");
        }
        return proffesors;
    }
    
    public void setProffesors(ArrayList<String> proffesors){
        this.proffesors = proffesors;
    }
}
