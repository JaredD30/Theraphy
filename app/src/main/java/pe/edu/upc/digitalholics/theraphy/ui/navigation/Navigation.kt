package pe.edu.upc.digitalholics.theraphy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.digitalholics.theraphy.ui.mypatients.MyPatientsViewModel


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.MyPatientsList.routes
    ) {
        composable(Routes.MyPatientsList.routes) {
            val myPatientsViewModel: MyPatientsViewModel = hiltViewModel()
        }
    }
}


sealed class Routes(val routes: String) {
    object MyPatientsList: Routes("MyPatientsList")
}