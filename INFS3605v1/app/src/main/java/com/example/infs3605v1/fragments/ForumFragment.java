package com.example.infs3605v1.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605v1.R;
import com.example.infs3605v1.adapters.ForumAdapter;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.Forum;

import java.util.ArrayList;
import java.util.Collections;

public class ForumFragment extends Fragment {

    ConstraintLayout forumFragmentElement;
    RecyclerView recyclerViewForum;
    ImageView forumAdd;
    FrameLayout frameLayout;

    RecyclerView.LayoutManager forumLayoutManager;
    AppDatabase db;
    ArrayList<Forum> forumArrayList;
    ForumAdapter forumAdapter;

    public ForumFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_forum, container, false);

        forumFragmentElement = frameLayout.findViewById(R.id.forumFragmentElement);
        forumAdd = forumFragmentElement.findViewById(R.id.forumAdd);

        db = AppDatabase.getInstance(getActivity().getApplicationContext());

        recyclerViewForum = forumFragmentElement.findViewById(R.id.forumRv);
        forumLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerViewForum.setLayoutManager(forumLayoutManager);

        forumArrayList = new ArrayList<Forum>(db.forumDao().getAll());
        Collections.reverse(forumArrayList);
        forumAdapter = new ForumAdapter();
        forumAdapter.setData(forumArrayList);
        recyclerViewForum.setAdapter(forumAdapter);

        forumAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentSoothingTools, new NewForumFragment()).commit();
            }
        });

        return frameLayout;
    }

}
