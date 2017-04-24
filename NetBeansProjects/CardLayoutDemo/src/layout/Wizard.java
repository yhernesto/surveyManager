/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import InterfaceClasses.QuestionType;
import Panels.ProffesorQuestionsPanel;
import Panels.QuestionsPanel;
import Panels.SimpleQuestionsPanel;
import Panels.SubjectQuestionsPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

/**
 *
 * @author ernesto
 */
public class Wizard extends javax.swing.JPanel {

    /**
     * Creates new form Wizard
     */
    private GeneratorControllerInterface gci;
    public SubjectQuestionsPanel     subjNumerical;
    public SubjectQuestionsPanel     subjTextual;
    public SimpleQuestionsPanel      proffEvaluated;
    public ProffesorQuestionsPanel   proffNumerical;
    public ProffesorQuestionsPanel   proffTextual;

    public Wizard(){};
    
    public Wizard(GeneratorControllerInterface gci) {
        this.gci = gci;
        initComponents();
        myInit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        tabbedPane = new javax.swing.JTabbedPane();
        wizard_tab1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        tab1_save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        wizard_tab1Panel = new javax.swing.JPanel();
        tab1_edit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        tab2_save = new javax.swing.JButton();
        tab2_back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        wizard_tab2Panel = new javax.swing.JPanel();
        tab2_edit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        tab3_save = new javax.swing.JButton();
        tab3_back = new javax.swing.JButton();
        wizard_tab3Panel = new javax.swing.JPanel();
        tab3_edit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        wizard_tab4Panel = new javax.swing.JPanel();
        tab4_back = new javax.swing.JButton();
        tab4_save = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        tab4_edit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        wizard_tab5Panel = new javax.swing.JPanel();
        tab5_back = new javax.swing.JButton();
        tab5_save = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        tab5_edit = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jTextField1.setText("jTextField1");

        wizard_tab1.setName(""); // NOI18N

        tab1_save.setText("Guardar");
        tab1_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab1_saveActionPerformed(evt);
            }
        });

        jLabel1.setText("Preguntas númericas:");

        javax.swing.GroupLayout wizard_tab1PanelLayout = new javax.swing.GroupLayout(wizard_tab1Panel);
        wizard_tab1Panel.setLayout(wizard_tab1PanelLayout);
        wizard_tab1PanelLayout.setHorizontalGroup(
            wizard_tab1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );
        wizard_tab1PanelLayout.setVerticalGroup(
            wizard_tab1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        tab1_edit.setText("Editar");
        tab1_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab1_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wizard_tab1Layout = new javax.swing.GroupLayout(wizard_tab1);
        wizard_tab1.setLayout(wizard_tab1Layout);
        wizard_tab1Layout.setHorizontalGroup(
            wizard_tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wizard_tab1Layout.createSequentialGroup()
                .addGroup(wizard_tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wizard_tab1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(wizard_tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(wizard_tab1Layout.createSequentialGroup()
                                .addGroup(wizard_tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(wizard_tab1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 9, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wizard_tab1Layout.createSequentialGroup()
                        .addComponent(tab1_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tab1_save)))
                .addContainerGap())
        );
        wizard_tab1Layout.setVerticalGroup(
            wizard_tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wizard_tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wizard_tab1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wizard_tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tab1_save)
                    .addComponent(tab1_edit)))
        );

        tabbedPane.addTab("Asignatura 1", wizard_tab1);

        tab2_save.setText("Guardar");
        tab2_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab2_saveActionPerformed(evt);
            }
        });

        tab2_back.setText("Atrás");
        tab2_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab2_backActionPerformed(evt);
            }
        });

        jLabel4.setText("Preguntas de texto");

        javax.swing.GroupLayout wizard_tab2PanelLayout = new javax.swing.GroupLayout(wizard_tab2Panel);
        wizard_tab2Panel.setLayout(wizard_tab2PanelLayout);
        wizard_tab2PanelLayout.setHorizontalGroup(
            wizard_tab2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        wizard_tab2PanelLayout.setVerticalGroup(
            wizard_tab2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        tab2_edit.setText("Editar");
        tab2_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab2_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wizard_tab2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tab2_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tab2_back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tab2_save))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 413, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wizard_tab2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tab2_save)
                    .addComponent(tab2_back)
                    .addComponent(tab2_edit))
                .addContainerGap())
        );

        tabbedPane.addTab("Asignatura 2", jPanel2);

        jLabel3.setText("Profesores evaluados");

        tab3_save.setText("Guardar");
        tab3_save.setToolTipText("");
        tab3_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab3_saveActionPerformed(evt);
            }
        });

        tab3_back.setText("Atrás");
        tab3_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab3_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wizard_tab3PanelLayout = new javax.swing.GroupLayout(wizard_tab3Panel);
        wizard_tab3Panel.setLayout(wizard_tab3PanelLayout);
        wizard_tab3PanelLayout.setHorizontalGroup(
            wizard_tab3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        wizard_tab3PanelLayout.setVerticalGroup(
            wizard_tab3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        tab3_edit.setText("Editar");
        tab3_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab3_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3)
                    .addComponent(wizard_tab3Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tab3_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
                        .addComponent(tab3_back)
                        .addGap(27, 27, 27)
                        .addComponent(tab3_save))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wizard_tab3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tab3_save)
                    .addComponent(tab3_back)
                    .addComponent(tab3_edit))
                .addContainerGap())
        );

        tabbedPane.addTab("Profesor 1", jPanel3);

        jLabel2.setText("Preguntas numéricas");

        javax.swing.GroupLayout wizard_tab4PanelLayout = new javax.swing.GroupLayout(wizard_tab4Panel);
        wizard_tab4Panel.setLayout(wizard_tab4PanelLayout);
        wizard_tab4PanelLayout.setHorizontalGroup(
            wizard_tab4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        wizard_tab4PanelLayout.setVerticalGroup(
            wizard_tab4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        tab4_back.setText("Atrás");
        tab4_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab4_backActionPerformed(evt);
            }
        });

        tab4_save.setText("Guardar");
        tab4_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab4_saveActionPerformed(evt);
            }
        });

        tab4_edit.setText("Editar");
        tab4_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab4_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wizard_tab4Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 409, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tab4_edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tab4_back)
                                .addGap(18, 18, 18)
                                .addComponent(tab4_save)))
                        .addGap(13, 13, 13))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wizard_tab4Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tab4_back)
                    .addComponent(tab4_save)
                    .addComponent(tab4_edit)))
        );

        tabbedPane.addTab("Profesor 2", jPanel1);

        jLabel5.setText("Preguntas de texto");

        javax.swing.GroupLayout wizard_tab5PanelLayout = new javax.swing.GroupLayout(wizard_tab5Panel);
        wizard_tab5Panel.setLayout(wizard_tab5PanelLayout);
        wizard_tab5PanelLayout.setHorizontalGroup(
            wizard_tab5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        wizard_tab5PanelLayout.setVerticalGroup(
            wizard_tab5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        tab5_back.setText("Atrás");
        tab5_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab5_backActionPerformed(evt);
            }
        });

        tab5_save.setText("Guardar");
        tab5_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab5_saveActionPerformed(evt);
            }
        });

        tab5_edit.setText("Editar");
        tab5_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab5_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wizard_tab5Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 423, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator5)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tab5_edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tab5_back)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tab5_save)))
                        .addGap(12, 12, 12))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wizard_tab5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tab5_save)
                    .addComponent(tab5_back)
                    .addComponent(tab5_edit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Profesor 3", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void tab3_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab3_saveActionPerformed
        // TODO add your handling code here:
        gci.updateTableData(proffEvaluated);
        proffEvaluated.setEnabled(false);
        gci.nextButton((JButton) evt.getSource(), tabbedPane);
        tabbedPane.setEnabledAt(tabbedPane.getSelectedIndex() + 1, false);  //inhabilitamos proffTextual
        tab3_edit.setEnabled(true);
        tab3_save.setEnabled(false);
    }//GEN-LAST:event_tab3_saveActionPerformed

    private void tab3_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab3_backActionPerformed
        // TODO add your handling code here:
        gci.previousButton((JButton) evt.getSource(), tabbedPane);
    }//GEN-LAST:event_tab3_backActionPerformed

    private void tab1_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab1_saveActionPerformed
        // TODO add your handling code here:
        gci.updateTableData(subjNumerical);
        subjNumerical.setEnabled(false);
        gci.nextButton((JButton) evt.getSource(), tabbedPane);
        tab1_edit.setEnabled(true);
        tab1_save.setEnabled(false);
    }//GEN-LAST:event_tab1_saveActionPerformed

    private void tab2_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab2_backActionPerformed
        // TODO add your handling code here:
        gci.previousButton((JButton) evt.getSource(), tabbedPane);
    }//GEN-LAST:event_tab2_backActionPerformed

    private void tab2_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab2_saveActionPerformed
        // TODO add your handling code here:
        gci.updateTableData(subjTextual);
        subjTextual.setEnabled(false);
        gci.nextButton((JButton) evt.getSource(), tabbedPane);
        tab2_edit.setEnabled(true);
        tab2_save.setEnabled(false);
    }//GEN-LAST:event_tab2_saveActionPerformed

    private void tab1_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab1_editActionPerformed
        // TODO add your handling code here:
        subjNumerical.setEnabled(true);
        tab1_save.setEnabled(true);
    }//GEN-LAST:event_tab1_editActionPerformed

    private void tab4_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab4_backActionPerformed
        // TODO add your handling code here:
        gci.previousButton((JButton) evt.getSource(), tabbedPane);
    }//GEN-LAST:event_tab4_backActionPerformed

    private void tab4_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab4_saveActionPerformed
        // TODO add your handling code here:
        gci.updateTableData(proffNumerical);
        proffNumerical.setEnabled(false);
        gci.nextButton((JButton) evt.getSource(), tabbedPane);
        tab4_edit.setEnabled(true);
        tab4_save.setEnabled(false);
    }//GEN-LAST:event_tab4_saveActionPerformed

    private void tab5_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab5_backActionPerformed
        // TODO add your handling code here:
        gci.previousButton((JButton) evt.getSource(), tabbedPane);
    }//GEN-LAST:event_tab5_backActionPerformed

    private void tab5_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab5_saveActionPerformed
        // TODO add your handling code here:
        gci.updateTableData(proffTextual);
        proffTextual.setEnabled(false);
        gci.nextButton((JButton) evt.getSource(), tabbedPane);
        tab5_edit.setEnabled(true);
        tab5_save.setEnabled(false);
    }//GEN-LAST:event_tab5_saveActionPerformed

    private void tab3_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab3_editActionPerformed
        proffEvaluated.setEnabled(true);
        tab3_save.setEnabled(true);
    }//GEN-LAST:event_tab3_editActionPerformed

    private void tab2_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab2_editActionPerformed
        subjTextual.setEnabled(true);
        tab2_save.setEnabled(true);
    }//GEN-LAST:event_tab2_editActionPerformed

    private void tab4_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab4_editActionPerformed
        proffNumerical.setEnabled(true);
        tab4_save.setEnabled(true);
    }//GEN-LAST:event_tab4_editActionPerformed

    private void tab5_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab5_editActionPerformed
        proffTextual.setEnabled(true);
        tab5_save.setEnabled(true);
    }//GEN-LAST:event_tab5_editActionPerformed
    
    
    
    private void myInit(){
        System.out.println("inicio del wizzard");
        
        for(int i = 1; i < tabbedPane.getTabCount(); i++) tabbedPane.setEnabledAt(i, false);
        
        subjNumerical   = new SubjectQuestionsPanel(gci, QuestionType.type.NUMERICAL);
        subjTextual     = new SubjectQuestionsPanel(gci, QuestionType.type.TEXTUAL);
        proffEvaluated  = new SimpleQuestionsPanel(gci, QuestionType.type.SIMPLE);
        proffNumerical  = new ProffesorQuestionsPanel(gci, QuestionType.type.NUMERICAL);
        proffTextual    = new ProffesorQuestionsPanel(gci, QuestionType.type.TEXTUAL);
//        subjNumerical.loadExcel(gci.getExcelPath());
        wizard_tab1Panel.setLayout(new BorderLayout());
        wizard_tab1Panel.add(subjNumerical,BorderLayout.NORTH); 
        wizard_tab2Panel.setLayout(new BorderLayout());
        wizard_tab2Panel.add(subjTextual,BorderLayout.NORTH); 
        wizard_tab3Panel.setLayout(new BorderLayout());
        wizard_tab3Panel.add(proffEvaluated,BorderLayout.NORTH); 
        wizard_tab4Panel.setLayout(new BorderLayout());
        wizard_tab4Panel.add(proffNumerical,BorderLayout.NORTH); 
        wizard_tab5Panel.setLayout(new BorderLayout());
        wizard_tab5Panel.add(proffTextual,BorderLayout.NORTH); 
        
        tab1_edit.setEnabled(false);
        tab2_edit.setEnabled(false);
        tab3_edit.setEnabled(false);
        tab4_edit.setEnabled(false);
        tab5_edit.setEnabled(false);
        
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton tab1_edit;
    private javax.swing.JButton tab1_save;
    public javax.swing.JButton tab2_back;
    private javax.swing.JButton tab2_edit;
    private javax.swing.JButton tab2_save;
    private javax.swing.JButton tab3_back;
    private javax.swing.JButton tab3_edit;
    private javax.swing.JButton tab3_save;
    private javax.swing.JButton tab4_back;
    private javax.swing.JButton tab4_edit;
    public javax.swing.JButton tab4_save;
    private javax.swing.JButton tab5_back;
    private javax.swing.JButton tab5_edit;
    public javax.swing.JButton tab5_save;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JPanel wizard_tab1;
    private javax.swing.JPanel wizard_tab1Panel;
    private javax.swing.JPanel wizard_tab2Panel;
    private javax.swing.JPanel wizard_tab3Panel;
    private javax.swing.JPanel wizard_tab4Panel;
    private javax.swing.JPanel wizard_tab5Panel;
    // End of variables declaration//GEN-END:variables
}
