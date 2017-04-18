/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.util.ArrayList;

/**
 *
 * @author ernesto
 */
public interface GeneratorModelInterface {

    void setExcelPath(String excelPath);
    void setCsvPath(String csvPath);
    void setReportPath(String reportPath);
    String getExcelPath();
    ArrayList<String> getProffesors();
    void setProffesors(ArrayList<String> proffesors);
}
