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
//Constructeur

this.state = {
//Debutdustate
}

}
componentDidMount() {
//DidMount

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
