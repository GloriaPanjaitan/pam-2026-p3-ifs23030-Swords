package org.delcom.pam_p3_ifs23030_Swords

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.delcom.pam_p3_ifs23030_Swords.ui.UIApp
import org.delcom.pam_p3_ifs23030_Swords.ui.theme.DelcomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengaktifkan tampilan full screen (tepi-ke-tepi)
        enableEdgeToEdge()

        setContent {
            // DelcomTheme akan menerapkan warna SteelGray & BladeSilver
            // yang telah kita definisikan di ui.theme.Color.kt
            DelcomTheme {
                // UIApp akan memuat NavHost yang berisi
                // Home, Profile, Swords, dan SwordsDetail
                UIApp()
            }
        }
    }
}