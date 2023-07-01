package com.example.intent_intentfilter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import com.example.intent_intentfilter.ui.theme.Intent_IntentFilterTheme

class SecondActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

   setContent{
       Intent_IntentFilterTheme {
           Text(text="second Activity")

       }
   }
    }
}