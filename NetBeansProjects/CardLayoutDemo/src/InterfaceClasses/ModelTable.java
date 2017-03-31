/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceClasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ernesto
 */
public class ModelTable {
    List<RowTable> rows = new ArrayList<RowTable>();
    int maxRows;
    boolean mustNotBeEmpty = false;
    
    
    public ModelTable(){};

    public List<RowTable> getRows() {
        return rows;
    }

    public void setRows(List<RowTable> rows) {
        this.rows = rows;
    }

    public int getMaxRows() {
        return maxRows;
    }

    public void setMaxRows(int maxRows) {
        this.maxRows = maxRows;
    }

    public boolean mustNotBeEmpty() {
        return mustNotBeEmpty;
    }

    public void setMustNotBeEmpty(boolean mustNotBeEmpty) {
        this.mustNotBeEmpty = mustNotBeEmpty;
    }
    
    
    public void addRowTable(RowTable row){
        if(rows == null) rows = new ArrayList<RowTable>();
        if(this.rows.size() < maxRows){
            rows.add(row);
        }
    }
   
    
    
    public void removeRowTable(int i){
        if(i < rows.size()){
            if(mustNotBeEmpty){
                if(i>0){
                    rows.remove(i);
                }
            }else{
                rows.remove(i);
            }
        }
    }
        
    
    public void removeLastRowTable(){
        if(!rows.isEmpty()){
            if(mustNotBeEmpty){
                if(rows.size()>1){
                    rows.remove(rows.size()-1);
                }
            }else{
                rows.remove(rows.size()-1);
            }
        }
    }


    public boolean getMustNotBeEmpty() {
        return mustNotBeEmpty;
    }

    public void mustNotBeEmpty(boolean mustNotBeEmpty) {
        this.mustNotBeEmpty = mustNotBeEmpty;
    }
    
    public int getTotalRows(){
        return rows.size();
    }

}
