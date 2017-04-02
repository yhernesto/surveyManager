/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import InterfaceClasses.ModelTable;
import InterfaceClasses.RowTable;
import InterfaceClasses.Table;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author ernesto
 */
public interface GeneratorControllerInterface {
    void nextButton(JButton button, JTabbedPane jtp);
    void previousButton(JButton button, JTabbedPane jtp);
    void setTextTextfield(JTextField textField, String text);
    void setExcelPath(String excelPath);
    void setCsvPath(String csvPath);
    void setReportPath(String reportPath);
    String getExcelPath();
    void loadExcelTable(String excelPath);
    public void questions_buttonAdd(Table questionTable,ModelTable questionTableModel, RowTable newRow);
    public void question_buttonRemove(Table questionTable,ModelTable questionTableModel);

}
