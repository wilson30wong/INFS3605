package com.example.infs3605v1.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "username",
        childColumns = "username",
        onDelete = ForeignKey.CASCADE))
public class Forum {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;
    String title;
    String username;
    String date;

    public Forum(){

    }

    public Forum(int id, String title, String username, String date){
        this.id = id;
        this.title = title;
        this.username = username;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
