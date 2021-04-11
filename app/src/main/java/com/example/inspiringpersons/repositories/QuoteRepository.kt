package com.example.inspiringpersons.repositories

import com.example.inspiringpersons.data.model.PersonsWithQuotes
import com.example.inspiringpersons.data.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    fun getPersonsAndQuotes() : Flow<List<PersonsWithQuotes>>

    suspend fun insertQuotes(quotes: List<Quote>)
}