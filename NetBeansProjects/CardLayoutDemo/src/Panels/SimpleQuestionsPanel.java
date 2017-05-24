/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import InterfaceClasses.QuestionType;
import layout.GeneratorControllerInterface;

/**
 *
 * @author ernesto
 */
public class SimpleQuestionsPanel extends QuestionsPanel {
    
    public SimpleQuestionsPanel(GeneratorControllerInterface gci, QuestionType.type questionsType) {
        super(gci);
        initGeneralComponents(gci,questionsType);
        myInitComponents();
    }
    
    private void myInitComponents(){
        setCategory(QuestionType.category.SIMPLE);
        rowTitleSetText("");
        questionTableCenterHeader.setText("Nombre de los Profesores: ");
        questionTableModel.addRowTable(questionsTableAddRow(questionTableModel.getTotalRows()));
        questionTableInit(questionTableModel);
    }
    
    
}
