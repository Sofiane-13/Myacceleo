
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
layout2
extends
Component
{
constructor(props)
{
super(props);
//Constructeur
this.table1itemsRef = getDatabase().ref('kmmp89opre1s4rrfsmdfqahn5g/table1'); this.table1items=[];
this.state
=
{
//Debutdustate
table1Source: new ListView.DataSource({rowHasChanged: (row1, row2)=>row1 !== row2}),
input1: '',
}
}
componentDidMount()
{
//DidMount
 this.table1itemsRef.on('child_added',	(dataSnapshot)=>{ this.table1items.push({id: dataSnapshot.key,   text: dataSnapshot.val()}); this.setState({table1Source:	this.state.table1Source.cloneWithRows(this.table1items)}); }); this.table1itemsRef.on('child_removed', (dataSnapshot)=>{ this.table1items = this.table1items.filter((x)=>x.id !== dataSnapshot.key); this.setState({ table1Source: this.state.table1Source.cloneWithRows(this.table1items)});});
}
//function
remlirTable() { if( (this.state.input1 !== '') && (this.state.input2 !== '') && (this.state.input3 !== '')) { this.table1itemsRef.push({  input1: this.state.input1 , input2: this.state.input2 , input3: this.state.input3 , });  this.setState({ input1 : '' }) , this.setState({ input2 : '' })  , this.setState({ input3 : '' })   } } 
 alerte = () => { Alert.alert('alerte'); };
renderRowtable1(rowData) { return ( <TouchableHighlight onPress={() => this.removetable1(rowData)}><View ><Text >input1 : {rowData.text.input1}</Text><Text >input2 : {rowData.text.input2}</Text><Text >input3 : {rowData.text.input3}</Text></View></TouchableHighlight>  ); }
removetable1(rowData) {  Alert.alert( ' Bravo ligne supprimée !');   this.table1itemsRef.child(rowData.id).remove();   }
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


<Col
resource-id='
2
2
'>
</Col>


<Col
resource-id='
2
3
'>
<ListView dataSource={this.state.table1Source} renderRow={this.renderRowtable1.bind(this)} enableEmptySections={true} />
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
</Col>


<Col
resource-id='
5
2
'>
<TextInput style={styles.StyleTO} placeholder="input1" onChangeText={(text) => this.setState({input1: text})} value={this.state.input1}/>
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
 row: { flexDirection: 'row', padding: 12, height: 44 }, separator: { height: 1, backgroundColor: '#CCCCCC', },
});
AppRegistry.registerComponent(
'layout2'
,()=>
layout2
);
