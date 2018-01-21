/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceClasses;

import java.awt.Component;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;

public class Table extends JPanel{
   
    ModelTable logicTable;

    public Table(ModelTable logicTable){
        this.logicTable = new ModelTable();
        updateTable(logicTable);
    };

    
    private void addComponents(RowTable row){
        int paneTotalComponents = getComponentCount();
        int rowTotalComponents  = row.getSize();
        
        int maxX = rowTotalComponents;
        int actualY = paneTotalComponents/rowTotalComponents;
        
        GridBagConstraints gbc  = new GridBagConstraints();
        gbc.fill    = GridBagConstraints.HORIZONTAL;
        
        for(int x = 0; x < maxX; x++){
            gbc.gridx   = x;
            gbc.gridy   = actualY;
            add((Component) row.getComponent(x), gbc);
        }
    }
    
    public void updateTable(ModelTable logicTable){
        this.removeAll();

        if(logicTable != null){
            this.logicTable = logicTable;
            if(logicTable.rows != null || !logicTable.getRows().isEmpty()){
                for(RowTable row : this.logicTable.getRows()){
                    addComponents(row);
                }    
            }
        }
        this.revalidate();
        this.repaint();
    }
    
}
