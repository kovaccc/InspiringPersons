package com.example.inspiringpersons.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.inspiringpersons.data.model.InspiringPerson
import kotlinx.coroutines.flow.Flow

@Dao
interface InspiringPersonDao {

    @Query("SELECT * FROM InspiringPerson ORDER BY birthDate")
    fun getInspiringPersons(): Flow<List<InspiringPerson>>


    @Query("SELECT * FROM InspiringPerson WHERE personId = :personId")
    fun getInspiringPerson(personId: Long): Flow<InspiringPerson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(persons: List<InspiringPerson>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInspiringPerson(inspiringPerson: InspiringPerson): Long
}