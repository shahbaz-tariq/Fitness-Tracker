package com.example.fitnesstracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//DataModel.kt
@Entity(tableName = "workouts")
data class Workout(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)

@Entity(tableName = "exercises")
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val targetMuscleGroup: String,
    val weight: Int,
    val sets: Int,
    val reps: Int,
    val workoutId: Int
)
