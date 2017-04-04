
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
Button
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
apiKey: "apiKey1" , authDomain:  "authDomain1" , databaseURL: "databaseURL1" ,
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
this.itemsRef
=
myFirebaseRefapp.database().ref('item');
this.state
=
{
//Debutdustate
Input2: '',
Input1: '',
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
ReplirTable() { if( (this.state.table1 !== '')) { this.itemsRef.push({  table1: this.state.table1 , });  this.setState({ table1 : '' })  } } 
 alrte2 = () => { Alert.alert('alerte2'); };
renderRowtable1(rowData) { return ( <TouchableHighlight onPress={() => this.removetable1(rowData)}><View ><Text >Input1 : {rowData.text.Input1}</Text><Text >Input2 : {rowData.text.Input2}</Text></View></TouchableHighlight>  ); }
removetable1(rowData) {  Alert.alert( ' Bravo ligne supprimée !');   this.table1itemsRef.child(rowData.id).remove();   }
render()
{
//Vue
return(
<View>
<Button title='Ajouter' onPress={() => this.ReplirTable()} onLongPress={() => this.alrte2()} buttonStyle={ styles.Style1 } icon={{name: 'squirrel', type: 'evilicon', buttonStyle: styles.Style1 }}  />
<TextInput style={styles.Style1} placeholder="Input2" onChangeText={(text) => this.setState({Input2: text})} value={this.state.Input2}/>
<TextInput style={styles.Style1} placeholder="Input1" onChangeText={(text) => this.setState({Input1: text})} value={this.state.Input1}/>
<ListView dataSource={this.state.table1Source} renderRow={this.renderRowtable1.bind(this)} enableEmptySections={true} />
</View>
);
}
}

var
styles
=
StyleSheet.create({
//StyleSheet
 row: { flexDirection: 'row', padding: 12, height: 44 }, separator: { height: 1, backgroundColor: '#CCCCCC', },
Style1: { right: 13 , width: 10, maxheigh: 9, maxWidth: 14, minHeight: 2, minWidth: 18, left: 13, Flex: 12, flexWrap: 'nowrap', JustifyContent: 'center' , BorderRadium: 9, position: 'relative' , padding: 14, paddingBottom: 12, paddingHorizontal: 9, paddingLeft: 6, paddingRight: 19, paddingTop: 17, bottom: 12, margin: 8, marginHorizontal: 8, marginTop: 16, marginRight: 14, fontSize: 12, fontStyle: 'italic' , fontWeight: 'bold' , borderStyle: 'dashed' , borderBottomLeftRadius: 8, borderBottomRightRadius: 4, borderBottomWidth: 9, borderWidth: 12, borderColor: '#ffffff' , borderLeftColor: '#008000' , borderLeftWidth: '21' , borderRadius: 9, borderRightColor: '#ff8c00' , borderRightWidth: 19, borderTopColor: '#d3d3d3' , borderTopLeftRadius: 25, borderTopRightRadius: borderTopRightRadius, borderTopWidth: 14, backfaceVisibility: 'hidden' , BackGroundColor: '#d3d3d3' , lineHeight: 15, textAlign: 'justify' , textDecorationLine: 'line-through' , textShadowColor: '#ffd700' , textAlignVertical: 'bottom' , textShadowRadius: 15, fontVariant: 'oldstyle-nums' , letterSpacing: 6, textDecorationColor: '#fffaf0' , textDecorationStyle: 'dashed' , writingDirection: 'rtl', },
});
AppRegistry.registerComponent('pfe',
()=>pfe);
