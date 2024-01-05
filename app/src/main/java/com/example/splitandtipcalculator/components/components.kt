package com.example.splitandtipcalculator.components


import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@Composable

fun InputField(modifier : Modifier = Modifier,
               valueState : MutableState<String>,
               labelId : String,
               enable:Boolean,
               isSingleLine : Boolean,
               keyboardType : KeyboardType = KeyboardType.Number,
               imeAction: ImeAction = ImeAction.Go,
               onAction : KeyboardActions = KeyboardActions.Default
               ){


    OutlinedTextField(value = valueState.value,
        onValueChange = {valueState.value },
        leadingIcon = {Icon(imageVector = Icons.Rounded.AccountBox, contentDescription ="")},
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 18.sp),
        enabled = enable,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction

         )



}

