package com.example.myuidemo

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.*



//bottomNavContentScreen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var scrollableState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF7F2F2))
            .verticalScroll(scrollableState)
//            .wrapContentSize(Alignment.Center),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "sportsu" ,
                fontWeight = FontWeight.Bold ,
                color = Color.Black ,
                fontSize = 35.sp ,
            )

            Box (modifier=modifier.width(46.dp)){

                Image(
                    painter = painterResource(id = R.drawable.navicon) ,
                    contentDescription = null ,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center)
                )
                Image(
                    painter = painterResource(id = R.drawable.icon) ,
                    contentDescription = null ,
                    modifier = Modifier
                        .size(15.dp)
                        .align(Alignment.TopEnd)
                )
            }
        }
        var text by remember { mutableStateOf("") } // Query for SearchBar
        var active by remember { mutableStateOf(false) } // Active state for SearchBar
//For adding search history, create a variable searchHistory of type mutableStateListOf.
        var searchHistory = remember { mutableStateListOf("") }

        Column(modifier = Modifier.fillMaxWidth()) {
            SearchBar(
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp , end = 12.dp),
                query = text,
                onQueryChange ={text=it} ,
                onSearch = {
                    searchHistory.add(it)
                    active=false
//                    text=""
                },
                active =active ,
                onActiveChange = {
                    active=it
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.search_sports_product),
//                        fontWeight = FontWeight.Light,
//                        fontSize = 20.sp,
//                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                    )
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon")
                },
                trailingIcon = {
                    if(active){
                        Icon(
                            modifier=Modifier.clickable {
                                if(text.isNotEmpty()){
                                    text=""
                                }else{
                                    active=false
                                }
                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                    }

                },
                tonalElevation = 0.dp,
                shape = RoundedCornerShape(16.dp)

            ) {
                searchHistory.forEach {
                    if (it.isNotEmpty()) {
                        Column {
                            Row(modifier = Modifier.padding(all = 14.dp)) {
                                Icon(
                                    modifier = Modifier.padding(end = 10.dp),
                                    imageVector = Icons.Default.History,
                                    contentDescription = null
                                )
                                //                            Spacer(modifier = Modifier.width(10.dp))
                                Text(text = it)


                            }
                        }

                        Text(
                            modifier = Modifier
                                .padding(all = 14.dp)
                                .fillMaxWidth()
                                .clickable {
                                    searchHistory.clear()
                                },
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            text = "clear all history"
                        )


                    }
                }
            }
            Column(

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .padding(start = 2.dp , end = 1.dp , top = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.frame) ,
                    contentDescription = null , // We're providing our own content description
                    modifier = Modifier
                        .size(400.dp)// Set the size of the image
                        .padding(4.dp) ,// Add some padding
                    contentScale = ContentScale.FillBounds
                )
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp , top = 20.dp) ,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.brand_txt) ,
                    fontWeight = FontWeight.Bold ,
                    color = Color.Black ,
                    fontSize = 30.sp ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 0.dp , end = 12.dp , top = 0.dp) ,
                )
            }
            val items = listOf(
                ListItem(painterResource(id = R.drawable.ellipse) ,painterResource(id = R.drawable.brand), "Nike") ,
                ListItem(painterResource(id = R.drawable.ellipse) ,painterResource(id = R.drawable.brand), "Adidas") ,
                ListItem(painterResource(id = R.drawable.ellipse) , painterResource(id = R.drawable.brand),"Puma") ,
                ListItem(painterResource(id = R.drawable.ellipse) , painterResource(id = R.drawable.brand),"Reebok") ,
                ListItem(painterResource(id = R.drawable.ellipse) , painterResource(id = R.drawable.brand),"Nike")
            )
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp , end = 16.dp) ,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                HorizontalScrollableList(items)
            }

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp , top = 20.dp) ,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.trend_heading) ,
                    fontWeight = FontWeight.Bold ,
                    color = Color.Black ,
                    fontSize = 30.sp ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 0.dp , end = 12.dp , top = 0.dp) ,
                )
            }
            val itemsTrend = listOf(
                ListItem1(
                    painterResource(id = R.drawable.rectangle_146) ,
                    painterResource(id = R.drawable.stroke_1),
                    painterResource(id = R.drawable.stroke_3),
                    painterResource(id = R.drawable.trend_img),
                    "mens running shoes" ,
                    "Nike Air Zoom-24" ,
                    "$ 138"
                ) ,
                ListItem1(
                    painterResource(id = R.drawable.rectangle_146) ,
                    painterResource(id = R.drawable.stroke_1),
                    painterResource(id = R.drawable.stroke_3),
                    painterResource(id = R.drawable.trend_img),
                    "Adidas sport Jack" ,
                    "Nike Air Zoom-24" ,
                    "$ 138"
                ) ,
                ListItem1(
                    painterResource(id = R.drawable.rectangle_146) ,
                    painterResource(id = R.drawable.stroke_1),
                    painterResource(id = R.drawable.stroke_3),
                    painterResource(id = R.drawable.trend_img),
                    "mens running shoes" ,
                    "Nike Air Zoom-24" ,
                    "$ 138"
                ) ,
                ListItem1(
                    painterResource(id = R.drawable.rectangle_146) ,
                    painterResource(id = R.drawable.stroke_1),
                    painterResource(id = R.drawable.stroke_3),
                    painterResource(id = R.drawable.trend_img),
                    "mens running shoes" ,
                    "Nike Air Zoom-24" ,
                    "$ 138"
                ) ,
                ListItem1(
                    painterResource(id = R.drawable.rectangle_146) ,
                    painterResource(id = R.drawable.stroke_1),
                    painterResource(id = R.drawable.stroke_3),
                    painterResource(id = R.drawable.trend_img),
                    "mens running shoes" ,
                    "Nike Air Zoom-24" ,
                    "$ 138"
                )
            )
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp , top = 10.dp,end=16.dp) ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                HorizontalScrollableList1(item = itemsTrend)
            }

        }
    }

}

