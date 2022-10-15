package com.example.cake.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cake.R

@Composable
fun Recipe2Screen(
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val labelResourceId = stringResource(R.string.next)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize(),

        )
    {
        Text(
            text = stringResource(R.string.cake_third),
            fontSize = 18.sp,
            modifier = Modifier
                .padding(start=50.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(R.drawable.cake_third),
            contentDescription = stringResource(R.string.chocolate_content_description),
            modifier = Modifier
                .wrapContentSize()
                .border(
                    BorderStroke(2.dp, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp) //frame
                )
                .padding(16.dp) // for the border padding
        )
        Button(
            onClick = onNextButtonClicked,
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text(labelResourceId)
        }
    }
}


@Preview
@Composable
fun Recipe2Preview() {
    Recipe2Screen(onNextButtonClicked = {}, modifier = Modifier)
}