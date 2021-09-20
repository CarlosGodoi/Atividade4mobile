package com.example.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Albuns implements Parcelable {

    private int user_id;
    private int id;
    private String title;
    private boolean completed;

    public Albuns(int user_id, int id, String title, boolean completed) {
        this.user_id = user_id;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Albuns(JSONObject json) throws JSONException {
        super();
        try {

            this.user_id = json.getInt("user_id");
            this.id = json.getInt("id");
            this.title = json.getString("titulo");
            this.completed = json.getBoolean("completed");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    protected Albuns(Parcel in) {
        user_id = in.readInt();
        id = in.readInt();
        title = in.readString();
        completed = in.readByte() != 0;
    }

    public static final Creator<Albuns> CREATOR = new Creator<Albuns>() {
        @Override
        public Albuns createFromParcel(Parcel in) {
            return new Albuns(in);
        }

        @Override
        public Albuns[] newArray(int size) {
            return new Albuns[size];
        }
    };

    @Override
    public String toString() {
        return "user_id"+user_id+"\n"+
                "id"+id+"\n"+
                "title"+title+"\n---------\n";
    }

    public int getUser_id(){ return user_id; }
    public void setUser_id(int user_id){this.user_id = user_id;}
    public int id(){ return id; }
    public void setId(int id){this.id = id;}
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isCompleted(){ return completed; }
    public void setCompleted(boolean completed) { this.completed = completed;}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Albuns albuns = (Albuns) o;
        return id == albuns.id;
    }

    @Override
    public int describeContents() { return 0; }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.user_id);
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
    }

}


