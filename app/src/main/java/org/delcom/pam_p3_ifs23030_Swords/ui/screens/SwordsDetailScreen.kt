package org.delcom.pam_p3_ifs23030_Swords.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.delcom.pam_p3_ifs23030_Swords.data.DummyData
import org.delcom.pam_p3_ifs23030_Swords.data.SwordData
import org.delcom.pam_p3_ifs23030_Swords.helper.RouteHelper
import org.delcom.pam_p3_ifs23030_Swords.ui.components.BottomNavComponent
import org.delcom.pam_p3_ifs23030_Swords.ui.components.LoadingUI
import org.delcom.pam_p3_ifs23030_Swords.ui.components.TopAppBarComponent
import org.delcom.pam_p3_ifs23030_Swords.ui.theme.DelcomTheme

@Composable
fun SwordsDetailScreen(
    navController: NavHostController,
    swordName: String
) {
    // Muat data pedang
    var sword by remember { mutableStateOf<SwordData?>(null) }

    LaunchedEffect(Unit) {
        sword = DummyData.getSwordsData().find { it.nama == swordName }
        if (sword == null) {
            RouteHelper.back(navController)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (sword != null) {
            // Top App Bar
            TopAppBarComponent(navController = navController, title = swordName, showBackButton = true)

            // Content
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                SwordsDetailUI(
                    sword = sword!!
                )
            }

            // Bottom Nav
            BottomNavComponent(navController = navController)
        } else {
            LoadingUI()
        }
    }
}

@Composable
fun SwordsDetailUI(
    sword: SwordData
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Gambar dan Nama Pedang
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Image(
                painter = painterResource(id = sword.gambar),
                contentDescription = sword.nama,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = sword.nama,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Asal: ${sword.asal}",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp)
            )
        }

        // Card: Sejarah
        SwordInfoCard(title = "Sejarah", content = sword.sejarah)

        // Card: Kelebihan
        SwordInfoCard(title = "Kelebihan", content = sword.kelebihan)

        // Card: Fakta Unik
        SwordInfoCard(title = "Fakta Unik", content = sword.faktaUnik)
    }
}

@Composable
fun SwordInfoCard(title: String, content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, bottom = 8.dp)
            )
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Composable
fun PreviewSwordsDetailUI() {
    DelcomTheme {
        // Mengambil data pertama dari list pedang untuk preview
        val dummySword = DummyData.getSwordsData()[0]
        SwordsDetailUI(sword = dummySword)
    }
}