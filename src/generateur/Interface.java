package generateur;
import  javax.swing.*;

import  java.awt.*;
import  java.awt.event.*;
import java.io.IOException;
  
//le listener est la classe test      
public class Interface extends JFrame implements ActionListener
{
    
    /** Constructeur de test 
     * @return */
    public Interface()
    {
    	super();
    	this.setSize(565, 509);
        //panel
        JPanel  pan=new JPanel();
       
        
        pan.setLayout(new BorderLayout());
        pan.setSize(888,888);
        
        //bouton ici
        JButton but=new JButton("Lancer la création !");
        
        //ajoute un listener : ici le listener est cette classe
        but.addActionListener(this);
        
        //ajoute le boutton dans le panel
        pan.add(but,BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pan);
        //pack(); //permet de mettre une bonne dimension a la fenetre
        setVisible(true);
    }
    
    /**
     * obligatoire car test implémente l'interface ActionListener
     */
    public  void    actionPerformed(ActionEvent e)
    {
    	
    	try {
        	executeCommands("./avant.sh");
        } catch (IOException e1) {
        	// TODO Auto-generated catch block
        	e1.printStackTrace();
        }
    	
        
    		//on lance l'execution
    		Controleur.Execution();

    		
   try {
    	executeCommands("./apres.sh");
    } catch (IOException e1) {
    	// TODO Auto-generated catch block
    	e1.printStackTrace();
    }

    }
    public static void executeCommands(String etat) throws IOException {

	    
        ProcessBuilder pb = new ProcessBuilder("bash", etat);
        pb.inheritIO();
        Process process = pb.start();
       
      
			try {
				process.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    
} 
    
  
}