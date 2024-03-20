package com.example.myuidemo

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PurchaseDetailedPage(modifier: Modifier = Modifier,navController: NavController) {


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF7F2F2))
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = modifier.clickable { navController.popBackStack() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.backarrow1),
                    contentDescription = null,
                    modifier = modifier
                        .width(24.dp)
                        .height(20.dp)

                )
                Image(
                    painter = painterResource(id = R.drawable.backarrow2),
                    contentDescription = null,
                    modifier = modifier
                        .width(32.dp)
                        .height(20.dp)
                        .padding(start = 9.dp)

                )
            }


            Box(modifier = modifier.width(46.dp)) {

                Image(
                    painter = painterResource(id = R.drawable.navicon),
                    contentDescription = null,
                    modifier = modifier
                        .size(30.dp)
                        .align(Alignment.Center)
                )
                Image(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = null,
                    modifier = modifier
                        .size(15.dp)
                        .align(Alignment.TopEnd)
                )
            }
        }

        var scrollableState = rememberScrollState()

        Column(
            modifier = modifier
                .background(Color(0xFFF7F2F2))
                .verticalScroll(scrollableState)
        ) {

            Column(

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
                    .height(306.dp)
                    .padding(start = 18.dp, end = 17.dp, top = 15.dp)
            ) {
                Box(modifier = modifier) {
                    Image(
                        painter = painterResource(id = R.drawable.rectangle_146),
                        contentDescription = null, // We're providing our own content description
                        modifier = modifier
                            .size(400.dp)// Set the size of the image
                            .padding(4.dp),// Add some padding
                        contentScale = ContentScale.FillBounds
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = modifier.padding(start = 318.dp, end = 20.dp, top = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.stroke_1),
                                contentDescription = null,
                                modifier = modifier
                                    .width(20.dp)
                                    .height(19.dp)


                            )
                            Image(
                                painter = painterResource(id = R.drawable.stroke_3),
                                contentDescription = null,
                                modifier = modifier
                                    .width(1.82.dp)
                                    .height(2.29.dp)
                                    .align(Alignment.TopEnd)

                            )
                        }

                    }

                    Image(
                        painter = painterResource(id = R.drawable.trend_img),
                        contentDescription = null,
                        modifier = modifier
                            .align(Alignment.Center)
                            .width(281.dp)
                            .height(137.dp)
                    )
                    Row(
                        modifier = modifier.padding(
                            start = 148.dp,
                            top = 276.dp,
                            end = 149.dp,
                            bottom = 2.dp
                        ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.rectangle_147),
                            contentDescription = null,

                            )

                        Image(
                            painter = painterResource(id = R.drawable.rectangle_122),
                            contentDescription = null,
                            modifier = modifier.padding(start = 7.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ellipse_92),
                            contentDescription = null,
                            modifier = modifier.padding(start = 7.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ellipse_92),
                            contentDescription = null,
                            modifier = modifier.padding(start = 7.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ellipse_92),
                            contentDescription = null,
                            modifier = modifier.padding(start = 7.dp)
                        )
                    }
                }


            }
            Text(
                text = stringResource(R.string.mens_running_shoes),
                modifier = modifier.padding(top = 29.dp, start = 16.dp),
                fontWeight = FontWeight.Light,
                fontSize = 16.sp

            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.nike_air_zoom),
                    color = Color(0xFF002534),
                    modifier = modifier
                        .padding(start = 16.dp)
                        .wrapContentWidth(Alignment.Start),
                    fontSize = 22.sp

                )
                Text(
                    text = "$ 138",
                    fontSize = 28.sp,
                    modifier = modifier
                        .padding(end = 16.dp)
                        .wrapContentSize(),
                    color = colorResource(id = R.color.orange),

                    )
            }

            //ratings
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(start = 16.dp, top = 18.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(painter = painterResource(id = R.drawable.star), contentDescription = null)
                Spacer(modifier = modifier.padding(start = 2.dp))
                Image(painter = painterResource(id = R.drawable.star), contentDescription = null)
                Spacer(modifier = modifier.padding(start = 2.dp))
                Image(painter = painterResource(id = R.drawable.star), contentDescription = null)
                Spacer(modifier = modifier.padding(start = 2.dp))
                Image(painter = painterResource(id = R.drawable.star), contentDescription = null)
                Spacer(modifier = modifier.padding(start = 2.dp))
                Image(painter = painterResource(id = R.drawable.star1), contentDescription = null)
                Spacer(modifier = modifier.padding(start = 8.dp))
                Text(
                    text = "4,200 ratings",
                    lineHeight = 11.72.sp,
                    fontSize = 12.sp,
                    modifier = modifier
                        .wrapContentSize(),
                    color = Color(0xFF989898),


                    )
            }

            //size
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = "Size",
                    fontSize = 16.sp,
                    lineHeight = 18.75.sp,
                    color = colorResource(id = R.color.mainui)
                )

                Spacer(modifier = Modifier.width(260.dp))
                Text(
                    text = "US",
                    fontSize = 16.sp,
                    lineHeight = 18.75.sp,
                    color = colorResource(id = R.color.mainui)
                )

                Spacer(modifier = Modifier.width(22.dp))

                Text(
                    text = "UK",
                    fontSize = 16.sp,
                    lineHeight = 18.75.sp,
                    color = Color(
                        0xFF989898
                    )
                )

                Spacer(modifier = Modifier.width(22.dp))

                Text(
                    text = "EU",
                    fontSize = 16.sp,
                    lineHeight = 18.75.sp,
                    color = Color(0xFF989898)
                )

            }
            //        Row(
            //            modifier = Modifier
            //                .fillMaxWidth()
            //                .padding(start = 16.dp, top = 12.dp),
            //            horizontalArrangement = Arrangement.Start
            //        ) {
            //            ImageWithText(
            //                imageRes = R.drawable.rectangle_43,
            //                text = "9",
            //            )
            //
            //            Spacer(modifier = modifier.width(15.dp))
            //
            //            ImageWithText(
            //                imageRes = R.drawable.rectangle_43,
            //                text = "10"
            //            )
            //            Spacer(modifier = modifier.width(15.dp))
            //
            //            ImageWithText(
            //                imageRes = R.drawable.rectangle_43,
            //                text = "11"
            //            )
            //            Spacer(modifier = modifier.width(15.dp))
            //
            //            ImageWithText(
            //                imageRes = R.drawable.rectangle_43,
            //                text = "12"
            //            )
            //        }
            var selectedIndex by remember { mutableStateOf(-1) }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 12.dp, end = 16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                for (i in 9..12) {
                    ImageWithText(
                        modifier = modifier.padding(end = 15.dp),
                        imageRes = if (selectedIndex == i) R.drawable.rectangle_44 else R.drawable.rectangle_43,
                        text = i.toString(),
                        onClick = { selectedIndex = i },
                        selected = selectedIndex == i
                    )
                }
            }

