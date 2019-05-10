package com.serpanalo.legalaplication.model;

public class User {

    private String id;
    private String ncolegiado;
    private String name;
    private String rol;
    private String firstname;
    private String token;

    public User() {
    }

    public User(String id, String ncolegiado, String name, String rol, String firstname, String token) {
        this.id = id;
        this.ncolegiado = ncolegiado;
        this.name = name;
        this.rol = rol;
        this.firstname = firstname;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNcolegiado() {
        return ncolegiado;
    }

    public void setNcolegiado(String ncolegiado) {
        this.ncolegiado = ncolegiado;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
