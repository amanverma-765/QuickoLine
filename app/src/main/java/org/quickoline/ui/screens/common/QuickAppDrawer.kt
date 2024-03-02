package org.quickoline.ui.screens.common

import androidx.compose.foundation.layout.width
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuickAppDrawer() {

    ModalDrawerSheet(
        modifier = Modifier
            .width(300.dp)
    ) { /* Drawer content */ }

}