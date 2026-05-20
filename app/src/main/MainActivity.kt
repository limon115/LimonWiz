// Author: Khalid Hasan Limon
package com.limon.classwiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.limon.classwiz.presentation.ui.AppNavigation
import com.limon.classwiz.ui.theme.ClassWizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {\n        super.onCreate(savedInstanceState)
        setContent {
            ClassWizTheme {
                AppNavigation()
            }
        }
    }
}
