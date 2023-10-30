package com.caseaplikasi.mobileapppromo

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.caseaplikasi.core.domain.model.PromoModel
import com.caseaplikasi.core.utils.AssetParamType
import com.caseaplikasi.mobileapppromo.ui.navigation.Screen
import com.caseaplikasi.mobileapppromo.ui.screen.PromoViewModel
import com.caseaplikasi.mobileapppromo.ui.screen.detail.DetailScreen
import com.caseaplikasi.mobileapppromo.ui.screen.home.HomeScreen
import com.caseaplikasi.mobileapppromo.ui.theme.CaseAplikasiMobileAppPromoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: PromoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaseAplikasiMobileAppPromoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PromoApp(viewModel = viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: PromoViewModel
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    viewModel =  viewModel,
                    navigateToDetail = { promo ->
                    navController.navigate(Screen.DetailPromo.createRoute(promo))
                })
            }
            composable(
                route = Screen.DetailPromo.route,
                arguments = listOf(
                    navArgument("promo") {
                        type = AssetParamType()
                    }
                )
            ){
                val promo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    it.arguments?.getParcelable("promo", PromoModel::class.java)
                } else {
                    it.arguments?.getParcelable("promo")
                }
                if (promo != null) {
                    DetailScreen(
                        promo = promo,
                        navigateBack = {
                            navController.navigateUp()
                        }
                    )
                }
            }
        }
    }
}
