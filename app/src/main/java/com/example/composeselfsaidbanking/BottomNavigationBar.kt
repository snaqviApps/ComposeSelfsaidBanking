package com.example.composeselfsaidbanking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeselfsaidbanking.data.BottomNavigation

val items : List<BottomNavigation> = listOf(
    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Home
    ),
    BottomNavigation(
        title = "Wallet",
        icon = Icons.Rounded.Wallet
    ),
    BottomNavigation(
        title = "Notifications",
        icon = Icons.Rounded.Notifications
    ),
    BottomNavigation(
        title = "Accounts",
        icon = Icons.Rounded.AccountCircle
    )
)

@Preview
@Composable
fun BottomNavigationBar(){
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)      // color of bottom-navigationBar,
        ) {
            items.forEachIndexed { index, bottomNavigationItem ->
                NavigationBarItem(
                    selected = index == 0,          // as no action on 'clicking'
                    onClick = {  },                 // no action is being taken
                    icon = {
                        Icon(
                            imageVector = bottomNavigationItem.icon,
                            contentDescription = bottomNavigationItem.title,
                            tint = MaterialTheme.colorScheme.background
                        )
                    },
                    label = {
                        Text(
                            text = bottomNavigationItem.title,
                            color = MaterialTheme.colorScheme.background
                        )
                    }
                )
            }
        }
    }
}
