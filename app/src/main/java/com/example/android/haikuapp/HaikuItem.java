package com.example.android.haikuapp;

public class HaikuItem {
    private int id = 0;
    private String haikuString = null;
    private String authorString = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHaikuString() {
        return haikuString;
    }

    public void setHaikuString(String haikuString) {
        this.haikuString = haikuString;
    }

    public String getAuthorString() {
        return authorString;
    }

    public void setAuthorString(String authorString) {
        this.authorString = authorString;
    }
}
