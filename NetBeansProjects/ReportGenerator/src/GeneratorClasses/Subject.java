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
public class Subject {
    private ArrayList<Answers> answers;
    private String code;
    private String name;
    private String groupCode;
    private String estudio;
    private Integer enrolledStudents;


    public Subject(){
        this.answers = new ArrayList<Answers>();
        this.code       = "";
        this.name       = "";
        this.groupCode  = "";
        this.estudio    = "";
        this.enrolledStudents = 0;
    }


    public Subject(String code, String name, String groupCode) {
        this.code       = code;
        this.name       = name;
        this.groupCode  = groupCode;
        this.answers    = new ArrayList<Answers>();
    }
     
    
    public ArrayList<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answers> answers) {
        this.answers = answers;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public Integer getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Integer enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
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
        return "Subject{" + "answersLengt=" + answers.size() + ", code=" + code + ", name=" + name + ", groupCode=" + groupCode + ", estudio=" + estudio + ", enrolledStudents=" + enrolledStudents + '}';
    }
    
    
    
}
