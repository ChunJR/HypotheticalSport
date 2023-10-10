package com.chun.hypotheticalsport.presentation.match

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.VideoFrameDecoder
import com.chun.hypotheticalsport.R
import com.chun.hypotheticalsport.domain.model.Match
import com.chun.hypotheticalsport.presentation.common.EmptyScreen
import com.chun.hypotheticalsport.presentation.common.ShimmerEffect
import com.chun.hypotheticalsport.ui.theme.IMAGE_HEIGHT
import com.chun.hypotheticalsport.ui.theme.LARGE_PADDING
import com.chun.hypotheticalsport.ui.theme.MEDIUM_PADDING
import com.chun.hypotheticalsport.ui.theme.Purple40
import com.chun.hypotheticalsport.ui.theme.PurpleGrey40
import com.chun.hypotheticalsport.ui.theme.PurpleGrey80

@ExperimentalFoundationApi
@Composable
fun MatchLazyColumn(
    state: State<MatchState>,
    modifier: Modifier = Modifier
) {
    val isValid = handleResult(state = state)
    if (isValid) {
        val matches = (state.value as MatchState.Success).matches
        LazyColumn(
            modifier = modifier
        ) {
            stickyHeader {
                CategoryHeader("Previous")
            }
            items(matches.previous) { previousMatch ->
                CategoryItem(previousMatch)
            }
            stickyHeader {
                CategoryHeader("Upcoming")
            }
            items(matches.upcoming) { upcomingMatch ->
                CategoryItem(upcomingMatch)
            }
        }
    }
}

@Composable
private fun CategoryHeader(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth()
            .background(PurpleGrey40)
            .padding(start = 16.dp, top = 10.dp, bottom = 10.dp)
    )
}

@Composable
private fun CategoryItem(
    match: Match,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = 0.dp,
        backgroundColor = PurpleGrey80
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = modifier
                    .padding(10.dp),
                text = match.description,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        start = MEDIUM_PADDING,
                        end = MEDIUM_PADDING,
                        bottom = MEDIUM_PADDING
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val imageLoader = ImageLoader.Builder(LocalContext.current)
                    .components {
                        add(VideoFrameDecoder.Factory())
                    }
                    .crossfade(true)
                    .build()
                val painter = rememberAsyncImagePainter(
                    model = match.highlights,
                    imageLoader = imageLoader,
                    error = painterResource(id = R.drawable.coming_soon)
                )
                Box (
                    modifier = modifier.weight(1.0f, true),
                ) {
                    Surface(shape = RoundedCornerShape(size = LARGE_PADDING)) {
                        Image(
                            modifier = modifier
                                .height(IMAGE_HEIGHT)
                                .fillMaxWidth()
                                .align(Alignment.Center),
                            painter = painter,
                            contentDescription = stringResource(id = R.string.match_highlight),
                            contentScale = ContentScale.Inside,
                        )
                    }
                    if (match.highlights != null) {
                        PlayButton()
                    } else {
                        AlarmButton()
                    }
                }
                Spacer(modifier = modifier.size(16.dp))
                Column(
                    modifier = modifier.weight(2.0f, true),
                ) {
                    Text(
                        text = "Date: " + match.date,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        text = "Home: " + match.home,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        text = "Away: " + match.away,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    match.winner?.let {
                        Text(
                            text = "Winner: " + match.winner,
                            fontSize = 14.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BoxScope.PlayButton(
    modifier: Modifier = Modifier,
) {
    IconButton(
        modifier = modifier
            .align(Alignment.Center)
            .size(30.dp)
            .background(Purple40, shape = CircleShape),
        onClick = { }
    ) {
        Icon(
            imageVector = Icons.Default.PlayArrow,
            tint = Color.White,
            contentDescription = stringResource(id = R.string.play_button),
        )
    }
}

@Composable
fun BoxScope.AlarmButton(
    modifier: Modifier = Modifier,
) {
    IconButton(
        modifier = modifier
            .align(Alignment.Center)
            .size(30.dp)
            .background(Purple40, shape = CircleShape),
        onClick = { }
    ) {
        Icon(
            imageVector = Icons.Default.DateRange,
            tint = Color.White,
            contentDescription = stringResource(id = R.string.alarm_button),
        )
    }
}

@Composable
fun handleResult(
    state: State<MatchState>,
): Boolean {
    return when (state.value) {
        is MatchState.Success -> true
        is MatchState.Loading -> {
            ShimmerEffect()
            false
        }
        is MatchState.Error -> {
            val message = (state.value as MatchState.Error).errorMessage
            EmptyScreen(message)
            false
        }
    }
}