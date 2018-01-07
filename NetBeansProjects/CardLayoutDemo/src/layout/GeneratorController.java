/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import GeneratorClasses.Answers;
import GeneratorClasses.NumericalAnswers;
import GeneratorClasses.Proffesor;
import GeneratorClasses.Report;
import GeneratorClasses.Subject;
import GeneratorClasses.SubjectsInformation;
import InterfaceClasses.ModelTable;
import InterfaceClasses.ProffesorQuestion;
import InterfaceClasses.Question;
import InterfaceClasses.QuestionType;
import InterfaceClasses.Questions;
import InterfaceClasses.SubjectQuestion;
import InterfaceClasses.Table;
import Panels.QuestionsPanel;
import Utils.MathUtils;
import Utils.PanelDataException;
import documentClasses.WordDocument;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import jxl.*;

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
        return gmi.getProffesorsColName();
    }
    
    
    public void updateTableData(QuestionsPanel questionPanel) throws PanelDataException{
        Questions questions = new Questions(questionPanel.getCategory(), questionPanel.getType());
        ArrayList<String>   questionsRawData = questionPanel.getQuestions();
        ArrayList<String>   answersRawData = questionPanel.getAnswers();
        Integer[]      error = checkData(questionsRawData);
        if(error[0] != 0) throw new PanelDataException("Falta ingresar la pregunta en la fila: " + error[1].toString());
        error = checkData(answersRawData);
        if(error[0] == 1) throw new PanelDataException("Falta ingresar la columna de respuesta en la fila: " + error[1].toString());
        if(error[0] == 2) throw new PanelDataException("La columna de respuesta no es alfanumérica: " + error[1].toString());
        
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
            int proffesorsSize = gmi.getProffesorsColName().getQuestions().size();
            for(int i = 0; i < questionPanel.getQuestions().size(); i++){
                proffesorQuestion = new ProffesorQuestion();
                proffesorQuestion.setQuestion(questionsRawData.get(i));
                for(int j = 0; j < proffesorsSize ; j++){
                    index = (proffesorsSize * i) + j;
                    proffesorQuestion.addProffesorAnswers(answersRawData.get(index));
                }
                questions.add(proffesorQuestion);
            }
            if(questionPanel.getType() == QuestionType.type.NUMERICAL){
                gmi.setProffesorNumericalData(questions);
            }else if(questionPanel.getType() == QuestionType.type.TEXTUAL){
                gmi.setProffesorTextualData(questions);
            }
        }else{
            //CATEGORY == SIMPLE or DEFAULT (Evaluated proffesors)
            Question    simpleQuestion;
            for(int i = 0; i < questionPanel.getAnswers().size(); i++){
                simpleQuestion = new Question();
                simpleQuestion.setQuestion(answersRawData.get(i));
                questions.add(simpleQuestion);
            }
            if(questionPanel.getType() == QuestionType.type.SIMPLE){
                clearProffesorsData();
                gmi.setProffesorsColName(questions);
                updateProffesorsData();
            }
        }
    }

    private Integer[] checkData(ArrayList<String> questions){
        // error = 1 -> blank TextField or full of whitespaces only
        // error = 2 -> TextField value is not alphanumeric
        int error = 0, cont = 0;
        QuestionsPanel auxPanel = new QuestionsPanel();
        Integer[] errorData = {0,0};
        Iterator iterator;
        String  data;
        
        iterator = questions.iterator();
        while(iterator.hasNext() && errorData[0] == 0){
            data = (String) iterator.next();
            if(data.equals("") || data.trim().isEmpty()) {
                errorData[0] = 1;
            }else if(data.length() == auxPanel.ANSWERS_TEXTFIELD_WIDTH){
                if(data.matches("^.*[^a-zA-Z0-9 ].*$")){
                    errorData[0] = 2;
                }
            }
            if(errorData[0] != 0) errorData[1] = cont;
            cont++;
        }  
        return errorData;
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
        return gmi.getProffesorsColName();
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
    
    public void generateReports(){
        /*
            abrir pdf de datos por asignatura   --ok
            Leer csv de respuestas
                crear subject
                llenar subject con datos para preguntas numéricas
                llenar subject con datos para preguntas textuales
                llenar profesor con datos para preguntas numéricas
                llenar profesor con datos para preguntas textuales
                llenar subject con información del pdf de asignaturas
                crear reporte de asignatura
            terminar de leer
             */          
//        initializeProffesors();
        SubjectsInformation subjectsInformation = new SubjectsInformation(";", gmi.getCsvPath());
        subjectsInformation.loadSubejctsInformation();
        ArrayList<Report> reports = new ArrayList();
        
        String cod1="", cod2="", group1="", group2="";
        
        try {
            WorkbookSettings workbookSettings = new WorkbookSettings();
            workbookSettings.setEncoding("cp1250");
            
            Workbook archivoExcel = Workbook.getWorkbook(new File(gmi.getExcelPath()), workbookSettings);
            for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++){   // Recorre cada hoja            
                Sheet page = archivoExcel.getSheet(sheetNo);
                for(int indexRow = 1; indexRow < page.getRows(); indexRow++){              // Skipping the header line
                    System.out.println("en la linea: " + indexRow);
                    cod1 = page.getCell(0,indexRow).getContents();
                    group1 = page.getCell(2,indexRow).getContents();
                    if(!cod1.equals(cod2) || !group1.equals(group2)){
                        Report report = new Report();
                        Subject subject = new Subject(cod1, page.getCell(1,indexRow).getContents(), group1); //code, assignatureName, group
                        // falta coger los valores del CSV de asignaturas
                        subject.setEstudio(subjectsInformation.getDegree(cod1, group1));
                        subject.setEnrolledStudents(subjectsInformation.getEnrolledStudents(cod1, group1));
                        if(subject.getEnrolledStudents() != null && subject.getEstudio() != null){
                            initializeSubject(subject);
                            //inicializar las preguntas y array de respuestas de las asignaturas
                            for(Question question : gmi.getProffesorsColName().getQuestions()){
                                String colProffesorName = question.getQuestion();
                                String proffName = page.getCell(Integer.valueOf(MathUtils.columnNameToInteger(colProffesorName)),indexRow).getContents();
                                if(proffName != null && !proffName.trim().isEmpty() ){
                                    Proffesor proffesor = new Proffesor(proffName);
                                    //inicializar las preguntas de cada professor
                                    initializeProffesors(proffesor,report.getProfessors().size());
                                    report.addProffesor(proffesor);
                                }
                            }
                            report.setSubject(subject);
                            reports.add(report);
                        }
                    }
                    Report lastReport = reports.get(reports.size()-1);
                    
                    for(Answers numericalAnswers : lastReport.getSubject().getAnswers(QuestionType.type.NUMERICAL)){
                        numericalAnswers.add(page.getCell(numericalAnswers.getColumn(), indexRow).getContents());
                    }
                    for(Answers textualAnswers : lastReport.getSubject().getAnswers(QuestionType.type.TEXTUAL)){
                        textualAnswers.add(page.getCell(textualAnswers.getColumn(), indexRow).getContents());
                    }
                    
                    //Proffessor's answers
                    for(Proffesor proffesor : lastReport.getProfessors()){
                        for(Answers numericalAnswers : proffesor.getAnswers(QuestionType.type.NUMERICAL)){
                            numericalAnswers.add(page.getCell(numericalAnswers.getColumn(), indexRow).getContents());
                        }
                        for(Answers textualAnswers : proffesor.getAnswers(QuestionType.type.TEXTUAL)){
                            textualAnswers.add(page.getCell(textualAnswers.getColumn(), indexRow).getContents());
                        }                     
                    }
                    cod2 = cod1;
                    group2 = group1;
                }
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        
        
        for(Report report : reports){
            try {
                for(Answers numericalAnswers : report.getSubject().getAnswers(QuestionType.type.NUMERICAL)){
                    NumericalAnswers numAnswers = (NumericalAnswers) numericalAnswers;
                    setStatisticalValues(numAnswers, report.getSubject().getEnrolledStudents());
                };
                for(Proffesor proffesor : report.getProfessors()){
                    for(Answers numericalAnswers : proffesor.getAnswers(QuestionType.type.NUMERICAL)){
                        NumericalAnswers numAnswers = (NumericalAnswers) numericalAnswers;
                        setStatisticalValues(numAnswers, report.getSubject().getEnrolledStudents());
                    }
                };
                
                createReport(report);
                System.out.println(report.toString());
            } catch (Exception ex) {
                Logger.getLogger(GeneratorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        gview.closeGUIAndProgram();    
    }
    
    private void setStatisticalValues(NumericalAnswers numericalAnswers, Integer enrolledStudents){
        NumericalAnswers numAnswers = (NumericalAnswers) numericalAnswers;
        numAnswers.setMean(MathUtils.getMean(numAnswers.getAnswers()));
        numAnswers.setMedian(MathUtils.getMedian(numAnswers.getAnswers()));
        numAnswers.setVariance(MathUtils.getVariance(numAnswers.getAnswers(), numAnswers.getMedian()));
        numAnswers.setMeanError(MathUtils.getMeanError(numAnswers.getAnswers(), numAnswers.getVariance(), enrolledStudents));
    }
    
    private void initializeProffesors(Proffesor proffesor, int proffesorIndex){

            for(Question question : gmi.getProffesorNumericalData().getQuestions()){
                ProffesorQuestion proffNumericalQuestion = (ProffesorQuestion) question;
                NumericalAnswers numericalAnswers = new NumericalAnswers();
                numericalAnswers.setType(QuestionType.type.NUMERICAL);
                numericalAnswers.setQuestion(proffNumericalQuestion.getQuestion());
                numericalAnswers.setColumn(Integer.valueOf(MathUtils.columnNameToInteger(proffNumericalQuestion.getProffesorsAnswers().get(proffesorIndex))));
                numericalAnswers.setAnswers(new ArrayList());
                proffesor.addAnswers(numericalAnswers);
                
            }
            for(Question question : gmi.getProffesorTextualData().getQuestions()){
                ProffesorQuestion proffTextualQuestion = (ProffesorQuestion) question;
                Answers textualAnswers = new Answers();
                textualAnswers.setType(QuestionType.type.TEXTUAL);
                textualAnswers.setQuestion(proffTextualQuestion.getQuestion());
                textualAnswers.setColumn(Integer.valueOf(MathUtils.columnNameToInteger(proffTextualQuestion.getProffesorsAnswers().get(proffesorIndex))));
                textualAnswers.setAnswers(new ArrayList());
                proffesor.addAnswers(textualAnswers);
            }
    }
    
    private void initializeSubject(Subject subject){
        for (Question subjNumQuestion : gmi.getSubjectNumericalData().getQuestions()){
            SubjectQuestion subjQuestion = (SubjectQuestion) subjNumQuestion;
            NumericalAnswers numericalAnswers = new NumericalAnswers();
            numericalAnswers.setType(QuestionType.type.NUMERICAL);
            numericalAnswers.setQuestion(subjQuestion.getQuestion());
            numericalAnswers.setColumn(Integer.valueOf(MathUtils.columnNameToInteger(subjQuestion.getAnswer())));
            numericalAnswers.setAnswers(new ArrayList());
            subject.addAnswers(numericalAnswers);
        }
        for (Question subjTextQuestion : gmi.getSubjectTextualData().getQuestions()){
            SubjectQuestion subjQuestion = (SubjectQuestion) subjTextQuestion;
            Answers textualAnswers = new Answers();
            textualAnswers.setType(QuestionType.type.TEXTUAL);
            textualAnswers.setQuestion(subjQuestion.getQuestion());
            textualAnswers.setColumn(Integer.valueOf(MathUtils.columnNameToInteger(subjQuestion.getAnswer())));
            textualAnswers.setAnswers(new ArrayList());
            subject.addAnswers(textualAnswers);
        }
        
    }

    private void createReport(Report report) throws Exception {
        for (Proffesor proffesor : report.getProfessors()){
            WordDocument wordDocument = new WordDocument(report.getSubject(), proffesor, gmi.getReportsPath());
            wordDocument.generateDocument();
        }
    }
    
}

