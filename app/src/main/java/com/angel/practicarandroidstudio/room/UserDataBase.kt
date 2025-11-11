package com.angel.practicarandroidstudio.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.angel.practicarandroidstudio.models.Users


@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class UserDataBase: RoomDatabase() {
    abstract fun usersDao() : UserDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: UserDataBase? = null

        fun getDatabase(context: Context): UserDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}