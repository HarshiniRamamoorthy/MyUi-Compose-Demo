package com.example.myuidemo


sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Purchase : BottomNavItem("Purchase", R.drawable.bag,"purchase")
    object Vector: BottomNavItem("Vector",R.drawable.vector,"vector")
    object Group: BottomNavItem("Group",R.drawable.group,"add_group")
    object Profile: BottomNavItem("Profile",R.drawable.profile,"profile")

}