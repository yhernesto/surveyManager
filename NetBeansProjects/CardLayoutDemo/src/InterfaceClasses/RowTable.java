/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceClasses;


import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ernesto
 */
public class RowTable{
    
   List<Component> components;
    
   public RowTable(){
       
   }
   
   public RowTable(List<Component> objects){
       this.components = objects;
   }

    public int getSize() {
        return components.size();
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> objects) {
        this.components = objects;
    }
   
    public void addComponent(Component component){
        if(components == null) components = new ArrayList<>();
        this.components.add(component);
    }
   
    public Component getComponent(int i){
        return components.get(i);
    }
   
    public void removeComponent(int i){
        components.remove(i);
    }
    
    public void removeAllComponent(){
        components.clear();
    }
}
