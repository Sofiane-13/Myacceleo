package generateur;

public class Controleur {
	static int i,j;
	static String nombouton,iconright,raisedlarge,Style,onclique,nomfunction,onlongclique,icon,iconbouton,utilise,nomlabel,MessageAlert;
    static String nomInputStyle,heigh,padding,marginRight,nominput,flex,fontSize,borderWidth,borderColor,borderRadius,FlexDirection,BackGroundColor,JustifyContent,borderRadium;
    
    
    
	public static void Execution(){
	//on parcourt le model 
	//la vue
    for(i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){

	    
	    //on test si il y'a un bouton
	    if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Button")){
	    	//on recupére les informations du bouton
	    	nombouton=TraiteurFichier.ListdeslignesModel.get(i+1);
	    	onclique=TraiteurFichier.ListdeslignesModel.get(i+5);
	    	onlongclique=TraiteurFichier.ListdeslignesModel.get(i+7);
	    	icon=TraiteurFichier.ListdeslignesModel.get(i+3);
	    	Style=TraiteurFichier.ListdeslignesModel.get(i+9);
	    	raisedlarge=TraiteurFichier.ListdeslignesModel.get(i+11);
	    	iconright=TraiteurFichier.ListdeslignesModel.get(i+13);
	    	//appeller injecteur	
	    	Injecteur.InjecterBouton(nombouton,onclique,onlongclique,icon,Style,raisedlarge,iconright);
	                                                     }
	    	 //on test si il y'a un label
	         else if (TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Input")) {
	        	//on recupére les informations de la function
	 	    	nominput=TraiteurFichier.ListdeslignesModel.get(i+1);
	 	    	Style=TraiteurFichier.ListdeslignesModel.get(i+4);
	 	    	//on appelle l'injecteur 
	 	    	Injecteur.InjecterInput(nominput,Style);
	         }
	  //on test si il y'a une listeView
	         else if (TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("list")) {
	        	//on recupére les informations de la List
	 	    	nomlabel=TraiteurFichier.ListdeslignesModel.get(i+1);
	 	    	//on appelle l'injecteur 
	 	    	Injecteur.InjecterListView();
	         }
	  //on test si il y'a un Stylesheet
	         else if (TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("StyleSheet")) {
	        	 nomInputStyle=TraiteurFichier.ListdeslignesModel.get(i+1);
	        	 heigh=TraiteurFichier.ListdeslignesModel.get(i+3);
	        	 flex=TraiteurFichier.ListdeslignesModel.get(i+5); 
	        	 BackGroundColor=TraiteurFichier.ListdeslignesModel.get(i+7);
	        	 borderRadium=TraiteurFichier.ListdeslignesModel.get(i+9);
	        	 padding=TraiteurFichier.ListdeslignesModel.get(i+11);
	        	 marginRight=TraiteurFichier.ListdeslignesModel.get(i+13);
	             fontSize=TraiteurFichier.ListdeslignesModel.get(i+15);
	        	 borderWidth=TraiteurFichier.ListdeslignesModel.get(i+17);
	        	 borderColor=TraiteurFichier.ListdeslignesModel.get(i+19);
	        	 borderRadius=TraiteurFichier.ListdeslignesModel.get(i+21);
	        	 Injecteur.InjecterStyleSheet(nomInputStyle,heigh,flex,BackGroundColor,borderRadium, padding, marginRight,fontSize, borderWidth, borderColor, borderRadius);
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
	 	   else if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("AlertFunction")){
	 		//on recupére les informations de la function
	 	    	nomfunction=TraiteurFichier.ListdeslignesModel.get(i+1);
	 	    	MessageAlert=TraiteurFichier.ListdeslignesModel.get(i+3);
	 	    	Injecteur.InjecterAlertFunction(nomfunction,MessageAlert);
	 	   }
	    
    	
                                             }
}
}
