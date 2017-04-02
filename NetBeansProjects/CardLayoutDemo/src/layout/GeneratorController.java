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
public class GeneratorController implements GeneratorControllerInterface{
    
    GeneratorView generatorView;
    GeneratorModelInterface gmi;
    
    public GeneratorController(GeneratorModelInterface gmi){
        this.gmi = gmi;
        generatorView = new GeneratorView(this, gmi);
        generatorView.createAndShowGUI();
    }
    
    public void nextButton(JButton jb , JTabbedPane jtp ){
        System.out.println(jtp.getSelectedIndex());
        if(jtp.getSelectedIndex() < jtp.getTabCount() - 1){
            jtp.setSelectedIndex(jtp.getSelectedIndex() + 1);
        }else{
            System.out.println("no existe siguiente");
        }
    }
    
    public void previousButton(JButton jb, JTabbedPane jtp){
        System.out.println(jtp.getSelectedIndex());
        if(jtp.getSelectedIndex() > 0){
            jtp.setSelectedIndex(jtp.getSelectedIndex() - 1);
        }else{
            System.out.println("no existe anterior");
        }
    }
    
    public void setTextTextfield(JTextField textField, String text){
        textField.setText(text);
    }
    
    public void setExcelPath(String excelPath){
        gmi.setExcelPath(excelPath);
    };
    
    public void setCsvPath(String csvPath){
        gmi.setCsvPath(csvPath);
    };
    
    public void setReportPath(String reportPath){
        gmi.setReportPath(reportPath);
    };
    
    public String getExcelPath(){
        return gmi.getExcelPath();
    }
    
    public void loadExcelTable(String excelPath){
        //  comentado mientras debugeamos porque no se un panel dentro de otro
        generatorView.wizard.numericas.loadExcel(excelPath);
        generatorView.wizard.texto.loadExcel(excelPath);
    }
    
    public void questions_buttonAdd(Table questionTable,ModelTable questionTableModel, RowTable newRow){
        questionTableModel.addRowTable(newRow);
        questionTable.updateTable(questionTableModel);
    }

    public void question_buttonRemove(Table questionTable, ModelTable questionTableModel){
        questionTableModel.removeLastRowTable();
        questionTable.updateTable(questionTableModel);
    };
}
