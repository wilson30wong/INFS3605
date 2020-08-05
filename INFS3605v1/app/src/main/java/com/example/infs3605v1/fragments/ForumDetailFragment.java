package com.example.infs3605v1.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.infs3605v1.R;
import com.example.infs3605v1.activities.ForumDetailActivity;
import com.example.infs3605v1.adapters.ForumDetailAdapter;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.ForumReply;

import java.util.ArrayList;

public class ForumDetailFragment extends Fragment {

    RecyclerView recyclerViewForumDetailFragment;
    ImageView forumDetailFragmentAdd;
    FrameLayout frameLayout;

    AppDatabase db;
    RecyclerView.LayoutManager forumDetailLayoutManager;
    ArrayList<ForumReply> forumReplyArrayList;
    ForumDetailAdapter forumDetailAdapter;


    public ForumDetailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_forum_detail, container, false);

        forumDetailFragmentAdd = frameLayout.findViewById(R.id.forumDetailFragmentAdd);
        recyclerViewForumDetailFragment = frameLayout.findViewById(R.id.forumDetailFragmentRv);
        forumDetailLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerViewForumDetailFragment.setLayoutManager(forumDetailLayoutManager);

        db = AppDatabase.getInstance(getActivity().getApplicationContext());

        forumReplyArrayList = new ArrayList<ForumReply>(db.forumReplyDao().findForumReplyByForumId(ForumDetailActivity.id));
        forumDetailAdapter = new ForumDetailAdapter();
        forumDetailAdapter.setData(forumReplyArrayList);
        recyclerViewForumDetailFragment.setAdapter(forumDetailAdapter);

        forumDetailFragmentAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentForumDetail, new NewForumReplyFragment()).addToBackStack(null).commit();
            }
        });

        return frameLayout;
    }

}
