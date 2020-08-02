package com.example.infs3605v1.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys =
        {@ForeignKey(entity = User.class,
                parentColumns = "username",
                childColumns = "username",
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Forum.class,
                parentColumns = "id",
                childColumns = "forumId",
                onDelete = ForeignKey.CASCADE)})
public class ForumReply {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;
    int forumId;
    String reply;
    String username;
    String date;

    public ForumReply(){

    }

    public ForumReply(int id, int forumId, String reply, String username, String date){
        this.id = id;
        this.forumId = forumId;
        this.reply = reply;
        this.username = username;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
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
