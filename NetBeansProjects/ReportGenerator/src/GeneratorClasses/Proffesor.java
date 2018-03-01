/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorClasses;

import InterfaceClasses.QuestionType;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author ernesto
 */
public class Proffesor {
    private String name;
    private ArrayList<Answers> answers;

    public Proffesor() {
        this.name = "";
        this.answers = new ArrayList<Answers>();
    }

    public Proffesor(String name){
        this.name = name;
        this.answers = new ArrayList<Answers>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answers> answers) {
        this.answers = answers;
    }
    
    public void addAnswer(String answer, int col){
        if(!this.answers.isEmpty() && col <= this.answers.size()){
            Answers answ = this.answers.stream().filter(ans -> ans.getColumn() == col).findFirst().orElse(null);
            if(answ != null) answ.add(answer);
        }
    }
    
    public void addAnswers(Answers answers){
        this.answers.add(answers);
    }
    
    public ArrayList<Answers> getAnswers(QuestionType.type type){
        return this.answers.stream().filter(ans -> ans.getType() == type).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        return "Proffesor{" + "name=" + name + ", answersLength=" + answers.toString() + '}';
    }
    
    public Integer getSurveyedAmount(){
        Integer maxAmount = null, tempAmount = 0;
        for(Answers numericalAnswers : getAnswers(QuestionType.type.NUMERICAL)){
            maxAmount = numericalAnswers.getAnswers().size();
            if(maxAmount > tempAmount) tempAmount = maxAmount;
        };
        return maxAmount;
    }
    
}

