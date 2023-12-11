package ghar.learn.composeselfsaidbanking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ghar.learn.composeselfsaidbanking.theme.ComposeSelfSaidBankingTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ghar.learn.composeselfsaidbanking.view.CardsSection
import ghar.learn.composeselfsaidbanking.view.FianceSection
import ghar.learn.composeselfsaidbanking.view.WalletSection

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ComposeSelfSaidBankingTheme {
            ComposeSelfSaidBankingTheme {
                // A surface container using the 'background' color from the theme

                SetStatusBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // home UI-Interactions
                    HomeScreen()
                }
            }
        }
    }

    @Composable
    fun SetStatusBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen() {
    Scaffold(                       // helps in putting UI-components like Top-Bar, BottomNavigation in place
        bottomBar = {
            BottomNavigationBar()
        }
    ) { padding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            WalletSection()                             // TopBar-section
            CardsSection()                            // Card-section
            Spacer(modifier = Modifier.height(16.dp))
            FianceSection()
//            CurrenciesSection()
        }
    }
}

