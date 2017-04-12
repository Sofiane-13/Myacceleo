package generateur;

import java.util.ArrayList;
import java.util.List;

public class Injecteur {
	static String CodeAajouter="",typeicon,Styleicon;
	static int i,j,f;
	public static  List<String>	TableinputList=new ArrayList<String>();
//Coté Model
public static void	InjecterDataBase( String NomDataBase, String apikye, String authDomain, String databaseURL){
	for(j=0;j<TraiteurFichier.ListdeslignesJsVue.size();j++){
		//on recupére la position du //ConfigurationDATABASE
		 if(TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase("//ConfigurationDATABASE")){
			 CodeAajouter="apiKey: \""+apikye+"\" , authDomain:  \""+authDomain+"\" , databaseURL: \""+databaseURL+"\" ,";
			  TraiteurFichier.ListdeslignesJsVue.add(j+1, CodeAajouter); 
		 }
	                                                         }
		                                           }
public static void InjecterTable(String Table){
	for(j=0;j<TraiteurFichier.ListdeslignesJsVue.size();j++){
		 if(TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase("//Constructeur")){
			CodeAajouter= "this."+Table+"itemsRef = myFirebaseRefapp.database().ref('"+Table+"'); this."+Table+"items=[];";
			TraiteurFichier.ListdeslignesJsVue.add(j+1, CodeAajouter);
		}
		 if(TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase("//Debutdustate")){
				CodeAajouter= Table+"Source: new ListView.DataSource({rowHasChanged: (row1, row2)=>row1 !== row2}),";
				TraiteurFichier.ListdeslignesJsVue.add(j+1, CodeAajouter);
			}
		 if(TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase("//DidMount")){
				CodeAajouter= " this."+Table+"itemsRef.on('child_added',	(dataSnapshot)=>{ this."+Table+"items.push({id: dataSnapshot.key,   text: dataSnapshot.val()}); this.setState({"+Table+"Source:	this.state."+Table+"Source.cloneWithRows(this."+Table+"items)}); });";
				CodeAajouter=CodeAajouter+" this."+Table+"itemsRef.on('child_removed', (dataSnapshot)=>{ this."+Table+"items = this."+Table+"items.filter((x)=>x.id !== dataSnapshot.key); this.setState({ "+Table+"Source: this.state."+Table+"Source.cloneWithRows(this."+Table+"items)});});";
				TraiteurFichier.ListdeslignesJsVue.add(j+1, CodeAajouter);
			}
		
	}
}
	
//Coté vue
public static void InjecterLabel( String NomLabel, String stylelabel, String contenu){
	 for(j=0;j<TraiteurFichier.ListdeslignesJsVue.size();j++){
		  //on recupére la position du <View>
	        if(TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase("//Vue")){
	        	CodeAajouter="<Text";
	        	if(!stylelabel.equalsIgnoreCase("none"))CodeAajouter=CodeAajouter+" style={ styles."+stylelabel+" } ";
	        	CodeAajouter=CodeAajouter+" > "+contenu+"</Text>";
	        	
	        }
	 }
}
public static void InjecterBouton(String nombouton,String onclique,String onlongclique,String icon,String Style,String raisedlarge,String iconright,String ligne,String colonne){
	//parcourire le nodejs
	
	 for(j=0;j<TraiteurFichier.ListdeslignesJsVue.size();j++){
       //on recupére la position du <View>
	        if((TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase(ligne))&&(TraiteurFichier.ListdeslignesJsVue.get(j+1).equalsIgnoreCase(colonne))){
		 	    //on prépare le code a injecter 	
	        	CodeAajouter="<Button";
	        	if(raisedlarge.equalsIgnoreCase("raised"))CodeAajouter=CodeAajouter+" raised";
	        	else if(raisedlarge.equalsIgnoreCase("large"))CodeAajouter=CodeAajouter+" large";
	        	//on parcours le model pour recuperer les propriété du icon
	        	 for(i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){
	        		 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase(icon) && TraiteurFichier.ListdeslignesModel.get(i-1).equalsIgnoreCase("Icone")){typeicon=TraiteurFichier.ListdeslignesModel.get(i+2);Styleicon=TraiteurFichier.ListdeslignesModel.get(i+4);}
	        	 }

	        	CodeAajouter=CodeAajouter+ " title='"+nombouton+"' onPress={() => this."+onclique+"()} onLongPress={() => this."+onlongclique+"()} buttonStyle={ styles."+Style+" } icon={{name: 'squirrel', type: '"+typeicon+"', buttonStyle: styles."+Styleicon+" }}  />";
		 	    //on injecte le code
		 	    TraiteurFichier.ListdeslignesJsVue.add(j+3, CodeAajouter); 
	                                                             }
	                                           }
	}

