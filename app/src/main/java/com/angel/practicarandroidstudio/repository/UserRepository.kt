package com.angel.practicarandroidstudio.repository
import com.angel.practicarandroidstudio.models.Users
import com.angel.practicarandroidstudio.room.UserDatabaseDao
import com.angel.practicarandroidstudio.room.UserDataBase
import kotlinx.coroutines.flow.Flow

class UserRepository( private val userDataBaseDatabaseDao: UserDatabaseDao) {
    val allUSers: Flow<List<Users>> = userDataBaseDatabaseDao.getUsers()



    suspend fun insert(users: Users) {
        userDataBaseDatabaseDao.insert(users)
    }

    suspend fun update(users: Users) {
        userDataBaseDatabaseDao.update(users)
    }

    suspend fun delete(users: Users) {
        userDataBaseDatabaseDao.delete(users)
    }


    fun getProfileById(id: Long): Flow<Users?> {
        return userDataBaseDatabaseDao.getUsersById(id)
    }
}