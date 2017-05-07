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
		CodeAinjecter="";
	for(m=0;m<100;m++){
		if(Controleur.celluleVue[m][0]==1){CodeAinjecter=CodeAinjecter+" <Row resource-id=' "+(m+1)+" '>";}
		for(n=0;n<100;n++){
			if(Controleur.celluleVue[m][n]==1){CodeAinjecter=CodeAinjecter+" <Col resource-id=' "+(m+1)+" "+(n+1)+" '> </Col> \n"; }
		}
		if(Controleur.celluleVue[m][0]==1)CodeAinjecter=CodeAinjecter+"</Row> \n" ;
		}
	for(int j=0;j<Controleur.complist.size();j++){
		//on inject la ListView dans la vue
		 if(Controleur.complist.get(j).equalsIgnoreCase("<ScrollView>")){
			 Controleur.complist.add(j+1, CodeAinjecter);
		 }}
	
}
	public static void RemplirCellue(String ligne,String colonne){
		int intligne = Integer.parseInt(ligne);
		int intcolonne =  Integer.parseInt(colonne);
		for(m=0;m<intligne;m++){
			Controleur.celluleVue[m][0] = 1;
		}
		for(m=0;m<intcolonne;m++){
			Controleur.celluleVue[intligne-1][m] =1;
		}
		
	}

	}