package com.example.sergiobet.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sergiobet.model.Match
import io.reactivex.Observable

@Dao
interface NextMatchDao {
    @Query("SELECT * FROM match_table")
    fun getAll(): List<Match>

    @Query("SELECT * FROM match_table")
    fun getAllAsync(): Observable<List<Match>>

    @Query("DELETE FROM match_table")
    fun deleteAll()

    @Insert
    fun insertAll(matches: List<Match>)
}