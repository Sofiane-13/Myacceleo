package generateur;

public class Controleur {
	static int i,j;
	static String nombouton,nomfunction,iconbouton,utilise,nomlabel;
    static String nomInputStyle,heigh,padding,marginRight,flex,fontSize,borderWidth,borderColor,borderRadius;
    
    
    
	public static void Execution(){
	//on parcourt le model 
	//la vue
    for(i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){

	    
	    //on test si il y'a un bouton
	    if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Button")){
	    	//on recupére les informations du bouton
	    	nombouton=TraiteurFichier.ListdeslignesModel.get(i+1);
	    	utilise=TraiteurFichier.ListdeslignesModel.get(i+5);
	    	//appeller injecteur	
	    	Injecteur.InjecterBouton(nombouton, utilise);
	                                                     }
	    	 //on test si il y'a un label
	         else if (TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("FormLabel")) {
	        	//on recupére les informations de la function
	 	    	nomlabel=TraiteurFichier.ListdeslignesModel.get(i+1);
	 	    	//on appelle l'injecteur 
	 	    	Injecteur.InjecterLabel(nomlabel);
	         }
	         else if (TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("InputStyle")) {
	        	 nomInputStyle=TraiteurFichier.ListdeslignesModel.get(i+1);
	        	 heigh=TraiteurFichier.ListdeslignesModel.get(i+3);
	        	 padding=TraiteurFichier.ListdeslignesModel.get(i+5);
	        	 marginRight=TraiteurFichier.ListdeslignesModel.get(i+7);
	        	 flex=TraiteurFichier.ListdeslignesModel.get(i+9);
	             fontSize=TraiteurFichier.ListdeslignesModel.get(i+11);
	        	 borderWidth=TraiteurFichier.ListdeslignesModel.get(i+13);
	        	 borderColor=TraiteurFichier.ListdeslignesModel.get(i+16);
	        	 borderRadius=TraiteurFichier.ListdeslignesModel.get(i+18);
	        	 Injecteur.InjecterInputStyle(nomInputStyle,heigh, padding, marginRight, flex, fontSize, borderWidth, borderColor, borderRadius);
	         }
	    //controleur
	  //on test si il y'a un Remplir table
	 	    else if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("RemplirTable")){
	 	    	//on recupére les informations de la function
	 	    	nomfunction=TraiteurFichier.ListdeslignesModel.get(i+1);
	 	    	utilise=TraiteurFichier.ListdeslignesModel.get(i+3);
	 	    	
	 	    	//on appelle l'injecteur
	 	    	Injecteur.InjecterFunRemplirTab(nomfunction,utilise);
	 	    	
	 	    }   
    	
                                             }
}
}
