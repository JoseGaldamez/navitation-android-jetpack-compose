package dev.josegaldamez.navigatorjetpackcompose

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.josegaldamez.navigatorjetpackcompose.screens.AddScreen
import dev.josegaldamez.navigatorjetpackcompose.screens.ContactScreen
import dev.josegaldamez.navigatorjetpackcompose.screens.HomeScreen

@Composable
 fun NavigatorHostController() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",

        enterTransition = { slideIntoContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Up,
            animationSpec = tween(300)
        ) },

        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Up,
                animationSpec = tween(300)
            )
        },

        popEnterTransition = { slideIntoContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Right,
            animationSpec = tween(300)
        ) },

        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Down,
                animationSpec = tween(300)
            )
        }



    ){
        composable(route = Screens.HomeScreen.name ){ HomeScreen(navController) }
        composable(route = Screens.AddScreen.name){ AddScreen(navController) }


        composable(
            route = "${Screens.ContactScreen.name}?userName={userName}",
            arguments = listOf( navArgument("userName"){
                defaultValue = "No name"
            } )
        ){stackEntry ->

            val userName = stackEntry.arguments?.getString("userName")
            ContactScreen(navController, userName)
        }


    }
}