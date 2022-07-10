package com.mobileweb3.dvs.android.ui.composables

import androidx.annotation.DrawableRes
import com.mobileweb3.dvs.android.R

object IconResources {

    @DrawableRes
    fun from(iconTag: String): Int? {
        return when {
            iconTag.equals("Telegram", true) -> {
                R.drawable.ic_telegram
            }
            iconTag.equals("Twitter", true) -> {
                R.drawable.ic_twitter
            }
            iconTag.equals("Keybase", true) -> {
                R.drawable.ic_keybase
            }
            iconTag.equals("Github", true) -> {
                R.drawable.ic_github2
            }
            iconTag.equals("Website", true) -> {
                R.drawable.ic_website
            }
            iconTag.equals("Medium", true) -> {
                R.drawable.ic_medium
            }
            iconTag.equals("Discord", true) -> {
                R.drawable.ic_discord
            }
            iconTag.equals("Instagram", true) -> {
                R.drawable.ic_instagram
            }
            iconTag.equals("Email", true) -> {
                R.drawable.ic_email
            }
            else -> null
        }
    }
}