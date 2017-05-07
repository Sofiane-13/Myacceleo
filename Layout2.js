
import
React,
{
Component
}
from
'react'
import
{AppRegistry,ScrollView,StyleSheet,Text,Alert,View,TouchableHighlight,TextInput,ListView}
from
'react-native';
import
{
Button,Grid,Col,Row
}
from
'react-native-elements'

import
{
Actions
}
from
'react-native-router-flux';
import
{
getDatabase
}
from
'./index.android.js';
export
default
class
Layout2
extends
Component
{
constructor(props)
{
super(props);
//Constructeur
this.lestachesitemsRef = getDatabase().ref('lrcimtbhsdtmasajr2vbohj3mk/lestaches'); this.lestachesitems=[];
this.state
=
{
//Debutdustate
lestachesSource: new ListView.DataSource({rowHasChanged: (row1, row2)=>row1 !== row2}),
}
}
componentDidMount()
{
//DidMount
 this.lestachesitemsRef.on('child_added',	(dataSnapshot)=>{ this.lestachesitems.push({id: dataSnapshot.key,   text: dataSnapshot.val()}); this.setState({lestachesSource:	this.state.lestachesSource.cloneWithRows(this.lestachesitems)}); }); this.lestachesitemsRef.on('child_removed', (dataSnapshot)=>{ this.lestachesitems = this.lestachesitems.filter((x)=>x.id !== dataSnapshot.key); this.setState({ lestachesSource: this.state.lestachesSource.cloneWithRows(this.lestachesitems)});});
}
//function
l2 = () => Actions.Layout2();
l1 = () => Actions.Layout1();
 Sauthentifier = () => { Alert.alert('authentification'); };
 AlerteTwit = () => { Alert.alert('Linkdin'); };
 Map = () => { Alert.alert('Map'); };
 Accessoires = () => { Alert.alert('Accessoire'); };
 Retour = () => { Alert.alert('Retour'); };
retour = () => Actions.Layout2();
 infol2 = () => { Alert.alert('pour_aller_au_layout2'); };
 infoajout = () => { Alert.alert('Pour_ajouter_un_client'); };
ajouter= () => { if( (this.state.Nom !== '') && (this.state.Prenom !== '')) { this.lestachesitemsRef.push({  Nom: this.state.Nom , Prenom: this.state.Prenom , });  this.setState({ Nom : '' }) , this.setState({ Prenom : '' })   } } 
verl2 = () => Actions.Layout2();
renderRowlestaches(rowData) { return ( <TouchableHighlight onPress={() => this.removelestaches(rowData)}><View ><Text >Nom : {rowData.text.Nom}</Text><Text >Prenom : {rowData.text.Prenom}</Text></View></TouchableHighlight>  ); }
removelestaches(rowData) {  Alert.alert( ' Bravo ligne supprimée !');   this.lestachesitemsRef.child(rowData.id).remove();   }
render()
{
//Vue
return(

<View
style={{marginTop:
50,
}}>
<ScrollView>

<Row
resource-id='
1
'>
<Col
resource-id='
1
1
'>
</Col>

</Row>


<Row
resource-id='
2
'>
<Col
resource-id='
2
1
'>
</Col>

</Row>


<Row
resource-id='
3
'>
<Col
resource-id='
3
1
'>
<ListView style={styles.View} dataSource={this.state.lestachesSource} renderRow={this.renderRowlestaches.bind(this)} enableEmptySections={true} />
</Col>

</Row>



</ScrollView>
</View>
);
}
}
var
styles
=
StyleSheet.create({
//StyleSheet
Dtext: { color: 'green' , fontFamily: 'h1', fontStyle: 'normal', fontWeight: 'normal', textAlign: 'auto', },
Imge: { borderColor: 'green', flexWrap: 'wrap', },
View: { backgroundColor: 'red', borderBottomColor: 'red', flexWrap: 'wrap', },
 row: { flexDirection: 'row', padding: 12, height: 44 }, separator: { height: 1, backgroundColor: '#CCCCCC', },
});
AppRegistry.registerComponent(
'Layout2'
,()=>
Layout2
);
