/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import InterfaceClasses.ProffesorQuestion;
import InterfaceClasses.Question;
import InterfaceClasses.Questions;
import InterfaceClasses.SubjectQuestion;
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
    Questions getEvaluatedProffesors();
    Question getEvaluatedProffesor(int ord);
    void setEvaluatedProffesors(Questions proffesors);
    Questions getSubjectNumericalData();
    void setSubjectNumericalData(Questions subjectNumericalData);
    Questions getSubjectTextualData();
    void setSubjectTextualData(Questions subjectTextualData);
    Questions getProffesorNumericalData();
    void setProffesorNumericalData(Questions proffesorNumericalData);
    Questions getProffesorTextualData();
    void setProffesorTextualData(Questions proffesorTextualData);

}
