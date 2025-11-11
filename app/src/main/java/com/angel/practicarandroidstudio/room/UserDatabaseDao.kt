package com.angel.practicarandroidstudio.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.angel.practicarandroidstudio.models.Users
import kotlinx.coroutines.flow.Flow

//Interface -> Repositorio -> Viewmodel -> view

@Dao //Data Access Observer
interface UserDatabaseDao {

    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<Users>>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUsersById(id: Long): Flow<Users>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: Users)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(user: Users)

    @Delete
    suspend fun delete(user: Users)


}