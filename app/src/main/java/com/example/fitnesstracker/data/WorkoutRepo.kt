package com.example.fitnesstracker.data

//WorkoutRepo.kt
class WorkoutRepository(private val workoutDao: WorkoutDao) {

    suspend fun getAllWorkouts(): List<Workout> {
        return workoutDao.getAllWorkouts()
    }

    suspend fun getWorkoutById(workoutId: Long): Workout? {
        return workoutDao.getWorkoutById(workoutId)
    }

    suspend fun insertWorkout(workout: Workout) {
        workoutDao.insertWorkout(workout)
    }

    suspend fun updateWorkout(workout: Workout) {
        workoutDao.updateWorkout(workout)
    }

    suspend fun deleteWorkout(workout: Workout) {
        workoutDao.deleteWorkout(workout)
    }
}