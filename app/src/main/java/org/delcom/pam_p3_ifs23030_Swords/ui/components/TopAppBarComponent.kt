package org.delcom.pam_p3_ifs23030_Swords.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.delcom.pam_p3_ifs23030_Swords.helper.ConstHelper
import org.delcom.pam_p3_ifs23030_Swords.helper.RouteHelper
import org.delcom.pam_p3_ifs23030_Swords.ui.theme.DelcomTheme

data class TopAppBarMenuItem(
    val text: String,
    val icon: ImageVector,
    val route: String? = null,
    val onClick: (() -> Unit)? = null,
    val isDestructive: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    navController: NavHostController,
    title: String = "Sword Heritage", // Default title diubah
    showBackButton: Boolean = true,
    showMenu: Boolean = true,
    customMenuItems: List<TopAppBarMenuItem>? = null,
    onBackClick: (() -> Unit)? = null,
    elevation: Int = 4,
    withSearch: Boolean = false,
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
) {
    var expanded by remember { mutableStateOf(false) }
    var isSearching by remember { mutableStateOf(false) }
    val queryFocusRequester = remember { FocusRequester() }

    fun setExpandState(state: Boolean) { expanded = state }
    fun setSearchState(state: Boolean) { isSearching = state }

    val defaultMenuItems = listOf(
        TopAppBarMenuItem(
            text = "Profile",
            icon = Icons.Filled.Person,
            route = ConstHelper.RouteNames.Profile
        ),
    )

    val menuItems = customMenuItems ?: defaultMenuItems

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = elevation.dp,
                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
                spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
            ),
        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
        color = MaterialTheme.colorScheme.primaryContainer, // Menggunakan primaryContainer agar lebih kontras
        tonalElevation = elevation.dp
    ) {
        TopAppBar(
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    if (showBackButton && !isSearching) {
                        Card(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(15.dp)),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
                            ),
                            onClick = {
                                onBackClick?.invoke() ?: RouteHelper.back(navController)
                            }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back",
                                    modifier = Modifier.size(20.dp),
                                    tint = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                    }

                    if (isSearching) {
                        TextField(
                            value = searchQuery,
                            onValueChange = { onSearchQueryChange(it) },
                            placeholder = {
                                Text(
                                    "Cari pedang legendaris...", // Placeholder lebih spesifik
                                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                                )
                            },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .focusRequester(queryFocusRequester),
                            colors = TextFieldDefaults.colors(
                                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                                unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                                cursorColor = MaterialTheme.colorScheme.primary
                            ),
                            textStyle = MaterialTheme.typography.bodyLarge
                        )

                        SideEffect {
                            queryFocusRequester.requestFocus()
                        }
                    } else {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent, // Transparent karena background diatur oleh Surface
                titleContentColor = MaterialTheme.colorScheme.onSurface,
                actionIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            actions = {
                if (isSearching) {
                    IconButton(onClick = {
                        setSearchState(false)
                        onSearchQueryChange("")
                    }) {
                        Icon(Icons.Filled.Close, "Tutup")
                    }
                } else {
                    if (withSearch) {
                        IconButton(onClick = { setSearchState(true) }) {
                            Icon(Icons.Filled.Search, "Cari")
                        }
                    }
                    if (showMenu) {
                        IconButton(onClick = { expanded = true }) {
                            Icon(Icons.Filled.MoreVert, "Menu")
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { setExpandState(false) },
                            containerColor = MaterialTheme.colorScheme.surface,
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            menuItems.forEachIndexed { index, item ->
                                DropdownMenuItem(
                                    text = {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(
                                                item.icon,
                                                null,
                                                modifier = Modifier.size(20.dp),
                                                tint = if(item.isDestructive) Color.Red else MaterialTheme.colorScheme.primary
                                            )
                                            Spacer(Modifier.width(12.dp))
                                            Text(item.text)
                                        }
                                    },
                                    onClick = {
                                        setExpandState(false)
                                        if (item.route != null) RouteHelper.to(navController, item.route, true)
                                        item.onClick?.invoke()
                                    }
                                )
                                if (index == menuItems.size - 2 && menuItems.last().isDestructive) {
                                    HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}