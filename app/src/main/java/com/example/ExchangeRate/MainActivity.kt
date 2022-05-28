package com.example.ExchangeRate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ExchangeRate.ui.theme.TestRetrofitTheme
import com.example.ExchangeRate.ui.theme.first
import com.example.ExchangeRate.ui.theme.second
import com.example.ExchangeRate.ui.theme.third

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(modifier = Modifier
                    .background(first)
                    .height(300.dp)
                    .weight(1f)) { Official() }
                Box(modifier = Modifier
                    .background(second)
                    .height(300.dp)
                    .weight(1f)) { Qiwi() }
                Box(
                    modifier = Modifier
                        .background(third)
                        .height(300.dp)
                        .weight(1f)
                ) { Aliexpress() }
            }
            Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
                val label = remember { mutableStateOf("Где выгоднее") }
                Button(onClick = { label.value = "Через киви" }) {
                    Text(label.value, fontSize = 25.sp)
                }
            }
        }
    }
}
@Composable
fun Official() {
    Text(
        text = "Курс ЦБ",
        fontSize = 20.sp,
        textAlign = Center
    )
}

@Composable
fun Qiwi() {
    Text(
        text = "Курс с киви",
        fontSize = 20.sp,
        textAlign = Center
    )
}

@Composable
fun Aliexpress() {
    Text(
        text = "Курс на алиэкспресс",
        fontSize = 20.sp,
        textAlign = Center
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestRetrofitTheme {

    }
}