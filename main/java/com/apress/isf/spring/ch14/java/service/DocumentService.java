package com.apress.isf.spring.ch14.java.service;

import com.apress.isf.spring.ch14.java.model.Document;
import com.apress.isf.spring.ch14.java.model.Type;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/28/2023.
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
