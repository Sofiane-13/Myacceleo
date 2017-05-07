
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
Acceuil
extends
Component
{
constructor(props)
{
super(props);
//Constructeur
this.state
=
{
//Debutdustate
nom: '',
}
}
componentDidMount()
{
//DidMount
}
//function
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
<TextInput style={styles.styleinput} placeholder="nom" onChangeText={(text) => this.setState({nom: text})} value={this.state.nom}/>
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
backfaceVisibility: { backfaceVisibility: 'backgroundColor' , backgroundColor: 'borderBottomColor', borderBottomColor: 'borderBottomLeftRadius', borderBottomLeftRadius: borderBottomRightRadius, borderBottomRightRadius: borderBottomWidth, borderBottomWidth: borderColor, borderColor: 'borderLeftColor', borderLeftColor: 'borderLeftWidth', borderLeftWidth: borderRadius, borderRadius: borderRightColor , borderRightColor: 'borderRightWidth', borderRightWidth: borderStyle , borderStyle: 'borderTopColor', borderTopColor: 'borderTopLeftRadius', borderTopLeftRadius: borderTopRightRadius, borderTopRightRadius: borderTopWidth, borderTopWidth: borderWidth, borderWidth: opacity, opacity: alignItems, alignItems: 'alignSelf', alignSelf: 'bottom', bottom: flex, flex: flexDirection, flexDirection: 'flexWrap', flexWrap: 'height', height: justifyContent, justifyContent: 'left', left: margin, margin: marginBottom, marginBottom: marginHorizontal , marginHorizontal: marginLeft , marginLeft: marginRight , marginRight: marginTop, marginTop: marginVertical, marginVertical: padding, padding: paddingBottom, paddingBottom: paddingHorizontal , paddingHorizontal: paddingRight , paddingRight: paddingTop , paddingTop: paddingVertical, paddingVertical: right , borderRightWidth: width, borderTopColor: End. , },
styleview: { flexWrap: 'wrap', },
styleinput: { fontFamily: 'h1', fontStyle: 'normal', fontWeight: 'normal', textAlign: 'auto', },
End.: { backfaceVisibility: 'nom' , backgroundColor: 'styleinput', borderBottomColor: '1', borderBottomLeftRadius: 1, borderBottomRightRadius: }	, borderBottomWidth: styleinput, borderLeftColor: 'h1', borderRadius: normal , borderRightColor: 'normal', borderStyle: 'auto', padding: StyleView, paddingBottom: backfaceVisibility , paddingHorizontal: backgroundColor , paddingRight: borderBottomColor , paddingTop: borderBottomLeftRadius, paddingVertical: borderBottomRightRadius , borderRightWidth: borderBottomWidth, borderTopColor: borderColor , },
contient: { backfaceVisibility: 'Style' , backgroundColor: 'End.', borderBottomColor: 'nom', borderBottomLeftRadius: styleinput, borderBottomRightRadius: 1, borderBottomWidth: 1, borderColor: '}	', borderLeftColor: 'styleinput', borderRadius: h1 , borderRightWidth: normal , borderStyle: 'normal', borderTopLeftRadius: auto, paddingHorizontal: StyleView , paddingRight: backfaceVisibility , paddingTop: backgroundColor, paddingVertical: borderBottomColor , borderRightWidth: borderBottomLeftRadius, borderTopColor: borderBottomRightRadius , },
});
AppRegistry.registerComponent(
'Acceuil'
,()=>
Acceuil
);
