
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
Map
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
mapRegion: { latitude: 125.6, longitude: 12.5, latitudeDelta: 12.3, longitudeDelta: 125.9 }
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
_handleMapRegionChange=mapRegion=>{this.setState({ mapRegion });};
_handlePlaySoundAsync=async=()=>{ await Audio.setIsEnabladeAsync(true); let sound=new Audio.Sound({source: 'urll', }); await sound.loadAsync(); await sound.playAsync();};
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
<Button title="chanson" onPress={this._handlePlaySoundAsync} />
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
<Video source={{ uri: 'h'}} rate={1.0} volume={1.0} muted={false} resizeMode="cover" repeat style={{width: 4, height: none}} />
</Col>


<Col
resource-id='
2
2
'>
<Image source={{ uri: 'uuui' }}  />
</Col>


<Col
resource-id='
2
3
'>
<MapView style={{ alignSelf: 'stretch', height: 200 }} region={this.state.mapRegion} onRegionChange={this._handleMapRegionChange} />
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
});
AppRegistry.registerComponent(
'Map'
,()=>
Map
);
