package com.example.infs3605v1.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605v1.R;
import com.example.infs3605v1.activities.SoothingToolsActivity;

import java.util.ArrayList;

public class SoothingToolsAdapter extends RecyclerView.Adapter<SoothingToolsAdapter.STElementViewHolder> {

    Context context;
    private ArrayList<String> sTElementArrayList;
    Intent intent;

    public STElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.soothing_tools_element, parent,
                false);
        STElementViewHolder sTElementViewHolder = new STElementViewHolder(view);
        return sTElementViewHolder;
    }

    public void onBindViewHolder(@NonNull STElementViewHolder holder, int position) {
        final String soothingToolsElement = sTElementArrayList.get(position);
        context = holder.view.getContext();
        holder.sTElementName.setText(soothingToolsElement);

        if(soothingToolsElement.equals("EXERCISES")){
            holder.sTElementImage.setImageResource(R.drawable.soothing_tools_exercise);
        } else if (soothingToolsElement.equals("MOOD TRACKER")){
            holder.sTElementImage.setImageResource(R.drawable.soothing_tools_mood_tracker);
        } else if (soothingToolsElement.equals("FORUM")) {
            holder.sTElementImage.setImageResource(R.drawable.soothing_tools_forum);
        } else if (soothingToolsElement.equals("MEDITATE")) {
            holder.sTElementImage.setImageResource(R.drawable.soothing_tools_meditate);
        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, SoothingToolsActivity.class);
                intent.putExtra("soothingToolsElement",soothingToolsElement);
                context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return sTElementArrayList.size();
    }

    public void setData(ArrayList<String> data) {
        this.sTElementArrayList = data;
    }

    public static class STElementViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView sTElementImage;
        public TextView sTElementName;

        public STElementViewHolder(View v) {
            super(v);
            view = v;
            sTElementImage = v.findViewById(R.id.sTElementImage);
            sTElementName = v.findViewById(R.id.sTElementName);
        }
    }
}

