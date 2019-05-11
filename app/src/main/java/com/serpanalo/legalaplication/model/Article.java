package com.serpanalo.legalaplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable {

    private String id;
    private String arrange;
    private String title;
    private String description;
    private String document_id;

    public Article() {
    }

    public Article(String id, String arrange, String title, String description, String document_id) {
        this.id = id;
        this.arrange = arrange;
        this.title = title;
        this.description = description;
        this.document_id = document_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArrange() {
        return arrange;
    }

    public void setArrange(String arrange) {
        this.arrange = arrange;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.arrange);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.document_id);
    }

    protected Article(Parcel in) {
        this.id = in.readString();
        this.arrange = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.document_id = in.readString();
    }

    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel source) {
            return new Article(source);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
