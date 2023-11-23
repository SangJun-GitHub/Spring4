package com.apress.isf.spring.ch12.java.service;

import com.apress.isf.spring.ch12.java.model.Document;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/22/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface DocumentService {
    public List<Document> getAllDocuments();
    public Document findDocumentById(String id);
    public Document saveDocument(String id, Document document);
    public Document removeDocumentById(String id);
    public boolean updateLocationFromDocumentId(String documentId, String location);

}
