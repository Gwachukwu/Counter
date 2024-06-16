package com.jetbrains.spacetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Counter()
        }
    }
}

//@Preview
//@Composable
//fun AppAndroidPreview() {
//    App()
//}

@Preview
@Composable
fun Counter(){
    val count = remember {
        mutableIntStateOf(0)
    }
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
           Text(count.intValue.toString())
       }
        Row {
            Increment(count)
            Spacer(modifier = Modifier.width(16.dp))
            Decrement(count)
        }
    }
}

@Composable
fun Increment(count : MutableState<Int>){
 Button(onClick = { count.value++ }) {
     Text(text = "+")
 }  
}

@Composable
fun Decrement(count : MutableState<Int>){
    Button(onClick = { count.value-- }) {
        Text(text = "-")
    }
}
