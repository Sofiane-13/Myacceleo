import
React,
{
Component
}
from
'react';
import
{
Scene,
Router,
TabBar,
Modal,
Schema,
Actions,
Reducer,
ActionConst}
from
'react-native-router-flux';
import
{AppRegistry,ScrollView,StyleSheet,Text,Alert,View,TouchableHighlight,TextInput,ListView}
from
'react-native';
var
Firebase=require('firebase');
var
config={
apiKey:
"AIzaSyDysc3BPHCAGkHJ4K61zwXhZb07M5rnCQE",
authDomain:
"pfedsl-68809.firebaseapp.com",
databaseURL:
"https://pfedsl-68809.firebaseio.com/",
};
const
myFirebaseRefapp=firebase.initializeApp(config);
import
*
as
firebase
from
"firebase";
export
const
getDatabase=()=>{
return(

myFirebaseRefapp.database()
);}
//import
import Layout5 from './Layout5';
import Layout4 from './Layout4';
import Layout3 from './Layout3';
import Layout1 from './Layout1';
import Layout2 from './Layout2';
export
default
class
pfe
extends
Component
{render()
{
return(
<Router
>
<Scene
key="root">
<Scene key="Layout5" component={Layout5} title="Layout5" />
<Scene key="Layout4" component={Layout4} title="layout4" />
<Scene key="Layout3" component={Layout3} title="Layout3" />
<Scene key="Layout1" component={Layout1} title="Layout1" />
<Scene key="Layout2" component={Layout2} title="Layout2" />
</Scene>
</Router>
);
}
}
AppRegistry.registerComponent('pfe',
()=>pfe);
