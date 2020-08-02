package com.example.infs3605v1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605v1.R;
import com.example.infs3605v1.database.Exercise;

import java.util.ArrayList;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ExercisesElementViewHolder> {

    Context context;
    private ArrayList<Exercise> exerciseElementArrayList;

    public ExercisesElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercises_element, parent,
                false);
        ExercisesElementViewHolder exercisesElementViewHolder = new ExercisesElementViewHolder(view);
        return exercisesElementViewHolder;
    }

    public void onBindViewHolder(@NonNull ExercisesElementViewHolder holder, int position) {
        final Exercise exerciseElement = exerciseElementArrayList.get(position);
        context = holder.view.getContext();
        holder.exercisesElementTitle.setText(exerciseElement.getTitle());
        holder.exercisesElementBody.setText(exerciseElement.getBody());
    }

    public int getItemCount() {
        return exerciseElementArrayList.size();
    }

    public void setData(ArrayList<Exercise> data) {
        this.exerciseElementArrayList = data;
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