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
			   static String [] resModel = null;
               static String Codefinale="";
               static int i;
public static  List<String> ListdeslignesModel = new ArrayList<String>();
// ../runtime-New_configuration(4)/org.xtext.UnivTlmcen.pfe/instances.pfe
static File fileModel = new File("./Model.txt");

			public static void LectureFichierModel(){
	

	int i;
	  
	Scanner scannerModel = null;
	
	
	//lecture model et js
	try {
		scannerModel = new Scanner(fileModel);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	while (scannerModel.hasNextLine()) {
	  String line = scannerModel.nextLine();
	  Modelfile=Modelfile+" "+line;
	   
	}
	

	//on decompose notre fichier
	 resModel = Modelfile.split(" ");
	 
     
	//on met le Model et Js dans une list 
	    for(i=0;i<resModel.length;i++){
	    	ListdeslignesModel.add(resModel[i]);
	    }
	    //on supprime du ficher ce dont on a pas besoin
	    ListdeslignesModel.removeAll(Arrays.asList("", ",",";","	","\"ApplicationPfe.univTlemcen\"","\"VersionPourPfe\"","	La","application","'applicationPfe'","{","}","version:",":","La","sdk:","max:","min:","target:","vue","controleur",".","Le","=>",""));
	    
	    
}

	

			public static void EcritureComposant(String nom){
				Codefinale="";
				for(i=0;i<Controleur.complist.size();i++){
					Codefinale=Codefinale+Controleur.complist.get(i)+"\n";
			    }
				try {
					//on crée un nouveau js file
					File Compfile=new File("./fichier/pfe/"+nom+".js");
					Compfile.createNewFile();
					//on crée un file writer
					FileWriter FileWriter=new FileWriter(Compfile);
					FileWriter.write(Codefinale);
					FileWriter.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			public static void Ecritureindex(){
				Codefinale="";
				for(i=0;i<Controleur.indexlist.size();i++){
					Codefinale=Codefinale+Controleur.indexlist.get(i)+"\n";
			    }
				try {
					//on crée un nouveau js file
					File Compfile=new File("./fichier/pfe/index.android.js");
					Compfile.createNewFile();
					//on crée un file writer
					FileWriter FileWriter=new FileWriter(Compfile);
					FileWriter.write(Codefinale);
					FileWriter.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

}


