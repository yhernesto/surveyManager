/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import InterfaceClasses.ModelTable;
import InterfaceClasses.RowTable;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import layout.GeneratorControllerInterface;

/**
 *
 * @author ernesto
 */
public class SubjectQuestions extends Questions{

    public SubjectQuestions(GeneratorControllerInterface gci, QuestionsType questionsType) {
   //inicializamos los componentes, creamos una Row para que el usuario introduzca datos, inicializamos la tabla
   // con la fila
        super(gci);
        initGeneralComponents(gci, questionsType);
        myInitComponents();
    }
    
    private void myInitComponents(){
        questionTableModel.addRowTable(questionsTableAddRow(questionTableModel.getTotalRows()));
        questionTableInit(questionTableModel);
    }
    
    public void addButtonAction(){
            questionTableModel.addRowTable(questionsTableAddRow(questionTableModel.getTotalRows()));
            gci.questions_buttonAdd(questionTable, questionTableModel);
    }
    
    public RowTable questionsTableAddRow(int tableSize){
        JLabel  questionNumber  = new JLabel(Integer.toString(tableSize + 1) + ":");
        JTextField question = new JTextField();
        question.setColumns(QUESTIONS_TEXTFIELD_WIDTH);

        JTextField answerColumn = new JTextField(3);

        RowTable row    = new RowTable();
        row.addComponent(questionNumber);
        row.addComponent(question);
        row.addComponent(answerColumn);

        System.out.println(questionNumber.getText());
        return row;
    }

}
