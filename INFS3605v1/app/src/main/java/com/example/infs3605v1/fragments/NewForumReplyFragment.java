package com.example.infs3605v1.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.infs3605v1.R;
import com.example.infs3605v1.activities.ForumDetailActivity;
import com.example.infs3605v1.activities.HomeActivity;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.ForumReply;
import com.example.infs3605v1.methods.Methods;

public class NewForumReplyFragment extends Fragment {

    ConstraintLayout newForumReplyElement;
    EditText newForumReplyTitle;
    Button newForumReplyCreate;
    Toast toast;
    FrameLayout frameLayout;

    AppDatabase db;
    ForumReply forumReply;
    Methods methods;

    public NewForumReplyFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_new_forum_reply, container, false);

        newForumReplyElement = frameLayout.findViewById(R.id.newForumReplyElement);
        newForumReplyTitle = newForumReplyElement.findViewById(R.id.newForumReplyTitle);
        newForumReplyCreate = newForumReplyElement.findViewById(R.id.newForumReplyCreate);

        db = AppDatabase.getInstance(getActivity().getApplicationContext());
        methods = new Methods(getActivity().getApplicationContext());

        newForumReplyCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forumReply = new ForumReply(
                        0,
                        ForumDetailActivity.id,
                        newForumReplyTitle.getText().toString().trim(),
                        HomeActivity.username,
                        methods.getCurrentDate()
                );

                db.forumReplyDao().insert(forumReply);
                toast = Toast.makeText(getActivity().getApplicationContext(), "Forum Reply Created", Toast.LENGTH_LONG);
                methods.toastConfiguration(toast);
                toast.show();
                getFragmentManager().beginTransaction().replace(R.id.fragmentForumDetail, new ForumDetailFragment()).commit();
            }
        });

        return frameLayout;
    }

}
