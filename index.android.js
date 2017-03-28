
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


apiKey:
"AIzaSyDysc3BPHCAGkHJ4K61zwXhZb07M5rnCQE",


authDomain:
"pfedsl-68809.firebaseapp.com",


databaseURL:
"https://pfedsl-68809.firebaseio.com/",
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
RemplirTable1() { if (this.state.Input1 !== '') {  this.itemsRef.push({    Input1: this.state.Input1    });  this.setState({ Input1 : ''     }) } }
renderRow(rowData) { return ( <TouchableHighlight onPress={() => this.removeTodo(rowData)}><View ><Text >{rowData.text.Input1}</Text></View></TouchableHighlight>  ); }
render()
{
//Vue
return(
<View>
<ListView dataSource={this.state.todoSource} renderRow={this.renderRow.bind(this)} enableEmptySections={true} />
<TextInput style={styles.style1} onChangeText={(text) => this.setState({Input1: text})} value={this.state.Input1}/>
<Button raised title='AddTache' onPress={() => this.RemplirTable1()} onLongPress={() => this.RemplirTable1()} buttonStyle={ styles.style1 } icon={{name: 'squirrel', type: 'octicon', buttonStyle: styles.style1 }}  />

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
style1: { height: 1, flex: 1, backgroundColor: '#CCCCCC' , },
});
AppRegistry.registerComponent('pfe',
()=>pfe);
