/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import InterfaceClasses.ModelTable;
import InterfaceClasses.RowTable;
import InterfaceClasses.Table;
import Panels.ProffesorQuestions;
import Panels.Questions;
import Panels.SimpleQuestions;
import Panels.SubjectQuestions;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author ernesto
 */
public class GeneratorController implements GeneratorControllerInterface{
    
    GeneratorView gview;
    GeneratorModelInterface gmi;
    
    public GeneratorController(GeneratorModelInterface gmi){
        this.gmi = gmi;
        gview = new GeneratorView(this, gmi);
        gview.createAndShowGUI();
    }
    
    public void nextButton(JButton jb , JTabbedPane jtp ){
        System.out.println(jtp.getSelectedIndex());
        if(jtp.getSelectedIndex() < jtp.getTabCount() - 1){
            jtp.setSelectedIndex(jtp.getSelectedIndex() + 1);
            jtp.setEnabledAt(jtp.getSelectedIndex(), true);
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
        gview.wizard.subjNumerical.loadExcel(excelPath);
        gview.wizard.subjTextual.loadExcel(excelPath);
        gview.wizard.proffEvaluated.loadExcel(excelPath);
        gview.wizard.proffTextual.loadExcel(excelPath);
        gview.wizard.proffNumerical.loadExcel(excelPath);

    }
    
    public void questions_buttonAdd(Table questionTable,ModelTable questionTableModel){
//        questionTableModel.addRowTable(newRow);
        questionTable.updateTable(questionTableModel);
    }

    public void question_buttonRemove(Table questionTable, ModelTable questionTableModel){
        questionTableModel.removeLastRowTable();
        questionTable.updateTable(questionTableModel);
    };

    public void setProffesors(ArrayList<String> proffesors) {
        gmi.setEvaluatedProffesors(proffesors);
    }

    public ArrayList<String> getProffesors() {
        return gmi.getEvaluatedProffesors();
    }

//    public void updateEvaluatedProffesors(SimpleQuestions evaluatedProffesors){
//        gview.wizard.proffNumerical.clearData();
//        gview.wizard.proffTextual.clearData();
//        
//        setProffesors(evaluatedProffesors.getProffesors());
//        
//        gview.wizard.proffNumerical.myInitComponents();
//        gview.wizard.proffTextual.myInitComponents();   
//    }
    
    public void updateTableData(Questions questionsAndAnswers){
        if(questionsAndAnswers.getClass() == SubjectQuestions.class){
            SubjectQuestions subjQuestions = (SubjectQuestions) questionsAndAnswers;
            if(subjQuestions.getQUESTION_TYPE() == Questions.QuestionsType.NUMERICAL){
                gmi.setSubjectNumericalQuestions(subjQuestions.getQuestions());
                gmi.setSubjectNumericalAnswers(subjQuestions.getAnswers());
            }else if(subjQuestions.getQUESTION_TYPE() == Questions.QuestionsType.TEXTUAL){
                gmi.setSubjectTextualQuestions(subjQuestions.getQuestions());
                gmi.setSubjectTextualAnswers(subjQuestions.getAnswers());                
            }
        }else if (questionsAndAnswers.getClass() == ProffesorQuestions.class){
            ProffesorQuestions proffQuestions = (ProffesorQuestions) questionsAndAnswers;
            if(proffQuestions.getQUESTION_TYPE() == Questions.QuestionsType.NUMERICAL){
                gmi.setProffesorNumericalQuestions(proffQuestions.getQuestions());
                gmi.setProffesorNumericalAnswers(proffQuestions.getAnswers());
            }else if(proffQuestions.getQUESTION_TYPE() == Questions.QuestionsType.TEXTUAL){
                gmi.setProffesorTextualQuestions(proffQuestions.getQuestions());
                gmi.setProffesorTextualAnswers(proffQuestions.getAnswers());                
            }
        }else if(questionsAndAnswers.getClass() == SimpleQuestions.class){
            SimpleQuestions simpleQuestions = (SimpleQuestions) questionsAndAnswers;
            if(simpleQuestions.getQUESTION_TYPE() == Questions.QuestionsType.SIMPLE){
                clearProffesorsData();
                gmi.setEvaluatedProffesors(simpleQuestions.getQuestions());
                updateProffesorsData();
            };
        }
    }
    
    public void clearProffesorsData(){
        gview.wizard.proffNumerical.clearData();
        gview.wizard.proffTextual.clearData();
    }
    
    public void updateProffesorsData(){
        gview.wizard.proffNumerical.setEnabled(true);
        gview.wizard.tab4_save.setEnabled(true);
        gview.wizard.proffTextual.setEnabled(true);
        gview.wizard.tab5_save.setEnabled(true);
        gview.wizard.proffNumerical.myInitComponents();
        gview.wizard.proffTextual.myInitComponents();
    }
}
