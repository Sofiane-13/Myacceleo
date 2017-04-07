package generateur;

import java.util.ArrayList;
import java.util.List;

import javax.swing.CellEditor;

public class SqueletteVue {

  static  String Ligne,colonne;
  static  String CodeAinjecter="";
  static	int i,m,n;
static int [][] cellule = new int [100][100];
	public static void PreparerSquelette(){
	RemplirTab();
	for(m=0;m<100;m++){
		if(cellule[m][0]==1){CodeAinjecter=CodeAinjecter+" <Row resource-id=' "+(m+1)+" '>";System.out.println(cellule[m][0]);}
		for(n=0;n<100;n++){
			if(cellule[m][n]==1){CodeAinjecter=CodeAinjecter+" <Col resource-id=' "+(m+1)+" "+(n+1)+" '> </Col> \n"; }
		}
		if(cellule[m][0]==1)CodeAinjecter=CodeAinjecter+"</Row> \n" ;
		}
	for(int j=0;j<TraiteurFichier.ListdeslignesJs.size();j++){
		//on inject la ListView dans la vue
		 if(TraiteurFichier.ListdeslignesJs.get(j).equalsIgnoreCase("<Grid>")){
			 TraiteurFichier.ListdeslignesJs.add(j+1, CodeAinjecter);
		 }}
		
	   System.out.println(CodeAinjecter); 		    
		
		
		
 

}
	
	public static void RemplirTab(){


		for(i=0;i<TraiteurFichier.ListdeslignesModel.size();i++){
			 if(TraiteurFichier.ListdeslignesModel.get(i).equalsIgnoreCase("ligne")){
Ligne = TraiteurFichier.ListdeslignesModel.get(i+1);
colonne = TraiteurFichier.ListdeslignesModel.get(i+3);

int intligne = Integer.parseInt(Ligne);
int intcolonne =  Integer.parseInt(colonne);
for(m=0;m<intligne;m++){
	cellule[m][0] = 1;
}
for(m=0;m<intcolonne;m++){
	cellule[intligne-1][m] =1;
}
System.out.println(Ligne+"-----------------------"+colonne);
			 }
	
	}
		
		for(m=0;m<100;m++){
		//	System.out.print("\n");
			for(n=0;n<100;n++){
			//System.out.print(cellule[m][n]);
			}
			
		}		
		
	}	
	
	}