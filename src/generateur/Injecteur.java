package generateur;

import java.util.ArrayList;
import java.util.List;

public class Injecteur {
	static String CodeAajouter="",typeicon,Styleicon;
	static int i,j,f;
	public static  List<String>	TableinputList=new ArrayList<String>();
//Coté Model------------------------------------------------------------------------------------------------

public static void InjecterTable(String Table){
	for(j=0;j<Controleur.complist.size();j++){
		 if(Controleur.complist.get(j).equalsIgnoreCase("//Constructeur")){
			CodeAajouter= "this."+Table+"itemsRef = getDatabase().ref('"+Main.mabase+"/"+Table+"'); this."+Table+"items=[];";
			Controleur.complist.add(j+1, CodeAajouter);
		}
		 if(Controleur.complist.get(j).equalsIgnoreCase("//Debutdustate")){
				CodeAajouter= Table+"Source: new ListView.DataSource({rowHasChanged: (row1, row2)=>row1 !== row2}),";
				Controleur.complist.add(j+1, CodeAajouter);
			}
		 if(Controleur.complist.get(j).equalsIgnoreCase("//DidMount")){
				CodeAajouter= " this."+Table+"itemsRef.on('child_added',	(dataSnapshot)=>{ this."+Table+"items.push({id: dataSnapshot.key,   text: dataSnapshot.val()}); this.setState({"+Table+"Source:	this.state."+Table+"Source.cloneWithRows(this."+Table+"items)}); });";
				CodeAajouter=CodeAajouter+" this."+Table+"itemsRef.on('child_removed', (dataSnapshot)=>{ this."+Table+"items = this."+Table+"items.filter((x)=>x.id !== dataSnapshot.key); this.setState({ "+Table+"Source: this.state."+Table+"Source.cloneWithRows(this."+Table+"items)});});";
				Controleur.complist.add(j+1, CodeAajouter);
			}
		
	}
}
	
//Coté vue-----------------------------------------------------------------------------
public static void InjecterLabel( String NomLabel, String stylelabel, String contenu,String ligne,String colonne){
	 for(j=0;j<Controleur.complist.size();j++){
		  //on recupére la position du <View>
		 if((Controleur.complist.get(j).equalsIgnoreCase(ligne))&&(Controleur.complist.get(j+1).equalsIgnoreCase(colonne))){
		       
	        
	        	CodeAajouter="<Text";
	        	if(!stylelabel.equalsIgnoreCase("none"))CodeAajouter=CodeAajouter+" style={ styles."+stylelabel+" } ";
	        	CodeAajouter=CodeAajouter+" > "+contenu+"</Text>";
	        	
	        	//on injecte le code
	        	Controleur.complist.add(j+3, CodeAajouter); 
	        }
	 }
}
public static void InjecterBouton(String nombouton,String onclique,String onlongclique,String icon,String Style,String raisedlarge,String iconright,String ligne,String colonne){
	//parcourire le nodejs
	
	 for(j=0;j<Controleur.complist.size();j++){
       //on recupére la position du <View>
		
	        if((Controleur.complist.get(j).equalsIgnoreCase(ligne))&&(Controleur.complist.get(j+1).equalsIgnoreCase(colonne))){
	        	
	        	//on prépare le code a injecter 	
	        	CodeAajouter="<Button";
	        	if(raisedlarge.equalsIgnoreCase("raised"))CodeAajouter=CodeAajouter+" raised";
	        	else if(raisedlarge.equalsIgnoreCase("large"))CodeAajouter=CodeAajouter+" large";
	        	//on parcours le model pour recuperer les propriété du icon
	        	 for(i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){
	        		 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase(icon) && TraiteurFichier.ListdeslignesModel.get(i-1).equalsIgnoreCase("Icone")){typeicon=TraiteurFichier.ListdeslignesModel.get(i+3);Styleicon=TraiteurFichier.ListdeslignesModel.get(i+5);}
	        	 }

	        	CodeAajouter=CodeAajouter+ " title='"+nombouton+"' onPress={() => this."+onclique+"()} onLongPress={() => this."+onlongclique+"()} buttonStyle={ styles."+Style+" } icon={{name: 'squirrel', type: '"+typeicon+"', buttonStyle: styles."+Styleicon+" }}  />";
	        	 
	        	//on injecte le code

	        	Controleur.complist.add(j+3,CodeAajouter); 
	                                                             }
	                                           }
	}

