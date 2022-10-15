package com.example.cake.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import com.example.cake.R
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

class StartScreen(onNextButtonClicked: () -> Unit) {

}

@Composable
fun StartScreen(
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
            text = stringResource(R.string.cake_zero),
            fontSize = 18.sp

        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(R.drawable.cake_zero),
            contentDescription = stringResource(R.string.cake_zero_content_description),
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
fun StartPreview() {
    StartScreen(onNextButtonClicked = { }, modifier = Modifier)
}