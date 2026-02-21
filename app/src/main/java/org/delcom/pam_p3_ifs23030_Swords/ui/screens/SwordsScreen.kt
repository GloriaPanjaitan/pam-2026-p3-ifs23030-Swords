package org.delcom.pam_p3_ifs23030_Swords.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.delcom.pam_p3_ifs23030_Swords.data.DummyData
import org.delcom.pam_p3_ifs23030_Swords.data.SwordData
import org.delcom.pam_p3_ifs23030_Swords.ui.components.BottomNavComponent
import org.delcom.pam_p3_ifs23030_Swords.ui.components.TopAppBarComponent

@Composable
fun SwordsScreen(navController: NavHostController) {
    var swords by remember { mutableStateOf(DummyData.getSwordsData()) }
    var searchQuery by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBarComponent(
            navController = navController,
            title = "Swords Collection",
            showBackButton = false,
            withSearch = true,
            searchQuery = searchQuery,
            onSearchQueryChange = { query ->
                searchQuery = query
                swords = DummyData.getSwordsData().filter { it.nama.contains(query, ignoreCase = true) }
            }
        )
        Box(modifier = Modifier.weight(1f)) {
            LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                items(swords) { sword ->
                    // PERBAIKAN: Gunakan rute "swords/" sesuai ConstHelper.SwordsDetail
                    SwordItem(sword) {
                        navController.navigate("swords/${sword.nama}")
                    }
                }
            }
        }
        BottomNavComponent(navController)
    }
}
@Composable
fun SwordItem(sword: SwordData, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp).clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = sword.gambar),
                contentDescription = null,
                modifier = Modifier.size(70.dp).clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = sword.nama, fontWeight = FontWeight.Bold)
                Text(text = sword.asal, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}