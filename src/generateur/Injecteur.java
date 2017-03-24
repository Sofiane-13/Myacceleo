package generateur;

public class Injecteur {
	static String CodeAajouter="";
	static int i,j;
public static void InjecterBouton(String nombouton,String utilise){
	//parcourire le nodejs
	 for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
       //on recupére la position du <View>
	        if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("<View>")){
		 	    //on prépare le code a injecter 	
		    	CodeAajouter= "<Button title='"+nombouton+"' onPress={() => this."+utilise+"()}/>";
		 	    //on injecte le code
		 	    TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter); 
	                                                             }
	                                           }
	}
public static void InjecterFunRemplirTab(String nomfunction,String utilise){
	 for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
	        //on recupére la position du <View>
	 	    if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//function")){
	 	    	
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter=nomfunction+"() { if (this.state."+utilise+" !== '') {  this.itemsRef.push({    "+utilise+": this.state."+utilise+"    });  this.setState({ "+utilise+" : ''     }) } }";
		 	    //on injecte le code
		 	    TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);
	                                                             }
	                                           }  

}
public static void InjecterLabel(String nomlabel){
	for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
	        
		//on inject dans le state la variable du label
	    //on recupére la position du Debutdustate
 	    if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//Debutdustate")){
 	    	
	 	    //on prépare le code a injecter 	
 	    	CodeAajouter=nomlabel+": '',";
	 	    //on injecte le code
	 	    TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);
                                                             }
                
		
		
	    	//on inject dans la vue
		    //on recupére la position du <View>
	 	    if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("<View>")){
	 	    	
		 	    //on prépare le code a injecter 	
	 	    	CodeAajouter="<TextInput onChangeText={(text) => this.setState({"+nomlabel+": text})} value={this.state."+nomlabel+"}/>";
		 	    //on injecte le code
		 	    TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);
	                                                             }
	                                           }  
		
	
}
public static void InjecterInputStyle(String nomInputStyle,String heigh,String padding,String marginRight,String flex,String fontSize,String borderWidth,String borderColor,String borderRadius){
	for(j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
		 //on recupére la position du //S
 	    if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("//StyleSheet")){
 	    	//on prépare le code a injecter
 	    	CodeAajouter=nomInputStyle+": {";
 	    	if (!heigh.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" height:"+heigh+",";}
 	        if (!padding.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" padding:"+padding+",";}
 	        if (!marginRight.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" marginRight:"+marginRight+",";}
 	        if (!flex.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" flex:"+flex+",";}
	        if (!fontSize.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" fontSize:"+fontSize+",";}
	        if (!borderWidth.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderWidth:"+borderWidth+",";}
	    	if (!borderColor.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderColor: '"+borderColor+"' ,";}
	    	if (!borderRadius.equalsIgnoreCase("none")){CodeAajouter=CodeAajouter+" borderRadius:"+borderRadius+",";}
 	    	//On fermme notre StyleSheet
 	    	CodeAajouter=CodeAajouter+" },";
 	    	//on injecte le code
 	    	TraiteurFichier.ListdeslignesJs.add(j+1, CodeAajouter);

 	    }
	}
	
}
}













