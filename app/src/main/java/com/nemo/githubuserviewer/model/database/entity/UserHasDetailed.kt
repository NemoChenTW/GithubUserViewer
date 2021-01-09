package com.nemo.githubuserviewer.model.database.entity

import androidx.room.Entity

@Entity
data class UserHasDetailed(
    val id: Int,
    val hasDetailed: Boolean
)
