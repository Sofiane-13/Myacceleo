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
			   static String JsfileVue="";
               static String [] resModel = null;
			   static String [] resJs = null;
			   static String [] resJsVue = null;
               static String Codefinale="";
               static int i;
public static  List<String> ListdeslignesModel = new ArrayList<String>();
public static  List<String> ListdeslignesJs = new ArrayList<String>();
public static  List<String> ListdeslignesJsVue = new ArrayList<String>();

static File fileModel = new File("./Model.txt");
static File fileJs = new File("./android.js");
static File Newfilejs=new File("./androidvue.js");
static File fileJsVue=new File("./index.android.js");

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
			public static void LectureFichierJs(){
				Scanner scannerJs = null;
				try {
					
					scannerJs = new Scanner(fileJs);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while (scannerJs.hasNextLine()) {
					  String line2 = scannerJs.nextLine();
					  Jsfile=Jsfile+" "+line2;
					   
					}
				resJs = Jsfile.split(" ");
				
				for(i=0;i<resJs.length;i++){
			    	ListdeslignesJs.add(resJs[i]);
			    }
			}
			public static void LectureFichierJsVue(){
				Scanner scannerJs = null;
				try {
					
					scannerJs = new Scanner(Newfilejs);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while (scannerJs.hasNextLine()) {
					  String line2 = scannerJs.nextLine();
					  JsfileVue=JsfileVue+" "+line2;
					   
					}
				resJsVue = JsfileVue.split(" ");
				
				for(i=0;i<resJsVue.length;i++){
			    	ListdeslignesJsVue.add(resJsVue[i]);
			    }
			}
	
			public static void EcritureFicherandroidvue(){
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
			public static void EcritureFicherindexandroid(){
				//on vide le tableau
				resJs=null;
				Codefinale="";
				for(i=0;i<ListdeslignesJsVue.size();i++){
					Codefinale=Codefinale+ListdeslignesJsVue.get(i)+"\n";
			    }
				try {
					//on crée un nouveau js file
					Newfilejs.createNewFile();
					//on crée un file writer
					FileWriter FileWriter=new FileWriter(fileJsVue);
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
			public static void AfficherListJsVue(){
				for(i=0;i<ListdeslignesJsVue.size();i++){
					System.out.println("i= "+i+" Mot= "+ListdeslignesJsVue.get(i));
				}
			}
}



















