package com.example.fetchrewards.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fetchrewards.network.FetchData

// Room
@Database(entities = [FetchData::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun fetchDao(): FetchRewardsDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context) : AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "fetch_database")
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}