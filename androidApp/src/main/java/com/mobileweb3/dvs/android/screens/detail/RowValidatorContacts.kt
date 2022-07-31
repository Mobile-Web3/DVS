package com.mobileweb3.dvs.android.screens.detail

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.android.ui.composables.IconWithHtmlLink
import com.mobileweb3.dvs.core.entity.validator.Contact

@Composable
fun RowValidatorContacts(contacts: List<Contact>, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(
                state = rememberScrollState(),
                enabled = true
            )
    ) {
        contacts.forEachIndexed { index, contact ->
            IconWithHtmlLink(
                iconTag = contact.type,
                link = contact.link
            )

            if (index != contacts.lastIndex) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}