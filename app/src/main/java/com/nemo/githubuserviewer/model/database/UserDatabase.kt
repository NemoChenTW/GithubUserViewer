package com.nemo.githubuserviewer.model.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null
        private var DB_NAME = "my_database"

        fun getInstance(context: Context): UserDatabase {
            return INSTANCE ?: Room.databaseBuilder(context, UserDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration().build().also {
                    INSTANCE = it
                }
        }
    }
}
