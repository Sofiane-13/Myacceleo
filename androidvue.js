
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
this.itemsRef
=
myFirebaseRefapp.database().ref('item');
this.state
=
{
//Debutdustate
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
render()
{
//Vue
return(

<ScrollView>
<Grid>
 <Row resource-id=' 1 '> <Col resource-id=' 1 1 '> </Col> 
</Row> 
 <Row resource-id=' 2 '> <Col resource-id=' 2 1 '> </Col> 
</Row> 
 <Row resource-id=' 3 '> <Col resource-id=' 3 1 '> </Col> 
 <Col resource-id=' 3 2 '> </Col> 
</Row> 
 <Row resource-id=' 4 '> <Col resource-id=' 4 1 '> </Col> 
 <Col resource-id=' 4 2 '> </Col> 
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
});

AppRegistry.registerComponent('pfe',
()=>pfe);
