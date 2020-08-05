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
import com.example.infs3605v1.activities.ForumDetailActivity;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.Forum;
import com.example.infs3605v1.database.ForumReply;

import java.util.ArrayList;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ForumViewHolder> {

    Context context;
    private ArrayList<Forum> forumArrayList;
    Intent intent;
    AppDatabase db;
    ForumReply forumReply;

    public ForumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forum_post, parent,
                false);
        ForumViewHolder forumViewHolder = new ForumViewHolder(view);
        return forumViewHolder;
    }

    public void onBindViewHolder(@NonNull ForumViewHolder holder, int position) {
        final Forum forum = forumArrayList.get(position);
        context = holder.view.getContext();
        holder.forumPostTitle.setText(forum.getTitle());
        holder.forumPostAuthorDate.setText(forum.getUsername() + " " + forum.getDate());
        db = AppDatabase.getInstance(context);
        forumReply = db.forumReplyDao().findMostRecentForumReplyByForum(forum.getId());
        if (forumReply != null) {
            holder.recentReply.setText(forumReply.getReply());
            holder.recentReplyAuthorDate.setText(forumReply.getUsername() + " " + forumReply.getDate());
        } else {
            holder.recentReply.setText("");
            holder.recentReplyAuthorDate.setText("");
        }
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context.getApplicationContext(), ForumDetailActivity.class);
                intent.putExtra("id", forum.getId());
                context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return forumArrayList.size();
    }

    public void setData(ArrayList<Forum> data) {
        this.forumArrayList = data;
    }

    public static class ForumViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ConstraintLayout forumPost;
        public TextView forumPostTitle;
        public TextView forumPostAuthorDate;
        public TextView recentReply;
        public TextView recentReplyAuthorDate;

        public ForumViewHolder(View v) {
            super(v);
            view = v;
            forumPost = v.findViewById(R.id.forumPost);
            forumPostTitle = forumPost.findViewById(R.id.forumPostTitle);
            forumPostAuthorDate = forumPost.findViewById(R.id.forumPostAuthorDate);
            recentReply = forumPost.findViewById(R.id.recentReply);
            recentReplyAuthorDate = forumPost.findViewById(R.id.recentReplyAuthorDate);
        }
    }
}