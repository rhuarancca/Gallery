package com.example.galleryapp.features.screen.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.galleryapp.R
import com.merttoptas.composebase.R
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.galleryapp.BuildConfig
import com.example.galleryapp.features.component.Scaffold
import com.example.galleryapp.features.component.TextComp
import com.example.galleryapp.features.component.TopBar

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val scaffoldState = rememberScaffoldState()
    val viewState by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                text = stringResource(id = R.string.settings_screen_title),
                elevation = 10.dp,
            )
        },
        content = {
            Content(
                isDark = viewState.isDark,
                onTriggerEvent = {
                    viewModel.onTriggerEvent(it)
                }
            )
        },
        backgroundColor = MaterialTheme.colors.background
    )

}

@Composable
private fun Content(
    isDark: Boolean = false,
    onTriggerEvent: (SettingsViewEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .border(
                    border = BorderStroke(width = 1.dp, color = Color.LightGray),
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                TextComp(
                    text = stringResource(id = R.string.settings_dark_theme),
                    style = MaterialTheme.typography.body2
                )

                Switch(
                    checked = isDark,
                    onCheckedChange = {
                        onTriggerEvent.invoke(SettingsViewEvent.OnChangeTheme)
                    })
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                TextComp(
                    text = stringResource(id = R.string.settings_screen_app_version_title),
                    style = MaterialTheme.typography.body2
                )

                TextComp(
                    text = BuildConfig.VERSION_NAME,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}
