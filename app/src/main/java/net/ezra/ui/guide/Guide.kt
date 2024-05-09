package net.ezra.ui.guide

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R

@Composable
fun GuideScreen( navController: NavHostController){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x1208F511))
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp))

            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),

                    contentScale = ContentScale.Crop,

                    painter = painterResource(id = R.drawable.spider1),
                    contentDescription = ""
                )

            }

            Spacer(modifier = Modifier.height(7.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            {
            Text(
                "Spider plant",
                fontSize = 25.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold

            )
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            {
                Text(
                    " (Chlorophytum comosum)",
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Light

                )
            }

            Spacer(modifier = Modifier.height(30.dp))


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            {
                Text(
                    "Quick facts?",
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Light

                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .padding(2.dp)
                ) {
                    Spacer(modifier = Modifier.width(40.dp))

                    Column{
                        Card(
                            modifier = Modifier
                                .width(130.dp)
                                .height(150.dp),
                            colors = CardDefaults.cardColors(Color(0xffffffff))

                        ) {
                       Text(
                           text = "Height",
                           fontSize = 25.sp,
                           fontFamily = FontFamily.Default,
                           fontWeight = FontWeight.SemiBold,

                           )

                            Image(
                            modifier = Modifier
                                .size(60.dp, 60.dp)
                                .background(Color.Transparent)
                                .clip(RoundedCornerShape(16.dp)),

                            painter = painterResource(id = R.drawable.height),
                            contentDescription = ""
                        )
                            Text(
                                text = "2 to 3 feet (0.6-0.9 m)",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )

                        }

                    }

                    Spacer(modifier = Modifier.width(40.dp))

                    Column{
                        Card(
                            modifier = Modifier
                                .width(120.dp)
                                .height(150.dp),
                            colors = CardDefaults.cardColors(Color(0xffffffff))

                        ) {
                            Text(
                                text = "Water",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )

                            Image(
                                modifier = Modifier
                                    .size(60.dp, 60.dp)
                                    .background(Color.Transparent)
                                    .clip(RoundedCornerShape(16.dp)),

                                painter = painterResource(id = R.drawable.water),
                                contentDescription = ""
                            )
                            Text(
                                text = "185 - 190 ml",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                    }
                }
            }


            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .padding(2.dp)
                ) {
                    Spacer(modifier = Modifier.width(40.dp))

                    Column{
                        Card(
                            modifier = Modifier
                                .width(130.dp)
                                .height(150.dp),
                            colors = CardDefaults.cardColors(Color(0xffffffff))

                        ) {
                            Text(
                                text = "Sun",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )

                            Image(
                                modifier = Modifier
                                    .size(60.dp, 60.dp)
                                    .background(Color.Transparent)
                                    .clip(RoundedCornerShape(16.dp)),

                                painter = painterResource(id = R.drawable.sun),
                                contentDescription = ""
                            )
                            Text(
                                text = " Part shade to full shade",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )

                        }

                    }

                    Spacer(modifier = Modifier.width(40.dp))

                    Column{
                        Card(
                            modifier = Modifier
                                .width(120.dp)
                                .height(150.dp),
                            colors = CardDefaults.cardColors(Color(0xffffffff))

                        ) {
                            Text(
                                text = "Soil",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )

                            Image(
                                modifier = Modifier
                                    .size(60.dp, 60.dp)
                                    .background(Color.Transparent)
                                    .clip(RoundedCornerShape(16.dp)),

                                painter = painterResource(id = R.drawable.soil),
                                contentDescription = ""
                            )
                            Text(
                                text = " well-drained general-purpose potting ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
                        Column(
                              modifier = Modifier
                                  .fillMaxWidth()
                                  .height(400.dp)
                                  .background(Color(0xffffffff))
                                  .padding(10.dp)
                               ) {

                           Text(text = "The spider plant (Chlorophytum comosum) is considered one of the most adaptable houseplants.These plants produce clusters of ribbony leaves - solid green or variegated with lengthwise stripes of white or yellow - that emerge from a crown of fleshy roots. Its flowers are tiny and white.Spider plants can grow in a wide range of conditions and suffer from few problems.The spider plant is so named because of its spider-like offsets, or spiderettes, which dangle down from the mother plant like spiders on a web.",
                               fontSize = 19.sp,
                               fontFamily = FontFamily.Default,

                           )

                            Spacer(modifier = Modifier.height(20.dp))

                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .width(300.dp)
                                      
                              
                                
                                ) {
                                Text(
                                    text = "Add to Plants",


                                    )
                            }

                                  }

        }
    }
}









@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    GuideScreen(rememberNavController())
}