public static void InjecterInput(String nominput,String Style,String ligne,String colonne){
	
	for(j=0;j<Controleur.complist.size();j++){
	        
		//on inject dans le state la variable du label
	    //on recupére la position du Debutdustate
 	    if(Controleur.complist.get(j).equalsIgnoreCase("//Debutdustate")){
 	    	
	 	    //on prépare le code a injecter 	
 	    	CodeAajouter=nominput+": '',";
	 	    //on injecte le code
 	    	Controleur.complist.add(j+1, CodeAajouter);
                                                             }
                
		
		
	    	//on inject dans la vue
		    //on recupére la position du <View>
	 	    if((Controleur.complist.get(j).equalsIgnoreCase(ligne))&&(Controleur.complist.get(j+1).equalsIgnoreCase(colonne))){
	 	    	
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter="<TextInput style={styles."+Style+"} placeholder=\""+nominput+"\" onChangeText={(text) => this.setState({"+nominput+": text})} value={this.state."+nominput+"}/>";
		 	    //on injecte le code		 	    
	 	    	Controleur.complist.add(j+3, CodeAajouter);
	                                                             }
	                                           }  
		
	
}
public static void	InjecterListView(String Stylelistview,String table,String ligne,String colonne){

	for(j=0;j<Controleur.complist.size();j++){
		//on inject la ListView dans la vue
		 if((Controleur.complist.get(j).equalsIgnoreCase(ligne))&&(Controleur.complist.get(j+1).equalsIgnoreCase(colonne))){
			
			 CodeAajouter="<ListView ";
			 if(!Stylelistview.equalsIgnoreCase("End."))CodeAajouter=CodeAajouter+"style={styles."+Stylelistview+"}";
			 CodeAajouter=CodeAajouter+" dataSource={this.state."+table+"Source} renderRow={this.renderRow"+table+".bind(this)} enableEmptySections={true} />";			 
			//on injecte le code
			 Controleur.complist.add(j+3, CodeAajouter);
		    }
			//on inject la function removeRow
		 
		 if(Controleur.complist.get(j).equalsIgnoreCase("//function")){
			 CodeAajouter="remove"+table+"(rowData) {  Alert.alert( ' Bravo ligne supprimée !');   this."+table+"itemsRef.child(rowData.id).remove();   }";
			 Controleur.complist.add(j+1, CodeAajouter);
		 }
			//on inject la function renderRow
		 if(Controleur.complist.get(j).equalsIgnoreCase("//function")){
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
			 Controleur.complist.add(j+1, CodeAajouter);
		 }
		 //les styles du listview

		if(Controleur.complist.get(j).equalsIgnoreCase("//StyleSheet")){
			 CodeAajouter=" row: { flexDirection: 'row', padding: 12, height: 44 }, separator: { height: 1, backgroundColor: '#CCCCCC', },";
			 Controleur.complist.add(j+1, CodeAajouter);
		 }
	}

}
public static void	InjecterAudio(String nom,String Url,String Textbouton,String ligne,String colonne,String StyleA){
	
	for(j=0;j<Controleur.complist.size();j++){
		//on inject la ListView dans la vue
		 if((Controleur.complist.get(j).equalsIgnoreCase(ligne))&&(Controleur.complist.get(j+1).equalsIgnoreCase(colonne))){
			 CodeAajouter="<Button ";
			 if(!StyleA.equals("End."))CodeAajouter=CodeAajouter+"buttonStyle={ styles."+StyleA+" } ";
			 CodeAajouter=CodeAajouter+"title=\""+Textbouton+"\" onPress={this._handlePlaySoundAsync} />";
			 Controleur.complist.add(j+3, CodeAajouter);
		 }
		 
		 if(Controleur.complist.get(j).equalsIgnoreCase("//function")){
			 CodeAajouter="_handlePlaySoundAsync=async=()=>{ await Audio.setIsEnabladeAsync(true); let sound=new Audio.Sound({source: '"+Url+"', }); await sound.loadAsync(); await sound.playAsync();};";
			 Controleur.complist.add(j+1, CodeAajouter);
		 }
		 }
	
}

