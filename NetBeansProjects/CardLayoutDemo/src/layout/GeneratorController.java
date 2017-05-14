/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import InterfaceClasses.ModelTable;
import InterfaceClasses.ProffesorQuestion;
import InterfaceClasses.Question;
import InterfaceClasses.QuestionType;
import InterfaceClasses.Questions;
import InterfaceClasses.RowTable;
import InterfaceClasses.SubjectQuestion;
import InterfaceClasses.Table;
import Panels.ProffesorQuestionsPanel;
import Panels.QuestionsPanel;
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

    
        
    public Questions getProffesors(){
        return gmi.getEvaluatedProffesors();
    }
    
    
    public void updateTableData(QuestionsPanel questionPanel){
        Questions questions = new Questions(questionPanel.getCategory(), questionPanel.getType());
        ArrayList<String>   questionsRawData = questionPanel.getQuestions();
        ArrayList<String>   answersRawData = questionPanel.getAnswers();
        if(questionPanel.getCategory() == QuestionType.category.SUBJECT){
            SubjectQuestion     subjectQuestion;
            for(int i = 0; i < questionPanel.getQuestions().size(); i++){
                subjectQuestion = new SubjectQuestion();
                subjectQuestion.setQuestion(questionsRawData.get(i));
                subjectQuestion.setAnswer(answersRawData.get(i));
                questions.add(subjectQuestion);
            }
            if(questionPanel.getType() == QuestionType.type.NUMERICAL){
                gmi.setSubjectNumericalData(questions);
            }else if(questionPanel.getType() == QuestionType.type.TEXTUAL){
                gmi.setSubjectTextualData(questions);
            }
        }else if(questionPanel.getCategory() == QuestionType.category.PROFFESOR){
            ProffesorQuestion   proffesorQuestion;
            int index;
            int proffesorsSize = gmi.getEvaluatedProffesors().getQuestions().size();
            for(int i = 0; i < questionPanel.getQuestions().size(); i++){
                proffesorQuestion = new ProffesorQuestion();
                proffesorQuestion.setQuestion(questionPanel.getQuestions().get(i));
                for(int j = 0; j < proffesorsSize ; j++){
                    index = (proffesorsSize * i) + j;
                    proffesorQuestion.addProffesor(gmi.getEvaluatedProffesor(j).getQuestion());
                    proffesorQuestion.addAnswer(answersRawData.get(index));
                }
                questions.add(proffesorQuestion);
            }
            if(questionPanel.getType() == QuestionType.type.NUMERICAL){
                gmi.setProffesorNumericalData(questions);
            }else if(questionPanel.getType() == QuestionType.type.TEXTUAL){
                gmi.setProffesorTextualData(questions);
            }
        }else{
            //CATEGORY == SIMPLE or DEFAULT
            Question    simpleQuestion;
             for(int i = 0; i < questionPanel.getQuestions().size(); i++){
                simpleQuestion = new SubjectQuestion();
                simpleQuestion.setQuestion(questionsRawData.get(i));
                questions.add(simpleQuestion);
            }
            if(questionPanel.getType() == QuestionType.type.SIMPLE){
                clearProffesorsData();
                gmi.setEvaluatedProffesors(questions);
                updateProffesorsData();
            }
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
    
    public void loadResumen(){
        gview.wizard.resumen.myInitComponents();
    }
    
    public Questions getEvaluatedProffesors(){
        return gmi.getEvaluatedProffesors();
    };
    
    public Questions getSubjectNumericalData(){
        return gmi.getSubjectNumericalData();
    };
    
    public Questions getSubjectTextualData(){
        return gmi.getSubjectTextualData();
    };
    public Questions getProffesorNumericalData(){
        return gmi.getProffesorNumericalData();
    };
    
    public Questions getProffesorTextualData(){
        return gmi.getProffesorTextualData();
    };
}
