/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import GeneratorClasses.Proffesor;
import GeneratorClasses.Subject;
import InterfaceClasses.Question;
import InterfaceClasses.QuestionType;
import InterfaceClasses.Questions;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ernesto
 */
public class GeneratorModel implements GeneratorModelInterface{
    private String  excelPath;
    private String  csvPath;
    private String  reportPath;
    private Questions proffesorsName;
    private Questions subjectNumericalData  = new Questions(QuestionType.category.SUBJECT, QuestionType.type.NUMERICAL);
    private Questions subjectTextualData    = new Questions(QuestionType.category.SUBJECT, QuestionType.type.TEXTUAL);
    private Questions proffesorNumericalData= new Questions(QuestionType.category.PROFFESOR, QuestionType.type.NUMERICAL);
    private Questions proffesorTextualData  = new Questions(QuestionType.category.PROFFESOR, QuestionType.type.TEXTUAL);
    private List<Proffesor> proffesors      = new ArrayList<Proffesor>();
    private List<Subject> subjects      = new ArrayList<Subject>();
    
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

    public String getCsvPath() {
        return csvPath;
    }

    public String getReportsPath() {
        return reportPath;
    }
    
    public Questions getProffesorsColName(){
        if(proffesorsName == null) {
            proffesorsName = new Questions(QuestionType.category.DEFAULT, QuestionType.type.SIMPLE);
            Question evaluatedProffesor = new Question();
            proffesorsName.add(evaluatedProffesor);
        }
        return proffesorsName;
    }
    
    public Question getEvaluatedProffesor(int ord){
        if(proffesorsName == null) {
            proffesorsName = new Questions(QuestionType.category.DEFAULT, QuestionType.type.SIMPLE);
            Question evaluatedProffesor = new Question();
            proffesorsName.add(evaluatedProffesor);
        }
        return proffesorsName.getQuestions().get(ord);
    }

    public Questions getSubjectNumericalData() {
        return subjectNumericalData;
    }

    public void setSubjectNumericalData(Questions subjectNumericalData) {
        this.subjectNumericalData = subjectNumericalData;
    }

    public Questions getSubjectTextualData() {
        return subjectTextualData;
    }

    public void setSubjectTextualData(Questions subjectTextualData) {
        this.subjectTextualData = subjectTextualData;
    }

    public Questions getProffesorNumericalData() {
        return proffesorNumericalData;
    }

    public void setProffesorNumericalData(Questions proffesorNumericalData) {
        this.proffesorNumericalData = proffesorNumericalData;
    }

    public Questions getProffesorTextualData() {
        return proffesorTextualData;
    }

    public void setProffesorTextualData(Questions proffesorTextualData) {
        this.proffesorTextualData = proffesorTextualData;
    }

    public void setProffesorsColName(Questions proffesorsName){
        this.proffesorsName = proffesorsName;
    }
    
    public void addProffesor(Proffesor proffesor){
        this.proffesors.add(proffesor);
    }

}