public static void	InjecterVideo(String mute,String  Url,String height,String width,String ligne,String colonne){
	
	for(j=0;j<Controleur.complist.size();j++){
		//on inject la ListView dans la vue
		 if((Controleur.complist.get(j).equalsIgnoreCase(ligne))&&(Controleur.complist.get(j+1).equalsIgnoreCase(colonne))){
			 CodeAajouter="<Video source={{ uri: '"+Url+"'}} rate={1.0} volume={1.0}";
			 if(mute.equals("true"))CodeAajouter=CodeAajouter+" muted={true}";
			 else CodeAajouter=CodeAajouter+" muted={false}";
			 CodeAajouter=CodeAajouter+" resizeMode=\"cover\" repeat style={{width: "+width+", height: "+height+"}} />";
			 Controleur.complist.add(j+3, CodeAajouter);	 
		 }
		 }
	}

public static void	InjecterImage(String Url,String ligne,String colonne,String Style){
	
	for(j=0;j<Controleur.complist.size();j++){
		//on inject la ListView dans la vue
		 if((Controleur.complist.get(j).equalsIgnoreCase(ligne))&&(Controleur.complist.get(j+1).equalsIgnoreCase(colonne))){
			 CodeAajouter="<Image source={{ uri: '"+Url+"' }} ";
			 if(!Style.equals("End."))CodeAajouter=CodeAajouter+"style={ styles."+Style+" } ";
			 CodeAajouter=CodeAajouter+" />";
			 Controleur.complist.add(j+3, CodeAajouter);
		 }
		 }
	}
public static void	InjecterMap(String latitude,String longitude,String latitudeDelta,String longitudeDelta,String ligne,String colonne){
	
	for(j=0;j<Controleur.complist.size();j++){
		//on inject la ListView dans la vue
		 if((Controleur.complist.get(j).equalsIgnoreCase(ligne))&&(Controleur.complist.get(j+1).equalsIgnoreCase(colonne))){
			 CodeAajouter="<MapView style={{ alignSelf: 'stretch', height: 200 }} region={this.state.mapRegion} onRegionChange={this._handleMapRegionChange} />";
			
			 Controleur.complist.add(j+3, CodeAajouter);
		 }
		 if(Controleur.complist.get(j).equalsIgnoreCase("//function")){
			 CodeAajouter="_handleMapRegionChange=mapRegion=>{this.setState({ mapRegion });};";
			 Controleur.complist.add(j+1, CodeAajouter);
		 }
		 if(Controleur.complist.get(j).equalsIgnoreCase("//Debutdustate")){
			 CodeAajouter="mapRegion: { latitude: "+latitude+", longitude: "+longitude+", latitudeDelta: "+latitudeDelta+", longitudeDelta: "+longitudeDelta+" }";
			 Controleur.complist.add(j+1, CodeAajouter);
		 }
		 
		
		 }
	}

