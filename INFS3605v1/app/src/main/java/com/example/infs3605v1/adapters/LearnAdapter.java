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

import java.util.ArrayList;

public class LearnAdapter extends RecyclerView.Adapter<LearnAdapter.LearnElementViewHolder> {

    Context context;
    private ArrayList<String> learnElementArrayList;

    public LearnElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learn_element, parent,
                false);
        LearnElementViewHolder learnElementViewHolder = new LearnElementViewHolder(view);
        return learnElementViewHolder;
    }

    public void onBindViewHolder(@NonNull LearnElementViewHolder holder, int position) {
        final String learnElement = learnElementArrayList.get(position);
        context = holder.view.getContext();
        holder.learnElementName.setText(learnElement);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LearnActivity.class);
                intent.putExtra("learnElement",learnElement);
                context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return learnElementArrayList.size();
    }

    public void setData(ArrayList<String> data) {
        this.learnElementArrayList = data;
    }

    public static class LearnElementViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView learnElementName;

        public LearnElementViewHolder(View v) {
            super(v);
            view = v;
            learnElementName = v.findViewById(R.id.learnElementName);
        }
    }
}
