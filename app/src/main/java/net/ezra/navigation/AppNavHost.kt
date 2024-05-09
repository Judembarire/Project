package net.ezra.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.ezra.ui.students.AddStudents
import net.ezra.ui.guide.GuideScreen
import net.ezra.ui.home.HomeScreen
import net.ezra.ui.login.LoginScreen
import net.ezra.ui.myplant.PlantScreen
import net.ezra.ui.plants.Plant
import net.ezra.ui.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_ADD


) {
    BackHandler {
        navController.popBackStack()

        }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {


        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }

        composable(ROUTE_PLANT) {
            PlantScreen(navController)
        }

        composable(ROUTE_GUIDE) {
            GuideScreen(navController)
        }


        composable(ROUTE_VIEW) {
            Plant(navController)
        }


        composable(ROUTE_ADD) {
            AddStudents(navController)
        }













    }
}