package org.delcom.pam_p3_ifs23030_Swords.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.delcom.pam_p3_ifs23030_Swords.R
import org.delcom.pam_p3_ifs23030_Swords.ui.components.BottomNavComponent
import org.delcom.pam_p3_ifs23030_Swords.ui.components.TopAppBarComponent

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopAppBarComponent(
            navController = navController,
            title = "Home",
            showBackButton = false
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Menampilkan ikon pedang utama sebagai visual Home
            Image(
                painter = painterResource(id = R.drawable.img_pedang),
                contentDescription = "Welcome Image",
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Selamat Datang di Galeri Pedang",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Eksplorasi koleksi pedang legendaris melalui menu Swords.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        BottomNavComponent(navController = navController)
    }
}