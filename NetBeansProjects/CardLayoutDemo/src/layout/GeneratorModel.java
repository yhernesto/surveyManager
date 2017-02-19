/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

/**
 * @author ernesto
 */
public class GeneratorModel implements GeneratorModelInterface{
    int numero;
    String  excelPath;
    String  csvPath;
    String  reportPath;
    
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
    
}
