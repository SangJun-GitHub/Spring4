package com.apress.isf.spring.ch09.service;

import com.apress.isf.spring.ch09.model.Document;
import com.apress.isf.spring.ch09.model.Type;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/18/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface SearchEngine {
    public List<Document> findByType(Type documentType);
    public List<Document> listAll();
    public List<Document> findByLocation(String location);
}
