package generateur;

import java.util.ArrayList;
import java.util.List;

public class Controleur {
	static int i,j,f;
	static String Codeainjecter,compocode;
	static String nomlayout,titrelayout;
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
    static String squellettecomp=" import React, { Component } from 'react' import {AppRegistry,ScrollView,StyleSheet,Text,Alert,View,TouchableHighlight,TextInput,ListView} from 'react-native'; import { Button,Grid,Col,Row } from 'react-native-elements' var Firebase = require('firebase'); var config = { //ConfigurationDATABASE }; const myFirebaseRefapp =  firebase.initializeApp(config); import * as firebase from \"firebase\"; export default class extends Component { constructor(props) { super(props); //Constructeur this.state = { //Debutdustate } componentDidMount() { //DidMount } //function render() { //Vue return(  <ScrollView> <Grid> </Grid> </ScrollView> ); } } var styles = StyleSheet.create({ //StyleSheet }); AppRegistry.registerComponent('pfe', ()=>pfe);";
    static String indexandroid= "import React, { Component } from 'react';   import { Scene, Router, TabBar, Modal, Schema, Actions, Reducer, ActionConst} from 'react-native-router-flux'; import {AppRegistry,ScrollView,StyleSheet,Text,Alert,View,TouchableHighlight,TextInput,ListView} from 'react-native';  //import      export   default    class pfe extends Component {render() { return( <Router > <Scene key=\"root\">            </Scene> </Router>  ); } } AppRegistry.registerComponent('pfe', ()=>pfe);";
    public static List<String> complist= new ArrayList<String>();
    public static int [][] celluleVue = new int [100][100];
    static String [] tabcom = null;
    static List<String> indexlist= new ArrayList<String>();	
    static String [] tabindex = null;	
	public static void Execution(){
	//on parcourt le model 
		tabindex=indexandroid.split(" ");
		 for(j=0;j<tabindex.length;j++){
			 indexlist.add(tabindex[j]);
			 System.out.println(tabindex[j]);
		    }
		
	
    for(i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){
    	//a chaque fois qu'on trouve un Layout
    	 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Layout")){
    		 
    		 //on prepare la liste du fichier composent
    		 tabcom=squellettecomp.split(" "); 
    		 for(j=0;j<tabcom.length;j++){
    			 complist.add(tabcom[j]);
    			 System.out.println("Num "+j+" "+tabcom[j]);
    		    }
    		 
    		 //on récupére le nom et le titre du layout
    		 nomlayout=TraiteurFichier.ListdeslignesModel.get(i+1);
    		 titrelayout=TraiteurFichier.ListdeslignesModel.get(i+3);
    		 
    		 //on injecte le Layout dans l'index
    		 for(j=0;j<indexlist.size();j++){
    			if(indexlist.get(j).equalsIgnoreCase("key=\"root\">")){
    				Codeainjecter="<Scene key=\""+nomlayout+"\" component={"+nomlayout+"} title=\""+titrelayout+"\" />";
    			indexlist.add(j+1,Codeainjecter); 
    			}
    		    }
    		 //affichage index
    		 System.out.println("affichage index-------------------------------------------");
    		 for(j=0;j<indexlist.size();j++){
    			 System.out.println(indexlist.get(j));
    		    }
    		 
    		 //on ajoute le nom du composant dans la liste composant
    		 for(j=0;j<complist.size();j++){
    			 if(complist.get(j).equalsIgnoreCase("class"))complist.add(j+1,nomlayout);
    		 }
    		 
    		 //on recupére les composent de ce layout un par un 
    			f=i+7;
   			 while((!TraiteurFichier.ListdeslignesModel.get(f).equalsIgnoreCase("Style"))){
    		 
    		 //on reparcours le model afin d'aller chercher le positionement des composents de ce layout et construire la vue
    		 for(j=0;j<TraiteurFichier.ListdeslignesModel.size();j++){
    			 if(TraiteurFichier.ListdeslignesModel.get(j).equalsIgnoreCase(TraiteurFichier.ListdeslignesModel.get(f))){
    				 //on test la nature du composant
    				 
    				 //si c'est une icone
    				 if(TraiteurFichier.ListdeslignesModel.get(j-1).equalsIgnoreCase("Icone")){
    					 //on ajoute dans cellule la ligne et la col
    					 ligne=TraiteurFichier.ListdeslignesModel.get(j+6);
    					 colonne=TraiteurFichier.ListdeslignesModel.get(j+8);
    					 SqueletteVue.RemplirCellue(ligne, colonne);
    				 }
    				 
    				 //si c'est un boutton
    				 if(TraiteurFichier.ListdeslignesModel.get(j-1).equalsIgnoreCase("Bouton")){
    					 //on ajoute dans cellule la ligne et la col
    					 System.out.println("------------------------------------------");
    					 ligne=TraiteurFichier.ListdeslignesModel.get(j+14);
    					 colonne=TraiteurFichier.ListdeslignesModel.get(j+16);
    					 SqueletteVue.RemplirCellue(ligne, colonne);
    				 }
    				 
    				//si c'est une listeView
    				 if(TraiteurFichier.ListdeslignesModel.get(j-1).equalsIgnoreCase("listView")){
    					 //on ajoute dans cellule la ligne et la col
    					 ligne=TraiteurFichier.ListdeslignesModel.get(j+6);
    					 colonne=TraiteurFichier.ListdeslignesModel.get(j+8);
    					 SqueletteVue.RemplirCellue(ligne, colonne);
    				 }
    				 if(TraiteurFichier.ListdeslignesModel.get(j-1).equalsIgnoreCase("Input")){
    					 ligne=TraiteurFichier.ListdeslignesModel.get(j+5);
    					 colonne=TraiteurFichier.ListdeslignesModel.get(j+7);
    					 SqueletteVue.RemplirCellue(ligne, colonne);
    				 }
    				 
    				 
    			 }
    		 }
    		 
    		 f++;}
   			 
   		
   			
   			 //avec les donnée de la cellule on construit notre vue
   			SqueletteVue.PreparerSquelette();
   			for(j=0;j<complist.size();j++){
   			 
   			 System.out.println("fin num "+j+" "+complist.get(j));
   		    }
   			
   			//on split la liste
   			String [] tabcom = null;
   			for(j=0;j<complist.size();j++){
      			 compocode=compocode+" "+complist.get(j);
      		    }
   			tabcom = compocode.split(" ");
   			complist.clear();
   			for(j=1;j<tabcom.length;j++){
   			 complist.add(tabcom[j]);
   			 System.out.println("Num "+j+" "+tabcom[j]);
   		    }
   		    //on recupére les composant du layout une deuxiéme fois afin d'injecter le code
   		//on recupére les composent de ce layout un par un pour une deuxiéme fois afin d'injecter le code
 			f=i+7;
 			 while((!TraiteurFichier.ListdeslignesModel.get(f).equalsIgnoreCase("Style"))){
 				//on reparcours le model afin d'aller chercher les donnée de ces composant
 				 for(j=0;j<TraiteurFichier.ListdeslignesModel.size();j++){
 	    			 if(TraiteurFichier.ListdeslignesModel.get(j).equalsIgnoreCase(TraiteurFichier.ListdeslignesModel.get(f))){
 	    				 //on test la nature du composant
 	    				 
 	    				 //si c'est une icone
 	    				 if(TraiteurFichier.ListdeslignesModel.get(j-1).equalsIgnoreCase("Bouton")){
 	    					 System.out.println(TraiteurFichier.ListdeslignesModel.get(j-1)+"///////////////////////////////////////////////////////////////");
 	    					 //on recupére les information du boutton
 	    					nombouton=TraiteurFichier.ListdeslignesModel.get(j);
 	    			    	onclique=TraiteurFichier.ListdeslignesModel.get(j+4);
 	    			    	onlongclique=TraiteurFichier.ListdeslignesModel.get(j+6);
 	    			    	icon=TraiteurFichier.ListdeslignesModel.get(j+2);
 	    			    	Style=TraiteurFichier.ListdeslignesModel.get(j+8);
 	    			    	raisedlarge=TraiteurFichier.ListdeslignesModel.get(j+10);
 	    			    	iconright=TraiteurFichier.ListdeslignesModel.get(j+12);
 	    			    	ligne=TraiteurFichier.ListdeslignesModel.get(j+14);
 	    		 	    	colonne=TraiteurFichier.ListdeslignesModel.get(j+16);
 	    		 	    	 System.out.println(ligne+"     "+colonne);
 	    			    	//appeller injecteur	
 	    		 		   
 	    					Injecteur.InjecterBouton(nombouton, onclique, onlongclique, icon, Style, raisedlarge, iconright, ligne, colonne);
 	    				 }
 	    				 }
 	    			 }
 				 f++; }
   			//....................
   			//La on devra ecrire le composant avant d'entamer un  autre
   			TraiteurFichier.EcritureComposant(nomlayout);
   			//on remet le tableau a 0
   		  celluleVue = new int [100][100];
   		  complist.clear();
    	 }
//    	//Le model
//    	 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("DataBase")){
//   	/* | */	 NomDataBase=TraiteurFichier.ListdeslignesModel.get(i+1);
//    		 apikye=TraiteurFichier.ListdeslignesModel.get(i+3);
//    		 authDomain=TraiteurFichier.ListdeslignesModel.get(i+5);
//    		 databaseURL=TraiteurFichier.ListdeslignesModel.get(i+7);
//    			Injecteur.InjecterDataBase(NomDataBase,apikye,authDomain,databaseURL);
//    	 }
//    	 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Table")){
//    		 Table=TraiteurFichier.ListdeslignesModel.get(i+1);
//    		 Injecteur.InjecterTable(Table);
//    	 }
//    	//la vue    
//	   //on test si il y'a un label
//    	 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Text")){
//    		   		 NomLabel=TraiteurFichier.ListdeslignesModel.get(i+1);
//    		    		 stylelabel=TraiteurFichier.ListdeslignesModel.get(i+5);
//    		    		 contenu=TraiteurFichier.ListdeslignesModel.get(i+3);
//    		    		
//    		    			Injecteur.InjecterLabel(NomLabel,stylelabel,contenu);
//    		    	 }
//    	 //on test si il y'a un bouton
//	    if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Bouton")){
//	    	//on recupére les informations du bouton
//	    	nombouton=TraiteurFichier.ListdeslignesModel.get(i+1);
//	    	onclique=TraiteurFichier.ListdeslignesModel.get(i+5);
//	    	onlongclique=TraiteurFichier.ListdeslignesModel.get(i+7);
//	    	icon=TraiteurFichier.ListdeslignesModel.get(i+3);
//	    	Style=TraiteurFichier.ListdeslignesModel.get(i+9);
//	    	raisedlarge=TraiteurFichier.ListdeslignesModel.get(i+11);
//	    	iconright=TraiteurFichier.ListdeslignesModel.get(i+13);
//	    	ligne=TraiteurFichier.ListdeslignesModel.get(i+15);
// 	    	colonne=TraiteurFichier.ListdeslignesModel.get(i+17);
//	    	//appeller injecteur	
//	    	Injecteur.InjecterBouton(nombouton,onclique,onlongclique,icon,Style,raisedlarge,iconright,ligne,colonne);
//	    	                                             }
//	    	 //on test si il y'a un input
//	         else if (TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Input")) {
//	        	//on recupére les informations de la function
//	 	    	nominput=TraiteurFichier.ListdeslignesModel.get(i+1);
//	 	    	Style=TraiteurFichier.ListdeslignesModel.get(i+4);
//	 	    	ligne=TraiteurFichier.ListdeslignesModel.get(i+6);
//	 	    	colonne=TraiteurFichier.ListdeslignesModel.get(i+8);
//	 	    	//on appelle l'injecteur 
//	 	    	Injecteur.InjecterInput(nominput,Style,ligne,colonne);
//	         }
//	  //on test si il y'a une listeView
//	         else if (TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("listView")) {
//	        	//on recupére les informations de la List
//	 	    	nomList=TraiteurFichier.ListdeslignesModel.get(i+1);
//	 	    	Stylelistview=TraiteurFichier.ListdeslignesModel.get(i+3);
//	 	    	Table=TraiteurFichier.ListdeslignesModel.get(i+5);
//	 	    	ligne=TraiteurFichier.ListdeslignesModel.get(i+7);
//	 	    	colonne=TraiteurFichier.ListdeslignesModel.get(i+9);
//	    	
//	 	    	//on appelle l'injecteur 
//	 	    	Injecteur.InjecterListView(Stylelistview,Table,ligne,colonne);
//	         }
//	  //on test si il y'a un Stylesheet
//	         else if (TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("StyleSheet")) {
//	        	 nomInputStyle=TraiteurFichier.ListdeslignesModel.get(i+1);
//	        	 right=TraiteurFichier.ListdeslignesModel.get(i+3);
//	        	 width=TraiteurFichier.ListdeslignesModel.get(i+5);
//	        	 heigh=TraiteurFichier.ListdeslignesModel.get(i+7);
//	        	 maxheigh=TraiteurFichier.ListdeslignesModel.get(i+9);
//	        	 maxWidth=TraiteurFichier.ListdeslignesModel.get(i+11);
//	        	 minHeight=TraiteurFichier.ListdeslignesModel.get(i+13);
//	        	 minWidth=TraiteurFichier.ListdeslignesModel.get(i+15);
//	        	 left=TraiteurFichier.ListdeslignesModel.get(i+17);
//	        	 Flex=TraiteurFichier.ListdeslignesModel.get(i+19);
//	        	 flexWrap=TraiteurFichier.ListdeslignesModel.get(i+21);
//	        	 JustifyContent=TraiteurFichier.ListdeslignesModel.get(i+23);
//	        	 BorderRadium=TraiteurFichier.ListdeslignesModel.get(i+25);
//	        	 position=TraiteurFichier.ListdeslignesModel.get(i+27);
//	        	 padding=TraiteurFichier.ListdeslignesModel.get(i+29);
//	        	 paddingBottom=TraiteurFichier.ListdeslignesModel.get(i+31);
//	        	 paddingHorizontal=TraiteurFichier.ListdeslignesModel.get(i+33);
//	        	 paddingLeft=TraiteurFichier.ListdeslignesModel.get(i+35);
//	        	 paddingRight=TraiteurFichier.ListdeslignesModel.get(i+37);
//	        	 paddingTop=TraiteurFichier.ListdeslignesModel.get(i+39);
//	        	 paddingVertical=TraiteurFichier.ListdeslignesModel.get(i+41);
//	        	 opacity=TraiteurFichier.ListdeslignesModel.get(i+43);
//	        	 bottom=TraiteurFichier.ListdeslignesModel.get(i+45);
//	        	 margin=TraiteurFichier.ListdeslignesModel.get(i+47);
//	        	 marginBottom=TraiteurFichier.ListdeslignesModel.get(i+49);
//	        	 marginHorizontal=TraiteurFichier.ListdeslignesModel.get(i+51);
//	        	 marginLeft=TraiteurFichier.ListdeslignesModel.get(i+53);
//	        	 marginTop=TraiteurFichier.ListdeslignesModel.get(i+55);
//	        	 marginVertical=TraiteurFichier.ListdeslignesModel.get(i+57);
//	        	 marginRight=TraiteurFichier.ListdeslignesModel.get(i+59);
//	        	 fontSize=TraiteurFichier.ListdeslignesModel.get(i+61);
//	        	 fontStyle=TraiteurFichier.ListdeslignesModel.get(i+63);
//	        	 fontWeight=TraiteurFichier.ListdeslignesModel.get(i+65);
//	        	 borderStyle=TraiteurFichier.ListdeslignesModel.get(i+67);
//	        	 borderBottomLeftRadius=TraiteurFichier.ListdeslignesModel.get(i+69);
//	        	 borderBottomRightRadius=TraiteurFichier.ListdeslignesModel.get(i+71);
//	        	 borderBottomWidth=TraiteurFichier.ListdeslignesModel.get(i+73);
//	        	 borderWidth=TraiteurFichier.ListdeslignesModel.get(i+75);
//	        	 borderColor=TraiteurFichier.ListdeslignesModel.get(i+78);
//	        	 borderLeftColor=TraiteurFichier.ListdeslignesModel.get(i+81);
//	        	 borderLeftWidth=TraiteurFichier.ListdeslignesModel.get(i+83);
//	        	 borderRadius=TraiteurFichier.ListdeslignesModel.get(i+85);
//	        	 borderRightColor = TraiteurFichier.ListdeslignesModel.get(i+88);
//	        	 borderRightWidth = TraiteurFichier.ListdeslignesModel.get(i+90);
//	        	 borderTopColor=TraiteurFichier.ListdeslignesModel.get(i+93);
//	        	 borderTopLeftRadius=TraiteurFichier.ListdeslignesModel.get(i+95);
//	        	 borderTopRightRadius=TraiteurFichier.ListdeslignesModel.get(i+96);
//	        	 borderTopWidth=TraiteurFichier.ListdeslignesModel.get(i+99);
//	        	 backfaceVisibility=TraiteurFichier.ListdeslignesModel.get(i+101);
//	        	 BackGroundColor=TraiteurFichier.ListdeslignesModel.get(i+104);
//	        	 lineHeight=TraiteurFichier.ListdeslignesModel.get(i+106);
//	        	 textAlign=TraiteurFichier.ListdeslignesModel.get(i+108);
//	        	 textDecorationLine=TraiteurFichier.ListdeslignesModel.get(i+110);
//	        	 textShadowColor=TraiteurFichier.ListdeslignesModel.get(i+113);
//	        	 textAlignVertical=TraiteurFichier.ListdeslignesModel.get(i+115);
//	        	 textShadowRadius=TraiteurFichier.ListdeslignesModel.get(i+117);
//	        	 fontVariant=TraiteurFichier.ListdeslignesModel.get(i+119);
//	        	 letterSpacing=TraiteurFichier.ListdeslignesModel.get(i+121);
//	        	 textDecorationColor=TraiteurFichier.ListdeslignesModel.get(i+124);
//	        	 textDecorationStyle=TraiteurFichier.ListdeslignesModel.get(i+126);
//	        	 writingDirection=TraiteurFichier.ListdeslignesModel.get(i+128);
//	        	 
//	        	 Injecteur.InjecterStyleSheet(nomInputStyle,right,width,maxheigh,maxWidth,minHeight,minWidth,left,Flex,flexWrap,JustifyContent,BorderRadium,position,padding,paddingBottom,paddingHorizontal,paddingLeft,paddingRight,paddingTop,paddingVertical,opacity,bottom,margin,marginBottom,marginHorizontal,marginLeft,marginTop,marginVertical,marginRight,fontSize,fontStyle,fontWeight,borderStyle,borderBottomLeftRadius,borderBottomRightRadius,borderBottomWidth,borderWidth,borderColor,borderLeftColor,borderLeftWidth,borderRadius,borderRightColor,borderRightWidth,borderTopColor,borderTopLeftRadius,borderTopRightRadius,borderTopWidth,backfaceVisibility,BackGroundColor,lineHeight,textAlign,textDecorationLine,textShadowColor,textAlignVertical,textShadowRadius,fontVariant,letterSpacing,textDecorationColor,textDecorationStyle,writingDirection);
//	         }
//	    //controleur
//	  //on test si il y'a un Remplir table
//	 	    else if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("RemplirTable")){
//	 	    	//on recupére les informations de la function
//	 	    	nomfunction=TraiteurFichier.ListdeslignesModel.get(i+1);
//	 	        
//	 	    	Table=TraiteurFichier.ListdeslignesModel.get(i+3);
//	 	        	
//	 	    	//on appelle l'injecteur
//	 	    	Injecteur.InjecterFunRemplirTab(nomfunction,Table);
//	 	    	
//	 	    }
//	 	   else if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("AlertFunction")){
//	 		//on recupére les informations de la function
//	 	    	nomfunction=TraiteurFichier.ListdeslignesModel.get(i+1);
//	 	    	MessageAlert=TraiteurFichier.ListdeslignesModel.get(i+3);
//	 	    	Injecteur.InjecterAlertFunction(nomfunction,MessageAlert);
//	 	   }
//	    
    	
                                             }
    //on ecrit l'index
    TraiteurFichier.Ecritureindex();
}
}

