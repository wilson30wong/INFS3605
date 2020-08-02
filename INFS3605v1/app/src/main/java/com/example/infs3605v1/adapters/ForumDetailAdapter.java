package com.example.infs3605v1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605v1.R;
import com.example.infs3605v1.database.ForumReply;

import java.util.ArrayList;

public class ForumDetailAdapter extends RecyclerView.Adapter<ForumDetailAdapter.ForumDetailViewHolder> {

    Context context;
    private ArrayList<ForumReply> forumReplyArrayList;

    public ForumDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forum_reply, parent,
                false);
        ForumDetailViewHolder forumDetailViewHolder = new ForumDetailViewHolder(view);
        return forumDetailViewHolder;
    }

    public void onBindViewHolder(@NonNull ForumDetailViewHolder holder, int position) {
        final ForumReply forumReply = forumReplyArrayList.get(position);
        context = holder.view.getContext();
        holder.forumReply.setText(forumReply.getReply());
        holder.forumReplyAuthorDate.setText(forumReply.getUsername() + " " + forumReply.getDate());
   ;
    }

    public int getItemCount() {
        return forumReplyArrayList.size();
    }

    public void setData(ArrayList<ForumReply> data) {
        this.forumReplyArrayList = data;
    }

    public static class ForumDetailViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView forumReply;
        public TextView forumReplyAuthorDate;

        public ForumDetailViewHolder(View v) {
            super(v);
            view = v;
            forumReply = v.findViewById(R.id.forumReply);
            forumReplyAuthorDate = v.findViewById(R.id.forumReplyAuthorDate);

        }
    }
}