public static void InjecterInput(String nominput,String Style,String ligne,String colonne){
	for(j=0;j<TraiteurFichier.ListdeslignesJsVue.size();j++){
	        
		//on inject dans le state la variable du label
	    //on recupére la position du Debutdustate
 	    if(TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase("//Debutdustate")){
 	    	
	 	    //on prépare le code a injecter 	
 	    	CodeAajouter=nominput+": '',";
	 	    //on injecte le code
	 	    TraiteurFichier.ListdeslignesJsVue.add(j+1, CodeAajouter);
                                                             }
                
		
		
	    	//on inject dans la vue
		    //on recupére la position du <View>
	 	    if((TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase(ligne))&&(TraiteurFichier.ListdeslignesJsVue.get(j+1).equalsIgnoreCase(colonne))){
	 	    	
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter="<TextInput style={styles."+Style+"} placeholder=\""+nominput+"\" onChangeText={(text) => this.setState({"+nominput+": text})} value={this.state."+nominput+"}/>";
		 	    //on injecte le code		 	    
	 	    	TraiteurFichier.ListdeslignesJsVue.add(j+3, CodeAajouter);
	                                                             }
	                                           }  
		
	
}
public static void	InjecterListView(String Stylelistview,String table,String ligne,String colonne){
	System.out.println(ligne+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+colonne);
	for(j=0;j<TraiteurFichier.ListdeslignesJsVue.size();j++){
		//on inject la ListView dans la vue
		 if((TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase(ligne))&&(TraiteurFichier.ListdeslignesJsVue.get(j+1).equalsIgnoreCase(colonne))){
				System.out.println("Condition ---------------------------------------------------");

			 CodeAajouter="<ListView dataSource={this.state."+table+"Source} renderRow={this.renderRow"+table+".bind(this)} enableEmptySections={true} />";			 
			//on injecte le code
		 	    TraiteurFichier.ListdeslignesJsVue.add(j+3, CodeAajouter);
		    }
			//on inject la function removeRow
		 
		 if(TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase("//function")){
			 CodeAajouter="remove"+table+"(rowData) {  Alert.alert( ' Bravo ligne supprimée !');   this."+table+"itemsRef.child(rowData.id).remove();   }";
			 	TraiteurFichier.ListdeslignesJsVue.add(j+1, CodeAajouter);
		 }
			//on inject la function renderRow
		 if(TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase("//function")){
			 //on ouvre le renderRow
			 
			 CodeAajouter="renderRow"+table+"(rowData) { return ( <TouchableHighlight onPress={() => this.remove"+table+"(rowData)}><View >";
			
			 //a chaque input trouvé on lui injecte son affichage on part les chercher de la table 
			 		for(int i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){	
			 			 if((TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("Table"))&&(TraiteurFichier.ListdeslignesModel.get(i+1).equalsIgnoreCase(table))){
					f=i+3;
			 while((!TraiteurFichier.ListdeslignesModel.get(f).equalsIgnoreCase("End.")))
		 	    	{CodeAajouter=CodeAajouter+"<Text >"+TraiteurFichier.ListdeslignesModel.get(f)+" : {rowData.text."+TraiteurFichier.ListdeslignesModel.get(f)+"}</Text>";  f++;}
			 			 }
			 	}
			//on referme le renderRow
			 CodeAajouter=CodeAajouter+"</View></TouchableHighlight>  ); }";
			 TraiteurFichier.ListdeslignesJsVue.add(j+1, CodeAajouter);
		 }
		 //les styles du listview

		if(TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase("//StyleSheet")){
			 CodeAajouter=" row: { flexDirection: 'row', padding: 12, height: 44 }, separator: { height: 1, backgroundColor: '#CCCCCC', },";
			 TraiteurFichier.ListdeslignesJsVue.add(j+1, CodeAajouter);
		 }
	}

}
//coté StyleSheet
public static void InjecterStyleSheet(String nomInputStyle,String right,String width,String maxheigh,String maxWidth,String minHeight,String minWidth,String left,String Flex,String flexWrap,String JustifyContent,String BorderRadium,String position,String padding,String paddingBottom,String paddingHorizontal,String paddingLeft,String paddingRight,String paddingTop,String paddingVertical,String opacity,String bottom,String margin,String marginBottom,String marginHorizontal,String marginLeft,String marginTop,String marginVertical,String marginRight,String fontSize,String fontStyle,String fontWeight,String borderStyle,String borderBottomLeftRadius,String borderBottomRightRadius,String borderBottomWidth,String borderWidth,String borderColor,String borderLeftColor,String borderLeftWidth,String borderRadius,String borderRightColor,String borderRightWidth,String borderTopColor,String borderTopLeftRadius,String borderTopRightRadius,String borderTopWidth,String backfaceVisibility,String BackGroundColor,String lineHeight,String textAlign,String textDecorationLine,String textShadowColor,String textAlignVertical,String textShadowRadius,String fontVariant,String letterSpacing,String textDecorationColor, String textDecorationStyle,String writingDirection){
	for(j=0;j<TraiteurFichier.ListdeslignesJsVue.size();j++){
		 //on recupére la position du //Stylesheet
 	    if(TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase("//StyleSheet")){
 	    	//on prépare le code a injecter
 	    	CodeAajouter=nomInputStyle+": {";  
 	       
 	    	 if (!right.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" right: "+right+" ,";}
 	    	 if (!width.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" width: "+width+",";}
 	 	     if (!maxheigh.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" maxheigh: "+maxheigh+",";}
 	 	     if (!maxWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" maxWidth: "+maxWidth+",";}
 		     if (!minHeight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" minHeight: "+minHeight+",";}
 		     if (!minWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" minWidth: "+minWidth+",";}
 		     if (!left.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" left: "+left+",";}
 		     if (!Flex.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" Flex: "+Flex+",";}
 		     if (!flexWrap.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" flexWrap: '"+flexWrap+"',";}
 		     if (!JustifyContent.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" JustifyContent: '"+JustifyContent+"' ,";}
 		     if (!BorderRadium.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" BorderRadium: "+BorderRadium+",";}
 		     if (!position.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" position: '"+position+"' ,";}
 		     if (!padding.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" padding: "+padding+",";}
 		     if (!paddingBottom.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingBottom: "+paddingBottom+",";}
 		     if (!paddingHorizontal.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingHorizontal: "+paddingHorizontal+",";}
 		     if (!paddingLeft.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingLeft: "+paddingLeft+",";}
 		     if (!paddingRight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingRight: "+paddingRight+",";}
 		     if (!paddingTop.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingTop: "+paddingTop+",";}
 		     if (!paddingVertical.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingVertical: "+paddingVertical+",";}
 		     if (!opacity.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" opacity: "+opacity+",";}
 		     if (!bottom.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" bottom: "+bottom+",";}
 		     if (!margin.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" margin: "+margin+",";}
 		     if (!marginBottom.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginBottom: "+marginBottom+",";}
 		     if (!marginHorizontal.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginHorizontal: "+marginHorizontal+",";}
 		     if (!marginLeft.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginLeft: "+marginLeft+",";}
 		     if (!marginTop.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginTop: "+marginTop+",";}
 		     if (!marginVertical.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginVertical: "+marginVertical+",";}
 		     if (!marginRight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginRight: "+marginRight+",";}
 		     if (!fontSize.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" fontSize: "+fontSize+",";}
 		     if (!fontStyle.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" fontStyle: '"+fontStyle+"' ,";}
 		     if (!fontWeight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" fontWeight: '"+fontWeight+"' ,";}
 		     if (!borderStyle.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderStyle: '"+borderStyle+"' ,";}
 		     if (!borderBottomLeftRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomLeftRadius: "+borderBottomLeftRadius+",";}
 		     if (!borderBottomRightRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomRightRadius: "+borderBottomRightRadius+",";}
 		     if (!borderBottomWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomWidth: "+borderBottomWidth+",";}
 		     if (!borderWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderWidth: "+borderWidth+",";}
 		     if (!borderColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderColor: '"+borderColor+"' ,";}
 		     if (!borderLeftColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderLeftColor: '"+borderLeftColor+"' ,";}
 		     if (!borderLeftWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderLeftWidth: '"+borderLeftWidth+"' ,";}
 		     if (!borderRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRadius: "+borderRadius+",";}
 		     if (!borderRightColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRightColor: '"+borderRightColor+"' ,";}
 		     if (!borderRightWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRightWidth: "+borderRightWidth+",";}
 		     if (!borderTopColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopColor: '"+borderTopColor+"' ,";}
 		     if (!borderTopLeftRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopLeftRadius: "+borderTopLeftRadius+",";}
 		     if (!borderTopRightRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopRightRadius: "+borderTopRightRadius+",";}
 		     if (!borderTopWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopWidth: "+borderTopWidth+",";}
 		     if (!backfaceVisibility.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" backfaceVisibility: '"+backfaceVisibility+"' ,";}
 		     if (!BackGroundColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" BackGroundColor: '"+BackGroundColor+"' ,";}
 		     if (!lineHeight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" lineHeight: "+lineHeight+",";}
 		     if (!textAlign.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" textAlign: '"+textAlign+"' ,";}
 		     if (!textDecorationLine.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" textDecorationLine: '"+textDecorationLine+"' ,";}
 		     if (!textShadowColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" textShadowColor: '"+textShadowColor+"' ,";}
 		     if (!textAlignVertical.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" textAlignVertical: '"+textAlignVertical+"' ,";}
 		     if (!textShadowRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" textShadowRadius: "+textShadowRadius+",";}
 		     if (!fontVariant.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" fontVariant: '"+fontVariant+"' ,";}
 		     if (!letterSpacing.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" letterSpacing: "+letterSpacing+",";}
 	       	 if (!textDecorationColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" textDecorationColor: '"+textDecorationColor+"' ,";}
 	    	 if (!textDecorationStyle.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" textDecorationStyle: '"+textDecorationStyle+"' ,";}
 	    	 if (!writingDirection.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" writingDirection: '"+writingDirection+"',";}

 	    	//On fermme notre StyleSheet
 	    	CodeAajouter=CodeAajouter+" },";
 	    	//on injecte le code
 	    	TraiteurFichier.ListdeslignesJsVue.add(j+1, CodeAajouter);

 	    }
	}
}
//function
public static void InjecterFunRemplirTab(String nomfunction,String Table){
	 for(j=0;j<TraiteurFichier.ListdeslignesJsVue.size();j++){
	        //on recupére la position de la //function
	 	    if(TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase("//function")){
	 	    	 //a chaque input trouvé on lui injecte son affichage on part les chercher de la table 
		 		
	 	    	for(int i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){	
		 			 if((TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase(Table))&&(TraiteurFichier.ListdeslignesModel.get(i-1).equalsIgnoreCase("Table"))){
				f=i+2;
		 while((!TraiteurFichier.ListdeslignesModel.get(f).equalsIgnoreCase("End.")))
	 	    	{String variable=TraiteurFichier.ListdeslignesModel.get(f);
	 	    	TableinputList.add(variable);  f++;}
		 			 }
		 	}
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter=nomfunction+"() { if(";
	 	    	//on ajoute autant de condion que de variable
	 for(int f=0;f<TableinputList.size();f++){
		 CodeAajouter=CodeAajouter+" (this.state."+TableinputList.get(f)+" !== '')";
	     //on prepare le et logique au cas ou il y'aurait un autre input
		 if ((f+1)<TableinputList.size())CodeAajouter=CodeAajouter+" &&";	 
	 }	    			
	 CodeAajouter=CodeAajouter+") { this."+Table+"itemsRef.push({ "; 			
	 for(int f=0;f<TableinputList.size();f++){
		 CodeAajouter=CodeAajouter+" "+TableinputList.get(f)+": this.state."+TableinputList.get(f)+" ,";
	     }		    			
	 CodeAajouter=CodeAajouter+" }); ";	   
	 //on initialise les variables a 0 et la premier function est un cas particulier car elle n'est pas précédé par une ,
	 if (TableinputList.size()!=0)CodeAajouter=CodeAajouter+" this.setState({ "+TableinputList.get(0)+" : '' }) ";
	 for(int f=1;f<TableinputList.size();f++){
		 CodeAajouter=CodeAajouter+", this.setState({ "+TableinputList.get(f)+" : '' })  ";
	     }
	 
	 CodeAajouter=CodeAajouter+" } } ";
	 	   
	 	    			
	 	    	//on injecte le code
		 	    TraiteurFichier.ListdeslignesJsVue.add(j+1, CodeAajouter);
	                                                             }TableinputList=new ArrayList<String>();
	                                           }  

}
public static void InjecterAlertFunction(String nomfunction,String MessageAlert){
	 for(j=0;j<TraiteurFichier.ListdeslignesJsVue.size();j++){
	        //on recupére la position de la //function
	 	    if(TraiteurFichier.ListdeslignesJsVue.get(j).equalsIgnoreCase("//function")){
	 	    	
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter=" "+nomfunction+" = () => { Alert.alert('"+MessageAlert+"'); };";
	 	    	//on injecte le code
		 	    TraiteurFichier.ListdeslignesJsVue.add(j+1, CodeAajouter);
	                                                             }
	                                           }  

}	

}





