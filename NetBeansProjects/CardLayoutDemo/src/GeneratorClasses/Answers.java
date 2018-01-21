/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorClasses;

import InterfaceClasses.QuestionType;
import java.util.ArrayList;

/**
 *
 * @author ernesto
 */
public class Answers{
    private QuestionType.type type;
    private String question;
    private Integer column;
    private ArrayList answers;
    
    public Answers(){
        this.answers    = new ArrayList<>();
        column          = null;
        question        = null;
        this.type       = QuestionType.type.SIMPLE;
    }
    
    public Answers(String question){
        this.answers = new ArrayList<>();
        this.question = question;
        this.type    = QuestionType.type.SIMPLE;
    }

    public Answers(QuestionType.type type, String question, Integer column) {
        this.answers = new ArrayList<>();
        this.type = type;
        this.question = question;
        this.column = column;
    }
    
        
    public QuestionType.type getType() {
        return type;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }
    

    public void setType(QuestionType.type type) {
        this.type = type;
    }
    
    public void add(String obj){
        if(obj != null && obj.trim().length() > 0){
            if(this.type == QuestionType.type.NUMERICAL){
                try{
                    this.answers.add(Integer.valueOf(obj));    
                }catch(NumberFormatException e){
                    System.out.println("error al parsear el string a Integer" + obj + " size : " + obj.length());
                }
            }else{
                this.answers.add(obj);
            }
        }
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList answers) {
        this.answers = answers;
    }    
    
}
