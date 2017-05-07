package generateur;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

   
 
public class Interface extends javax.swing.JFrame {
	Interface(){
	JFrame fenetre = new JFrame();
	  //Définit un titre pour notre fenêtre
    fenetre.setTitle("Créer votre application");
    //Définit sa taille : 400 pixels de large et 100 pixels de haut
    fenetre.setSize(400, 100);
    //Nous demandons maintenant à notre objet de se positionner au centre
    fenetre.setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Instanciation d'un objet JPanel
    JPanel pan = new JPanel();
    //Définition de sa couleur de fond
    pan.setBackground(Color.ORANGE);  
    //On prévient notre JFrame que notre JPanel sera son content pane
    this.setContentPane(pan);
    
    //Et enfin, la rendre visible        
    fenetre.setVisible(true);
	
}
	}
