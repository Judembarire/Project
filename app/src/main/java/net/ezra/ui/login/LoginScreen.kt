package net.ezra.ui.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.ui.auth.AuthHeader


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    LazyColumn {
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = "",

                    modifier = Modifier
                        .fillMaxSize(),

                    contentScale = ContentScale.Crop


                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),

                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Image(
                        modifier = Modifier
                            .size(128.dp, 128.dp)
                            .background(Color.Transparent)
                            .clip(CircleShape),

                        painter = painterResource(id = R.drawable.leaf),
                        contentDescription = ""
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    var name by remember {
                        mutableStateOf(TextFieldValue(""))
                    }

                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text(text = "Enter name") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = ""
                            )
                        },

                        )



                    Spacer(modifier = Modifier.height(15.dp))


                    var email by remember {
                        mutableStateOf(TextFieldValue(""))
                    }

                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = "Enter email") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = ""
                            )
                        },
                    )


                    Spacer(modifier = Modifier.height(10.dp))


                    var pin by remember {
                        mutableStateOf(TextFieldValue(""))
                    }

                    OutlinedTextField(

                        value = pin,
                        onValueChange = { pin = it },
                        label = { Text(text = "Enter pin") },
                        textStyle = TextStyle(Color.Magenta),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color.Black,
                            focusedBorderColor = Color.Red,
                            unfocusedLabelColor = Color.Black,
                            focusedLabelColor = Color.Red,
                            cursorColor = Color.Red

                        )

                    )

                    Spacer(modifier = Modifier.height(23.dp))

                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Submit",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(7.dp),

                            )
                    }

                    Spacer(modifier = Modifier.height(23.dp))


                    Text(
                        modifier = Modifier

                            .clickable {
                                navController.navigate(ROUTE_HOME) {
                                    popUpTo(ROUTE_LOGIN) { inclusive = true }
                                }
                            } ,
                                text = "Don't Have An Account?",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface
                    )


                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    LoginScreen(rememberNavController())
}

