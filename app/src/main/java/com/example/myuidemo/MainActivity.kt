package com.example.myuidemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.BottomNavigation
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyUiDemoTheme {
//                 A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//             MainBottomBar()
                    MainScreenView()
//                }

//            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {

        NavigationGraph(navController = navController)
    }
}


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.MyNetwork.screen_route) {
            NetworkScreen()
        }
        composable(BottomNavItem.AddPost.screen_route) {
            AddPostScreen()
        }
        composable(BottomNavItem.Notification.screen_route) {
            NotificationScreen()
        }

    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.MyNetwork,
        BottomNavItem.AddPost,
        BottomNavItem.Notification,

    )
    BottomNavigation(backgroundColor = Color(0xFFFFFFFF), modifier = Modifier.height(80.dp).padding(1.dp)) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
    items.forEach { item ->
        BottomNavigationItem(
            icon = {
                Icon(
                    modifier = Modifier.size(22.dp).padding(bottom = 2.dp),
                    painter =painterResource(id = item.icon),
                    contentDescription = item.title,
                    tint = if (currentRoute == item.screen_route) colorResource(id = R.color.orange) else Color.Black,

                )
            },
            label = { Text(text = item.title, color =if(currentRoute==item.screen_route) colorResource(
                id = R.color.orange
            )else Color.Black,
                fontSize = 17.sp) },
            selectedContentColor = colorResource(id = R.color.orange),
            unselectedContentColor = Color.Black.copy(0.4f),
            alwaysShowLabel = false,
            selected = currentRoute == item.screen_route,
            onClick = {
                navController.navigate(item.screen_route) {
                    //       Pop up to the start destination of the graph to
//                        // avoid building up a large stack of destinations
                    navController.graph.startDestinationRoute?.let { screen_route ->
                        popUpTo(screen_route) {
                            saveState = true
                        }
                    }
                    // Avoid multiple copies of the same destination when re-selecting
                        launchSingleTop = true
//                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                }
            }
        )
    }
}
}

