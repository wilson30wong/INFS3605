package com.example.infs3605v1.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605v1.R;
import com.example.infs3605v1.activities.LearnActivity;
import com.example.infs3605v1.activities.SoothingToolsActivity;

import java.util.ArrayList;

public class SoothingToolsAdapter extends RecyclerView.Adapter<SoothingToolsAdapter.STElementViewHolder> {

    Context context;
    private ArrayList<String> sTElementArrayList;

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

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SoothingToolsActivity.class);
                System.out.println(soothingToolsElement);
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
        public TextView sTElementName;

        public STElementViewHolder(View v) {
            super(v);
            view = v;
            sTElementName = v.findViewById(R.id.sTElementName);
        }
    }
}

