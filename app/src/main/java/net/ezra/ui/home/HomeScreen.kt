package net.ezra.ui.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_GUIDE
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_PLANT
import net.ezra.navigation.ROUTE_VIEW


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen( navController: NavHostController){

    Scaffold(

        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //all contents of your screen must be placed within this column
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    item{
                        Box (
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(
                                    shape = RoundedCornerShape(
                                        bottomEnd = 15.dp,
                                        bottomStart = 15.dp
                                    )
                                )

                        ){
                            val context = LocalContext.current.applicationContext
                            androidx.compose.material3.TopAppBar(
                                title = { Text(text = "Planta") },
                                navigationIcon = {
                                    androidx.compose.material3.IconButton(onClick = {
                                        Toast.makeText(
                                            context,
                                            "You have clicked a home Icon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }) {
                                        Image(
                                            modifier = Modifier
                                                .size(100.dp, 100.dp)
                                                .background(Color.Transparent)
                                                .clip(CircleShape),

                                            painter = painterResource(id = R.drawable.leaf),
                                            contentDescription = ""
                                        )
                                        var search by rememberSaveable {
                                            mutableStateOf("")
                                        }

                                    }
                                },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = Color(0x2C08F511),
                                    titleContentColor = Color.Black,
                                    navigationIconContentColor = Color.Black
                                ),
                                actions = {
                                    androidx.compose.material3.IconButton(onClick = {
                                        Toast.makeText(
                                            context,
                                            "You have clicked on the search Icon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }) {
                                        androidx.compose.material3.Icon(
                                            imageVector = Icons.Filled.Search,
                                            contentDescription = "search",
                                            tint = Color.White
                                        )
                                    }

                                    androidx.compose.material3.IconButton(onClick = {
                                        Toast.makeText(
                                            context,
                                            "You have clicked on the person Icon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }) {
                                        androidx.compose.material3.Icon(
                                            imageVector = Icons.Filled.Person,
                                            contentDescription = "person",
                                            tint = Color.White
                                        )

                                    }
                                })
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text("Your plants",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(7.dp)

                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp),
                            Arrangement.Bottom
                        ) {
                            Text("see more...",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Light,
                                textAlign = TextAlign.Right,
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate(ROUTE_PLANT) {
                                            popUpTo(ROUTE_HOME) { inclusive = true }
                                        }
                                    }
                            )
                        }


                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp)
                        ) {
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(140.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(120.dp)
                                            .padding(2.dp)
                                    ) {
                                        Column{
                                            Card(
                                                modifier = Modifier
                                                    .width(110.dp)
                                                    .height(130.dp),
                                                colors = CardDefaults.cardColors(Color(0xffffffff))

                                            ) {
                                                Image(
                                                    modifier = Modifier
                                                        .size(150.dp, 150.dp)
                                                        .background(Color.Transparent)
                                                        .clip(RoundedCornerShape(16.dp))
                                                        .clickable {
                                                            navController.navigate(ROUTE_VIEW) {
                                                                popUpTo(ROUTE_HOME) { inclusive = true }
                                                            }
                                                        },

                                                    painter = painterResource(id = R.drawable.spiderplant),
                                                    contentDescription = ""
                                                )
                                            }
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.width(25.dp))

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(140.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(120.dp)
                                            .padding(2.dp)
                                    ) {
                                        Column{
                                            Card(
                                                modifier = Modifier
                                                    .width(110.dp)
                                                    .height(130.dp),
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

                                Spacer(modifier = Modifier.width(25.dp))

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(140.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(120.dp)
                                            .padding(2.dp)
                                    ) {
                                        Column{
                                            Card(
                                                modifier = Modifier
                                                    .width(110.dp)
                                                    .height(130.dp),
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

                                Spacer(modifier = Modifier.width(25.dp))

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(140.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(120.dp)
                                            .padding(2.dp)
                                    ) {
                                        Column{
                                            Card(
                                                modifier = Modifier
                                                    .width(110.dp)
                                                    .height(130.dp),
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

                        Spacer(modifier = Modifier.height(30.dp))

                        Column(
                            modifier = Modifier
                                .height(40.dp)
                                .fillMaxWidth()
                        ){
                            Text("Popular Plants",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(7.dp)
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .padding(5.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .padding(2.dp)
                            ) {
                                Column{
                                    Card(
                                        modifier = Modifier
                                            .width(150.dp)
                                            .height(130.dp),
                                        colors = CardDefaults.cardColors(Color(0xFF746F6F))

                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .height(130.dp)
                                                .width(150.dp),
                                            contentAlignment = Alignment.BottomStart
                                        ) {

                                            Image(
                                                modifier = Modifier
                                                    .background(Color.Transparent)
                                                    .clip(RoundedCornerShape(16.dp))
                                                    .fillMaxSize()
                                                    .clickable {
                                                        navController.navigate(ROUTE_GUIDE) {
                                                            popUpTo(ROUTE_HOME) { inclusive = true }
                                                        }
                                                    },

                                                painter = painterResource(id = R.drawable.spiderplant),
                                                contentDescription = "",


                                                contentScale = ContentScale.Crop

                                            )
                                            Text(
                                                text = "Spiderplant",
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold,

                                                modifier = Modifier.padding(7.dp)

                                                )
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.width(40.dp))

                                Column{
                                    Card(
                                        modifier = Modifier
                                            .width(150.dp)
                                            .height(130.dp),
                                        colors = CardDefaults.cardColors(Color(0xFF746F6F))

                                    ) {
//                        Image(
//                            modifier = Modifier
//                                .size(150.dp, 150.dp)
//                                .background(Color.Transparent)
//                                .clip(RoundedCornerShape(16.dp)),
//
//                            painter = painterResource(id = R.drawable.spiderplant),
//                            contentDescription = ""
//                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .padding(5.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .padding(2.dp)
                            ) {
                                Column{
                                    Card(
                                        modifier = Modifier
                                            .width(180.dp)
                                            .height(130.dp),
                                        colors = CardDefaults.cardColors(Color(0xFF746F6F))

                                    ) {
//                        Image(
//                            modifier = Modifier
//                                .size(150.dp, 150.dp)
//                                .background(Color.Transparent)
//                                .clip(RoundedCornerShape(16.dp)),
//
//                            painter = painterResource(id = R.drawable.spiderplant),
//                            contentDescription = ""
//                        )
                                    }
                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                Column{
                                    Card(
                                        modifier = Modifier
                                            .width(180.dp)
                                            .height(130.dp),
                                        colors = CardDefaults.cardColors(Color(0xFF746F6F))

                                    ) {
//                        Image(
//                            modifier = Modifier
//                                .size(150.dp, 150.dp)
//                                .background(Color.Transparent)
//                                .clip(RoundedCornerShape(16.dp)),
//
//                            painter = painterResource(id = R.drawable.spiderplant),
//                            contentDescription = ""
//                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .padding(5.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .padding(2.dp)
                            ) {
                                Column{
                                    Card(
                                        modifier = Modifier
                                            .width(180.dp)
                                            .height(130.dp),
                                        colors = CardDefaults.cardColors(Color(0xFF746F6F))

                                    ) {
//                        Image(
//                            modifier = Modifier
//                                .size(150.dp, 150.dp)
//                                .background(Color.Transparent)
//                                .clip(RoundedCornerShape(16.dp)),
//
//                            painter = painterResource(id = R.drawable.spiderplant),
//                            contentDescription = ""
//                        )
                                    }
                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                Column{
                                    Card(
                                        modifier = Modifier
                                            .width(180.dp)
                                            .height(130.dp),
                                        colors = CardDefaults.cardColors(Color(0xFF746F6F))

                                    ) {
//                        Image(
//                            modifier = Modifier
//                                .size(150.dp, 150.dp)
//                                .background(Color.Transparent)
//                                .clip(RoundedCornerShape(16.dp)),
//
//                            painter = painterResource(id = R.drawable.spiderplant),
//                            contentDescription = ""
//                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .padding(5.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .padding(2.dp)
                            ) {
                                Column{
                                    Card(
                                        modifier = Modifier
                                            .width(180.dp)
                                            .height(130.dp),
                                        colors = CardDefaults.cardColors(Color(0xFF746F6F))

                                    ) {
//                        Image(
//                            modifier = Modifier
//                                .size(150.dp, 150.dp)
//                                .background(Color.Transparent)
//                                .clip(RoundedCornerShape(16.dp)),
//
//                            painter = painterResource(id = R.drawable.spiderplant),
//                            contentDescription = ""
//                        )
                                    }
                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                Column{
                                    Card(
                                        modifier = Modifier
                                            .width(180.dp)
                                            .height(130.dp),
                                        colors = CardDefaults.cardColors(Color(0xFF746F6F))

                                    ) {
//                        Image(
//                            modifier = Modifier
//                                .size(150.dp, 150.dp)
//                                .background(Color.Transparent)
//                                .clip(RoundedCornerShape(16.dp)),
//
//                            painter = painterResource(id = R.drawable.spiderplant),
//                            contentDescription = ""
//                        )
                                    }
                                }
                            }
                        }




                    }
                }
            }

            },

                bottomBar = { BottomBar()  }
    )



}



@Composable
fun BottomBar() {

        val selectedIndex = remember { mutableStateOf(0) }
        BottomNavigation(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(topEnd = 20.dp , topStart = 20.dp))
                ,
                    elevation = 10.dp)
        {
            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Home, "")
            },
                label = { androidx.compose.material.Text(text = "Home") },
                selected = (selectedIndex.value == 0),
                onClick = {
                    selectedIndex.value = 0
                })
            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Favorite, "")
            },
                label = { androidx.compose.material.Text(text = "My plants") },
                selected = (selectedIndex.value == 1),
                onClick = {
                    selectedIndex.value = 1
                })
            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Person, "")
            },
                label = { androidx.compose.material.Text(text = "Community") },
                selected = (selectedIndex.value == 2),
                onClick = {
                    selectedIndex.value = 2
                })
        }
    }






@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    HomeScreen(rememberNavController())
}

