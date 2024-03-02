package org.quickoline.ui.screens.homescreen

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import org.quickoline.R
import org.quickoline.ui.theme.CardColor1
import org.quickoline.ui.theme.CardColor2
import org.quickoline.ui.theme.CardColor3
import org.quickoline.ui.theme.CardColor4

data class CategoryData(
    val title: String,
    val cardColor: Color,
    @DrawableRes val image: Int
)


val CategoryList = listOf(

    CategoryData(
        title = "Form Filling",
        cardColor = CardColor1,
        image = R.drawable.services_icon
    ),
    CategoryData(
        title = "Legal Work",
        cardColor = CardColor2,
        image = R.drawable.legalwork_icon
    ),
    CategoryData(
        title = "Last Minute",
        cardColor = CardColor3,
        image = R.drawable.lastminute_icon
    ),
    CategoryData(
        title = "More Services",
        cardColor = CardColor4,
        image = R.drawable.extraservices_icon
    )

)