package org.quickoline.utils

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString

@Composable
fun HyperlinkText(
    modifier: Modifier = Modifier,
    fullText: String,
    hyperLinks: Map<String, String>,
    textStyle: TextStyle = TextStyle.Default,
    linkTextStyle: TextStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
    onClick: (url: String) -> Unit
) {

    val annotatedString = buildAnnotatedString {
        append(fullText)
        for((key, value) in hyperLinks){
            val startIndex = fullText.indexOf(key)
            val endIndex = startIndex + key.length
            addStyle(
                style = SpanStyle(
                    color = linkTextStyle.color,
                    fontSize = linkTextStyle.fontSize,
                    fontWeight = linkTextStyle.fontWeight,
                    textDecoration = linkTextStyle.textDecoration
                ),
                start = startIndex,
                end = endIndex
            )
            addStringAnnotation(
                tag = "URL",
                annotation = value,
                start = startIndex,
                end = endIndex
            )
        }
//        addStyle(
//            style = SpanStyle(
//                fontSize = linkTextStyle.fontSize
//            ),
//            start = 0,
//            end = fullText.length
//        )
    }

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        style = textStyle,
        onClick = {
            annotatedString
                .getStringAnnotations("URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    onClick(stringAnnotation.item)
                }
        }
    )
}
