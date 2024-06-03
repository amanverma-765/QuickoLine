package org.quickoline.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun QuickolineLogo(
    modifier: Modifier = Modifier,
    logoStyle: TextStyle = TextStyle()
) {
    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            withStyle(
                style = logoStyle.toSpanStyle().merge(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                )
            ) {
                append("Quicko")
            }
            withStyle(
                style = logoStyle.toSpanStyle().merge(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.Bold
                    )
                )
            ) {
                append("Line")
            }
        }
    )
}
