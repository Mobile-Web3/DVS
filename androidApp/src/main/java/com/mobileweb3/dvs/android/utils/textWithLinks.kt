package com.mobileweb3.dvs.android.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import java.util.regex.Pattern

//first we match the html tags and enable the links
@Composable
fun textWithLinks(
    text: String,
    linkColor: Color = MaterialTheme.colors.primary
) = buildAnnotatedString {
    //the html pattern we are searching for
    val htmlTagPattern = Pattern.compile(
        "(?i)<a([^>]+)>(.+?)</a>",
        Pattern.CASE_INSENSITIVE or Pattern.MULTILINE or Pattern.DOTALL
    )
    val matcher = htmlTagPattern.matcher(text)
    var matchStart: Int
    var matchEnd = 0
    var previousMatchStart = 0
    //while there are links in the text we add them to the annotated string:
    while (matcher.find()) {
        matchStart = matcher.start(1)
        matchEnd = matcher.end()
        //first we find the text that is before/between links
        val beforeMatch = text.substring(
            startIndex = previousMatchStart,
            endIndex = matchStart - 2
        )
        //the html tag that we will use as text
        val tagMatch = text.substring(
            startIndex = text.indexOf(
                char = '>',
                startIndex = matchStart
            ) + 1,
            endIndex = text.indexOf(
                char = '<',
                startIndex = matchStart + 1
            ),
        )
        //first append is the text before a link
        withStyle( //our own style
            SpanStyle(
                color = MaterialTheme.colors.onBackground,
            )
        ) {
            append(
                beforeMatch
            )
        }

        // attach a string annotation that stores a URL to the text
        val annotation = text.substring(
            startIndex = matchStart + 7, //omit '<a hreh ='
            endIndex = text.indexOf(
                char = '"',
                startIndex = matchStart + 7,
            )
        )
        //the "annotation" value will be used later for the clickable property
        pushStringAnnotation(tag = "link_tag", annotation = annotation)
        withStyle( //our own style
            SpanStyle(
                color = linkColor,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(
                //text to show as hyperlink
                tagMatch
            )
        }
        pop() //don't forget to add this line after a pushStringAnnotation
        previousMatchStart = matchEnd
    }
    //append the rest of the string (after the last link)
    if (text.length > matchEnd) {
        withStyle( //our own style
            SpanStyle(
                color = MaterialTheme.colors.onBackground,
            )
        ) {
            append(
                text.substring(
                    startIndex = matchEnd,
                    endIndex = text.length
                )
            )
        }
    }
}