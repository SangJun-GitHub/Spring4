package com.apress.isf.spring.ch15.java.service;

import com.apress.isf.spring.ch15.java.model.Document;
import com.apress.isf.spring.ch15.java.model.Type;

import java.util.List;

/**
 * Created by Sang Jun Park on 12/04/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface SearchEngine {
    public List<Document> findByType(Type documentType);

    public List<Document> listAll();

    public List<Document> findByLocation(String location);

    public Document findById(String id);
}
