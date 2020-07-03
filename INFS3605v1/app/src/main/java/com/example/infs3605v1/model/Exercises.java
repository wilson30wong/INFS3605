package com.example.infs3605v1.model;

import com.android.volley.toolbox.StringRequest;

public class Exercises {

    String title;
    String body;

    public Exercises(){

    }

    public Exercises(String title, String body){
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
