package com.example.fetchrewards.models

import android.app.Application
import androidx.lifecycle.*
import com.example.fetchrewards.database.AppDatabase
import com.example.fetchrewards.database.FetchRewardsDao
import com.example.fetchrewards.network.Api
import com.example.fetchrewards.network.FetchData
import kotlinx.coroutines.launch
import java.lang.Exception
//import com.example.fetchrewards.network.FetchDao

class FetchViewModel(application: Application) : AndroidViewModel(application) {

    private val _data = MutableLiveData<List<FetchData>>()
    val data: LiveData<List<FetchData>> = _data
    //lateinit var data: LiveData<List<FetchData>>

    private var fetchDao: FetchRewardsDao = AppDatabase.getDatabase(application).fetchDao()

    private val _filtered = MutableLiveData<List<FetchData>>()
    val filtered: LiveData<List<FetchData>> = _filtered

    init{
        getFetchData()
    }

    private fun getFetchData() {
        viewModelScope.launch{
            try {
                _data.value = Api.retrofitService.getData()
//                Api.retrofitService.getData().forEach{
//                    item -> fetchDao.insert(item)
//                }
//                data = fetchDao.getName()
            }catch (e: Exception){
                _data.value = listOf()
            }
        }
    }
}