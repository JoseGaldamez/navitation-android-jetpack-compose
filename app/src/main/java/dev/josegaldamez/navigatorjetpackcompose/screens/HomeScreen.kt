package dev.josegaldamez.navigatorjetpackcompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import dev.josegaldamez.navigatorjetpackcompose.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                containerColor = Color.Red,
                onClick = { navController.navigate(Screens.AddScreen.name) }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Go to Add Screen",
                    tint = Color.White
                )
            }
        },

        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red
                ),
                title = {
                    Text("Home", color = Color.White)
                })
        }
    ) { padding ->

        Column( modifier = Modifier.padding(padding)  ) {

            NameElement("Jose Galdamez", navController)
            Divider()
            NameElement("Tony Stark", navController)
            Divider()
            NameElement("Peter Parker", navController)
            Divider()
            NameElement("Steve Rogers", navController)
            Divider()

            Text(
                text = "Agregar nuevo elemento",
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        navController.navigate(Screens.AddScreen.name)
                    }
            )

        }

    }

}

@Composable
fun NameElement(name: String, navController: NavHostController){
    Text(text = name,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.DarkGray,
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                // TODO: Enviar información a la siguiente pantalla
                navController.navigate(
                    "${Screens.ContactScreen.name}?userName=$name")

            }
    )
}