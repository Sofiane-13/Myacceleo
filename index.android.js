
import
React,
{
Component
}
from
'react'
import
{AppRegistry,ScrollView,StyleSheet,Text,Alert,View,TouchableHighlight,TextInput,ListView,Button}
from
'react-native';
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
renderRow(rowData) { return ( <TouchableHighlight onPress={() => this.removeTodo(rowData)}> <View> <View style={styles.row}> <Text style={styles.todoText}>{rowData.text.todo}</Text> </View> <View style={styles.separator} /> </View> </TouchableHighlight> ); }
renderRow(rowData) { return ( <TouchableHighlight onPress={() => this.removeTodo(rowData)}> <View> <View style={styles.row}> <Text style={styles.todoText}>{rowData.text.todo}</Text> </View> <View style={styles.separator} /> </View> </TouchableHighlight> ); }
render()
{
return(
<View>
<ScrollView> <ListView dataSource={this.state.todoSource} renderRow={this.renderRow.bind(this)} enableEmptySections={true} /> </ScrollView>
<TextInput style={styles.style1} onChangeText={(text) => this.setState({Input1: text})} value={this.state.Input1}/>
<Button raised title='AddTache' onPress={() => this.RemplirTable1()} onLongPress={() => this.RemplirTable1()} style={ styles.style1 } icon={{name: 'squirrel', type: 'octicon', buttonStyle: styles.style1 }}  />
<ScrollView> <ListView dataSource={this.state.todoSource} renderRow={this.renderRow.bind(this)} enableEmptySections={true} /> </ScrollView>
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
 row: { flexDirection: 'row', padding: 12, height: 44 }, separator: { height: 1, backgroundColor: '#CCCCCC', },
style1: { FlexDirection: 'center' , JustifyContent: center, },
});
AppRegistry.registerComponent('pfe',
()=>pfe);
