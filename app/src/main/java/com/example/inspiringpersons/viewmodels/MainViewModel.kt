package com.example.inspiringpersons.viewmodels

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.inspiringpersons.di.SharedPrefModule
import com.example.inspiringpersons.utilities.Constants
import com.example.inspiringpersons.utilities.Constants.DATE_DEFAULT
import com.example.inspiringpersons.utilities.notifyObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val TAG = "MainViewModel"


@HiltViewModel
class MainViewModel @Inject constructor(
    @SharedPrefModule.DateSharedPreferences private val dateSharedPref: SharedPreferences
)  : ViewModel() {

    private val _currentQuotesMLD = MutableLiveData<ArrayList<String>>()
    val currentQuotesLD: LiveData<ArrayList<String>>
        get() = _currentQuotesMLD


    private val _birthDateMLD = MutableLiveData<Long>()
    val birthDateLD: LiveData<Long>
        get() = _birthDateMLD


    private val _deathDateMLD = MutableLiveData<Long>()
    val deathDateLD: LiveData<Long>
        get() = _deathDateMLD

    private val dateListener = SharedPreferences.OnSharedPreferenceChangeListener{sharedPreferences, key ->
        Log.d(TAG, "dateListener: started")
        when(key) {
        Constants.DATE_PERSON_BIRTH -> {

            _birthDateMLD.value = sharedPreferences.getLong(key, DATE_DEFAULT)

            Log.d(TAG, "dateListener: new birth date is ${_birthDateMLD.value}")

        }

        Constants.DATE_PERSON_DEATH -> {

            _birthDateMLD.value = sharedPreferences.getLong(key, DATE_DEFAULT)

            Log.d(TAG, "dateListener: new death date is ${_birthDateMLD.value}")

        }
    }

        Log.d(TAG, "dateListener: ends")
    }




    init {
        dateSharedPref.registerOnSharedPreferenceChangeListener(dateListener)
        _birthDateMLD.value = dateSharedPref.getLong(Constants.DATE_PERSON_BIRTH, DATE_DEFAULT)
        _deathDateMLD.value = dateSharedPref.getLong(Constants.DATE_PERSON_DEATH, DATE_DEFAULT)

    }

    fun addQuote(quote: String) {
        Log.d(TAG, "addQuote: starts with $quote")
        if(_currentQuotesMLD.value == null) {
            _currentQuotesMLD.value = arrayListOf() // initialize if not exist
        }
        _currentQuotesMLD.value?.add(quote)
        _currentQuotesMLD.notifyObserver() // if you didn't assign its own value it wouldn't notify activity
        Log.d(TAG, "addQuote: ends with ${_currentQuotesMLD.value}")
    }

    fun updatePersonBirth(date: Long) {
        Log.d(TAG, "updatePersonBirth: starts with $date")
        dateSharedPref.edit().putLong(Constants.DATE_PERSON_BIRTH, date).apply()
    }

    fun updatePersonDeath(date: Long) {
        Log.d(TAG, "updatePersonDeath: starts with $date")
        dateSharedPref.edit().putLong(Constants.DATE_PERSON_DEATH, date).apply()
    }


    override fun onCleared() {
        Log.d(TAG, "onCleared: starts")
        super.onCleared()
        dateSharedPref.unregisterOnSharedPreferenceChangeListener(dateListener)
        Log.d(TAG, "onCleared: ends")
    }


}