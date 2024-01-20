package com.example.fitnesstracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesstracker.data.Workout
import com.example.fitnesstracker.data.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// WorkoutViewModel.kt
@HiltViewModel
class WorkoutViewModel @Inject constructor(
    private val workoutRepository: WorkoutRepository
) : ViewModel() {

    private val _allWorkouts = MutableLiveData<List<Workout>>()
    val allWorkouts: LiveData<List<Workout>> get() = _allWorkouts

    private val _selectedWorkout = MutableLiveData<Workout>()
    val selectedWorkout: LiveData<Workout> get() = _selectedWorkout

    fun getAllWorkouts() {
        viewModelScope.launch {
            _allWorkouts.value = workoutRepository.getAllWorkouts()
        }
    }

    fun getWorkoutById(workoutId: Long) {
        viewModelScope.launch {
            _selectedWorkout.value = workoutRepository.getWorkoutById(workoutId)
        }
    }

    fun insertWorkout(workout: Workout) {
        viewModelScope.launch {
            workoutRepository.insertWorkout(workout)
        }
    }

    fun updateWorkout(workout: Workout) {
        viewModelScope.launch {
            workoutRepository.updateWorkout(workout)
        }
    }

    fun deleteWorkout(workout: Workout) {
        viewModelScope.launch {
            workoutRepository.deleteWorkout(workout)
        }
    }
}
