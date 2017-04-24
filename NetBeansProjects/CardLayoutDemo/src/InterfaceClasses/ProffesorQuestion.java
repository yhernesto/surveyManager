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
    
    
}
