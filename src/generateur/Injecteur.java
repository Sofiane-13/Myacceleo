package generateur;

import java.util.List;

public class Injecteur {
	static String CodeAajouter="",typeicon,Styleicon;
	static int i,j;
//Coté vue
public static void InjecterBouton(String nombouton,String onclique,String onlongclique,String icon,String Style,String raisedlarge,String iconright){
	//parcourire le nodejs
	 for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
       //on recupére la position du <View>
	        if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//Vue")){
		 	    //on prépare le code a injecter 	
	        	CodeAajouter="<Button";
	        	if(raisedlarge.equalsIgnoreCase("raised"))CodeAajouter=CodeAajouter+" raised";
	        	else if(raisedlarge.equalsIgnoreCase("large"))CodeAajouter=CodeAajouter+" large";
	        	//on parcours le model pour recuperer les propriété du icon
	        	 for(i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){
	        		 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase(icon)){typeicon=TraiteurFichier.ListdeslignesModel.get(i+2);Styleicon=TraiteurFichier.ListdeslignesModel.get(i+4);}
	        	 }

	        	CodeAajouter=CodeAajouter+ " title='"+nombouton+"' onPress={() => this."+onclique+"()} onLongPress={() => this."+onlongclique+"()} buttonStyle={ styles."+Style+" } icon={{name: 'squirrel', type: '"+typeicon+"', buttonStyle: styles."+Styleicon+" }}  />";
		 	    //on injecte le code
		 	    TraiteurFichier.ListdeslignesJs.add(j+3, CodeAajouter); 
	                                                             }
	                                           }
	}

public static void InjecterInput(String nominput,String Style){
	for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
	        
		//on inject dans le state la variable du label
	    //on recupére la position du Debutdustate
 	    if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//Debutdustate")){
 	    	
	 	    //on prépare le code a injecter 	
 	    	CodeAajouter=nominput+": '',";
	 	    //on injecte le code
	 	    TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);
                                                             }
                
		
		
	    	//on inject dans la vue
		    //on recupére la position du <View>
	 	    if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//Vue")){
	 	    	
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter="<TextInput style={styles."+Style+"} placeholder=\""+nominput+"\" onChangeText={(text) => this.setState({"+nominput+": text})} value={this.state."+nominput+"}/>";
		 	    //on injecte le code		 	    
	 	    	TraiteurFichier.ListdeslignesJs.add(j+3, CodeAajouter);
	                                                             }
	                                           }  
		
	
}
public static void	InjecterListView(List<String> ListViewinputList){
	for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
		//on inject la ListView dans la vue
		 if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//Vue")){
			 
			 CodeAajouter="<ListView dataSource={this.state.todoSource} renderRow={this.renderRow.bind(this)} enableEmptySections={true} />";			 
			//on injecte le code
		 	    TraiteurFichier.ListdeslignesJs.add(j+3, CodeAajouter);
		    }
			//on inject la function removeRow
		 if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//function")){
			 CodeAajouter="removeTodo(rowData) {  Alert.alert( ' Bravo ligne supprimée !');   this.itemsRef.child(rowData.id).remove();   }";
			 	TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);
		 }
			//on inject la function renderRow
		 if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//function")){
			 //on ouvre le renderRow
			 
			 CodeAajouter="renderRow(rowData) { return ( <TouchableHighlight onPress={() => this.removeTodo(rowData)}><View >";
			 	for(int f=0;f<ListViewinputList.size();f++){
			 //a chaque input trouvé on lui injecte son affichage
			 		CodeAajouter=CodeAajouter+"<Text >"+ListViewinputList.get(f)+" : {rowData.text."+ListViewinputList.get(f)+"}</Text>";
			 	}
			//on referme le renderRow
			 CodeAajouter=CodeAajouter+"</View></TouchableHighlight>  ); }";
			 TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);
		 }
		 //A revoire on laisse juste celui du separateur et celui du row doit etre donné par l'utilisateur

		if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//StyleSheet")){
			 CodeAajouter=" row: { flexDirection: 'row', padding: 12, height: 44 }, separator: { height: 1, backgroundColor: '#CCCCCC', },";
			 TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);
		 }
	}

}
//coté StyleSheet
public static void InjecterStyleSheet(String nomInputStyle,String right,String width,String maxheigh,String maxWidth,String minHeight,String minWidth,String left,String Flex,String flexWrap,String JustifyContent,String BorderRadium,String position,String padding,String paddingBottom,String paddingHorizontal,String paddingLeft,String paddingRight,String paddingTop,String paddingVertical,String opacity,String bottom,String margin,String marginBottom,String marginHorizontal,String marginLeft,String marginTop,String marginVertical,String marginRight,String fontSize,String fontStyle,String fontWeight,String borderStyle,String borderBottomLeftRadius,String borderBottomRightRadius,String borderBottomWidth,String borderWidth,String borderColor,String borderLeftColor,String borderLeftWidth,String borderRadius,String borderRightColor,String borderRightWidth,String borderTopColor,String borderTopLeftRadius,String borderTopRightRadius,String borderTopWidth,String backfaceVisibility,String BackGroundColor,String lineHeight,String textAlign,String textDecorationLine,String textShadowColor,String textAlignVertical,String textShadowRadius,String fontVariant,String letterSpacing,String textDecorationColor, String textDecorationStyle,String writingDirection){
	for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
		 //on recupére la position du //Stylesheet
 	    if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//StyleSheet")){
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
 	    	TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);

 	    }
	}
}
//function
public static void InjecterFunRemplirTab(String nomfunction,List<String> TableinputList){
	 for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
	        //on recupére la position de la //function
	 	    if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//function")){
	 	    	
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter=nomfunction+"() { if(";
	 	    	//on ajoute autant de condion que de variable
	 for(int f=0;f<TableinputList.size();f++){
		 CodeAajouter=CodeAajouter+" (this.state."+TableinputList.get(f)+" !== '')";
	     //on prepare le et logique au cas ou il y'aurait un autre input
		 if ((f+1)<TableinputList.size())CodeAajouter=CodeAajouter+" &&";	 
	 }	    			
	 CodeAajouter=CodeAajouter+") { this.itemsRef.push({ "; 			
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
		 	    TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);
	                                                             }
	                                           }  

}
public static void InjecterAlertFunction(String nomfunction,String MessageAlert){
	 for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
	        //on recupére la position de la //function
	 	    if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//function")){
	 	    	
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter=" "+nomfunction+" = () => { Alert.alert('"+MessageAlert+"'); };";
	 	    	//on injecte le code
		 	    TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);
	                                                             }
	                                           }  

}	

}





