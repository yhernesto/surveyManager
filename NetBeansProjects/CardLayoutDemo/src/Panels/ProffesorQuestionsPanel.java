/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import InterfaceClasses.QuestionType;
import InterfaceClasses.Questions;
import InterfaceClasses.RowTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;
import layout.GeneratorControllerInterface;

/**
 *
 * @author ernesto
 */
public class ProffesorQuestionsPanel extends QuestionsPanel {
    
    public ProffesorQuestionsPanel(GeneratorControllerInterface gci, QuestionType.type questionsType) {
   //inicializamos los componentes, creamos una Row para que el usuario introduzca datos, inicializamos la tabla
   // con la fila
   
        super(gci);
        initGeneralComponents(gci, questionsType);
        myInitComponents();
    }
    
    public void myInitComponents(){
        setCategory(QuestionType.category.PROFFESOR);
        questionTableLeftHeader.setText("Pregunta: ");
        questionTableRightHeader.setText("Profesores: ");
        questionsTableAddRow(questionTableModel.getTotalRows(), gci.getProffesors());
        questionTableInit(questionTableModel);
    }
    
    
    public void questionsTableAddRow(int tableSize, Questions profesores){
        System.out.println("tamaño de profesores: " + profesores.getQuestions().size());
        JLabel  questionNumber  = new JLabel(Integer.toString(tableSize + 1) + ":");
        JTextField question     = new JTextField();
        JTextField answerColumn = new JTextField(ANSWERS_TEXTFIELD_WIDTH);
        question.setColumns(QUESTIONS_TEXTFIELD_WIDTH);
        JLabel emptySpace   = new JLabel("  ");

        JLabel proffesorName    = new JLabel(profesores.getQuestions().get(0).getQuestion());
        
        RowTable row    = new RowTable();
        row.addComponent(questionNumber);
        row.addComponent(question);
        row.addComponent(emptySpace);
        row.addComponent(proffesorName);
        row.addComponent(answerColumn);
        
        questionTableModel.addRowTable(row);
        
        addProffesors(profesores);
    }
    
    private void addProffesors(Questions profesores){
        for(int i=1; i<profesores.size(); i++){
            RowTable row = new RowTable();
            JLabel emptySpace = new JLabel(" ");
            JLabel emptySpace1 = new JLabel(" ");
            JLabel emptySpace2 = new JLabel(" ");
            JLabel proffesorName    = new JLabel(profesores.getQuestions().get(i).getQuestion());
            JTextField answerColumn = new JTextField(ANSWERS_TEXTFIELD_WIDTH);
            maxCharacters(answerColumn,ANSWERS_TEXTFIELD_WIDTH);
            row.addComponent(emptySpace);
            row.addComponent(emptySpace1);
            row.addComponent(emptySpace2);
            row.addComponent(proffesorName);
            row.addComponent(answerColumn);
            questionTableModel.addRowTable(row);
        }
    }
    
    public void addButtonAction(){
        questionsTableAddRow(questionTableModel.getTotalRows(), gci.getProffesors());
        gci.questions_buttonAdd(questionTable, questionTableModel);
    }
    
    public void removeButtonAction(){
        if(questionTableModel.getTotalRows()>gci.getProffesors().size()){
            for(int i=0; i<gci.getProffesors().size(); i++) gci.question_buttonRemove(questionTable, questionTableModel);
        }
    }

    
}
