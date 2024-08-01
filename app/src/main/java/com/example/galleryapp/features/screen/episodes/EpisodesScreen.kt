package com.example.galleryapp.features.screen.episodes

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.galleryapp.features.component.*
import com.example.galleryapp.R
import com.example.galleryapp.data.model.EpisodesResultResponse
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun EpisodesScreen(
    viewModel: EpisodesViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val viewState = viewModel.uiState.collectAsState().value

    LaunchedEffect(viewModel.uiEvent) {
        launch {
            viewModel.uiEvent.collect {
                when (it) {
                    is EpisodesViewEvent.SnackBarError -> {
                        scaffoldState.snackbarHostState.showSnackbar(it.message.orEmpty())
                    }
                }
            }
        }
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                text = stringResource(id = R.string.episodes_screen_title),
                actions = {
                    IconButton(onClick = {
                    }) {
                    }
                },
                elevation = 10.dp,
            )
        },
        content = {
            Content(
                isLoading = viewState.isLoading,
                data = viewState.data,
            )
        }
    )
}

@Composable
private fun Content(
    isLoading: Boolean,
    data: List<EpisodesResultResponse>?,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            if (isLoading) {
                items(10) {
                    EpisodesShimmer()
                }
            } else {
                items(items = data ?: listOf()) { item ->
                    EpisodesCard(
                        name = item.name.orEmpty(),
                        date = item.airDate.orEmpty(),
                        episode = item.episode.orEmpty(),
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun DetailContentItemViewPreview() {
    EpisodesScreen(viewModel = hiltViewModel())
}