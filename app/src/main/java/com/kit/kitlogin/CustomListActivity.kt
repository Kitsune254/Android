package com.kit.kitlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kit.kitlogin.ui.theme.KitLoginTheme

class CustomListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KitLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    CustomList()

                }
            }
        }
    }
}

data class FruitModel(val name:String, val image : Int)

@Composable
fun Customlist(model: FruitModel) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color(0xFF863040))
    ){
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
           // onTextLayout = {}
        )
    }
}

private val fruitList = mutableListOf<FruitModel>().apply {
    add(FruitModel("Bayer Leverkusen",R.drawable.bayer))
    add(FruitModel("Liverpool",R.drawable.liverpool))
    add(FruitModel("Manchester United",R.drawable.utd))
    add(FruitModel("Manchester City",R.drawable.city))
    add(FruitModel("Crystal Palace",R.drawable.palace))
    add(FruitModel("Bayern Munich",R.drawable.bayern))
    add(FruitModel("Arsenal",R.drawable.arsenal))
    add(FruitModel("Newcastle",R.drawable.newcastle))
}

@Composable
fun CustomList() {
    LazyColumn (
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 35.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        items(fruitList){model ->
            Customlist(model)
        }
    }
}

@Preview
@Composable
private fun CustomListprev() {
    CustomList()
}