/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import InterfaceClasses.RowTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import layout.GeneratorControllerInterface;

/**
 *
 * @author ernesto
 */
public class ProffesorQuestions extends Questions {
    int questionTable_TEXTFIELD_WIDTH = 20;
    
    
    public ProffesorQuestions(GeneratorControllerInterface gci) {
   //inicializamos los componentes, creamos una Row para que el usuario introduzca datos, inicializamos la tabla
   // con la fila
        super(gci);
        myInitComponents(gci);
        questionTableModel.addRowTable(questionsTableAddRow(questionTableModel.getTotalRows()));
        questionTableInit(questionTableModel);
    }
    
    
    public RowTable questionsTableAddRow(int tableSize){
        JLabel  questionNumber  = new JLabel("Profesor "+ Integer.toString(tableSize + 1) + ":");
        JTextField question = new JTextField();
        question.setColumns(questionTable_TEXTFIELD_WIDTH);



        RowTable row    = new RowTable();
        row.addComponent(questionNumber);
        row.addComponent(question);

        System.out.println(questionNumber.getText());
        return row;
    }
    
    public void addButtonAction(){
            gci.questions_buttonAdd(questionTable, questionTableModel, questionsTableAddRow(questionTableModel.getTotalRows()));
    }
}
