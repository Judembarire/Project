package net.ezra.ui.home

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import net.ezra.R
import net.ezra.navigation.ROUTE_GUIDE
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_PLANT
import net.ezra.ui.students.FirestoreViewModel
import net.ezra.ui.students.Item
import net.ezra.ui.students.ItemList


class FirestoreViewModel : ViewModel() {

    private val firestore = Firebase.firestore
    private val itemsCollection = firestore.collection("Students")

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    init {
        fetchItems()
    }

    fun fetchItems() {
        itemsCollection.addSnapshotListener { snapshot, error ->
            if (error != null) {
                Log.e("FirestoreViewModel", "Error fetching items", error)
                return@addSnapshotListener
            }

            val itemList = mutableListOf<Item>()
            snapshot?.documents?.forEach { document ->
                val item = document.toObject(Item::class.java)?.copy(studentClass = document.id)
                item?.let {
                    itemList.add(it)
                }
            }
            _items.value = itemList
        }
    }
}



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, items: () -> Unit){

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
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(
                                    shape = RoundedCornerShape(
                                        bottomEnd = 15.dp,
                                        bottomStart = 15.dp
                                    )
                                )

                        ) {
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

                        Text(
                            "Your plants",
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
                            .height(100.dp)
                            .fillMaxWidth()
                    ) {
                        item {
                            LazyHorizontalGrid(rows = GridCells.Fixed(1),) {

                                items.forEach { item ->
                                    item {
                                        Column {


                                            SubcomposeAsyncImage(
                                                model = ImageRequest.Builder(LocalContext.current)
                                                    .data(item.imageUrl)
                                                    .crossfade(true)
                                                    .build(),
                                                loading = {
                                                    CircularProgressIndicator()
                                                },
                                                contentDescription = item.studentName,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier.clip(RoundedCornerShape(10))
                                            )

                                            item.studentName?.let { Text(text = it) }
                                            item.studentClass?.let { Text(text = it) }

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
                                ) {
                                    Text(
                                        "Popular Plants",
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
                                        Column {
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
                                                                    popUpTo(ROUTE_HOME) {
                                                                        inclusive = true
                                                                    }
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

                                        Column {
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
                                        Column {
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

                                        Column {
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
                                        Column {
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

                                        Column {
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
                                        Column {
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

                                        Column {
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

@Composable
fun StudentList(navController: NavHostController, viewModel: FirestoreViewModel) {
    val items by viewModel.items.observeAsState(initial = emptyList())

    // Fetch items when the composable is first created
    LaunchedEffect(viewModel, key2 = true) {
        viewModel.fetchItems()
    }

    Column {

        ItemList(items)

    }


}



