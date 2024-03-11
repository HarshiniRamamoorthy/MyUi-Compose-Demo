package com.example.myuidemo


sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Purchase", R.drawable.bag,"home")
    object MyNetwork: BottomNavItem("Vector",R.drawable.vector,"my_network")
    object AddPost: BottomNavItem("Group",R.drawable.group,"add_post")
    object Notification: BottomNavItem("Profile",R.drawable.profile,"notification")

}