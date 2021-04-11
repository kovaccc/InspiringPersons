package com.example.inspiringpersons.viewmodels

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.inspiringpersons.data.model.InspiringPerson
import com.example.inspiringpersons.data.model.PersonsWithQuotes
import com.example.inspiringpersons.di.SharedPrefModule
import com.example.inspiringpersons.repositories.InspiringPersonsRepository
import com.example.inspiringpersons.repositories.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val TAG = "PersonsViewModel"

@HiltViewModel
class PersonsViewModel @Inject constructor(
    quoteRepository: QuoteRepository,
    private val inspiringPersonsRepository: InspiringPersonsRepository,
    )  : ViewModel() {

    val personsWithQuotes: LiveData<List<PersonsWithQuotes>> = quoteRepository.getPersonsAndQuotes().asLiveData()

    override fun onCleared() {
        Log.d(TAG, "onCleared: starts")
        super.onCleared()
        Log.d(TAG, "onCleared: ends")
    }
}