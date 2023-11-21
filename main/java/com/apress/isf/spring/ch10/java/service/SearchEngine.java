package com.apress.isf.spring.ch10.java.service;

import com.apress.isf.spring.ch10.java.model.Document;
import com.apress.isf.spring.ch10.java.model.Type;

import java.util.List;

public interface SearchEngine {
    public List<Document> findByType(Type type);
    public List<Document> listAll();
    public List<Document> findByLocation(String location);
}
