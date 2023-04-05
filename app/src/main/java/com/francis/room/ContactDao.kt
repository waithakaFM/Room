package com.francis.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao{

    // Updating and inserting, similar to onConflict = replace
    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact ORDER BY firstName ASC")
    // flow can also be replace by livedata
    fun getContextOrderedByFirstName(): Flow<List<Contact>>


    @Query("SELECT * FROM contact ORDER BY lastName ASC")
    fun getContextOrderedByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY phoneNumber ASC")
    fun getContextOrderedByPhoneNumber(): Flow<List<Contact>>
}
