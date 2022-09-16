package co.edu.udea.compumovil.gr03_20221.dojojetcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.udea.compumovil.gr03_20221.dojojetcompose.ui.theme.DojoJetComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DojoJetComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()
                    var persons by rememberSaveable { mutableStateOf(mutableListOf<Person>()) }

                    NavHost(navController = navController, startDestination = "LISTA"){
                        composable(route="LISTA"){
                            MyList(navController = navController, persons = persons)
                        }
                        composable(route="FORMULARIO"){
                            Formulario(navController = navController, persons = persons)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DojoJetComposeTheme {
        Greeting("Android")
    }
}

@Composable
fun Formulario(navController: NavController, persons: MutableList<Person>){

    var name by rememberSaveable { mutableStateOf("")}
    var lastName by rememberSaveable { mutableStateOf("")}
    var city by rememberSaveable { mutableStateOf("")}

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        MyField(
            value = name,
            onValueChange = {name = it},
            placeholder = "Name",
            imageVector = Icons.Filled.Person,
            contentDescrption = "Person"
        )
        Spacer(modifier = Modifier.height(4.dp))
        MyField(
            value = lastName,
            onValueChange = {lastName=it},
            placeholder = "LastName",
            imageVector = Icons.Filled.Person,
            contentDescrption = "Person"
        )
        Spacer(modifier = Modifier.height(4.dp))
        MyField(
            value = city,
            onValueChange = {city=it},
            placeholder = "City",
            imageVector = Icons.Filled.LocationOn,
            contentDescrption = "Location"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            persons.add(Person(name, lastName, city))
            navController.navigate("LISTA")
        }) {
            Text(text = "Añadir")
        }
    }
}

@Composable
fun MyField(value: String, onValueChange: (String) -> Unit, placeholder: String, imageVector: ImageVector, contentDescrption: String){
    OutlinedTextField(value = value, onValueChange = onValueChange, placeholder = {
        Text(text = placeholder)
    },
        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = contentDescrption )
        }
    )
}

@Composable
fun MyItem(name: String, lastName: String, city: String){
    var conteo by rememberSaveable { mutableStateOf( 0)}
    Row(verticalAlignment = Alignment.CenterVertically){
        Column() {
            Text(text = "$name $lastName")
            Text(text = "$city")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            IconButton(onClick = { conteo++ }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
            }
            Text(text = conteo.toString())
        }
    }
}

data class Person(val name: String, val lastName: String, val city: String)

@Composable
fun MyList(navController: NavController, persons: MutableList<Person>){
    LazyColumn(){
        items(persons) {item ->
            MyItem(item.name, item.lastName, item.city )
        }
        item { 
            Button(onClick = { navController.navigate("FORMULARIO") }) {
                Text(text = "Nuevo")
            }
        }
    }
}


