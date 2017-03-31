package generateur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TraiteurFichier {
               static String Modelfile="";
			   static String Jsfile="";
               static String [] resModel = null;
			   static String [] resJs = null;
               static String Codefinale="";
               static int i;
public static  List<String> ListdeslignesModel = new ArrayList<String>();
public static  List<String> ListdeslignesJs = new ArrayList<String>();

static File fileModel = new File("./Model.txt");
static File fileJs = new File("./android.js");
static File Newfilejs=new File("./index.android.js");


			public static void LectureFichier(){
	

	int i;
	  
	Scanner scannerModel = null;
	
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
     
	//on met le Model et Js dans une list 
	    for(i=0;i<resModel.length;i++){
	    	ListdeslignesModel.add(resModel[i]);
	    }
	    //on supprime du ficher ce dont on a pas besoin
	    ListdeslignesModel.removeAll(Arrays.asList("", ",",";","	","\"ApplicationPfe.univTlemcen\"","\"VersionPourPfe\"","	La","application","'applicationPfe'","{","}","version:",":","La","sdk:","max:","min:","target:","vue","controleur",".","Le","=>",""));
	    
	    for(i=0;i<resJs.length;i++){
	    	ListdeslignesJs.add(resJs[i]);
	    }
}
	
			public static void EcritureFicher(){
				//on vide le tableau
				resJs=null;
				for(i=0;i<ListdeslignesJs.size();i++){
					Codefinale=Codefinale+ListdeslignesJs.get(i)+"\n";
			    }
				try {
					//on crée un nouveau js file
					Newfilejs.createNewFile();
					//on crée un file writer
					FileWriter FileWriter=new FileWriter(Newfilejs);
					FileWriter.write(Codefinale);
					FileWriter.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				
}
			public static void AfficherListJs(){
				for(i=0;i<ListdeslignesJs.size();i++){
					System.out.println("i= "+i+" Mot= "+ListdeslignesJs.get(i));
				}
}
			public static void AfficherListModel(){
				for(i=0;i<ListdeslignesModel.size();i++){
					System.out.println("i= "+i+" Mot= "+ListdeslignesModel.get(i));
				}
}
}



















