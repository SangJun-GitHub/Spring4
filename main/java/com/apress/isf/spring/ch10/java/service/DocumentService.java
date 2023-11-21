package com.apress.isf.spring.ch10.java.service;

import com.apress.isf.spring.ch10.java.model.Document;
import com.apress.isf.spring.ch10.java.model.Type;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/20/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface DocumentService {
    public void createNewType(Type type);
    public void updateType(Type type);
    public void removeTypeById(String id);
    public List<Type> getAllDefinedTypes();
    public Type getTypeById(String id);

    public void createNewDocument(Document document);
    public void removeDocumentById(String id);
    public void updateDocument(Document document);
    public void updateLocationFromDocumentId(String documentId, String location);
}