public static void InjecterStyleText(String nomInputStyle,String color,String fontFamily,String fontSize,String fontStyle,String fontWeight,String lineHeight,String TextAlign,String backfaceVisibility,String backgroundColor,String borderBottomColor,String borderBottomLeftRadius,String borderBottomRightRadius,String borderBottomWidth,String borderColor,String borderLeftColor,String borderLeftWidth,String borderRadius,String borderRightColor,String borderRightWidth,String borderStyle,String borderTopColor,String borderTopLeftRadius,String borderTopRightRadius,String borderTopWidth,String borderWidth,String opacity){
	for(j=0;j<Controleur.complist.size();j++){
		 //on recupére la position du //Stylesheet
	    if(Controleur.complist.get(j).equalsIgnoreCase("//StyleSheet")){
	    	//on prépare le code a injecter
	    	CodeAajouter=nomInputStyle+": {";  
	    
	    	 if (!color.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" color: '"+color+"' ,";}
 	    	 if (!fontFamily.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" fontFamily: '"+fontFamily+"',";}
 	 	     if (!fontSize.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" fontSize: "+fontSize+",";}
 	 	     if (!fontStyle.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" fontStyle: '"+fontStyle+"',";}
 		     if (!fontWeight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" fontWeight: '"+fontWeight+"',";}
 		     if (!lineHeight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" lineHeight: "+lineHeight+",";}
 		     if (!TextAlign.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" textAlign: '"+TextAlign+"',";}
 		    if (!backfaceVisibility.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" backfaceVisibility: '"+backfaceVisibility+"',";}
 		     if (!backgroundColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" backgroundColor: '"+backgroundColor+"' ,";}
 		     if (!borderBottomColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomColor: '"+borderBottomColor+"',";}
 		     if (!borderBottomLeftRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomLeftRadius: "+borderBottomLeftRadius+",";}
 		     if (!borderBottomRightRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomRightRadius: "+borderBottomRightRadius+",";}
 		     if (!borderBottomWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomWidth: "+borderBottomWidth+",";}
 		     if (!borderColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderColor: '"+borderColor+"',";}
 		     if (!borderLeftColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderLeftColor: '"+borderLeftColor+"',";}
 		     if (!borderLeftWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderLeftWidth: "+borderLeftWidth+",";}
 		     if (!borderRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRadius: "+borderRadius+",";}
 		     if (!borderRightColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRightColor: '"+borderRightColor+"',";}
 		     if (!borderRightWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRightWidth: "+borderRightWidth+" ,";}
 		     if (!borderTopColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopColor: '"+borderTopColor+"' ,";}
 		     if (!borderTopLeftRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopLeftRadius: "+borderTopLeftRadius+" ,";}
 		     if (!borderTopRightRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopRightRadius: "+borderTopRightRadius+" ,";}
 		     if (!borderTopWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopWidth: "+borderTopWidth+" ,";}
 		     if (!borderWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderWidth: "+borderWidth+" ,";}
 		     if (!opacity.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" opacity: "+opacity+" ,";}
 			
	    	
	    	//On fermme notre StyleSheet
 	    	CodeAajouter=CodeAajouter+" },";
 	    	//on injecte le code
 	    	Controleur.complist.add(j+1, CodeAajouter);
	    }
	    }
}
public static void InjecterStyleImage(String nomInputStyle,String backfaceVisibility,String backgroundColor,String borderBottomLeftRadius,String borderBottomRightRadius,String borderColor,String borderRadius,String borderTopLeftRadius,String borderTopRightRadius,String borderWidth,String opacity,String overflow,String alignItems,String alignSelf,String bottom,String flex,String justifyContent,String left,String margin,String marginBottom,String marginLeft,String marginRight,String marginTop,String marginVertical,String padding,String paddingBottom,String paddingHorizontal,String paddingRight,String paddingTop,String paddingVertical,String right,String width,String flexDirection,String flexWrap,String height){
	for(j=0;j<Controleur.complist.size();j++){
		 //on recupére la position du //Stylesheet
	    if(Controleur.complist.get(j).equalsIgnoreCase("//StyleSheet")){
	    	//on prépare le code a injecter
	    	CodeAajouter=nomInputStyle+": {";  
	    	
	    	 if (!backfaceVisibility.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" backfaceVisibility: '"+backfaceVisibility+"' ,";}
 	    	 if (!backgroundColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" backgroundColor: '"+backgroundColor+"',";}
 	 	     if (!borderBottomLeftRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomLeftRadius: "+borderBottomLeftRadius+",";}
 	 	     if (!borderBottomRightRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomRightRadius: "+borderBottomRightRadius+",";}
 		     if (!borderColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderColor: '"+borderColor+"',";}
 		     if (!borderRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRadius: "+borderRadius+",";}
 		     if (!borderTopLeftRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopLeftRadius: "+borderTopLeftRadius+",";}
 		     if (!borderTopRightRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopRightRadius: "+borderTopRightRadius+",";}
 		     if (!borderWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderWidth: "+borderWidth+",";}
 		     if (!opacity.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" opacity: "+opacity+" ,";}
 		     if (!overflow.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" overflow: '"+overflow+"',";}
 		     if (!alignItems.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" alignItems: '"+alignItems+"' ,";}
 		     if (!alignSelf.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" alignSelf: '"+alignSelf+"',";}
 		     if (!bottom.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" bottom: "+bottom+",";}
 		     if (!flex.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" flex: "+flex+",";}
 		     if (!flexDirection.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" flexDirection: '"+flexDirection+"',";}
 		     if (!flexWrap.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" flexWrap: '"+flexWrap+"',";}
 		     if (!height.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" height: "+height+",";}
 		     if (!justifyContent.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" justifyContent: '"+justifyContent+"',";}
 		     if (!left.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" left: "+left+",";}
 		     if (!margin.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" margin: "+margin+",";}
 		     if (!marginBottom.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginBottom: "+marginBottom+" ,";}
 		     if (!marginLeft.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginLeft: "+marginLeft+" ,";}
 		     if (!marginRight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginRight: "+marginRight+",";}
 		     if (!marginTop.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginTop: "+marginTop+",";}
 		     if (!marginVertical.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginVertical: "+marginVertical+",";}
 		     if (!padding.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" padding: "+padding+",";}
 		     if (!paddingBottom.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingBottom: "+paddingBottom+" ,";}
 		     if (!paddingHorizontal.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingHorizontal: "+paddingHorizontal+" ,";}
 		     if (!paddingRight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingRight: "+paddingRight+" ,";}
 		     if (!paddingTop.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingTop: "+paddingTop+",";}
 		     if (!paddingVertical.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingVertical: "+paddingVertical+" ,";}
 		     if (!right.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" right: "+right+" ,";}
 		     if (!width.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" width: "+width+" ,";}
 		     
	    	
	    	//On fermme notre StyleSheet
 	    	CodeAajouter=CodeAajouter+" },";
 	    	//on injecte le code
 	    	Controleur.complist.add(j+1, CodeAajouter);

 	    }
	    }
}
//coté StyleSheet--------------------------------------------------------------------
 
public static void InjecterStyleView(String nomInputStyle,String backfaceVisibility,String backgroundColor,String borderBottomColor,String borderBottomLeftRadius,String borderBottomRightRadius,String borderBottomWidth,String borderColor,String borderLeftColor,String borderLeftWidth,String borderRadius,String borderRightColor,String borderRightWidth,String borderStyle,String borderTopColor,String borderTopLeftRadius,String borderTopRightRadius,String borderTopWidth,String borderWidth,String opacity,String alignItems,String alignSelf,String bottom,String flex,String flexDirection,String flexWrap,String height,String justifyContent,String left,String margin,String marginBottom,String marginLeft,String marginRight,String marginTop,String marginVertical,String padding,String paddingBottom,String paddingHorizontal,String paddingRight,String paddingTop,String paddingVertical,String right,String width){
	for(j=0;j<Controleur.complist.size();j++){
		 //on recupére la position du //Stylesheet
 	    if(Controleur.complist.get(j).equalsIgnoreCase("//StyleSheet")){
 	    	//on prépare le code a injecter
 	    	CodeAajouter=nomInputStyle+": {";  
 	        if (!backfaceVisibility.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" backfaceVisibility: '"+backfaceVisibility+"' ,";}
 	    	 if (!backgroundColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" backgroundColor: '"+backgroundColor+"',";}
 	 	     if (!borderBottomColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomColor: '"+borderBottomColor+"',";}
 	 	     if (!borderBottomLeftRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomLeftRadius: "+borderBottomLeftRadius+",";}
 		     if (!borderBottomRightRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomRightRadius: "+borderBottomRightRadius+",";}
 		     if (!borderBottomWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderBottomWidth: "+borderBottomWidth+",";}
 		     if (!borderColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderColor: '"+borderColor+"',";}
 		     if (!borderLeftColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderLeftColor: '"+borderLeftColor+"',";}
 		     if (!borderLeftWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderLeftWidth: "+borderLeftWidth+",";}
 		     if (!borderRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRadius: "+borderRadius+" ,";}
 		     if (!borderRightColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRightColor: '"+borderRightColor+"',";}
 		     if (!borderRightWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRightWidth: "+borderRightWidth+" ,";}
 		     if (!borderStyle.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderStyle: '"+borderStyle+"',";}
 		     if (!borderTopColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopColor: '"+borderTopColor+"',";}
 		     if (!borderTopLeftRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopLeftRadius: "+borderTopLeftRadius+",";}
 		     if (!borderTopRightRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopRightRadius: "+borderTopRightRadius+",";}
 		     if (!borderTopWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopWidth: "+borderTopWidth+",";}
 		     if (!borderWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderWidth: "+borderWidth+",";}
 		     if (!opacity.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" opacity: "+opacity+",";}
 		     if (!alignItems.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" alignItems: '"+alignItems+"',";}
 		     if (!alignSelf.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" alignSelf: '"+alignSelf+"',";}
 		     if (!bottom.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" bottom: "+bottom+",";}
 		     if (!flex.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" flex: "+flex+",";}
 		     if (!flexDirection.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" flexDirection: '"+flexDirection+"',";}
 		     if (!flexWrap.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" flexWrap: '"+flexWrap+"',";}
 		     if (!height.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" height: "+height+",";}
 		     if (!justifyContent.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" justifyContent: '"+justifyContent+"',";}
 		     if (!left.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" left: "+left+",";}
 		     if (!margin.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" margin: "+margin+",";}
 		     if (!marginBottom.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginBottom: "+marginBottom+" ,";}
 		     if (!marginLeft.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginLeft: "+marginLeft+" ,";}
 		     if (!marginRight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginRight: "+marginRight+",";}
 		     if (!marginTop.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginTop: "+marginTop+",";}
 		     if (!marginVertical.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginVertical: "+marginVertical+",";}
 		     if (!padding.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" padding: "+padding+",";}
 		     if (!paddingBottom.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingBottom: "+paddingBottom+" ,";}
 		     if (!paddingHorizontal.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingHorizontal: "+paddingHorizontal+" ,";}
 		     if (!paddingRight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingRight: "+paddingRight+" ,";}
 		     if (!paddingTop.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingTop: "+paddingTop+",";}
 		     if (!paddingVertical.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" paddingVertical: "+paddingVertical+" ,";}
 		     if (!right.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRightWidth: "+right+",";}
 		     if (!width.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderTopColor: "+width+" ,";}
 		     
 	    	//On ferme notre StyleSheet
 	    	CodeAajouter=CodeAajouter+" },";
 	    	//on injecte le code
 	    	Controleur.complist.add(j+1, CodeAajouter);
 	    	

 	    }
	}
	
}

//function-------------------------------------------------------------------------
public static void InjecterFunRemplirTab(String nomfunction,String Table){
	 for(j=0;j<Controleur.complist.size();j++){
	        //on recupére la position de la //function
	 	    if(Controleur.complist.get(j).equalsIgnoreCase("//function")){
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
	 	    	CodeAajouter=nomfunction+"= () => { if(";
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
	 Controleur.complist.add(j+1, CodeAajouter);
	                                                             }TableinputList=new ArrayList<String>();
	                                           }  

}
public static void InjecterAlertFunction(String nomfunction,String MessageAlert){
	 for(j=0;j<Controleur.complist.size();j++){
	        //on recupére la position de la //function
	 	    if(Controleur.complist.get(j).equalsIgnoreCase("//function")){
	 	    	
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter=" "+nomfunction+" = () => { Alert.alert('"+MessageAlert+"'); };";
	 	    	//on injecte le code
	 	    	Controleur.complist.add(j+1, CodeAajouter);
	                                                             }
	                                           }  

}	


public static void InjecterNavigation(String nomfunction,String nomlayout){
	 for(j=0;j<Controleur.complist.size();j++){
	        //on recupére la position de la //function
	 	    if(Controleur.complist.get(j).equalsIgnoreCase("//function")){
	 	    	
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter=nomfunction+" = () => Actions."+nomlayout+"();";
	 	    	//on injecte le code
	 	    	Controleur.complist.add(j+1, CodeAajouter);
	                                                             }
	                                           }  

}

}





