package ghar.learn.composeselfsaidbanking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeselfsaidbanking.data.Card
import ghar.learn.composeselfsaidbanking.theme.BlueEnd
import ghar.learn.composeselfsaidbanking.theme.BlueStart
import ghar.learn.composeselfsaidbanking.theme.GreenEnd
import ghar.learn.composeselfsaidbanking.theme.GreenStart
import ghar.learn.composeselfsaidbanking.theme.OrangeEnd
import ghar.learn.composeselfsaidbanking.theme.OrangeStart
import ghar.learn.composeselfsaidbanking.theme.PurpleEnd
import ghar.learn.composeselfsaidbanking.theme.PurpleStart

val cards = listOf<Card>(
    Card(
        cardType = "VISA",
        cardNumber = "3664 2345 2322 3976",
        cardName = "Savings",
        cardBalance = 46.555,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "3664 2345 2322 3976",
        cardName = "Business",
        cardBalance = 46.555,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "3004 2005 2322 3901",
        cardName = "School",
        cardBalance = 6.555,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "366 2001 2322 1076",
        cardName = "Trips",
        cardBalance = 25.555,
        color = getGradient(GreenStart, GreenEnd)
    )
)

fun getGradient(purpleStart: Color, purpleEnd: Color): Brush {
    return Brush.horizontalGradient(
        colors = listOf(
            purpleStart,
            purpleEnd
        )
    )
}

// Create Cards Section
@Preview
@Composable
fun CardsSection(){
    LazyRow {                           // RecyclerView (here horizontal)
        items(cards.size){ index: Int ->        // like For-loop till the card-size is not Zero
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if(card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    // Box to hold all the components and texts (similar to 'item-layout' in layout-based recyclerViews
    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$${card.cardBalance}",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}
