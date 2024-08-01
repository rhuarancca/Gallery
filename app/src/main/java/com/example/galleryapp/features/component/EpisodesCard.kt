@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.galleryapp.features.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.galleryapp.R

@Composable
fun EpisodesCard(
    modifier: Modifier = Modifier,
    name: String,
    date: String,
    episode: String,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ) {
        ConstraintLayout(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
            val (title, textDate, textEpisode, image) = createRefs()

            TextComp(
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
                text = "Episode Name: $name",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground
            )
            TextComp(
                modifier = Modifier.constrainAs(textDate) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                },
                text = "Date: $date",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground,
            )
            TextComp(
                modifier = Modifier.constrainAs(textEpisode) {
                    top.linkTo(textDate.bottom)
                    start.linkTo(parent.start)
                },
                text = "Episode: $episode",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground,
            )

            Image(
                modifier = Modifier.constrainAs(image) {
                    top.linkTo(parent.top, margin = 16.dp)
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                    end.linkTo(parent.end)
                },
                painter = painterResource(id = R.drawable.ic_arrow_right_icon),
                contentDescription = "",
                contentScale = ContentScale.Inside
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BodyPreview() {
    EpisodesCard(
        modifier = Modifier,
        name = "Rick and Morty",
        date = "2020-03-19",
        episode = "S01E01",
    )
}