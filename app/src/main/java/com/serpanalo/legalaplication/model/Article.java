package com.serpanalo.legalaplication.model;

public class Article {

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
}
