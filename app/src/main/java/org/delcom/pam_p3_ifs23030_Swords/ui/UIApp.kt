package org.delcom.pam_p3_ifs23030_Swords.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.delcom.pam_p3_ifs23030_Swords.helper.ConstHelper
import org.delcom.pam_p3_ifs23030_Swords.ui.screens.HomeScreen
import org.delcom.pam_p3_ifs23030_Swords.ui.screens.ProfileScreen
import org.delcom.pam_p3_ifs23030_Swords.ui.screens.SwordsDetailScreen
import org.delcom.pam_p3_ifs23030_Swords.ui.screens.SwordsScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UIApp(
    navController: NavHostController = rememberNavController(),
) {
    // Menggunakan innerPadding agar konten tidak tertutup bar
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ConstHelper.RouteNames.Home, // Hapus .path
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Home Screen
            composable(
                route = ConstHelper.RouteNames.Home, // Hapus .path
            ) {
                HomeScreen(navController = navController)
            }

            // Profile Screen
            composable(
                route = ConstHelper.RouteNames.Profile, // Hapus .path
            ) {
                ProfileScreen(navController = navController)
            }

            // Swords Screen
            composable(
                route = ConstHelper.RouteNames.Swords, // Hapus .path
            ) {
                SwordsScreen(navController = navController)
            }

            // Swords Detail Screen
            composable(
                route = ConstHelper.RouteNames.SwordsDetail, // Hapus .path
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                )
            ) { backStackEntry ->
                val swordName = backStackEntry.arguments?.getString("name") ?: ""

                SwordsDetailScreen(
                    navController = navController,
                    swordName = swordName
                )
            }
        }
    }
}