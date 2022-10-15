package com.example.cake.ui.theme

import android.graphics.fonts.FontFamily
import android.graphics.fonts.FontStyle
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily.Companion.Monospace
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cake.R

@Composable
fun CaloriesScreen(
    modifier: Modifier = Modifier,
    viewModel: CakeViewModel = viewModel()
) {
    val cal: String = viewModel.calculateCalories().toString()
    val image= painterResource(R.drawable.thankyou)
    Box {


        //val cal: String = viewModel.calculateCalories().toString()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize(),

            )
        {
            Text(
                text = stringResource(R.string.calories_consumed) + " " + cal + "!",
                fontSize = 30.sp,
                fontWeight = FontWeight.W800,
                modifier= Modifier
                    .padding(start=45.dp)
            )
            //  Spacer(modifier = Modifier.height(5.dp))
            Image(
                painter=image,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(start = 0.dp)
                    .border(
                        BorderStroke(5.dp, Color(105, 205, 216)),
                        shape = RoundedCornerShape(4.dp) //frame
                    )
                    .padding(18.dp) // for the border padding

            )
        }
    }
}

@Composable
fun BackgroundImage() {
    val image= painterResource(R.drawable.thank1)
    Box {
        Image(
            painter=image,
            contentDescription= null,
            modifier= Modifier
                .wrapContentWidth()
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        CaloriesScreen()
    }
}

@Preview
@Composable
fun CaloriesScreenPreview() {
    BackgroundImage()
}