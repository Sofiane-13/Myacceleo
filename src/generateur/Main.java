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
	static String nombouton,iconbouton,utilise,ajouter,Modelfile="",Jsfile="";
	
	public static void main(String[] args) {
		int i,j,k,l,m,n;	
		int o=0;
		
		List<String> ListdeslignesModel = new ArrayList<String>();
		List<String> ListdeslignesJs = new ArrayList<String>();
	   
		File fileModel = new File("./Model.txt");
		File fileJs = new File("./index.android.js");


		String [] resModel = null;  
		Scanner scannerModel = null;
		String [] resJs = null;  
		Scanner scannerJs = null;
		//lecture model et js
		try {
			scannerModel = new Scanner(fileModel);
			scannerJs = new Scanner(fileJs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (scannerModel.hasNextLine()) {
		  String line = scannerModel.nextLine();
		  Modelfile=Modelfile+" "+line;
		   
		}
		
		while (scannerJs.hasNextLine()) {
			  String line2 = scannerJs.nextLine();
			  Jsfile=Jsfile+" "+line2;
			   
			}
		//on decompose notre fichier
		 resModel = Modelfile.split(" ");
		 resJs = Jsfile.split(" ");
		
		 System.out.println("****************Afficher Model*********************"); 
	//on met le Model et Js dans une list 
	    for(i=0;i<resModel.length;i++){
	    	ListdeslignesModel.add(resModel[i]);
	    }
	    //on supprime du ficher ce dont on a pas besoin
	    ListdeslignesModel.removeAll(Arrays.asList("", ",",";","	","\"ApplicationPfe.univTlemcen\"","\"VersionPourPfe\"","	La","application","'applicationPfe'","{","}","version:",":","La","sdk:","max:","min:","target:","vue","controleur","End.",".","Le","=>",""));
	    for(i=0;i<resJs.length;i++){
	    	ListdeslignesJs.add(resJs[i]);
	    }
	    
	   
	//on parcourt le model 
	    for(i=0;i<ListdeslignesModel.size();i++){

		    System.out.println(ListdeslignesModel.get(i));
		    //on test si il y'a un bouton
		    if(ListdeslignesModel.get(i).equalsIgnoreCase("Button")){
		    	//on recupére les informations du boton
		    	nombouton=ListdeslignesModel.get(i+1);
		    	 for(j=0;j<ListdeslignesJs.size();j++){
			        //on recupére la position du <View>
			 	    if(ListdeslignesJs.get(j).equalsIgnoreCase("<View>")){
				 	    //on prépare le code a injecter 	
				 	    ajouter= "<Button title="+nombouton+" />";
				 	    //on injecte le code
				 	    ListdeslignesJs.add(j+1, ajouter);
		 	                                                             }
		 	                                           }	
		    	
		                                                            }
	    	
	                                             }
	    
	    
	    
	    System.out.println("****************Afficher Js**************************");
    //on affiche le Js
	    for(i=0;i<ListdeslignesJs.size();i++){
	    	System.out.println(ListdeslignesJs.get(i));
	    }
}
}