package com.upload.api.upload.models;


public class FileUpload {

    private String name;
    private String identication;
    private String Role;

    public FileUpload() {
    }

    public FileUpload(String name, String identication, String role) {
        this.name = name;
        this.identication = identication;
        Role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentication() {
        return identication;
    }

    public void setIdentication(String identication) {
        this.identication = identication;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
