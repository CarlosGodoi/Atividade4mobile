package com.example.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Posts implements Parcelable {

    private int user_id;
    private int id;
    private String title;
    private String body;
    private boolean completed;

    public Posts(int user_id, int id, String title, String body, boolean completed) {
        this.user_id = user_id;
        this.id = id;
        this.title = title;
        this.body = body;
        this.completed = completed;
    }





    public Posts(JSONObject json) throws JSONException {
        super();
        try {

            this.user_id = json.getInt("userId");
            this.id = json.getInt("id");
            this.title = json.getString("titulo");
            this.body = json.getString("id");
            this.completed = json.getBoolean("completed");
        } catch(JSONException e){
            e.printStackTrace();
        }
    }

    protected Posts(Parcel in) {
        user_id = in.readInt();
        id = in.readInt();
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<Posts> CREATOR = new Creator<Posts>() {
        @Override
        public Posts createFromParcel(Parcel in) {
            return new Posts(in);
        }

        @Override
        public Posts[] newArray(int size) {
            return new Posts[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public String toString(){
        return "user_id"+user_id+"\n"+
                "id"+id+"\n"+
                "title"+title+"\n"+
                "body"+body+"\n---------------\n";
    }

    public int getUser_id(){return user_id;}
    public void setUser_id(int user_id){this.user_id = user_id;}
    public int id(){return id;}
    public void setId(int id){this.id = id;}
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
    public boolean isCompleted(){ return completed; }
    public void setCompleted(boolean completed) { this.completed = completed;}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posts posts = (Posts) o;
        return id == posts.id;
    }
    @Override
    public int hashCode(){return Objects.hash(id);}


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.user_id);
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.body);
    }
}

