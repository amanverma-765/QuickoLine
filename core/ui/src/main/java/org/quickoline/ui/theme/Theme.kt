package org.quickoline.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.materialkolor.DynamicMaterialTheme
import com.materialkolor.PaletteStyle

@Composable
fun QuickoLineTheme(
    seedColor: Color = Color.Green,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    DynamicMaterialTheme(
        seedColor = seedColor,
        useDarkTheme = darkTheme,
        isExtendedFidelity = true,
        style = PaletteStyle.Vibrant,
        content = content
    )
}