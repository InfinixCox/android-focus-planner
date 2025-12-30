package com.infinixcox.focusplanner.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit_logs")
data class HabitLogEntity(
    @PrimaryKey(autoGenerate = true) val log_id: Int = 0,
    val completion_date: Long // Timestamp for streaks
)
