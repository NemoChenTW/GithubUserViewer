package com.nemo.githubuserviewer.model.database

import androidx.paging.PagingSource
import androidx.room.*
import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.model.data.ListedUser
import com.nemo.githubuserviewer.model.database.entity.User
import com.nemo.githubuserviewer.model.database.entity.UserFavorite

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Insert(entity = User::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(listedUsers: List<ListedUser>)

    @Update
    fun update(user: User)

    @Update(entity = User::class)
    fun update(detailedUser: DetailedUser)

    @Update(entity = User::class)
    fun update(listedUser: ListedUser)

    @Update(entity = User::class)
    fun update(userFavorite: UserFavorite)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users")
    fun queryAllData(): PagingSource<Int, User>

    @Query("SELECT * FROM users LIMIT :size")
    suspend fun queryData(size: Int): List<User>

    @Query("SELECT * FROM users WHERE login = :name")
    fun findUserByName(name: String): User
}
