/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import InterfaceClasses.Question;
import InterfaceClasses.QuestionType;
import InterfaceClasses.Questions;

/**
 * @author ernesto
 */
public class GeneratorModel implements GeneratorModelInterface{
    private String  excelPath;
    private String  csvPath;
    private String  reportPath;
    private Questions evaluatedProffesors;
    private Questions subjectNumericalData  = new Questions(QuestionType.category.SUBJECT, QuestionType.type.NUMERICAL);
    private Questions subjectTextualData    = new Questions(QuestionType.category.SUBJECT, QuestionType.type.TEXTUAL);
    private Questions proffesorNumericalData= new Questions(QuestionType.category.PROFFESOR, QuestionType.type.NUMERICAL);
    private Questions proffesorTextualData  = new Questions(QuestionType.category.PROFFESOR, QuestionType.type.TEXTUAL);
    
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
    
    public Questions getEvaluatedProffesors(){
        if(evaluatedProffesors == null) {
            evaluatedProffesors = new Questions(QuestionType.category.DEFAULT, QuestionType.type.SIMPLE);
            Question evaluatedProffesor = new Question();
            evaluatedProffesors.add(evaluatedProffesor);
        }
        return evaluatedProffesors;
    }
    
    public Question getEvaluatedProffesor(int ord){
        if(evaluatedProffesors == null) {
            evaluatedProffesors = new Questions(QuestionType.category.DEFAULT, QuestionType.type.SIMPLE);
            Question evaluatedProffesor = new Question();
            evaluatedProffesors.add(evaluatedProffesor);
        }
        return evaluatedProffesors.getQuestions().get(ord);
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

    public void setEvaluatedProffesors(Questions evaluatedProffesors){
        this.evaluatedProffesors = evaluatedProffesors;
    }
    

}
