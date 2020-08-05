package com.example.infs3605v1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605v1.R;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.Forum;
import com.example.infs3605v1.fragments.ForumDetailFragment;

public class ForumDetailActivity extends AppCompatActivity {

    TextView forumDetailForumTitle;
    TextView forumDetailForumAuthorDate;

    Intent intent;
    public static int id;
    AppDatabase db;
    Forum forum;
    FragmentManager fragmentManager;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_detail);

        forumDetailForumTitle = findViewById(R.id.forumDetailForumTitle);
        forumDetailForumAuthorDate = findViewById(R.id.forumDetailForumAuthorDate);

        intent = getIntent();
        id = intent.getIntExtra("id", 0);
        db = AppDatabase.getInstance(getApplicationContext());
        forum = db.forumDao().findForumById(id);

        forumDetailForumTitle.setText(forum.getTitle());
        forumDetailForumAuthorDate.setText(forum.getUsername() + " " + forum.getDate());

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentForumDetail, new ForumDetailFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
        } else if(count % 2 == 0){
            intent = new Intent(getApplicationContext(), SoothingToolsActivity.class);
            intent.putExtra("soothingToolsElement","FORUM");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

}