//description

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .height(105.dp)
                    .padding(start = 17.dp, end = 18.dp, top = 22.dp)
            ) {
                Text(
                    text = stringResource(R.string.detailed_txt),
                    textAlign = TextAlign.Justify,
                    color = Color(
                        0xFF959595
                    ),
                    fontSize = 13.sp,
                    lineHeight = 23.sp,
                )
            }

            //advantages
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.advantage_txt),
                    modifier = modifier.align(Alignment.CenterVertically),
                    color = Color(
                        0xFF002D40
                    ),
                    fontSize = 16.sp,
                    lineHeight = 18.75.sp,
                )


                Box(modifier = modifier) {

                    Image(
                        painter = painterResource(id = R.drawable.stroke),
                        contentDescription = null,
                        modifier = modifier
                            .width(28.dp)
                            .height(28.dp)
                            .align(Alignment.Center)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.stroke_arrow),
                        contentDescription = null,
                        modifier = modifier
                            .width(10.51.dp)
                            .height(5.28.dp)
                            .align(Alignment.Center)
                    )
                }
            }
            //divider
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.line_5),
                    contentDescription = null,
                    modifier = modifier,

                    )
            }
            //tech
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.tech_info_txt),
                    modifier = modifier.align(Alignment.CenterVertically),
                    color = Color(
                        0xFF002D40
                    ),
                    fontSize = 16.sp,
                    lineHeight = 18.75.sp,
                )


                Box(modifier = modifier) {

                    Image(
                        painter = painterResource(id = R.drawable.stroke),
                        contentDescription = null,
                        modifier = modifier
                            .width(28.dp)
                            .height(28.dp)
                            .align(Alignment.Center)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.stroke_arrow),
                        contentDescription = null,
                        modifier = modifier
                            .width(10.51.dp)
                            .height(5.28.dp)
                            .align(Alignment.Center)
                    )
                }
            }
            //divider
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.line_5),
                    contentDescription = null,
                    modifier = modifier,

                    )
            }

            //reviews
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.review_txt),
                    modifier = modifier.align(Alignment.CenterVertically),
                    color = Color(
                        0xFF002D40
                    ),
                    fontSize = 16.sp,
                    lineHeight = 18.75.sp,
                )


                Box(modifier = modifier) {

                    Image(
                        painter = painterResource(id = R.drawable.stroke),
                        contentDescription = null,
                        modifier = modifier
                            .width(28.dp)
                            .height(28.dp)
                            .align(Alignment.Center)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.stroke_arrow),
                        contentDescription = null,
                        modifier = modifier
                            .width(10.51.dp)
                            .height(5.28.dp)
                            .align(Alignment.Center)
                    )
                }
            }
            //divider
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.line_5),
                    contentDescription = null,
                    modifier = modifier,

                    )
            }
            //add to cart&buy now
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(start = 0.dp, top = 12.dp, end = 0.dp)
                    .background(Color(0xFFFFFFFF)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = modifier.padding(top = 12.dp, bottom = 12.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.rectangle_67),
                        contentDescription = "null",
                    )
                    Text(
                        text = "Add to Cart",
                        color = Color(
                            0xFF002D40
                        ),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Box(modifier = modifier.padding(top = 12.dp, bottom = 12.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.rectangle_68),
                        contentDescription = "null",
                    )
                    Text(
                        text = "Buy now",
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = modifier.height(100.dp)
            ) {

            }

        }

    }
}

@Composable
fun ImageWithText(
    modifier: Modifier = Modifier,
    imageRes: Int,
    text: String,
    onClick: () -> Unit,
    selected: Boolean
) {
    Box(
        modifier = modifier.clickable(onClick = onClick)
    ) {

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "null",
            modifier = Modifier
                .height(60.dp)
        )
        Text(
            text = text,
            color = if (selected) Color.White else Color(0xFF919191),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
//@Composable
//fun ImageWithText1(modifier: Modifier = Modifier, imageRes: Int, text: String) {
//
//    var clicked by rememberSaveable { mutableStateOf(false) }
//    LaunchedEffect(clicked) {
//        println("Clicked: $clicked")
//    }
//
//
//    Box(modifier = modifier.clickable { clicked=!clicked }) {
//        Image(
//            painter = painterResource(id = imageRes),
//            contentDescription = "null",
//        )
//        Text(
//            text = text,
//            color =if(clicked) Color.White else Color(0xFF002D40),
//            modifier = Modifier.align(Alignment.Center)
//        )
//    }
//}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewHorizontalScrollableList() {
//    PurchaseDetailedPage()
}