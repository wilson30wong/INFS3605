package com.example.infs3605v1.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Learn {

    @PrimaryKey
    @NonNull
    String name;
    String whatIs;
    String signsAndSymptoms;
    String manage;
    String stories;

    public Learn(){

    }

    public Learn(String name, String whatIs, String signsAndSymptoms, String manage, String stories){
        this.name = name;
        this.whatIs = whatIs;
        this.signsAndSymptoms = signsAndSymptoms;
        this.manage = manage;
        this.stories = stories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhatIs() {
        return whatIs;
    }

    public void setWhatIs(String whatIs) {
        this.whatIs = whatIs;
    }

    public String getSignsAndSymptoms() {
        return signsAndSymptoms;
    }

    public void setSignsAndSymptoms(String signsAndSymptoms) {
        this.signsAndSymptoms = signsAndSymptoms;
    }

    public String getManage() {
        return manage;
    }

    public void setManage(String manage) {
        this.manage = manage;
    }

    public String getStories() {
        return stories;
    }

    public void setStories(String stories) {
        this.stories = stories;
    }
}
