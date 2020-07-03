package com.example.infs3605v1.model;

public class Helpline {

    String link;
    String phone;
    String desc;

    public Helpline(){

    }

    public Helpline(String link, String phone, String desc){
        this.link = link;
        this.phone = phone;
        this.desc = desc;
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
}
