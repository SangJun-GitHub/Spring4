package com.apress.isf.spring.ch14.java.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sang Jun Park on 11/28/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class User {
    public String userId;
    public String email;
    public String password;
    public String name;
    List<Document> documents = new ArrayList<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
