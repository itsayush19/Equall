package com.aktech.equall.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aktech.equall.screens.HomeScreen.presentation.HomeScreen
import com.aktech.equall.utils.EquallColors
import com.aktech.equall.utils.EquallIcons


enum class BottomNavItem(val label: String, val icon: ImageVector) {
    Home("Home", EquallIcons.Home),
    Loans("Loans", EquallIcons.Loans),
    Payments("Payments", EquallIcons.Payments),
    Profile("Profile", EquallIcons.Profile),
}

@Composable
@Preview
fun MainScreen() {
    MaterialTheme {
        var selectedNav by remember { mutableStateOf(BottomNavItem.Home) }

        Scaffold(
            containerColor = EquallColors.ScreenBg,
            topBar = { EquallTopBar() },
            bottomBar = {
                EquallBottomNavigation(
                    selected = selectedNav,
                    onSelect = { selectedNav = it },
                )
            },
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
            ) {
                when (selectedNav) {
                    BottomNavItem.Home -> HomeScreen()
                    BottomNavItem.Loans -> PlaceholderScreen("Loans")
                    BottomNavItem.Payments -> PlaceholderScreen("Payments")
                    BottomNavItem.Profile -> PlaceholderScreen("Profile")
                }
            }
        }
    }
}


@Composable
private fun EquallTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(EquallColors.Surface)
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Equall",
            color = EquallColors.Brand,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(EquallColors.Surface, CircleShape)
                .border(1.dp, EquallColors.Border, CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = EquallIcons.Notifications,
                contentDescription = "Notifications",
                tint = EquallColors.PillText,
                modifier = Modifier.size(20.dp),
            )
        }
    }
}


@Composable
private fun EquallBottomNavigation(
    selected: BottomNavItem,
    onSelect: (BottomNavItem) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(EquallColors.Surface)
            .navigationBarsPadding()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BottomNavItem.entries.forEach { item ->
            val active = item == selected
            val tint = if (active) EquallColors.Brand else EquallColors.NavInactive
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onSelect(item) }
                    .padding(horizontal = 12.dp, vertical = 4.dp),
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.label,
                    tint = tint,
                    modifier = Modifier.size(24.dp),
                )
                Text(
                    text = item.label,
                    color = tint,
                    fontSize = 12.sp,
                    fontWeight = if (active) FontWeight.SemiBold else FontWeight.Normal,
                )
            }
        }
    }
}


@Composable
private fun PlaceholderScreen(title: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = title,
            color = EquallColors.PillText,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }
}
