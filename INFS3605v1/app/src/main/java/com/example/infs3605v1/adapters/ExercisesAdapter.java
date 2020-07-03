package com.example.infs3605v1.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605v1.R;
import com.example.infs3605v1.activities.LearnActivity;
import com.example.infs3605v1.model.Exercises;

import java.util.ArrayList;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ExercisesElementViewHolder> {

    Context context;
    private ArrayList<Exercises> exercisesElementArrayList;

    public ExercisesElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercises_element, parent,
                false);
        ExercisesElementViewHolder exercisesElementViewHolder = new ExercisesElementViewHolder(view);
        return exercisesElementViewHolder;
    }

    public void onBindViewHolder(@NonNull ExercisesElementViewHolder holder, int position) {
        final Exercises exercisesElement = exercisesElementArrayList.get(position);
        context = holder.view.getContext();
        holder.exercisesElementTitle.setText(exercisesElement.getTitle());
        holder.exercisesElementBody.setText(exercisesElement.getBody());

    }

    public int getItemCount() {
        return exercisesElementArrayList.size();
    }

    public void setData(ArrayList<Exercises> data) {
        this.exercisesElementArrayList = data;
    }

    public static class ExercisesElementViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView exercisesElementTitle;
        public TextView exercisesElementBody;

        public ExercisesElementViewHolder(View v) {
            super(v);
            view = v;
            exercisesElementTitle = v.findViewById(R.id.exercisesElementTitle);
            exercisesElementBody = v.findViewById(R.id.exercisesElementBody);
        }
    }
}