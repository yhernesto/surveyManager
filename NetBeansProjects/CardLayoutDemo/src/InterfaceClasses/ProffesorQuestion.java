/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceClasses;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ernesto
 */
public class ProffesorQuestion extends Question{
    private HashMap<String, String> proffesorsAnswers;

    public ProffesorQuestion() {
        proffesorsAnswers = new HashMap<String, String>();
    }
    

    public HashMap<String, String> getProffesorsAnswers() {
        return proffesorsAnswers;
    }

    public void setProffesorsAnswers(HashMap<String, String> proffesorsAnswers) {
        this.proffesorsAnswers = proffesorsAnswers;
    }

    public void addProffesorAnswers(String proffesor, String answer){
        this.proffesorsAnswers.put(proffesor, answer);
    }
    
}
