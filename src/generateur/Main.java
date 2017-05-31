package generateur;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.security.SecureRandom;
public class Main {
	public static String mabase;
	static String nombouton,nomfunction,iconbouton,utilise,ajouter;
	
	public static void main(String[] args) {
		int id=(int) Math.random()*5;
		Random ran = new Random();
		int x = ran.nextInt(6) + 5;
		Random r = new Random();
		int[] fiveRandomNumbers = r.ints(5, 0, 11).toArray();
		int randomNumber = r.ints(1, 0, 11).findFirst().getAsInt();
		SecureRandom random = new SecureRandom();
	     mabase = new BigInteger(130, random).toString(32);
		
	     //on supp le fichier si il éxiste
	     File file = new File("/home/sofiane/work/MyAcceleo/fichier/pfe");
	     boolean isDirectoryCreated = file.mkdir();
	        if (isDirectoryCreated) {
	            System.out.println("successfully made");
	             } else {
	               file.delete();
	               file.mkdir();
	               System.out.println("deleted and made");
	               }
		
	     new Interface();
//	TraiteurFichier.LectureFichierModel();
//	Controleur.Execution();

}

	

	
}