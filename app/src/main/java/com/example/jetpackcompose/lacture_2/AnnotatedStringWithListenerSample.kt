package com.example.jetpackcompose.lacture_2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text // Only this Text import should stay
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AnnotatedStringWithListenerSample() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val uriHandler = LocalUriHandler.current

        Text(
            text = buildAnnotatedString {
                append("Build your first app using ") // Added a space here

                val link = LinkAnnotation.Url(
                    url = "https://judge.beecrowd.com/en/profile/1206330",
                    styles = TextLinkStyles(
                        style = SpanStyle(color = Color.Cyan)
                    )
                ) {
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)
                }

                withLink(link) {
                    append("Jetpack Compose")
                }
            }
        )
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun PreviewAnnotatedText() {
//    AnnotatedStringWithListenerSample()
//}