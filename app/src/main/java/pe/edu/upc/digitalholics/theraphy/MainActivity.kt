package pe.edu.upc.digitalholics.theraphy

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.WithFragmentBindings
import pe.edu.upc.digitalholics.theraphy.ui.navigation.Navigation
import pe.edu.upc.digitalholics.theraphy.ui.theme.TheraphyTheme



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstaceState: Bundle?) {
        super.onCreate(savedInstaceState)
        setContent {
            TheraphyTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Navigation()
                }
            }
        }
    }
}



@HiltAndroidApp
class CoreApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        MainActivity()
    }
}



