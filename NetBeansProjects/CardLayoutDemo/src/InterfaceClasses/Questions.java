/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceClasses;

import java.util.ArrayList;

/**
 *
 * @author ernesto
 */
public class Questions {
    public QuestionType.category category;
    public QuestionType.type type;
    public ArrayList<Question> questions;
    
    public Questions(){};
    
    public Questions(QuestionType.category category, QuestionType.type type){
        this.type = type;
        this.category = category;
        questions = new ArrayList<>();
    }

    public QuestionType.type getType() {
        return type;
    }

    public void setType(QuestionType.type type) {
        this.type = type;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public QuestionType.category getCategory() {
        return category;
    }

    public void setCategory(QuestionType.category category) {
        this.category = category;
    }
    
    public void add(Question data){
        questions.add(data);
    }
    
    public int size(){
        return this.questions.size();
    }
}
