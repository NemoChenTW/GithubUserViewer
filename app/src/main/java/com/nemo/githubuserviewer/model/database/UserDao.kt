package com.nemo.githubuserviewer.model.database

import androidx.room.*
import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.model.data.ListedUser
import com.nemo.githubuserviewer.model.database.entity.User
import com.nemo.githubuserviewer.model.database.entity.UserFavorite
import com.nemo.githubuserviewer.model.database.entity.UserHasDetailed

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Update(entity = User::class)
    fun update(detailedUser: DetailedUser)

    @Update(entity = User::class)
    fun update(listedUser: ListedUser)

    @Update(entity = User::class)
    fun update(userFavorite: UserFavorite)

    @Update(entity = User::class)
    fun update(userHasDetailed: UserHasDetailed)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users WHERE login = :name")
    fun findUserByName(name: String): User
}
