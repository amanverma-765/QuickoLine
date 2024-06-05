package org.quickoline.home.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import org.quickoline.home.R
import org.quickoline.ui.theme.FormFillingServicesColor
import org.quickoline.ui.theme.LastMinuteServicesColor
import org.quickoline.ui.theme.LegalServicesColor
import org.quickoline.ui.theme.MoreServicesColor


internal data class CategoryItem(
    @DrawableRes
    val icon: Int,
    val bgColor: Color,
    @StringRes
    val title: Int,
    val category: Category
)

internal val categoryCards = listOf(
    CategoryItem(
        title = org.quickoline.ui.R.string.form_filling,
        icon = R.drawable.formfilling_icon,
        bgColor = FormFillingServicesColor,
        category = Category.FORM_FILLING
    ),
    CategoryItem(
        title = org.quickoline.ui.R.string.legal_work,
        icon = R.drawable.legalwork_icon,
        bgColor = LegalServicesColor,
        category = Category.LEGAL_WORK
    ),
    CategoryItem(
        title = org.quickoline.ui.R.string.last_minute,
        icon = R.drawable.lastminute_icon,
        bgColor = LastMinuteServicesColor,
        category = Category.LAST_MINUTE
    ),
    CategoryItem(
        title = org.quickoline.ui.R.string.more_services,
        icon = R.drawable.extraservices_icon,
        bgColor = MoreServicesColor,
        category = Category.MORE_SERVICES
    )
)

internal enum class Category {
    FORM_FILLING,
    LEGAL_WORK,
    LAST_MINUTE,
    MORE_SERVICES
}