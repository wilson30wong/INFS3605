package com.example.infs3605v1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class,
        Learn.class,
        Helpline.class,
        Exercise.class,
        MoodTracker.class,
        Forum.class,
        ForumReply.class}, version = 8)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract LearnDao learnDao();
    public abstract HelplineDao helplineDao();
    public abstract ExerciseDao exerciseDao();
    public abstract MoodTrackerDao moodTrackerDao();
    public abstract ForumDao forumDao();
    public abstract ForumReplyDao forumReplyDao();

    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context) {

        if(instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "appDb").allowMainThreadQueries().build();
        }
        return instance;
    }
}
