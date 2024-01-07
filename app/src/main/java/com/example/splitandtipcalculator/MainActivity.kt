package com.example.splitandtipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.splitandtipcalculator.components.InputField
import com.example.splitandtipcalculator.ui.theme.SplitAndTipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplitAndTipCalculatorTheme {
                My_app()



            }
        }
    }
}

@Preview
@Composable
fun My_app(){
    Surface(
        modifier = Modifier.fillMaxSize(),

    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            TopHeader(134.134)

            Bottom_panel()







        }
    }



}

@Composable
private fun Bottom_panel() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        //shadowElevation = 4.dp,
        border = BorderStroke(1.dp, Color.Gray)
    ) {

        val curr  = remember {
            mutableStateOf("")
        }

        Column(modifier = Modifier.fillMaxSize()) {

            Column(modifier = Modifier.fillMaxSize()) {

                InputField(
                    valueState = curr,
                    labelId = "hello",
                    enable = true,
                    singleLine = true
                )



            }



        }





    }
}

@Composable
private fun TopHeader(perPersonValue: Double = 0.0) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2f / 1f)
            .padding(24.dp, 28.dp, 24.dp, 0.dp),
        shape = RoundedCornerShape(12.dp),
        color = colorResource(id = R.color.boxcolor),
       // shadowElevation = 1.dp,
        //tonalElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Total Per Person",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            //variable create for format maintain 2 number after a decimal

            val formattedData = "%.2f".format(perPersonValue)

            Text(
                text = "\$$formattedData",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )


        }


    }
}
