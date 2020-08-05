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
import com.example.infs3605v1.activities.HomeActivity;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.Forum;
import com.example.infs3605v1.methods.Methods;

public class NewForumFragment extends Fragment {

    ConstraintLayout newForumElement;
    EditText newForumTitle;
    Button newForumCreate;
    Toast toast;
    FrameLayout frameLayout;

    AppDatabase db;
    Forum forum;
    Methods methods;

    public NewForumFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_new_forum, container, false);

        newForumElement = frameLayout.findViewById(R.id.newForumElement);
        newForumTitle = newForumElement.findViewById(R.id.newForumTitle);
        newForumCreate = newForumElement.findViewById(R.id.newForumCreate);

        db = AppDatabase.getInstance(getActivity().getApplicationContext());
        methods = new Methods(getActivity().getApplicationContext());

        newForumCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forum = new Forum(
                        0,
                        newForumTitle.getText().toString().trim(),
                        HomeActivity.username,
                        methods.getCurrentDate()
                );
                db.forumDao().insert(forum);
                toast = Toast.makeText(getActivity().getApplicationContext(), "Forum Post Created", Toast.LENGTH_LONG);
                methods.toastConfiguration(toast);
                toast.show();
                getFragmentManager().beginTransaction().replace(R.id.fragmentSoothingTools, new ForumFragment()).addToBackStack(null).commit();
            }
        });
        return frameLayout;
    }

}
