package net.ezra.ui.myplant


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantScreen(
    navController: NavHostController
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x2C08F511))
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(bottomEnd = 15.dp , bottomStart = 15.dp))

            ) {
                    val context = LocalContext.current.applicationContext
                    TopAppBar(
                        title = { Text(text = "MyPlants") },
                        navigationIcon = {
                            IconButton(onClick = {
                                Toast.makeText(
                                    context,
                                    "You have clicked a home Icon",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }) {
                                Image(
                                    modifier = Modifier
                                        .size(80.dp, 80.dp)
                                        .background(Color.Transparent)
                                        .clip(CircleShape),

                                    painter = painterResource(id = R.drawable.leaf),
                                    contentDescription = ""
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0x2C08F511),
                            titleContentColor = Color.Black,
                            navigationIconContentColor = Color.Black
                        ),
                        actions = {
                            IconButton(onClick = {
                                Toast.makeText(
                                    context,
                                    "You have clicked on the search Icon",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "search",
                                    tint = Color.White
                                )
                            }

                            IconButton(onClick = {
                                Toast.makeText(
                                    context,
                                    "You have clicked on the person Icon",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "person",
                                    tint = Color.White
                                )

                            }
                        })
                }

            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)

            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .padding(7.dp),

                    colors = CardDefaults.cardColors(
                        Color.White
                    )

                ) {
               Column(
                   modifier = Modifier
                       .fillMaxWidth()
                       .height(90.dp)
               ) {
                   Row(
                       modifier = Modifier
                           .fillMaxWidth()
                           .height(90.dp)
                           .padding(2.dp)
                   ) {
                     Column {
                        Row {
                            Card(
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(40.dp),
                                colors = CardDefaults.cardColors(Color(0xffffffff))

                            ) {
                             Text(
                                 "Spider Plant",
                                 fontSize = 25.sp,
                                 fontFamily = FontFamily.Cursive,
                                 fontWeight = FontWeight.Bold
                                 )
                            }
                        }
                         Spacer(modifier = Modifier.height(7.dp))

                         Row {
                             Card(
                                 modifier = Modifier
                                     .width(250.dp)
                                     .height(35.dp),
                                 colors = CardDefaults.cardColors(Color(0xffffffff))

                             ) {
                                 Image(
                                     modifier = Modifier
                                         .size(40.dp, 40.dp)
                                         .background(Color.Transparent)
                                         .clip(CircleShape),

                                     painter = painterResource(id = R.drawable.waterdrop),
                                     contentDescription = ""
                                 )
                             }
                         }
                       }

                       Spacer(modifier = Modifier.width(25.dp))

                     Column{
                         Card(
                             modifier = Modifier
                                 .width(107.dp)
                                 .height(90.dp),
                             colors = CardDefaults.cardColors(Color(0xffffffff))

                         ) {
                             Image(
                                 modifier = Modifier
                                     .size(150.dp, 150.dp)
                                     .background(Color.Transparent)
                                 .clip(RoundedCornerShape(16.dp)),

                                 painter = painterResource(id = R.drawable.spiderplant),
                                 contentDescription = ""
                             )
                         }
                     }
                   }
                  }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)

            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .padding(7.dp),

                    colors = CardDefaults.cardColors(
                        Color.White
                    )

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .padding(2.dp)
                        ) {
                            Column {
                                Row {
                                    Card(
                                        modifier = Modifier
                                            .width(200.dp)
                                            .height(40.dp),
                                        colors = CardDefaults.cardColors(Color(0xffffffff))

                                    ) {
                                        Text(
                                            "Chinese Evergreen",
                                            fontSize = 25.sp,
                                            fontFamily = FontFamily.Cursive,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(7.dp))

                                Row {
                                    Card(
                                        modifier = Modifier
                                            .width(250.dp)
                                            .height(35.dp)

                                    ) {

                                    }
                                }
                            }

                            Spacer(modifier = Modifier.width(25.dp))

                            Column{
                                Card(
                                    modifier = Modifier
                                        .width(107.dp)
                                        .height(90.dp)

                                ) {

                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)

            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .padding(7.dp),

                    colors = CardDefaults.cardColors(
                        Color.White
                    )

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .padding(2.dp)
                        ) {
                            Column {
                                Row {
                                    Card(
                                        modifier = Modifier
                                            .width(200.dp)
                                            .height(40.dp)

                                    ) {

                                    }
                                }
                                Spacer(modifier = Modifier.height(7.dp))

                                Row {
                                    Card(
                                        modifier = Modifier
                                            .width(250.dp)
                                            .height(35.dp)

                                    ) {

                                    }
                                }
                            }

                            Spacer(modifier = Modifier.width(25.dp))

                            Column{
                                Card(
                                    modifier = Modifier
                                        .width(107.dp)
                                        .height(90.dp)

                                ) {

                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)

            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .padding(7.dp),

                    colors = CardDefaults.cardColors(
                        Color.White
                    )

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .padding(2.dp)
                        ) {
                            Column {
                                Row {
                                    Card(
                                        modifier = Modifier
                                            .width(200.dp)
                                            .height(40.dp)

                                    ) {

                                    }
                                }
                                Spacer(modifier = Modifier.height(7.dp))

                                Row {
                                    Card(
                                        modifier = Modifier
                                            .width(250.dp)
                                            .height(35.dp)

                                    ) {

                                    }
                                }
                            }

                            Spacer(modifier = Modifier.width(25.dp))

                            Column{
                                Card(
                                    modifier = Modifier
                                        .width(107.dp)
                                        .height(90.dp)

                                ) {

                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)

            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .padding(7.dp),

                    colors = CardDefaults.cardColors(
                        Color.White
                    )

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .padding(2.dp)
                        ) {
                            Column {
                                Row {
                                    Card(
                                        modifier = Modifier
                                            .width(200.dp)
                                            .height(40.dp)

                                    ) {

                                    }
                                }
                                Spacer(modifier = Modifier.height(7.dp))

                                Row {
                                    Card(
                                        modifier = Modifier
                                            .width(250.dp)
                                            .height(35.dp)

                                    ) {

                                    }
                                }
                            }

                            Spacer(modifier = Modifier.width(25.dp))

                            Column{
                                Card(
                                    modifier = Modifier
                                        .width(107.dp)
                                        .height(90.dp)

                                ) {

                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)

            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .padding(7.dp),

                    colors = CardDefaults.cardColors(
                        Color.White
                    )

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .padding(2.dp)
                        ) {
                            Column {
                                Row {
                                    Card(
                                        modifier = Modifier
                                            .width(200.dp)
                                            .height(40.dp)

                                    ) {

                                    }
                                }
                                Spacer(modifier = Modifier.height(7.dp))

                                Row {
                                    Card(
                                        modifier = Modifier
                                            .width(250.dp)
                                            .height(35.dp)

                                    ) {

                                    }
                                }
                            }

                            Spacer(modifier = Modifier.width(25.dp))

                            Column{
                                Card(
                                    modifier = Modifier
                                        .width(107.dp)
                                        .height(90.dp)

                                ) {

                                }
                            }
                        }
                    }
                }
            }






        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    PlantScreen(rememberNavController())
}