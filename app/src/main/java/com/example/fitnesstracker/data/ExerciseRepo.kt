package com.example.fitnesstracker.data

//ExerciseRepo.kt
class ExerciseRepository(private val exerciseDao: ExerciseDao) {

    suspend fun getExercisesForWorkout(workoutId: Long): List<Exercise> {
        return exerciseDao.getExercisesForWorkout(workoutId)
    }

    suspend fun getExerciseById(exerciseId: Long): Exercise? {
        return exerciseDao.getExerciseById(exerciseId)
    }

    suspend fun insertExercise(exercise: Exercise) {
        exerciseDao.insertExercise(exercise)
    }

    suspend fun updateExercise(exercise: Exercise) {
        exerciseDao.updateExercise(exercise)
    }

    suspend fun deleteExercise(exercise: Exercise) {
        exerciseDao.deleteExercise(exercise)
    }
}
