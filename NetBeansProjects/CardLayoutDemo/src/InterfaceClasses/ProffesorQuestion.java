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
    private ArrayList<String> proffesorsAnswers;

    public ProffesorQuestion() {
        proffesorsAnswers = new ArrayList<>();
    }
    
    public ArrayList<String> getProffesorsAnswers() {
        return proffesorsAnswers;
    }

    public void setProffesorsAnswers(ArrayList<String> proffesorsAnswers) {
        this.proffesorsAnswers = proffesorsAnswers;
    }

    public void addProffesorAnswers(String answer){
        this.proffesorsAnswers.add(answer);
    }
    
}
