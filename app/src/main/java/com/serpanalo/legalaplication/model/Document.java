package com.serpanalo.legalaplication.model;

import java.util.ArrayList;

public class Document {

    private String id;
    private String title;
    private String document_version;
    private String structure_negative;
    private String structure_positive;
    private String redaction_positive;
    private String redaction_negative;
    private String implication_positive;
    private String implication_negative;
    private ArrayList<Article> articles;

    private boolean isvote;

    public Document(String id, String title, String document_version, String structure_negative, String structure_positive, String redaction_positive, String redaction_negative, String implication_positive, String implication_negative, ArrayList<Article> articles, boolean isvote) {
        this.id = id;
        this.title = title;
        this.document_version = document_version;
        this.structure_negative = structure_negative;
        this.structure_positive = structure_positive;
        this.redaction_positive = redaction_positive;
        this.redaction_negative = redaction_negative;
        this.implication_positive = implication_positive;
        this.implication_negative = implication_negative;
        this.articles = articles;
        this.isvote = isvote;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocument_version() {
        return document_version;
    }

    public void setDocument_version(String document_version) {
        this.document_version = document_version;
    }

    public String getStructure_negative() {
        return structure_negative;
    }

    public void setStructure_negative(String structure_negative) {
        this.structure_negative = structure_negative;
    }

    public String getStructure_positive() {
        return structure_positive;
    }

    public void setStructure_positive(String structure_positive) {
        this.structure_positive = structure_positive;
    }

    public String getRedaction_positive() {
        return redaction_positive;
    }

    public void setRedaction_positive(String redaction_positive) {
        this.redaction_positive = redaction_positive;
    }

    public String getRedaction_negative() {
        return redaction_negative;
    }

    public void setRedaction_negative(String redaction_negative) {
        this.redaction_negative = redaction_negative;
    }

    public String getImplication_positive() {
        return implication_positive;
    }

    public void setImplication_positive(String implication_positive) {
        this.implication_positive = implication_positive;
    }

    public String getImplication_negative() {
        return implication_negative;
    }

    public void setImplication_negative(String implication_negative) {
        this.implication_negative = implication_negative;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public boolean isIsvote() {
        return isvote;
    }

    public void setIsvote(boolean isvote) {
        this.isvote = isvote;
    }
}
