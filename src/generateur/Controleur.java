package generateur;

import java.util.ArrayList;
import java.util.List;

public class Controleur {
	static int i,j;
	static String nombouton,iconright,raisedlarge,Style,onclique,nomfunction,onlongclique,icon,iconbouton,utilise,nomlabel,MessageAlert;
    static String nomInputStyle,heigh,padding,marginRight,nominput,flex,fontSize,borderWidth,borderColor,borderRadius,FlexDirection,JustifyContent,borderRadium;
    static String lineHeight,textAlign,textDecorationLine,right,width,maxheigh,maxWidth,BorderRadium,position,minHeight,minWidth,left,Flex,flexWrap,fontStyle,paddingBottom,paddingHorizontal,paddingLeft,paddingRight,paddingTop,paddingVertical,opacity,bottom,margin,marginBottom,marginHorizontal,marginLeft,marginTop,marginVertical,fontWeight,borderStyle,borderBottomLeftRadius,borderBottomRightRadius,textShadowColor,borderRightColor,borderLeftColor,borderBottomWidth,borderLeftWidth,textAlignVertical,borderRightWidth,tborderRightColor,textShadowRadius,extShadowRadius,fontVariant,letterSpacing,textDecorationColor,textDecorationStyle,writingDirection,borderRightColorborderRightWidth,borderTopColor,borderTopLeftRadius,borderTopRightRadius,borderTopWidth,backfaceVisibility,BackGroundColor;
    static String NomDataBase,apikye,authDomain,databaseURL;
    static String NomLabel,stylelabel,contenu;
    static String Stylelistview,table;
    static String nomList,Table;
    static String ligne,colonne;
    static List<String> ListViewinputList = new ArrayList<String>();
    static List<String> TableinputList = new ArrayList<String>();
    
	 
    	
	public static void Execution(){
	//on parcourt le model 
	
		
	
    for(i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){
    	//Le model
    	 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("DataBase")){
   	/* | */	 NomDataBase=TraiteurFichier.ListdeslignesModel.get(i+1);
    		 apikye=TraiteurFichier.ListdeslignesModel.get(i+3);
    		 authDomain=TraiteurFichier.ListdeslignesModel.get(i+5);
    		 databaseURL=TraiteurFichier.ListdeslignesModel.get(i+7);
    			Injecteur.InjecterDataBase(NomDataBase,apikye,authDomain,databaseURL);
    	 }
    	 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Table")){
    		 Table=TraiteurFichier.ListdeslignesModel.get(i+1);
    		 Injecteur.InjecterTable(Table);
    	 }
    	//la vue    
	   //on test si il y'a un label
    	 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Text")){
    		   		 NomLabel=TraiteurFichier.ListdeslignesModel.get(i+1);
    		    		 stylelabel=TraiteurFichier.ListdeslignesModel.get(i+5);
    		    		 contenu=TraiteurFichier.ListdeslignesModel.get(i+3);
    		    		
