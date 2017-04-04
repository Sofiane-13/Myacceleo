import React, { Component } from 'react'
import {AppRegistry,ScrollView,StyleSheet,Text,Alert,View,TouchableHighlight,TextInput,ListView} from 'react-native';
import { Button } from 'react-native-elements'
var Firebase = require('firebase');
var config = {
//ConfigurationDATABASE
};
const myFirebaseRefapp =  firebase.initializeApp(config);
import * as firebase from "firebase";
export default class pfe extends Component {
constructor(props) {
super(props);
this.itemsRef = myFirebaseRefapp.database().ref('item');
this.state = {
//Debutdustate
todoSource: new ListView.DataSource({rowHasChanged: (row1, row2)=>row1 !== row2})
}
this.items = [];
}
componentDidMount() {
this.itemsRef.on('child_added', (dataSnapshot)=>{
this.items.push({id: dataSnapshot.key, text: dataSnapshot.val()});
this.setState({todoSource: this.state.todoSource.cloneWithRows(this.items)});
});
this.itemsRef.on('child_removed', (dataSnapshot)=>{
this.items = this.items.filter((x)=>x.id !== dataSnapshot.key);
this.setState({
todoSource: this.state.todoSource.cloneWithRows(this.items)});
});
}
//function
render() {
//Vue
return(
<View>

</View>
);
}
}
 var styles = StyleSheet.create({
//StyleSheet
});
AppRegistry.registerComponent('pfe', ()=>pfe);
