package ghar.learn.composeselfsaidbanking.view

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyFranc
import androidx.compose.material.icons.rounded.CurrencyPound
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.CurrencyYuan
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ghar.learn.composeselfsaidbanking.data.Currency
import ghar.learn.composeselfsaidbanking.theme.GreenStart

val currencies: List<Currency> = listOf(
    Currency(
        name = "USD",
        buy = 23.45f,
        sell = 24.00f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "YUAN",
        buy = 23.45f,
        sell = 24.00f,
        icon = Icons.Rounded.CurrencyYuan
    ),
    Currency(
        name = "EUR",
        buy = 25.45f,
        sell = 24.00f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "YEN",
        buy = 23.45f,
        sell = 24.00f,
        icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        name = "STR",
        buy = 23.45f,
        sell = 24.00f,
        icon = Icons.Rounded.CurrencyPound
    ),
    Currency(
        name = "FR",
        buy = 23.45f,
        sell = 24.00f,
        icon = Icons.Rounded.CurrencyFranc
    ),
    Currency(
        name = "USD",
        buy = 23.45f,
        sell = 24.00f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "YUAN",
        buy = 23.45f,
        sell = 24.00f,
        icon = Icons.Rounded.CurrencyYuan
    ),
    Currency(
        name = "EUR",
        buy = 18.45f,
        sell = 19.00f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "YEN",
        buy = 2.45f,
        sell = 2.50f,
        icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        name = "STR",
        buy = 3.45f,
        sell = 4.00f,
        icon = Icons.Rounded.CurrencyPound
    ),
    Currency(
        name = "FR",
        buy = 1.45f,
        sell = 1.50f,
        icon = Icons.Rounded.CurrencyFranc
    )
)

@Preview
@Composable
fun CurrenciesSection() {
    var isVisible by remember {                 // memorizes the state
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 18.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        iconState = if (isVisible) {
                            Icons.Rounded.KeyboardArrowUp
                        } else {
                            Icons.Rounded.KeyboardArrowDown
                        }
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = iconState,
                        contentDescription = "Currencies",
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }
                Spacer(Modifier.width(16.dp))
                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold
                )
            }
            // Outside Row of Control icon with state (isVisible)
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            )

            // handle state (isVisible) to hide / show
            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    val boxWithConstraintsScope = this
                    val width = boxWithConstraintsScope.maxWidth / 3            // for 3-Column

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                            .padding(horizontal = 12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                modifier = Modifier.width(width),
                                text = "Currency",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                            Text(
                                modifier = Modifier.width(width - 4.dp),
                                text = "Buy",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                            Text(
                                modifier = Modifier.width(width),
                                text = "Sell",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        // data under the Row for the currencies columns (03)
                        LazyColumn() {
                            items(currencies.size) { index ->
                                CurrencyItem(index, width.div(1.2f))
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun CurrencyItem(index: Int, width: Dp) {
    val currency = currencies[index]
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.width(width - 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = currency.icon,
                    contentDescription = currency.name,
                    tint = Color.White
                )
            }

            // display values for individual heads:
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = currency.name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text =" $${ currency.buy }",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text =" $${ currency.sell }",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}
