package com.example.sergiobet.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "match_table")
data class Match(@PrimaryKey val description: String,
                 @ColumnInfo val homeTeamFlag: String,
                 @ColumnInfo val visitorTeamFlag: String,
                 @ColumnInfo val scheduledTime: String)