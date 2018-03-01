/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorClasses;

import java.util.ArrayList;

/**
 *
 * @author ernesto
 */
public class Report {
    Subject subject;
    ArrayList<Proffesor> professors;
    
    public Report(){
        this.subject = null;
        this.professors = new ArrayList<>();
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public ArrayList<Proffesor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Proffesor> professors) {
        this.professors = professors;
    }
    
    public void addProffesor(Proffesor proffesor){
        this.professors.add(proffesor);
    }

    @Override
    public String toString() {
        return "Report{" + "subject=" + subject + ", professors=" + professors + '}';
    }
    
}
