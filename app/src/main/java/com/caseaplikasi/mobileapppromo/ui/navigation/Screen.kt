package com.caseaplikasi.mobileapppromo.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object DetailPromo : Screen("home/{promo}") {
        fun createRoute(promo: String) = "home/$promo"
    }
}