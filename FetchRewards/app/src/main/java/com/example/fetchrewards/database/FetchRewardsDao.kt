package com.example.fetchrewards.database

import androidx.lifecycle.LiveData
import com.example.fetchrewards.network.FetchData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
//Room
@Dao
interface FetchRewardsDao {
    @Query("SELECT * FROM FetchData " +
            "WHERE name != '' " +
            "GROUP BY listId " +
            "ORDER BY name ASC, name")
    fun getName(): LiveData<List<FetchData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(fetchReward: FetchData)
}