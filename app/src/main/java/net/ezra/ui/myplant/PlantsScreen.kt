package net.ezra.ui.myplant


import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import net.ezra.R
import net.ezra.ui.home.BottomBar
import net.ezra.ui.students.Item


data class Item(

    val imageUrl: String? = "",
    val studentName: String? = "",
    val studentClass: String? = "",
    val email: String? = "",
    val phone: String? = "",

    )
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
fun PlantScreen(
    navController: NavHostController,
    items: () -> Unit
) {

    Scaffold(

        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp))

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

                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    items.forEach { item ->
                        item {
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
                                                        colors = CardDefaults.cardColors(
                                                            Color(
                                                                0xffffffff
                                                            )
                                                        )

                                                    ) {
                                                        item.studentName?.let { Text(text = it) }
                                                    }
                                                }
                                                Spacer(modifier = Modifier.height(7.dp))

                                                Row {
                                                    Card(
                                                        modifier = Modifier
                                                            .width(250.dp)
                                                            .height(35.dp),
                                                        colors = CardDefaults.cardColors(
                                                            Color(
                                                                0xffffffff
                                                            )
                                                        )

                                                    ) {
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
                                                    }
                                                }
                                            }

                                            Spacer(modifier = Modifier.width(25.dp))

                                            Column {
                                                Card(
                                                    modifier = Modifier
                                                        .width(107.dp)
                                                        .height(90.dp),
                                                    colors = CardDefaults.cardColors(
                                                        Color(
                                                            0xffffffff
                                                        )
                                                    )

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
            androidx.compose.material.Icon(imageVector = Icons.Default.Home, "")
        },
            label = { androidx.compose.material.Text(text = "Home") },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })
        BottomNavigationItem(icon = {
            androidx.compose.material.Icon(imageVector = Icons.Default.Favorite, "")
        },
            label = { androidx.compose.material.Text(text = "My plants") },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })
        BottomNavigationItem(icon = {
            androidx.compose.material.Icon(imageVector = Icons.Default.Person, "")
        },
            label = { androidx.compose.material.Text(text = "Community") },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })
    }
}