//brands
// Data class representing an item in the list
data class ListItem(val image: Painter , val image1:Painter,val text: String)

//trends
// Data class representing an item in the list
data class ListItem1(val image1: Painter, val image2: Painter,val image3: Painter ,val image4: Painter,val text: String , val text1: String , val text2: String)

//brands
// Custom composable representing an item in the list
@Composable
fun ListItemView(modifier: Modifier=Modifier,item:ListItem) {
    Column(
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = modifier) {

                Image(
                    painter = item.image ,
                    contentDescription = null , // We're providing our own content description
                    modifier = modifier
                        .size(120.dp) // Set the size of the image
                        .padding( top = 12.dp)
                        .width(70.dp)
                        .height(90.dp) // Add some padding
                )
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .padding( top = 12.dp)
                    .align(Alignment.Center),
            ){
                Image(
                    painter =item.image1  ,
                    contentDescription = null ,
                    modifier = modifier
                        .width(36.dp)
                        .height(13.dp)
                )
            }


        }
        Text(
            text = item.text,
            modifier = Modifier.padding( top =5.dp).align(Alignment.CenterHorizontally) ,
            fontSize = 18.sp,
            maxLines = 2 // Limit text to two lines
        )
    }

}

//trends
// Custom composable representing an item in the list
@Composable
fun ListItemView1(modifier: Modifier=Modifier,item: ListItem1) {

    Box(modifier=modifier) {
        Image(
            painter = item.image1,
            contentDescription = null,
            modifier= modifier
                .width(209.dp)
                .height(233.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier.padding(start =173.dp, end = 18.dp,top=18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box {
                Image(
                    painter = item.image2 ,
                    contentDescription = null ,
                    modifier = modifier
                        .width(18.dp)
                        .height(17.dp)


                )
                Image(
                    painter = item.image3,
                    contentDescription = null,
                    modifier= modifier
                        .width(1.82.dp)
                        .height(2.29.dp)
                        .align(Alignment.TopEnd)

                )
            }

        }
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(start =38.dp, end = 39.35.dp,top=52.dp, bottom = 26.83.dp),
        ){
            Image(
                painter =item.image4  ,
                contentDescription = null ,
                modifier = modifier
                    .width(133.65.dp)
                    .height(65.17.dp)
            )
        }
       TrendingText(
           message1 = item.text ,
           message2 =item. text1 ,
           message3 = item.text2,
           modifier=modifier.align(Alignment.BottomStart),

       )
    }
}

//trending text
@Composable
fun TrendingText(message1: String, message2: String,message3: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(start = 17.dp)
    ){

        Text(
            text = message1,
            modifier = modifier.padding(top = 29.dp),
            fontWeight = FontWeight.ExtraLight

        )
        Text(
            text = message2,
            modifier = modifier
                .padding(top = 4.dp)
                .width(134.dp)
                .height(19.dp),

        )
        Text(
            text = message3,
            fontSize=18.sp,
            modifier = modifier
                .padding(top = 10.dp , bottom = 18.dp)
                .width(47.dp)
                .height(21.dp),
            color = colorResource(id = R.color.orange),

        )
    }

}




//brands
@Composable
fun HorizontalScrollableList(item: List<ListItem>) {

    LazyRow {
        items(item) { item ->
            ListItemView(item = item)
        }
    }
}

//trends
@Composable
fun HorizontalScrollableList1(modifier: Modifier=Modifier,item: List<ListItem1>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(item) { item ->
            ListItemView1(item = item)
        }
    }
}


@Composable
fun NetworkScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "My Network Screen" ,
            fontWeight = FontWeight.Bold ,
            color = Color.White ,
            modifier = Modifier.align(Alignment.CenterHorizontally) ,
            textAlign = TextAlign.Center ,
            fontSize = 20.sp
        )
    }
}

@Composable
fun AddPostScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Add Post Screen" ,
            fontWeight = FontWeight.Bold ,
            color = Color.White ,
            modifier = Modifier.align(Alignment.CenterHorizontally) ,
            textAlign = TextAlign.Center ,
            fontSize = 20.sp
        )
    }
}


@Composable
fun NotificationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Notification Screen" ,
            fontWeight = FontWeight.Bold ,
            color = Color.White ,
            modifier = Modifier.align(Alignment.CenterHorizontally) ,
            textAlign = TextAlign.Center ,
            fontSize = 20.sp
        )
    }
}


@Composable
fun DetailedPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Jobs Screen" ,
            fontWeight = FontWeight.Bold ,
            color = Color.White ,
            modifier = Modifier.align(Alignment.CenterHorizontally) ,
            textAlign = TextAlign.Center ,
            fontSize = 20.sp
        )
    }
}

//@Preview(
//    showBackground = true ,
//    showSystemUi = true
//)
//@Composable
//fun PreviewHorizontalScrollableList() {
////    HomeScreen()
//}