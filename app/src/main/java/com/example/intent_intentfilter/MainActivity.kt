package com.example.intent_intentfilter

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import coil.compose.AsyncImage
import com.example.intent_intentfilter.ui.theme.Intent_IntentFilterTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ImageViewModel> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Intent_IntentFilterTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    viewModel.uri?.let{
                        AsyncImage(model =viewModel.uri,contentDescription=null)
                    }
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


// Implicit Intent....
                       val intent = Intent(Intent.ACTION_SEND).apply {
                            type ="text/plain"
                            putExtra(Intent.EXTRA_EMAIL, arrayOf("test@test.com"))
                            putExtra(Intent.EXTRA_SUBJECT,"This is my subject")
                            putExtra(Intent.EXTRA_TEXT,"This is the Content of my email")
                        }
                        if (intent.resolveActivity(packageManager) != null)
                        {
                            startActivity(intent)
                        }
                    }) {
                        Text(text = "Click Me ")
                    }

                }

            }
        }


    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
        } else {
            intent?.getParcelableExtra(Intent.EXTRA_STREAM)
        }
        viewModel.updateUri(uri)
    }
}




