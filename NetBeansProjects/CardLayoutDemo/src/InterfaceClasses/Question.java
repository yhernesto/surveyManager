/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceClasses;

/**
 *
 * @author ernesto
 */
public class Question {
    String question;
    QuestionType.type type;
    
    public Question(){
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionType.type getType() {
        return type;
    }

    public void setType(QuestionType.type type) {
        this.type = type;
    }
    
    
}
