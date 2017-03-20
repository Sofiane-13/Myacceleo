package generateur;

public class Controleur {
	static int i,j;
	static String nombouton,nomfunction,iconbouton,utilise,nomlabel;
public static void Execution(){
	//on parcourt le model 
    for(i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){

	    
	    //on test si il y'a un bouton
	    if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Button")){
	    	//on recupére les informations du bouton
	    	nombouton=TraiteurFichier.ListdeslignesModel.get(i+1);
	    	utilise=TraiteurFichier.ListdeslignesModel.get(i+5);
	    	//appeller injecteur	
	    	Injecteur.InjecterBouton(nombouton, utilise);
	                                                     }
	    	//on test si il y'a un Remplir table
	    else if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("RemplirTable")){
	    	//on recupére les informations de la function
	    	nomfunction=TraiteurFichier.ListdeslignesModel.get(i+1);
	    	utilise=TraiteurFichier.ListdeslignesModel.get(i+3);
	    	
	    	//on appelle l'injecteur
	    	Injecteur.InjecterFunRemplirTab(nomfunction,utilise);
	    	
	    }    //on test si il y'a un label
	         else if (TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("FormLabel")) {
	        	//on recupére les informations de la function
	 	    	nomlabel=TraiteurFichier.ListdeslignesModel.get(i+1);
	 	    	//on appelle l'injecteur 
	 	    	Injecteur.InjecterLabel(nomlabel);
	         }
    	
                                             }
}
}
