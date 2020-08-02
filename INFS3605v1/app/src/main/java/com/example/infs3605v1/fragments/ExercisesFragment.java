package com.example.infs3605v1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605v1.R;
import com.example.infs3605v1.adapters.ExercisesAdapter;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.Exercise;

import java.util.ArrayList;

public class ExercisesFragment extends Fragment {

    ConstraintLayout exercisesFragmentElement;
    RecyclerView recyclerViewExercises;
    RecyclerView.LayoutManager exercisesLayoutManager;
    FrameLayout frameLayout;

    AppDatabase db;
    ExercisesAdapter exercisesAdapter;
    ArrayList<Exercise> exerciseElementArrayList;

    public ExercisesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_exercises, container, false);

        exercisesFragmentElement = frameLayout.findViewById(R.id.exercisesFragmentElement);

        db = AppDatabase.getInstance(getActivity().getApplicationContext());

        recyclerViewExercises = exercisesFragmentElement.findViewById(R.id.exercisesRv);
        exercisesLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerViewExercises.setLayoutManager(exercisesLayoutManager);

        exercisesAdapter = new ExercisesAdapter();
        exerciseElementArrayList = new ArrayList<Exercise>(db.exerciseDao().getAll());
        exercisesAdapter.setData(exerciseElementArrayList);
        recyclerViewExercises.setAdapter(exercisesAdapter);

        return frameLayout;
    }

}
