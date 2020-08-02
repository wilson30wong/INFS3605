package com.example.infs3605v1.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Helpline {

    @PrimaryKey
    @NonNull
    String link;
    String phone;
    String desc;
    String logoLink;

    public Helpline(){

    }

    public Helpline(String link, String phone, String desc, String logoLink ){
        this.link = link;
        this.phone = phone;
        this.desc = desc;
        this.logoLink = logoLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLogoLink() {
        return logoLink;
    }

    public void setLogoLink(String logoLink) {
        this.logoLink = logoLink;
    }
}
