package com.infinixcox.focusplanner.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.infinixcox.focusplanner.data.local.entity.*
import com.infinixcox.focusplanner.data.local.dao.TaskDao

@Database(
    entities = [TaskEntity::class, HabitEntity::class, HabitLogEntity::class, AchievementLogEntity::class],
    version = 1
)
abstract class FocusDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
