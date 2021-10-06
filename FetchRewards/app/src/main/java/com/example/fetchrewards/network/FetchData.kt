package com.example.fetchrewards.network

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FetchData (
    @PrimaryKey val id: String,
    val listId: Int,
    @NonNull val name: String?,
)

//data class FetchData (
//    val id: String,
//    val listId: Int,
//    val name: String?
//    )