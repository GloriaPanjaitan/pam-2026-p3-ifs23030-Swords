package org.delcom.pam_p3_ifs23030_Swords.ui.components

import android.content.res.Configuration
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.delcom.pam_p3_ifs23030_Swords.helper.ConstHelper
import org.delcom.pam_p3_ifs23030_Swords.helper.RouteHelper
import org.delcom.pam_p3_ifs23030_Swords.ui.theme.DelcomTheme
import androidx.compose.material3.Text
sealed class MenuBottomNav(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val iconActive: ImageVector,
) {
    object Home : MenuBottomNav(
        ConstHelper.RouteNames.Home, // Hapus .path di sini
        "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    )

    object Swords : MenuBottomNav(
        ConstHelper.RouteNames.Swords, // Hapus .path di sini
        "Swords",
        Icons.Outlined.Shield,
        Icons.Filled.Shield
    )

    object Profile : MenuBottomNav(
        ConstHelper.RouteNames.Profile, // Hapus .path di sini
        "Profile",
        Icons.Outlined.Person,
        Icons.Filled.Person
    )
}

@Composable
fun BottomNavComponent(navController: NavHostController) {
    val items: List<MenuBottomNav> = listOf(
        MenuBottomNav.Home,
        MenuBottomNav.Swords,
        MenuBottomNav.Profile,
    )

    val navBackStackEntry = navController.currentBackStackEntry
    val currentRoute = navBackStackEntry?.destination?.route

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
            ),
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        tonalElevation = 2.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            modifier = Modifier.height(80.dp), // Disesuaikan tingginya agar standar
            tonalElevation = 0.dp
        ) {
            items.forEach { screen ->
                val selected = currentRoute == screen.route

                NavigationBarItem(
                    label = { Text(text = screen.title) },
                    selected = selected,
                    onClick = {
                        RouteHelper.to(navController, screen.route, true)
                    },
                    icon = {
                        NavigationIcon(
                            selected = selected,
                            screen = screen
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        indicatorColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationIcon(
    selected: Boolean,
    screen: MenuBottomNav,
    hasNotification: Boolean = false
) {
    BadgedBox(
        badge = {
            if (hasNotification && !selected) {
                Badge(
                    modifier = Modifier.size(8.dp),
                    containerColor = MaterialTheme.colorScheme.error
                )
            }
        }
    ) {
        Icon(
            imageVector = if (selected) screen.iconActive else screen.icon,
            contentDescription = screen.title,
            modifier = Modifier.size(24.dp)
        )
    }
}