package com.example.fetchrewards.models

import android.app.Application
import androidx.lifecycle.*
import com.example.fetchrewards.network.FetchData
import com.example.fetchrewards.repository.FetchRepository

class FetchViewModel(application: Application) : AndroidViewModel(application) {
    val data: LiveData<List<FetchData>> = FetchRepository(application).loadData()
}