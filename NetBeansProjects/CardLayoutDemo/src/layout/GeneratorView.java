package layout;
 
/*
 * GeneratorView.java
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class GeneratorView implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    Landing landing;
    Wizard wizard;
    final static String LANDING = "landing";
    final static String WIZARD = "wizard";
    static GeneratorControllerInterface gci;
    GeneratorModelInterface gmi;
    
    
    public GeneratorView(GeneratorControllerInterface gci, GeneratorModelInterface gmi){
        this.gci    = gci;
        this.gmi    = gmi;
    }
     
    public void addComponentToPane(Container pane) {

//         
        landing = new Landing(gci);
        wizard = new Wizard(gci);


        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(landing, LANDING);
        cards.add(wizard, WIZARD);
         
        pane.add(cards, BorderLayout.CENTER);
        
    }
     
    public void itemStateChanged(ItemEvent evt) {
//        CardLayout cl = (CardLayout)(cards.getLayout());
//        cl.show(cards, (String)evt.getItem());
        System.out.println("el boton de afuera");
    }
     

    public void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
//        GeneratorView demo = new GeneratorView(gti);
        addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
}