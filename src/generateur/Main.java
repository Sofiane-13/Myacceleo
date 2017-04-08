package generateur;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class Main {
	static String nombouton,nomfunction,iconbouton,utilise,ajouter;
	
	public static void main(String[] args) {

	    JFrame fenetre = new JFrame();
	    //Définit un titre pour notre fenêtre
	    fenetre.setTitle("Créer votre application");
	    //Définit sa taille : 400 pixels de large et 100 pixels de haut
	    fenetre.setSize(400, 100);
	    //Nous demandons maintenant à notre objet de se positionner au centre
	    fenetre.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Et enfin, la rendre visible        
	    fenetre.setVisible(true);
		
		
		//on lit les fichiers
		 
		TraiteurFichier.LectureFichierJs();//lecture du squelette
		TraiteurFichier.LectureFichierModel();
		
		TraiteurFichier.AfficherListJs();
		System.out.println("************************************************************");
		TraiteurFichier.AfficherListModel();
		
		SqueletteVue.PreparerSquelette();//on integre la vu au squelette
		System.out.println("************************************************************");
		TraiteurFichier.EcritureFicherandroidvue();//on ecrit le fichier squellette avec la vue
		
		TraiteurFichier.LectureFichierJsVue();//on lit le fichier squellette avec la vue
		System.out.println("************************************************************");

		TraiteurFichier.AfficherListJsVue();
		//on lance l'execution
		Controleur.Execution();
		System.out.println("************************************************************");

		TraiteurFichier.AfficherListJsVue();
		

		//on lance l'ecriture du fichier
		TraiteurFichier.EcritureFicherindexandroid();
}
}