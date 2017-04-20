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
    ArrayList<String> getEvaluatedProffesors();
    void setEvaluatedProffesors(ArrayList<String> proffesors);
    ArrayList<String> getSubjectNumericalQuestions();
    void setSubjectNumericalQuestions(ArrayList<String> subjectNumericalQuestions);
    ArrayList<String> getSubjectTextualQuestions();
    void setSubjectTextualQuestions(ArrayList<String> subjectTextualQuestions);
    ArrayList<String> getProffesorNumericalQuestions();
    void setProffesorNumericalQuestions(ArrayList<String> proffesorNumericalQuestions);
    ArrayList<String> getProffesorTextualQuestions();
    void setProffesorTextualQuestions(ArrayList<String> proffesorTextualQuestions);
    ArrayList<String> getSubjectNumericalAnswers();
    void setSubjectNumericalAnswers(ArrayList<String> subjectNumericalQuestions);
    ArrayList<String> getSubjectTextualAnswers();
    void setSubjectTextualAnswers(ArrayList<String> subjectTextualQuestions);
    ArrayList<String> getProffesorNumericalAnswers();
    void setProffesorNumericalAnswers(ArrayList<String> proffesorNumericalQuestions);
    ArrayList<String> getProffesorTextualAnswers();
    void setProffesorTextualAnswers(ArrayList<String> proffesorTextualQuestions);
}
