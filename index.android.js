

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
var
Firebase
=
require('firebase');
var
config
=
{
//ConfigurationDATABASE
apiKey: "AIzaSyDysc3BPHCAGkHJ4K61zwXhZb07M5rnCQE" , authDomain:  "pfedsl-68809.firebaseapp.com" , databaseURL: "https://pfedsl-68809.firebaseio.com/" ,
};
const
myFirebaseRefapp
=

firebase.initializeApp(config);
import
*
as
firebase
from
"firebase";
export
default
class
pfe
extends
Component
{
constructor(props)
{
super(props);
//Constructeur
this.tacheitemsRef = myFirebaseRefapp.database().ref('tache'); this.tacheitems=[];
this.clientitemsRef = myFirebaseRefapp.database().ref('client'); this.clientitems=[];
this.itemsRef
=
myFirebaseRefapp.database().ref('item');
this.state
=
{
//Debutdustate
Input2: '',
Input1: '',
tacheSource: new ListView.DataSource({rowHasChanged: (row1, row2)=>row1 !== row2}),
clientSource: new ListView.DataSource({rowHasChanged: (row1, row2)=>row1 !== row2}),
todoSource:
new
ListView.DataSource({rowHasChanged:
(row1,
row2)=>row1
!==
row2})
}
this.items
=
[];
}
componentDidMount()
{
//DidMount
 this.tacheitemsRef.on('child_added',	(dataSnapshot)=>{ this.tacheitems.push({id: dataSnapshot.key,   text: dataSnapshot.val()}); this.setState({tacheSource:	this.state.tacheSource.cloneWithRows(this.tacheitems)}); }); this.tacheitemsRef.on('child_removed', (dataSnapshot)=>{ this.tacheitems = this.tacheitems.filter((x)=>x.id !== dataSnapshot.key); this.setState({ tacheSource: this.state.tacheSource.cloneWithRows(this.tacheitems)});});
 this.clientitemsRef.on('child_added',	(dataSnapshot)=>{ this.clientitems.push({id: dataSnapshot.key,   text: dataSnapshot.val()}); this.setState({clientSource:	this.state.clientSource.cloneWithRows(this.clientitems)}); }); this.clientitemsRef.on('child_removed', (dataSnapshot)=>{ this.clientitems = this.clientitems.filter((x)=>x.id !== dataSnapshot.key); this.setState({ clientSource: this.state.clientSource.cloneWithRows(this.clientitems)});});
this.itemsRef.on('child_added',
(dataSnapshot)=>{
this.items.push({id:
dataSnapshot.key,
text:
dataSnapshot.val()});
this.setState({todoSource:
this.state.todoSource.cloneWithRows(this.items)});
});
this.itemsRef.on('child_removed',
(dataSnapshot)=>{
this.items
=
this.items.filter((x)=>x.id
!==
dataSnapshot.key);
this.setState({
todoSource:
this.state.todoSource.cloneWithRows(this.items)});
});
}
//function
ReplirTabletache() { if( (this.state.Input1 !== '') && (this.state.Input2 !== '')) { this.tacheitemsRef.push({  Input1: this.state.Input1 , Input2: this.state.Input2 , });  this.setState({ Input1 : '' }) , this.setState({ Input2 : '' })   } } 
ReplirTable() { if( (this.state.Input1 !== '') && (this.state.Input2 !== '')) { this.clientitemsRef.push({  Input1: this.state.Input1 , Input2: this.state.Input2 , });  this.setState({ Input1 : '' }) , this.setState({ Input2 : '' })   } } 
 alrte2 = () => { Alert.alert('alerte2'); };
renderRowtache(rowData) { return ( <TouchableHighlight onPress={() => this.removetache(rowData)}><View ><Text >Input1 : {rowData.text.Input1}</Text><Text >Input2 : {rowData.text.Input2}</Text></View></TouchableHighlight>  ); }
removetache(rowData) {  Alert.alert( ' Bravo ligne supprimée !');   this.tacheitemsRef.child(rowData.id).remove();   }
renderRowclient(rowData) { return ( <TouchableHighlight onPress={() => this.removeclient(rowData)}><View ><Text >Input1 : {rowData.text.Input1}</Text><Text >Input2 : {rowData.text.Input2}</Text></View></TouchableHighlight>  ); }
removeclient(rowData) {  Alert.alert( ' Bravo ligne supprimée !');   this.clientitemsRef.child(rowData.id).remove();   }
render()
{
//Vue
return(

<ScrollView>
<Grid>

<Row
resource-id='
1
'>
<Col
resource-id='
1
1
'>
<TextInput style={styles.Style1} placeholder="Input1" onChangeText={(text) => this.setState({Input1: text})} value={this.state.Input1}/>
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
<TextInput style={styles.Style1} placeholder="Input2" onChangeText={(text) => this.setState({Input2: text})} value={this.state.Input2}/>
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
<Button title='Ajouter' onPress={() => this.ReplirTable()} onLongPress={() => this.alrte2()} buttonStyle={ styles.Style1 } icon={{name: 'squirrel', type: 'evilicon', buttonStyle: styles.Style1 }}  />
</Col>


<Col
resource-id='
3
2
'>
<Button title='Ajoutertache' onPress={() => this.ReplirTabletache()} onLongPress={() => this.alrte2()} buttonStyle={ styles.Style1 } icon={{name: 'squirrel', type: 'evilicon', buttonStyle: styles.Style1 }}  />
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
<ListView dataSource={this.state.clientSource} renderRow={this.renderRowclient.bind(this)} enableEmptySections={true} />
</Col>


<Col
resource-id='
4
2
'>
<ListView dataSource={this.state.tacheSource} renderRow={this.renderRowtache.bind(this)} enableEmptySections={true} />
</Col>

</Row>


</Grid>
</ScrollView>

);
}
}
var
styles
=
StyleSheet.create({
//StyleSheet
 row: { flexDirection: 'row', padding: 12, height: 44 }, separator: { height: 1, backgroundColor: '#CCCCCC', },
 row: { flexDirection: 'row', padding: 12, height: 44 }, separator: { height: 1, backgroundColor: '#CCCCCC', },
Style1: { right: 13 , width: 10, maxheigh: 9, maxWidth: 14, minHeight: 2, minWidth: 18, left: 13, Flex: 12, flexWrap: 'nowrap', JustifyContent: 'center' , BorderRadium: 9, position: 'relative' , padding: 14, paddingBottom: 12, paddingHorizontal: 9, paddingLeft: 6, paddingRight: 19, paddingTop: 17, bottom: 12, margin: 8, marginHorizontal: 8, marginTop: 16, marginRight: 14, fontSize: 12, fontStyle: 'italic' , fontWeight: 'bold' , borderStyle: 'dashed' , borderBottomLeftRadius: 8, borderBottomRightRadius: 4, borderBottomWidth: 9, borderWidth: 12, borderColor: '#ffffff' , borderLeftColor: '#008000' , borderLeftWidth: '21' , borderRadius: 9, borderRightColor: '#ff8c00' , borderRightWidth: 19, borderTopColor: '#d3d3d3' , borderTopLeftRadius: 25, borderTopRightRadius: borderTopRightRadius, borderTopWidth: 14, backfaceVisibility: 'hidden' , BackGroundColor: '#d3d3d3' , lineHeight: 15, textAlign: 'justify' , textDecorationLine: 'line-through' , textShadowColor: '#ffd700' , textAlignVertical: 'bottom' , textShadowRadius: 15, fontVariant: 'oldstyle-nums' , letterSpacing: 6, textDecorationColor: '#fffaf0' , textDecorationStyle: 'dashed' , writingDirection: 'rtl', },
});

AppRegistry.registerComponent('pfe',
()=>pfe);
