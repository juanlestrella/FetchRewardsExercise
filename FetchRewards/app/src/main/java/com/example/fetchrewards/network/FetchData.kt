package com.example.fetchrewards.network

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FetchData (
    @PrimaryKey val id: String,
    @NonNull val listId: Int,
    @NonNull val name: String?, //might be null when get
)