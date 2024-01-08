package com.example.splitandtipcalculator

import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
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
            var split by remember { mutableIntStateOf(0) }
            TopHeader(134.555)




            Bottom_panel(split = split, onupdate = {updatedSplit ->
                if (split==0 && updatedSplit == split-1){
                    split = 0
                }
                else{
                    split = updatedSplit
                }
                }
            )




        }
    }



}

fun ankit (curr : MutableState<String>){
    Log.d("tt", curr.value)
}


@Composable
private fun Bottom_panel(split : Int , onupdate:(Int)->Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        //shadowElevation = 4.dp,
        border = BorderStroke(1.dp, Color.Gray)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            InputTextField()
            splitRowCreator(onupdate, split)




        }



    }

}

@Composable
private fun splitRowCreator(onupdate: (Int) -> Unit, split: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Split")

        // Spacer(modifier = Modifier.width(120.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Plush_minusIcon(imageVector = Icons.Rounded.Remove) {
                onupdate(split - 1)
            }

            Text(
                text = "$split",
                modifier = Modifier
                    .wrapContentWidth()
                    .width(58.dp),
                maxLines = 1,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Visible
            )

            Plush_minusIcon(imageVector = Icons.Rounded.Add) {
                onupdate(split + 1)
            }


        }

    }
}


@Composable
private fun Plush_minusIcon(imageVector: ImageVector,onClick : ()->Unit) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .clickable { onClick() },

        shape = CircleShape,
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {

        Icon(
            imageVector = imageVector,
            contentDescription = "",
            modifier = Modifier
                .size(58.dp)
                .padding(4.dp)
        )
    }
}


@Composable
private fun InputTextField() {
    val curr = remember {
        mutableStateOf("")
    }


    InputField(
        valueState = curr,
        labelId = "Bill Amount",
        enable = true,
        singleLine = true,
        placeholder = "Enter your bill amount",
        onAction = KeyboardActions { if (curr.value.trim().isNotEmpty()) ankit(curr) }
    )
}






@Composable
private fun TopHeader(perPersonValue:Double= 0.0) {
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
