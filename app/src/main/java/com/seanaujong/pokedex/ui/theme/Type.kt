package com.seanaujong.pokedex.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.seanaujong.pokedex.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val RobotoFont = GoogleFont(name = "Roboto")

val RobotoCondensedFont = GoogleFont(name = "Roboto Condensed")

val RobotoFontFamily = FontFamily(
    Font(googleFont = RobotoFont, fontProvider = provider),
    Font(resId = R.font.roboto_regular),
    Font(googleFont = RobotoFont, fontProvider = provider, weight = FontWeight.Bold),
    Font(resId = R.font.roboto_bold),
    Font(googleFont = RobotoFont, fontProvider = provider, weight = FontWeight.Light),
    Font(resId = R.font.roboto_light),
    Font(googleFont = RobotoFont, fontProvider = provider, weight = FontWeight.Medium),
    Font(resId = R.font.roboto_medium),
)

val RobotoCondensedFontFamily = FontFamily(
    Font(googleFont = RobotoCondensedFont, fontProvider = provider),
    Font(resId = R.font.roboto_condensed_regular),
    Font(googleFont = RobotoCondensedFont, fontProvider = provider, weight = FontWeight.Light),
    Font(resId = R.font.roboto_condensed_light)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = RobotoCondensedFontFamily,
        fontSize = 20.sp,
        color = Color.Blue
    )
)