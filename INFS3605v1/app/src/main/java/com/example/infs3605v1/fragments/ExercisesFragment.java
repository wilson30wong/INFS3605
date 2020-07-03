package com.example.infs3605v1.fragments;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.infs3605v1.R;
import com.example.infs3605v1.adapters.ExercisesAdapter;
import com.example.infs3605v1.adapters.LearnAdapter;
import com.example.infs3605v1.model.Exercises;

import java.util.ArrayList;


public class ExercisesFragment extends Fragment {

    ConstraintLayout exercisesFragmentElement;
    ConstraintLayout exercisesElement;
    RecyclerView recyclerViewExercises;
    RecyclerView.LayoutManager exercisesLayoutManager;

    public ExercisesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FrameLayout frameLayout = (FrameLayout)inflater.inflate(R.layout.fragment_exercises, container, false);

        exercisesFragmentElement = frameLayout.findViewById(R.id.exercisesFragmentElement);

        recyclerViewExercises = exercisesFragmentElement.findViewById(R.id.rv_exercises);
        exercisesLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerViewExercises.setLayoutManager(exercisesLayoutManager);

        ExercisesAdapter exercisesAdapter = new ExercisesAdapter();
        ArrayList<Exercises> exercisesElementArrayList = new ArrayList<Exercises>();
        exercisesElementArrayList.add(new Exercises("breathe","Practice 4-7-8 breathing.\n\nInhale to 4\nHold for 7\nExhale to 8"));
        exercisesElementArrayList.add(new Exercises("self-soothe","Take a shower, or bath, find a grounding object, and light a candle."));
        exercisesElementArrayList.add(new Exercises("other","Other\n\nOther\nOther"));
        exercisesElementArrayList.add(new Exercises("other","Other\n\nOther\nOther"));
        exercisesAdapter.setData(exercisesElementArrayList);
        recyclerViewExercises.setAdapter(exercisesAdapter);


        return frameLayout;
    }

}
