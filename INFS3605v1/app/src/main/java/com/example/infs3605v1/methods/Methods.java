package com.example.infs3605v1.methods;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605v1.R;
import com.example.infs3605v1.database.AppDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Methods {

    private Context context;
    Date dateRaw;
    SimpleDateFormat dateFormat;
    String date;
    View view;
    TextView textView;
    AppDatabase db;

    public Methods(Context context){
        this.context = context;
    }

    public Toast toastConfiguration(Toast toast) {
        view = toast.getView();
        view.getBackground().setColorFilter(context.getResources().getColor(R.color.colorPrimaryDark), PorterDuff.Mode.SRC_IN);

        textView = (TextView) view.findViewById(android.R.id.message);
        textView.setTextColor(Color.WHITE);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(15);

        return toast;
    }

    public String getCurrentDate(){
        dateRaw = Calendar.getInstance().getTime();
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        date  = dateFormat.format(dateRaw);
        return date;
    }

    public void clearDatabase(){
        db = AppDatabase.getInstance(context);
        db.userDao().deleteAll();
        db.learnDao().deleteAll();
        db.helplineDao().deleteAll();
        db.exerciseDao().deleteAll();
        db.moodTrackerDao().deleteAll();
        db.forumDao().deleteAll();
        db.forumReplyDao().deleteAll();
    }

}
