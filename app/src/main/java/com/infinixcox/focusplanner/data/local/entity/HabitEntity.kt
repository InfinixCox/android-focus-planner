package com.infinixcox.focusplanner.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class HabitEntity(
    @PrimaryKey(autoGenerate = true) val habit_id: Int = 0,
    val packageName: String, // e.g., "com.instagram.android"
    val is_blocked: Boolean = true
)