    		    			Injecteur.InjecterLabel(NomLabel,stylelabel,contenu);
    		    	 }
    	 //on test si il y'a un bouton
	    if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Bouton")){
	    	//on recupére les informations du bouton
	    	nombouton=TraiteurFichier.ListdeslignesModel.get(i+1);
	    	onclique=TraiteurFichier.ListdeslignesModel.get(i+5);
	    	onlongclique=TraiteurFichier.ListdeslignesModel.get(i+7);
	    	icon=TraiteurFichier.ListdeslignesModel.get(i+3);
	    	Style=TraiteurFichier.ListdeslignesModel.get(i+9);
	    	raisedlarge=TraiteurFichier.ListdeslignesModel.get(i+11);
	    	iconright=TraiteurFichier.ListdeslignesModel.get(i+13);
	    	ligne=TraiteurFichier.ListdeslignesModel.get(i+15);
 	    	colonne=TraiteurFichier.ListdeslignesModel.get(i+17);
	    	//appeller injecteur	
	    	Injecteur.InjecterBouton(nombouton,onclique,onlongclique,icon,Style,raisedlarge,iconright,ligne,colonne);
	    	                                             }
	    	 //on test si il y'a un label
	         else if (TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Input")) {
	        	//on recupére les informations de la function
	 	    	nominput=TraiteurFichier.ListdeslignesModel.get(i+1);
	 	    	Style=TraiteurFichier.ListdeslignesModel.get(i+4);
	 	    	ligne=TraiteurFichier.ListdeslignesModel.get(i+6);
	 	    	colonne=TraiteurFichier.ListdeslignesModel.get(i+8);
	 	    	//on appelle l'injecteur 
	 	    	Injecteur.InjecterInput(nominput,Style,ligne,colonne);
	         }
	  //on test si il y'a une listeView
	         else if (TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("listView")) {
	        	//on recupére les informations de la List
	 	    	nomList=TraiteurFichier.ListdeslignesModel.get(i+1);
	 	    	Stylelistview=TraiteurFichier.ListdeslignesModel.get(i+3);
	 	    	Table=TraiteurFichier.ListdeslignesModel.get(i+5);
	 	    	ligne=TraiteurFichier.ListdeslignesModel.get(i+7);
	 	    	colonne=TraiteurFichier.ListdeslignesModel.get(i+9);
	    	
	 	    	//on appelle l'injecteur 
	 	    	Injecteur.InjecterListView(Stylelistview,Table,ligne,colonne);
	         }
	  //on test si il y'a un Stylesheet
	         else if (TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("StyleSheet")) {
	        	 nomInputStyle=TraiteurFichier.ListdeslignesModel.get(i+1);
	        	 right=TraiteurFichier.ListdeslignesModel.get(i+3);
	        	 width=TraiteurFichier.ListdeslignesModel.get(i+5);
	        	 heigh=TraiteurFichier.ListdeslignesModel.get(i+7);
	        	 maxheigh=TraiteurFichier.ListdeslignesModel.get(i+9);
	        	 maxWidth=TraiteurFichier.ListdeslignesModel.get(i+11);
	        	 minHeight=TraiteurFichier.ListdeslignesModel.get(i+13);
	        	 minWidth=TraiteurFichier.ListdeslignesModel.get(i+15);
	        	 left=TraiteurFichier.ListdeslignesModel.get(i+17);
	        	 Flex=TraiteurFichier.ListdeslignesModel.get(i+19);
	        	 flexWrap=TraiteurFichier.ListdeslignesModel.get(i+21);
	        	 JustifyContent=TraiteurFichier.ListdeslignesModel.get(i+23);
	        	 BorderRadium=TraiteurFichier.ListdeslignesModel.get(i+25);
	        	 position=TraiteurFichier.ListdeslignesModel.get(i+27);
	        	 padding=TraiteurFichier.ListdeslignesModel.get(i+29);
	        	 paddingBottom=TraiteurFichier.ListdeslignesModel.get(i+31);
	        	 paddingHorizontal=TraiteurFichier.ListdeslignesModel.get(i+33);
	        	 paddingLeft=TraiteurFichier.ListdeslignesModel.get(i+35);
	        	 paddingRight=TraiteurFichier.ListdeslignesModel.get(i+37);
	        	 paddingTop=TraiteurFichier.ListdeslignesModel.get(i+39);
	        	 paddingVertical=TraiteurFichier.ListdeslignesModel.get(i+41);
	        	 opacity=TraiteurFichier.ListdeslignesModel.get(i+43);
	        	 bottom=TraiteurFichier.ListdeslignesModel.get(i+45);
	        	 margin=TraiteurFichier.ListdeslignesModel.get(i+47);
	        	 marginBottom=TraiteurFichier.ListdeslignesModel.get(i+49);
	        	 marginHorizontal=TraiteurFichier.ListdeslignesModel.get(i+51);
	        	 marginLeft=TraiteurFichier.ListdeslignesModel.get(i+53);
	        	 marginTop=TraiteurFichier.ListdeslignesModel.get(i+55);
	        	 marginVertical=TraiteurFichier.ListdeslignesModel.get(i+57);
	        	 marginRight=TraiteurFichier.ListdeslignesModel.get(i+59);
	        	 fontSize=TraiteurFichier.ListdeslignesModel.get(i+61);
	        	 fontStyle=TraiteurFichier.ListdeslignesModel.get(i+63);
	        	 fontWeight=TraiteurFichier.ListdeslignesModel.get(i+65);
	        	 borderStyle=TraiteurFichier.ListdeslignesModel.get(i+67);
	        	 borderBottomLeftRadius=TraiteurFichier.ListdeslignesModel.get(i+69);
	        	 borderBottomRightRadius=TraiteurFichier.ListdeslignesModel.get(i+71);
	        	 borderBottomWidth=TraiteurFichier.ListdeslignesModel.get(i+73);
	        	 borderWidth=TraiteurFichier.ListdeslignesModel.get(i+75);
	        	 borderColor=TraiteurFichier.ListdeslignesModel.get(i+78);
	        	 borderLeftColor=TraiteurFichier.ListdeslignesModel.get(i+81);
	        	 borderLeftWidth=TraiteurFichier.ListdeslignesModel.get(i+83);
	        	 borderRadius=TraiteurFichier.ListdeslignesModel.get(i+85);
	        	 borderRightColor = TraiteurFichier.ListdeslignesModel.get(i+88);
	        	 borderRightWidth = TraiteurFichier.ListdeslignesModel.get(i+90);
	        	 borderTopColor=TraiteurFichier.ListdeslignesModel.get(i+93);
	        	 borderTopLeftRadius=TraiteurFichier.ListdeslignesModel.get(i+95);
	        	 borderTopRightRadius=TraiteurFichier.ListdeslignesModel.get(i+96);
	        	 borderTopWidth=TraiteurFichier.ListdeslignesModel.get(i+99);
	        	 backfaceVisibility=TraiteurFichier.ListdeslignesModel.get(i+101);
	        	 BackGroundColor=TraiteurFichier.ListdeslignesModel.get(i+104);
	        	 lineHeight=TraiteurFichier.ListdeslignesModel.get(i+106);
	        	 textAlign=TraiteurFichier.ListdeslignesModel.get(i+108);
	        	 textDecorationLine=TraiteurFichier.ListdeslignesModel.get(i+110);
	        	 textShadowColor=TraiteurFichier.ListdeslignesModel.get(i+113);
	        	 textAlignVertical=TraiteurFichier.ListdeslignesModel.get(i+115);
	        	 textShadowRadius=TraiteurFichier.ListdeslignesModel.get(i+117);
	        	 fontVariant=TraiteurFichier.ListdeslignesModel.get(i+119);
	        	 letterSpacing=TraiteurFichier.ListdeslignesModel.get(i+121);
	        	 textDecorationColor=TraiteurFichier.ListdeslignesModel.get(i+124);
	        	 textDecorationStyle=TraiteurFichier.ListdeslignesModel.get(i+126);
	        	 writingDirection=TraiteurFichier.ListdeslignesModel.get(i+128);
	        	 
	        	 Injecteur.InjecterStyleSheet(nomInputStyle,right,width,maxheigh,maxWidth,minHeight,minWidth,left,Flex,flexWrap,JustifyContent,BorderRadium,position,padding,paddingBottom,paddingHorizontal,paddingLeft,paddingRight,paddingTop,paddingVertical,opacity,bottom,margin,marginBottom,marginHorizontal,marginLeft,marginTop,marginVertical,marginRight,fontSize,fontStyle,fontWeight,borderStyle,borderBottomLeftRadius,borderBottomRightRadius,borderBottomWidth,borderWidth,borderColor,borderLeftColor,borderLeftWidth,borderRadius,borderRightColor,borderRightWidth,borderTopColor,borderTopLeftRadius,borderTopRightRadius,borderTopWidth,backfaceVisibility,BackGroundColor,lineHeight,textAlign,textDecorationLine,textShadowColor,textAlignVertical,textShadowRadius,fontVariant,letterSpacing,textDecorationColor,textDecorationStyle,writingDirection);
	         }
	    //controleur
	  //on test si il y'a un Remplir table
	 	    else if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("RemplirTable")){
	 	    	//on recupére les informations de la function
	 	    	nomfunction=TraiteurFichier.ListdeslignesModel.get(i+1);
	 	        
	 	    	Table=TraiteurFichier.ListdeslignesModel.get(i+3);
	 	        	
	 	    	//on appelle l'injecteur
	 	    	Injecteur.InjecterFunRemplirTab(nomfunction,Table);
	 	    	
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

