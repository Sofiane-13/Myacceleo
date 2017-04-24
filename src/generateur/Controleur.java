package generateur;

import java.util.ArrayList;
import java.util.List;

public class Controleur {
	static int i,j,f;
	static String backgroundColor,alignItems,overflow,TextShadowRadius,TextShadowColor,TextDecorationLine,color,TextAlign,fontFamily,borderBottomColor,alignSelf,borderLeftColo,flexDirection,height ,justifyContent;
	static String Codeainjecter,compocode,nomlayoutnav;
	static String nomlayout,titrelayout;
	static String nombouton,iconright,raisedlarge,Style,onclique,nomfunction,onlongclique,icon,iconbouton,utilise,nomlabel,MessageAlert;
    static String nomInputStyle,heigh,padding,marginRight,nominput,flex,fontSize,borderWidth,borderColor,borderRadius,FlexDirection,JustifyContent,borderRadium;
    static String lineHeight,textAlign,textDecorationLine,right,width,maxheigh,maxWidth,BorderRadium,position,minHeight,minWidth,left,Flex,flexWrap,fontStyle,paddingBottom,paddingHorizontal,paddingLeft,paddingRight,paddingTop,paddingVertical,opacity,bottom,margin,marginBottom,marginHorizontal,marginLeft,marginTop,marginVertical,fontWeight,borderStyle,borderBottomLeftRadius,borderBottomRightRadius,textShadowColor,borderRightColor,borderLeftColor,borderBottomWidth,borderLeftWidth,textAlignVertical,borderRightWidth,tborderRightColor,textShadowRadius,extShadowRadius,fontVariant,letterSpacing,textDecorationColor,textDecorationStyle,writingDirection,borderRightColorborderRightWidth,borderTopColor,borderTopLeftRadius,borderTopRightRadius,borderTopWidth,backfaceVisibility,BackGroundColor;

