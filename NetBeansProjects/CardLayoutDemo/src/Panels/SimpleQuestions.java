/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import layout.GeneratorControllerInterface;

/**
 *
 * @author ernesto
 */
public class SimpleQuestions extends Questions {
    
    public SimpleQuestions(GeneratorControllerInterface gci) {
        super(gci);
        myInitComponents(gci);
        questionTableModel.addRowTable(questionsTableAddRow(questionTableModel.getTotalRows()));
        questionTableInit(questionTableModel);
    }
    
}
