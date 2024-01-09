package com.apress.isf.spring.ch16.java.service;

import com.apress.isf.spring.ch16.java.model.Document;
import com.apress.isf.spring.ch16.java.model.Type;

import java.util.List;

/**
 * Created by Sang Jun Park on 01/08/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface DocumentService {
    public List<Document> getAllDocuments();
    public Document findDocumentById(String id);
    public Document saveDocument(String id, Document document);
    public Document removeDocumentById(String id);
    public List<Document> findByType(Type type);
    public boolean updateLocationFromDocumentId(String documentId, String location);
}
