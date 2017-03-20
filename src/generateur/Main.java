package generateur;

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
		//on lit les fichiers
		TraiteurFichier.LectureFichier();
		
		TraiteurFichier.AfficherListJs();
		System.out.println("************************************************************");
		TraiteurFichier.AfficherListModel();
		//on lance l'execution
		Controleur.Execution();
		//on lance l'ecriture du fichier
		TraiteurFichier.EcritureFicher();
}
}