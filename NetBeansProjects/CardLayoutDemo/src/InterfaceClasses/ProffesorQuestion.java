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
public class ProffesorQuestion extends Question{
    public ArrayList<String> proffesors;
    public ArrayList<String> answers;

    public ProffesorQuestion() {
        this.proffesors = new ArrayList<String>();
        this.answers    = new ArrayList<String>();
    }
    
    public ArrayList<String> getProffesors() {
        return proffesors;
    }

    public void setProffesors(ArrayList<String> proffesors) {
        this.proffesors = proffesors;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }
    
    public void addProffesor(String proffesor){
        this.proffesors.add(proffesor);
    }
    
    public String getProffesor(int ord){
        return this.proffesors.get(ord);
    }
    
    public void addAnswer(String answer){
        this.answers.add(answer);
    }
    
    public String getAnswer(int ord){
        return this.answers.get(ord);
    }

}
