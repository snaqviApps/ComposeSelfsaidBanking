package ghar.learn.composeselfsaidbanking.data

import androidx.compose.ui.graphics.Brush

data class Card(
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val cardBalance: Double,
    val color: Brush
)