    static String NomLabel,stylelabel,contenu;
    static String Stylelistview,table;
    static String nomList,Table;
    static String ligne,colonne;
    static List<String> ListViewinputList = new ArrayList<String>();
    static List<String> TableinputList = new ArrayList<String>();
    static String squellettecomp=" import React, { Component } from 'react' import {AppRegistry,ScrollView,StyleSheet,Text,Alert,View,TouchableHighlight,TextInput,ListView} from 'react-native'; import { Button,Grid,Col,Row } from 'react-native-elements'  import { Actions } from 'react-native-router-flux'; import { getDatabase } from './index.android.js'; export default class extends Component { constructor(props) { super(props); //Constructeur this.state = { //Debutdustate } } componentDidMount() { //DidMount } //function render() { //Vue return(  <View style={{marginTop: 50, }}> <ScrollView>  </ScrollView> </View> ); } } var styles = StyleSheet.create({ //StyleSheet }); AppRegistry.registerComponent( ,()=> );";
    static String indexandroid= "import React, { Component } from 'react'; import { Scene, Router, TabBar, Modal, Schema, Actions, Reducer, ActionConst} from 'react-native-router-flux'; import {AppRegistry,ScrollView,StyleSheet,Text,Alert,View,TouchableHighlight,TextInput,ListView} from 'react-native'; var Firebase=require('firebase'); var config={ apiKey: \"AIzaSyDysc3BPHCAGkHJ4K61zwXhZb07M5rnCQE\", authDomain: \"pfedsl-68809.firebaseapp.com\", databaseURL: \"https://pfedsl-68809.firebaseio.com/\", }; const myFirebaseRefapp=firebase.initializeApp(config); import * as firebase from \"firebase\"; export const getDatabase=()=>{ return(  myFirebaseRefapp.database() );} //import export default class pfe extends Component {render() { return( <Router > <Scene key=\"root\"> </Scene> </Router> ); } } AppRegistry.registerComponent('pfe', ()=>pfe);";
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
			
		    }
		
	
    for(i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){
    	//a chaque fois qu'on trouve un Layout
    	 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Layout")){
    		 
    		 //on prepare la liste du fichier composent
    		 tabcom=squellettecomp.split(" "); 
    		 for(j=0;j<tabcom.length;j++){
    			 complist.add(tabcom[j]);
    		
    		    }
    		 
    		 //on récupére le nom et le titre du layout
    		 nomlayout=TraiteurFichier.ListdeslignesModel.get(i+1);
    		 titrelayout=TraiteurFichier.ListdeslignesModel.get(i+3);
    		 
    		 //on injecte le Layout dans l'index
    		 for(j=0;j<indexlist.size();j++){
    			 if(indexlist.get(j).equalsIgnoreCase("//import")){
     				Codeainjecter="import "+nomlayout+" from './"+nomlayout+"';";
     			indexlist.add(j+1,Codeainjecter); 
     			}
    			if(indexlist.get(j).equalsIgnoreCase("key=\"root\">")){
    				Codeainjecter="<Scene key=\""+nomlayout+"\" component={"+nomlayout+"} title=\""+titrelayout+"\" />";
    			indexlist.add(j+1,Codeainjecter); 
    			}
    		    }
    	
    		 
    		 
    		
    		 //on ajoute le nom du composant dans la liste composant
    		 for(j=0;j<complist.size();j++){
    			 if(complist.get(j).equalsIgnoreCase("class"))complist.add(j+1,nomlayout);
    			 if(complist.get(j).equalsIgnoreCase("AppRegistry.registerComponent(")){complist.add(j+1,"'"+nomlayout+"'");complist.add(j+3,nomlayout);}
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
    					 ligne=TraiteurFichier.ListdeslignesModel.get(j+4);
    					 colonne=TraiteurFichier.ListdeslignesModel.get(j+6);
    					
    					 SqueletteVue.RemplirCellue(ligne, colonne);
    				 }
    				 
    				 
    			 }
    		 }
    		 
    		 f++;}
   			 
   		
   			
   			 //avec les donnée de la cellule on construit notre vue
   			SqueletteVue.PreparerSquelette();
   		
   			
   			//on split la liste
   			String [] tabcom = null;
   			compocode="";
   			for(j=0;j<complist.size();j++){
      			 compocode=compocode+" "+complist.get(j);
      		    }
   			tabcom = compocode.split(" ");
   			complist.clear();
   			for(j=1;j<tabcom.length;j++){
   			 complist.add(tabcom[j]);
   		    }
   		    //on recupére les composant du layout une deuxiéme fois afin d'injecter le code
   		//on recupére les composent de ce layout un par un pour une deuxiéme fois afin d'injecter le code
 			f=i+7;
 			 while((!TraiteurFichier.ListdeslignesModel.get(f).equalsIgnoreCase("Style"))){
 				//on reparcours le model afin d'aller chercher les donnée de ces composant
 				 for(j=0;j<TraiteurFichier.ListdeslignesModel.size();j++){
 	    			 if(TraiteurFichier.ListdeslignesModel.get(j).equalsIgnoreCase(TraiteurFichier.ListdeslignesModel.get(f))){
 	    				 //on test la nature du composant
 	    				 
 	    				 //si c'est une Boutton
 	    				 if(TraiteurFichier.ListdeslignesModel.get(j-1).equalsIgnoreCase("Bouton")){
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
 	    		 	
 	    		 	    	//appeller injecteur	
 	    		 		   
 	    					Injecteur.InjecterBouton(nombouton, onclique, onlongclique, icon, Style, raisedlarge, iconright, ligne, colonne);
 	    				 }
 	    				if(TraiteurFichier.ListdeslignesModel.get(j-1).equalsIgnoreCase("Input")){
 	    					nominput=TraiteurFichier.ListdeslignesModel.get(j);
 	    					
 	    		 	    	Style=TraiteurFichier.ListdeslignesModel.get(j+2);
 	    		 	    	ligne=TraiteurFichier.ListdeslignesModel.get(j+4);
 	    		 	    	colonne=TraiteurFichier.ListdeslignesModel.get(j+6);
 	    		 	    	
 	    		 	    	Injecteur.InjecterInput(nominput,Style,ligne,colonne);
 	    				}
 	    				if(TraiteurFichier.ListdeslignesModel.get(j-1).equalsIgnoreCase("listView")){
 	    					//on recupére les informations de la List
 	    		 	    	nomList=TraiteurFichier.ListdeslignesModel.get(j);
 	    		 	    	Stylelistview=TraiteurFichier.ListdeslignesModel.get(j+2);
 	    		 	    	Table=TraiteurFichier.ListdeslignesModel.get(j+4);
 	    		 	    	ligne=TraiteurFichier.ListdeslignesModel.get(j+6);
 	    		 	    	colonne=TraiteurFichier.ListdeslignesModel.get(j+8);
 	    		    	
 	    		 	    	//on appelle l'injecteur 
 	    		 	    	Injecteur.InjecterListView(Stylelistview,Table,ligne,colonne);
 	    		 	    }
 	    				 }
 	    			 }
 				 f++; }
   			//Apres avoir fini avec les composant de la vue on lui inject tout les function et table
 			for(f=0;f<TraiteurFichier.ListdeslignesModel.size();f++){
 		    	//si on trouve remplir table
 		    	 if(TraiteurFichier.ListdeslignesModel.get(f).equalsIgnoreCase("RemplirTable")){
 		    		//on recupére les informations de la function
 		 	    	nomfunction=TraiteurFichier.ListdeslignesModel.get(f+1);
 		 	        
 		 	    	Table=TraiteurFichier.ListdeslignesModel.get(f+3);
 		 	        	
 		 	    	//on appelle l'injecteur
 		 	    	Injecteur.InjecterFunRemplirTab(nomfunction,Table);
 		    	 }
 		    	if(TraiteurFichier.ListdeslignesModel.get(f).equalsIgnoreCase("Table")){
 		    		//on recupére les informations de la function
 		    		 Table=TraiteurFichier.ListdeslignesModel.get(f+1);
 		    		 Injecteur.InjecterTable(Table);
 		    	 }
 		    	if(TraiteurFichier.ListdeslignesModel.get(f).equalsIgnoreCase("AlertFunction")){
 		    		//on recupére les informations de la function
 		 	    	nomfunction=TraiteurFichier.ListdeslignesModel.get(f+1);
 		 	    	MessageAlert=TraiteurFichier.ListdeslignesModel.get(f+3);
 		 	    	Injecteur.InjecterAlertFunction(nomfunction,MessageAlert);
 		    	 }
 		    	if(TraiteurFichier.ListdeslignesModel.get(f).equalsIgnoreCase("Navigate")){
 		    		//on recupére les informations de la function
 		 	    	nomfunction=TraiteurFichier.ListdeslignesModel.get(f+1);
 		 	    	nomlayoutnav=TraiteurFichier.ListdeslignesModel.get(f+3);
 		 	    	Injecteur.InjecterNavigation(nomfunction,nomlayoutnav);
 		    	 }
 		    	if(TraiteurFichier.ListdeslignesModel.get(f).equalsIgnoreCase("StyleText")){
 		    		
 		    		nomInputStyle=TraiteurFichier.ListdeslignesModel.get(f+1);
 		    		color=TraiteurFichier.ListdeslignesModel.get(f+3);
 		    		fontFamily=TraiteurFichier.ListdeslignesModel.get(f+5);
 		    		fontSize=TraiteurFichier.ListdeslignesModel.get(f+7);
 		    		fontStyle=TraiteurFichier.ListdeslignesModel.get(f+9);
 		    		fontWeight=TraiteurFichier.ListdeslignesModel.get(f+11);
 		    		lineHeight=TraiteurFichier.ListdeslignesModel.get(f+13);
 		    		TextAlign=TraiteurFichier.ListdeslignesModel.get(f+15);
 		    		TextDecorationLine=TraiteurFichier.ListdeslignesModel.get(f+17);
 		    		TextShadowColor=TraiteurFichier.ListdeslignesModel.get(f+19);
 		    		TextShadowRadius=TraiteurFichier.ListdeslignesModel.get(f+21);
 		    		backfaceVisibility=TraiteurFichier.ListdeslignesModel.get(f+23);
 		    		backgroundColor=TraiteurFichier.ListdeslignesModel.get(f+25);
 		    		borderBottomColor=TraiteurFichier.ListdeslignesModel.get(f+27);
 		    		borderBottomLeftRadius=TraiteurFichier.ListdeslignesModel.get(f+29);
 		    		borderBottomRightRadius=TraiteurFichier.ListdeslignesModel.get(f+31);
 		    		borderBottomWidth=TraiteurFichier.ListdeslignesModel.get(f+33);
 		    		borderColor=TraiteurFichier.ListdeslignesModel.get(f+35);
 		    		borderLeftColor=TraiteurFichier.ListdeslignesModel.get(f+37);
 		    		borderLeftWidth=TraiteurFichier.ListdeslignesModel.get(f+39);
 		    		borderRadius=TraiteurFichier.ListdeslignesModel.get(f+41);
 		    		borderRightColor=TraiteurFichier.ListdeslignesModel.get(f+43);
 		    		borderRightWidth=TraiteurFichier.ListdeslignesModel.get(f+45);
 		    		borderStyle=TraiteurFichier.ListdeslignesModel.get(f+47);
 		    		borderTopColor=TraiteurFichier.ListdeslignesModel.get(f+49);
 		    		borderTopLeftRadius=TraiteurFichier.ListdeslignesModel.get(f+51);
 		    		borderTopRightRadius=TraiteurFichier.ListdeslignesModel.get(f+53);
 		    		borderTopWidth=TraiteurFichier.ListdeslignesModel.get(f+55);
 		    		borderWidth=TraiteurFichier.ListdeslignesModel.get(f+57);
 		    		opacity=TraiteurFichier.ListdeslignesModel.get(f+59);
 		    		Injecteur.InjecterStyleText(nomInputStyle,color,fontFamily,fontSize,fontStyle,fontWeight,lineHeight,TextAlign,TextDecorationLine,TextShadowColor,TextShadowRadius,backfaceVisibility,backgroundColor,borderBottomColor,borderBottomLeftRadius,borderBottomRightRadius,borderBottomWidth,borderColor,borderLeftColor,borderLeftWidth,borderRadius,borderRightColor,borderRightWidth,borderStyle,borderTopColor,borderTopLeftRadius,borderTopRightRadius,borderTopWidth,borderWidth,opacity);
 		    	}
 		    	if(TraiteurFichier.ListdeslignesModel.get(f).equalsIgnoreCase("StyleView")){
 		    		//on recupére les informations du stylView
 		    	nomInputStyle=TraiteurFichier.ListdeslignesModel.get(f+1);
 		    	backfaceVisibility=TraiteurFichier.ListdeslignesModel.get(f+3);
 		    	backgroundColor = TraiteurFichier.ListdeslignesModel.get(f+5);
 		    	borderBottomColor=TraiteurFichier.ListdeslignesModel.get(f+7);
 		    	borderBottomLeftRadius=TraiteurFichier.ListdeslignesModel.get(f+9);
 		    	borderBottomRightRadius=TraiteurFichier.ListdeslignesModel.get(f+11);
 		    	borderBottomWidth=TraiteurFichier.ListdeslignesModel.get(f+13);
 		    	borderColor=TraiteurFichier.ListdeslignesModel.get(f+15);
 		    	borderLeftColor=TraiteurFichier.ListdeslignesModel.get(f+17);
 		    	borderLeftWidth=TraiteurFichier.ListdeslignesModel.get(f+19);
 		    	borderRadius=TraiteurFichier.ListdeslignesModel.get(f+21);
 		    	borderRightColor=TraiteurFichier.ListdeslignesModel.get(f+23);
 		    	borderRightWidth=TraiteurFichier.ListdeslignesModel.get(f+25);
 		    	borderStyle=TraiteurFichier.ListdeslignesModel.get(f+27);
 		    	borderTopColor=TraiteurFichier.ListdeslignesModel.get(f+29);
 		    	borderTopLeftRadius=TraiteurFichier.ListdeslignesModel.get(f+31);
 		    	borderTopRightRadius=TraiteurFichier.ListdeslignesModel.get(f+33);
 		    	borderTopWidth=TraiteurFichier.ListdeslignesModel.get(f+35);
 		    	borderWidth=TraiteurFichier.ListdeslignesModel.get(f+37);
 		    	opacity=TraiteurFichier.ListdeslignesModel.get(f+39);
 		    	alignItems=TraiteurFichier.ListdeslignesModel.get(f+41);
 		    	alignSelf=TraiteurFichier.ListdeslignesModel.get(f+43);
 		      	bottom=TraiteurFichier.ListdeslignesModel.get(f+45);
 		    	flex=TraiteurFichier.ListdeslignesModel.get(f+47);
 		    	flexDirection=TraiteurFichier.ListdeslignesModel.get(f+49);
 		    	flexWrap=TraiteurFichier.ListdeslignesModel.get(f+51);
 		    	height=TraiteurFichier.ListdeslignesModel.get(f+53);
 		    	justifyContent=TraiteurFichier.ListdeslignesModel.get(f+55);
 		    	left=TraiteurFichier.ListdeslignesModel.get(f+57);
 		    	margin=TraiteurFichier.ListdeslignesModel.get(f+59);
 		    	marginBottom=TraiteurFichier.ListdeslignesModel.get(f+61);
 		    	marginHorizontal=TraiteurFichier.ListdeslignesModel.get(f+63);
 		    	marginLeft=TraiteurFichier.ListdeslignesModel.get(f+65);
 		    	marginRight=TraiteurFichier.ListdeslignesModel.get(f+67);
 		    	marginTop=TraiteurFichier.ListdeslignesModel.get(f+69);
 		    	marginVertical=TraiteurFichier.ListdeslignesModel.get(f+71);
 		    	padding=TraiteurFichier.ListdeslignesModel.get(f+73);
 		    	paddingBottom=TraiteurFichier.ListdeslignesModel.get(f+75);
 		    	paddingHorizontal=TraiteurFichier.ListdeslignesModel.get(f+77);
 		    	paddingRight=TraiteurFichier.ListdeslignesModel.get(f+79);
 		    	paddingTop=TraiteurFichier.ListdeslignesModel.get(f+81);
 		    	paddingVertical=TraiteurFichier.ListdeslignesModel.get(f+83);
 		    	right=TraiteurFichier.ListdeslignesModel.get(f+85);
 		    	width=TraiteurFichier.ListdeslignesModel.get(f+87);
 		    
 		    	
 		    	Injecteur.InjecterStyleView(nomInputStyle,backfaceVisibility,backgroundColor,borderBottomColor,borderBottomLeftRadius,borderBottomRightRadius,borderBottomWidth,borderColor,borderLeftColor,borderLeftWidth,borderRadius,borderRightColor,borderRightWidth,borderStyle,borderTopColor,borderTopLeftRadius,borderTopRightRadius,borderTopWidth,borderWidth,opacity,alignItems,alignSelf,bottom,flex,flexDirection,flexWrap,height,justifyContent,left,margin,marginBottom,marginHorizontal,marginLeft,marginRight,marginTop,marginVertical,padding,paddingBottom,paddingHorizontal,paddingRight,paddingTop,paddingVertical,right,width);
 		    	 }
 		    	if(TraiteurFichier.ListdeslignesModel.get(f).equalsIgnoreCase("StyleImage")){
 		    		
 		    		nomInputStyle=TraiteurFichier.ListdeslignesModel.get(f+1);
 		    		backfaceVisibility=TraiteurFichier.ListdeslignesModel.get(f+3);
 		    		backgroundColor=TraiteurFichier.ListdeslignesModel.get(f+5);
 		    		borderBottomLeftRadius=TraiteurFichier.ListdeslignesModel.get(f+7);
 		    		borderBottomRightRadius=TraiteurFichier.ListdeslignesModel.get(f+9);
 		    		borderColor=TraiteurFichier.ListdeslignesModel.get(f+11);
 		    		borderRadius=TraiteurFichier.ListdeslignesModel.get(f+13);
 		    		borderTopLeftRadius=TraiteurFichier.ListdeslignesModel.get(f+15);
 		    		borderTopRightRadius=TraiteurFichier.ListdeslignesModel.get(f+17);
 		    		borderWidth=TraiteurFichier.ListdeslignesModel.get(f+19);
 		    		opacity=TraiteurFichier.ListdeslignesModel.get(f+21);
 		    		overflow=TraiteurFichier.ListdeslignesModel.get(f+23);
 		    		alignItems=TraiteurFichier.ListdeslignesModel.get(f+25);
 		    		alignSelf=TraiteurFichier.ListdeslignesModel.get(f+27);
 		    		bottom=TraiteurFichier.ListdeslignesModel.get(f+29);
 		    		flex=TraiteurFichier.ListdeslignesModel.get(f+31);
 		    		justifyContent=TraiteurFichier.ListdeslignesModel.get(f+33);
 		    		left=TraiteurFichier.ListdeslignesModel.get(f+35);
 		    		margin=TraiteurFichier.ListdeslignesModel.get(f+37);
 		    		marginBottom=TraiteurFichier.ListdeslignesModel.get(f+39);
 		    		marginHorizontal=TraiteurFichier.ListdeslignesModel.get(f+41);
 		    		marginLeft=TraiteurFichier.ListdeslignesModel.get(f+43);
 		    		marginRight=TraiteurFichier.ListdeslignesModel.get(f+45);
 		    		marginTop=TraiteurFichier.ListdeslignesModel.get(f+47);
 		    		marginVertical=TraiteurFichier.ListdeslignesModel.get(f+49);
 		    		padding=TraiteurFichier.ListdeslignesModel.get(f+51);
 		    		paddingBottom=TraiteurFichier.ListdeslignesModel.get(f+53);
 		    		paddingHorizontal=TraiteurFichier.ListdeslignesModel.get(f+55);
 		    		paddingRight=TraiteurFichier.ListdeslignesModel.get(f+57);
 		    		paddingTop=TraiteurFichier.ListdeslignesModel.get(f+59);
 		    		paddingVertical=TraiteurFichier.ListdeslignesModel.get(f+61);
 		    		right=TraiteurFichier.ListdeslignesModel.get(f+63);
 		    		width=TraiteurFichier.ListdeslignesModel.get(f+65);
 		    		flexDirection=TraiteurFichier.ListdeslignesModel.get(f+67);
 		    		flexWrap=TraiteurFichier.ListdeslignesModel.get(f+69);
 		    		height=TraiteurFichier.ListdeslignesModel.get(f+71);
 		    		Injecteur.InjecterStyleImage(nomInputStyle,backfaceVisibility,backgroundColor,borderBottomLeftRadius,borderBottomRightRadius,borderColor,borderRadius,borderTopLeftRadius,borderTopRightRadius,borderWidth,opacity,overflow,alignItems,alignSelf,bottom,flex,justifyContent,left,margin,marginBottom,marginHorizontal,marginLeft,marginRight,marginTop,marginVertical,padding,paddingBottom,paddingHorizontal,paddingRight,paddingTop,paddingVertical,right,width,flexDirection,flexWrap,height);
 		    	}
 		    	
 		    	 }
   			//La on devra ecrire le composant avant d'entamer un  autre
   			TraiteurFichier.EcritureComposant(nomlayout);
   			//on remet le tableau a 0
   		  celluleVue = new int [100][100];
   		  tabcom = null;
   		  complist.clear();
   		for(j=0;j<complist.size();j++){
			
		 }
    	 }

    	//la vue    
//	   //on test si il y'a un label
//    	 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Text")){
//    		   		 NomLabel=TraiteurFichier.ListdeslignesModel.get(i+1);
//    		    		 stylelabel=TraiteurFichier.ListdeslignesModel.get(i+5);
//    		    		 contenu=TraiteurFichier.ListdeslignesModel.get(i+3);
//    		    		
//    		    			Injecteur.InjecterLabel(NomLabel,stylelabel,contenu);
//    		    	 }



    	
                                             }
    //on ecrit l'index
    TraiteurFichier.Ecritureindex();
}
}

