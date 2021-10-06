package com.example.fetchrewards.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.fetchrewards.database.AppDatabase
import com.example.fetchrewards.database.FetchRewardsDao
import com.example.fetchrewards.network.Api
import com.example.fetchrewards.network.ApiService
import com.example.fetchrewards.network.FetchData

class FetchRepository(application: Application) {

    private var fetchDao: FetchRewardsDao = AppDatabase.getDatabase(application).fetchDao()


    fun loadData(): LiveData<List<FetchData>>{
        return liveData{
            val getDatas = Api.retrofitService.getData()

            getDatas.forEach { data ->
                fetchDao.insert(data)
            }

            emitSource(fetchDao.getName())
        }
    }
}