package com.nemo.githubuserviewer.model.database.entity

import androidx.room.Entity

@Entity
data class UserFavorite(
    val id: Int,
    val isFavorite: Boolean
)
