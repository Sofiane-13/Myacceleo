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

//import





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
<Scene key="layout2" component={layout2} title="Layouttwo" />
<Scene key="Layout1" component={Layout1} title="layouOne" />











</Scene>
</Router>

);
}
}
AppRegistry.registerComponent('pfe',
()=>pfe);
