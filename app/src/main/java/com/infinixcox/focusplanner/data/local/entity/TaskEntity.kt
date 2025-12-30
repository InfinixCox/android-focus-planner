package com.infinixcox.focusplanner.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val task_id: Int = 0,
    val title: String,
    val description: String?,
    val priority: Int, // 1=Low, 2=Medium, 3=High
    val is_sensitive: Boolean, // True = Not sent to AI
    val status: String = "PENDING", // PENDING, DONE
    val created_at: Long = System.currentTimeMillis()
)
