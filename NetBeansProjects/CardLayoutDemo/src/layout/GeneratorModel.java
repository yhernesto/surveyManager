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
    private String  excelPath;
    private String  csvPath;
    private String  reportPath;
    private ArrayList<String>   evaluatedProffesors;
    private ArrayList<String>   subjectNumericalQuestions;
    private ArrayList<String>   subjectTextualQuestions;
    private ArrayList<String>   proffesorNumericalQuestions;
    private ArrayList<String>   proffesorTextualQuestions;
    private ArrayList<String>   subjectNumericalAnswers;
    private ArrayList<String>   subjectTextualAnswers;
    private ArrayList<String>   proffesorNumericalAnswers;
    private ArrayList<String>   proffesorTextualAnswers;
    
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
    
    public ArrayList<String> getEvaluatedProffesors(){
        if(evaluatedProffesors == null) {
            evaluatedProffesors = new ArrayList();
            evaluatedProffesors.add("");
        }
        return evaluatedProffesors;
    }
    
    public void setEvaluatedProffesors(ArrayList<String> evaluatedProffesors){
        this.evaluatedProffesors = evaluatedProffesors;
    }

    public ArrayList<String> getSubjectNumericalQuestions() {
        return subjectNumericalQuestions;
    }

    public void setSubjectNumericalQuestions(ArrayList<String> subjectNumericalQuestions) {
        this.subjectNumericalQuestions = subjectNumericalQuestions;
    }

    public ArrayList<String> getSubjectTextualQuestions() {
        return subjectTextualQuestions;
    }

    public void setSubjectTextualQuestions(ArrayList<String> subjectTextualQuestions) {
        this.subjectTextualQuestions = subjectTextualQuestions;
    }

    public ArrayList<String> getProffesorNumericalQuestions() {
        return proffesorNumericalQuestions;
    }

    public void setProffesorNumericalQuestions(ArrayList<String> proffesorNumericalQuestions) {
        this.proffesorNumericalQuestions = proffesorNumericalQuestions;
    }

    public ArrayList<String> getProffesorTextualQuestions() {
        return proffesorTextualQuestions;
    }

    public void setProffesorTextualQuestions(ArrayList<String> proffesorTextualQuestions) {
        this.proffesorTextualQuestions = proffesorTextualQuestions;
    }    

    public ArrayList<String> getSubjectNumericalAnswers() {
        return subjectNumericalAnswers;
    }

    public void setSubjectNumericalAnswers(ArrayList<String> subjectNumericalAnswers) {
        this.subjectNumericalAnswers = subjectNumericalAnswers;
    }

    public ArrayList<String> getSubjectTextualAnswers() {
        return subjectTextualAnswers;
    }

    public void setSubjectTextualAnswers(ArrayList<String> subjectTextualAnswers) {
        this.subjectTextualAnswers = subjectTextualAnswers;
    }

    public ArrayList<String> getProffesorNumericalAnswers() {
        return proffesorNumericalAnswers;
    }

    public void setProffesorNumericalAnswers(ArrayList<String> proffesorNumericalAnswers) {
        this.proffesorNumericalAnswers = proffesorNumericalAnswers;
    }

    public ArrayList<String> getProffesorTextualAnswers() {
        return proffesorTextualAnswers;
    }

    public void setProffesorTextualAnswers(ArrayList<String> proffesorTextualAnswers) {
        this.proffesorTextualAnswers = proffesorTextualAnswers;
    }
}
