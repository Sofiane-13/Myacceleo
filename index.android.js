'use strict';
import React, { Component } from 'react'
import {
AppRegistry,
ScrollView,
StyleSheet,
Text,
Alert,
View,
TouchableHighlight,
TextInput,
ListView
} from 'react-native';
var Firebase = require('firebase');
var config = {
  apiKey: "AIzaSyDysc3BPHCAGkHJ4K61zwXhZb07M5rnCQE",
  authDomain: "pfedsl-68809.firebaseapp.com",
  databaseURL: "https://pfedsl-68809.firebaseio.com/",
};
const myFirebaseRefapp =  firebase.initializeApp(config);
import * as firebase from "firebase";
export default class pfe extends Component {
constructor(props) {
super(props);
this.itemsRef = myFirebaseRefapp.database().ref('item');
this.state = {newTodo: '',todoSource: new ListView.DataSource({rowHasChanged: (row1, row2) => row1 !== row2})}
}
//function
render() {
return (
<View>
</View>
);
}
}
AppRegistry.registerComponent('pfe', () => pfe);
