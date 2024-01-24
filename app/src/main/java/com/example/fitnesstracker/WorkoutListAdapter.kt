package com.example.fitnesstracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.data.Workout
import com.example.fitnesstracker.databinding.ItemWorkoutBinding

class WorkoutListAdapter : ListAdapter<Workout, WorkoutListAdapter.WorkoutViewHolder>(WorkoutDiffCallback()) {

    private var onItemClickListener: ((Long) -> Unit)? = null

    fun setOnItemClickListener(listener: (Long) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val binding = ItemWorkoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val workout = getItem(position)
        holder.bind(workout)
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(workout.workoutId)
        }
    }

    inner class WorkoutViewHolder(private val binding: ItemWorkoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(workout: Workout) {
            binding.workoutName.text = workout.workoutName
            binding.exerciseCount.text = resources.getQuantityString(R.plurals.exercise_count, workout.exercises.size, workout.exercises.size)

            val exercisesAdapter = ExercisesAdapter(workout.exercises)
            binding.exercisesList.adapter = exercisesAdapter
        }
    }

    class WorkoutDiffCallback : DiffUtil.ItemCallback<Workout>() {
        override fun areItemsTheSame(oldItem: Workout, newItem: Workout): Boolean =
            oldItem.workoutId == newItem.workoutId

        override fun areContentsTheSame(oldItem: Workout, newItem: Workout): Boolean =
            oldItem == newItem
    }

}
