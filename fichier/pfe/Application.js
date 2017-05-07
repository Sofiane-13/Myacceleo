
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
Application
extends
Component
{
constructor(props)
{
super(props);
console.disableYellowBox=true;
//Constructeur
this.InforitemsRef = getDatabase().ref('mau6ovtqgq5aeuif92r7nuffk4/Infor'); this.Inforitems=[];
this.state
=
{
//Debutdustate
InforSource: new ListView.DataSource({rowHasChanged: (row1, row2)=>row1 !== row2}),
imp: '',
}
}
componentDidMount()
{
//DidMount
 this.InforitemsRef.on('child_added',	(dataSnapshot)=>{ this.Inforitems.push({id: dataSnapshot.key,   text: dataSnapshot.val()}); this.setState({InforSource:	this.state.InforSource.cloneWithRows(this.Inforitems)}); }); this.InforitemsRef.on('child_removed', (dataSnapshot)=>{ this.Inforitems = this.Inforitems.filter((x)=>x.id !== dataSnapshot.key); this.setState({ InforSource: this.state.InforSource.cloneWithRows(this.Inforitems)});});
}

//function
navvi = () => Actions.Map();
 uneAl = () => { Alert.alert('succes'); };
renderRowInfor(rowData) { return ( <TouchableHighlight onPress={() => this.removeInfor(rowData)}><View ><Text >:imp; : {rowData.text.:imp;}</Text></View></TouchableHighlight>  ); }
removeInfor(rowData) {  Alert.alert( ' Bravo ligne supprimée !');   this.InforitemsRef.child(rowData.id).remove();   }
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
<Text style={ styles.stylev }  > info</Text>
</Col>


<Col
resource-id='
1
2
'>
<TextInput style={styles.stylet} placeholder="imp" onChangeText={(text) => this.setState({imp: text})} value={this.state.imp}/>
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
<ListView style={styles.stylev} dataSource={this.state.InforSource} renderRow={this.renderRowInfor.bind(this)} enableEmptySections={true} />
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
<Button title='navi' onPress={() => this.navvi()} onLongPress={() => this.uneAl()} buttonStyle={ styles.stylev } icon={{name: 'squirrel', type: 'octicon', buttonStyle: styles.stylev }}  />
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
stylet: { fontFamily: 'h1', fontStyle: 'normal', fontWeight: 'normal', textAlign: 'auto', backgroundColor: '#8b008b' , },
stylev: { backfaceVisibility: 'hidden' , backgroundColor: '#ffe4b5', borderBottomColor: '#ffe4b5', borderBottomLeftRadius: 3, borderBottomRightRadius: 4, borderBottomWidth: 4, borderTopRightRadius: 6, borderTopWidth: 25, borderWidth: 17, alignItems: 'center', alignSelf: 'flex-end', flexWrap: 'wrap', },
 row: { flexDirection: 'row', padding: 12, height: 44 }, separator: { height: 1, backgroundColor: '#CCCCCC', },
});
AppRegistry.registerComponent(
'Application'
,()=>
Application
);
