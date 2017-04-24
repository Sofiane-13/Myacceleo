
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
this.lestachesitemsRef = getDatabase().ref('vbn151eo6orr4897feb85k4pvt/lestaches'); this.lestachesitems=[];
this.state
=
{
//Debutdustate
lestachesSource: new ListView.DataSource({rowHasChanged: (row1, row2)=>row1 !== row2}),
Input2: '',
Input1: '',
}
}
componentDidMount()
{
//DidMount
 this.lestachesitemsRef.on('child_added',	(dataSnapshot)=>{ this.lestachesitems.push({id: dataSnapshot.key,   text: dataSnapshot.val()}); this.setState({lestachesSource:	this.state.lestachesSource.cloneWithRows(this.lestachesitems)}); }); this.lestachesitemsRef.on('child_removed', (dataSnapshot)=>{ this.lestachesitems = this.lestachesitems.filter((x)=>x.id !== dataSnapshot.key); this.setState({ lestachesSource: this.state.lestachesSource.cloneWithRows(this.lestachesitems)});});
}
//function
l5 = () => Actions.Layout5();
l4 = () => Actions.Layout4();
l3 = () => Actions.Layout3();
l2 = () => Actions.Layout2();
l1 = () => Actions.Layout1();
 Sauthentifier = () => { Alert.alert('authentification'); };
 AlerteTwit = () => { Alert.alert('Linkdin'); };
 Map = () => { Alert.alert('Map'); };
 Accessoires = () => { Alert.alert('Accessoire'); };
 Retour = () => { Alert.alert('Retour'); };
retour = () => Actions.Layout2();
 TodoList = () => { Alert.alert('Alerte22'); };
 AlerteTable = () => { Alert.alert('AttendezSVP'); };
VERSER= () => { if( (this.state.Input2 !== '') && (this.state.Input1 !== '')) { this.lestachesitemsRef.push({  Input2: this.state.Input2 , Input1: this.state.Input1 , });  this.setState({ Input2 : '' }) , this.setState({ Input1 : '' })   } } 
TODO = () => Actions.Layout2();
renderRowlestaches(rowData) { return ( <TouchableHighlight onPress={() => this.removelestaches(rowData)}><View ><Text >Input2 : {rowData.text.Input2}</Text><Text >Input1 : {rowData.text.Input1}</Text></View></TouchableHighlight>  ); }
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


<Col
resource-id='
1
2
'>
<TextInput style={styles.Dtext} placeholder="Input1" onChangeText={(text) => this.setState({Input1: text})} value={this.state.Input1}/>
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


<Col
resource-id='
2
2
'>
<TextInput style={styles.Dtext} placeholder="Input2" onChangeText={(text) => this.setState({Input2: text})} value={this.state.Input2}/>
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
</Col>

</Row>


<Row
resource-id='
4
'>
<Col
resource-id='
4
1
'>
<Button title='RetourLayout2' onPress={() => this.l2()} onLongPress={() => this.Retour()} buttonStyle={ styles.View } icon={{name: 'squirrel', type: 'octicon', buttonStyle: styles.View }}  />
</Col>


<Col
resource-id='
4
2
'>
<Button raised title='AddTache' onPress={() => this.VERSER()} onLongPress={() => this.AlerteTable()} buttonStyle={ styles.View } icon={{name: 'squirrel', type: 'octicon', buttonStyle: styles.View }}  />
</Col>

</Row>


<Row
resource-id='
5
'>
<Col
resource-id='
5
1
'>
<ListView dataSource={this.state.lestachesSource} renderRow={this.renderRowlestaches.bind(this)} enableEmptySections={true} />
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
