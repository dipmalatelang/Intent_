package com.example.intent_intentfilter

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.intent_intentfilter.ui.theme.Intent_IntentFilterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Intent_IntentFilterTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {

                        //explicit Intent example
                        //TO GO one Activity to Another....

                      /*  Intent(applicationContext, SecondActivity::class.java).also {
                            startActivity(it)
                        }*/

                        //.............

                        //Activity to another app eg youtube

                        Intent(Intent.ACTION_MAIN).also {
                            it.`package`="com.google.android.youtube"

                            try {
                                startActivity(it)
                                } catch (e: ActivityNotFoundException){
                                e.printStackTrace()
                                 }

                           /* if(it.resolveActivity(packageManager) != null){
                                startActivity(it)
                            }*/


                        }

                        //.....
                    }) {
                        Text(text = "Click Me ")
                    }

                }

            }
        }
    }
}




