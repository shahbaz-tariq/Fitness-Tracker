package com.example.fitnesstracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnesstracker.databinding.FragmentWorkoutListBinding

class WorkoutListFragment : Fragment() {

    private lateinit var binding: FragmentWorkoutListBinding
    private val viewModel: WorkoutViewModel by viewModels()
    private lateinit var workoutAdapter: WorkoutAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkoutListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState:

    Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeWorkouts()
    }

    private fun setupRecyclerView() {
        adapter = WorkoutListAdapter() { workoutId ->
            val action = WorkoutListFragmentDirections.actionWorkoutListFragmentToWorkoutDetailFragment(workoutId)
            findNavController().navigate(action)
        }
        binding.workoutList.adapter = adapter
    }

    private fun observeWorkouts() {
        viewModel.allWorkouts.observe(viewLifecycleOwner) { workouts ->
            adapter.submitList(workouts)
        }
    }
}