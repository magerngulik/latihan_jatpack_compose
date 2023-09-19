package com.example.testingjackpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.Blue),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 200.dp, height = 100.dp) // Tentukan lebar dan tinggi
                            .background(
                                color = Color.Red,
                                shape = RoundedCornerShape(16.dp)
                            ) // Tentukan warna latar belakang

                    ) {
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "data kosong")

                }
            }

        }
    }

    @Composable
    fun QFormScreen() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 10.dp)
        ) {
            CostomeTextFieldRadius(
                label = "Password",
                initialText = "",
                leadingIcon = Icons.Default.Person,
                onTextChange = {
                    println(it)
                },
                type = KeyboardType.Email, textFieldColor = Color.Red
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))

        }
    }

    @Composable
    fun CostomeTextFieldRadius(
        label: String,
        initialText: String,
        onTextChange: (String) -> Unit,
        leadingIcon: ImageVector,
        type: KeyboardType,
        textFieldColor: Color = Color.White //
    ) {
        var name by remember {
            mutableStateOf(initialText)
        }
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "${label}")
            Spacer(modifier = Modifier.padding(bottom = 5.dp))
            TextField(
                value = name,
                keyboardOptions = KeyboardOptions(
                    keyboardType = type
                ),
                onValueChange = {
                    name = it
                    onTextChange(it) // Memanggil callback saat teks berubah
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(textFieldColor),

                leadingIcon = {
                    // Menggunakan ImageVector yang diteruskan melalui parameter
                    Icon(imageVector = leadingIcon, contentDescription = "User Icon")
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Blue, // Warna garis penunjuk saat fokus
                    unfocusedIndicatorColor = Color.Gray, // Warna garis penunjuk saat tidak fokus
                    errorIndicatorColor = Color.Red, // Warna garis penunjuk saat kesalahan
                    cursorColor = Color.Black, // Warna kursor
                    disabledTextColor = Color.Gray, // Warna teks saat nonaktif
                ),
            )
        }
    }


    @Preview
    @Composable
    fun SimpleComposablePreview() {
        QFormScreen()
    }


}
