package com.infinixcox.focusplanner.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "achievement_logs")
data class AchievementLogEntity(
    @PrimaryKey(autoGenerate = true) val achievement_id: Int = 0,
    val milestone_type: String, // STREAK_7_DAY, TASK_MARATHON
    val points_awarded: Int,
    val date_awarded: Long = System.currentTimeMillis()
)
