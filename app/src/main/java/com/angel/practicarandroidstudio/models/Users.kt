package com.angel.practicarandroidstudio.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id : Long =0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "email")
    val email: String
)
