package generateur;

public class Injecteur {
	static String CodeAajouter="",typeicon,Styleicon;
	static int i,j;
//Coté vue
public static void InjecterBouton(String nombouton,String onclique,String onlongclique,String icon,String Style,String raisedlarge,String iconright){
	//parcourire le nodejs
	 for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
       //on recupére la position du <View>
	        if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("<View>")){
		 	    //on prépare le code a injecter 	
	        	CodeAajouter="<Button";
	        	if(raisedlarge.equalsIgnoreCase("raised"))CodeAajouter=CodeAajouter+" raised";
	        	else if(raisedlarge.equalsIgnoreCase("large"))CodeAajouter=CodeAajouter+" large";
	        	//on parcours le model pour recuperer les propriété du icon
	        	 for(i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){
	        		 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase(icon)){typeicon=TraiteurFichier.ListdeslignesModel.get(i+2);Styleicon=TraiteurFichier.ListdeslignesModel.get(i+4);}
	        	 }

	        	CodeAajouter=CodeAajouter+ " title='"+nombouton+"' onPress={() => this."+onclique+"()} onLongPress={() => this."+onlongclique+"()} style={ styles."+Style+" } icon={{name: 'squirrel', type: '"+typeicon+"', buttonStyle: styles."+Styleicon+" }}  />";
		 	    //on injecte le code
		 	    TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter); 
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
	 	    if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("<View>")){
	 	    	
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter="<TextInput style={styles."+Style+"} onChangeText={(text) => this.setState({"+nominput+": text})} value={this.state."+nominput+"}/>";
		 	    //on injecte le code
		 	    TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);
	                                                             }
	                                           }  
		
	
}
public static void	InjecterListView(){
	for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
		//on inject la ListView dans la vue
		 if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("<View>")){
			 
			 CodeAajouter="<ScrollView> <ListView dataSource={this.state.todoSource} renderRow={this.renderRow.bind(this)} enableEmptySections={true} /> </ScrollView>";			 
			//on injecte le code
		 	    TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);
		    }
			//on inject la function renderRow
		 if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//function")){
			 CodeAajouter="renderRow(rowData) { return ( <TouchableHighlight onPress={() => this.removeTodo(rowData)}> <View> <View style={styles.row}> <Text style={styles.todoText}>{rowData.text.todo}</Text> </View> <View style={styles.separator} /> </View> </TouchableHighlight> ); }";
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
public static void InjecterStyleSheet(String nomInputStyle,String heigh,String flex,String FlexDirection,String BackGroundColor,String JustifyContent,String borderRadium,String padding,String marginRight,String fontSize,String borderWidth,String borderColor,String borderRadius){
	for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
		 //on recupére la position du //Stylesheet
 	    if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//StyleSheet")){
 	    	//on prépare le code a injecter
 	    	CodeAajouter=nomInputStyle+": {";  
 	       	if (!heigh.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" height: "+heigh+",";}
 	    	 if (!flex.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" flex: "+flex+",";}
 	    	 if (!FlexDirection.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" FlexDirection: '"+FlexDirection+"' ,";}
 	    	 if (!BackGroundColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" BackGroundColor: "+BackGroundColor+",";}
 	    	 if (!JustifyContent.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" JustifyContent: "+JustifyContent+",";}
 	    	 if (!borderRadium.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRadium: "+borderRadium+",";}
 	    	 if (!padding.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" padding: "+padding+",";}
 	 	     if (!marginRight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginRight: "+marginRight+",";}
 	 	     if (!fontSize.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" fontSize: "+fontSize+",";}
 		     if (!borderWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderWidth: "+borderWidth+",";}
 	       	if (!borderColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderColor: '"+borderColor+"' ,";}
 	    	if (!borderRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRadius: "+borderRadius+",";}
 	      
 	    	//On fermme notre StyleSheet
 	    	CodeAajouter=CodeAajouter+" },";
 	    	//on injecte le code
 	    	TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);

 	    }
	}
}
//function
public static void InjecterFunRemplirTab(String nomfunction,String utilise){
	 for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
	        //on recupére la position de la //function
	 	    if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//function")){
	 	    	
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter=nomfunction+"() { if (this.state."+utilise+" !== '') {  this.itemsRef.push({    "+utilise+": this.state."+utilise+"    });  this.setState({ "+utilise+" : ''     }) } }";
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
	 	    	CodeAajouter="const "+nomfunction+" = () => { Alert.alert('"+MessageAlert+"'); };";
	 	    	//on injecte le code
		 	    TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);
	                                                             }
	                                           }  

}	

}





