package com.serpanalo.legalaplication.model;

public class User {

    private String id;
    private String name;
    private String rol;
    private String surname;

    public User() {
    }

    public User(String id, String name, String rol, String surname) {
        this.id = id;
        this.name = name;
        this.rol = rol;
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
