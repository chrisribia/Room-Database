package com.example.lateroomdb.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NoteDao {
    @Insert
   suspend fun addNote(note : Note)

    @Query("SELECT * FROM Note ORDER BY id DESC")
   suspend fun  getAllNotes() : List<Note>


    @Insert
   suspend fun addMultipleNotes(vararg note : Note)
}