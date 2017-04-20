
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
Layout1
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

<ScrollView>
<Grid>

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


<Col
resource-id='
1
2
'>
</Col>


<Col
resource-id='
1
3
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
</Col>

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
layout2
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

<ScrollView>
<Grid>

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


<Col
resource-id='
1
2
'>
</Col>


<Col
resource-id='
1
3
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
</Col>

</Row>


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
</Col>

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
