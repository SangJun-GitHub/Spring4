package com.apress.isf.spring.ch11.spring.service;

import com.apress.isf.spring.ch11.java.model.Document;
import com.apress.isf.spring.ch11.java.model.Type;
import com.apress.isf.spring.ch11.java.service.DocumentService;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/21/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class DocumetServiceFacade  implements DocumentService {
    @Override
    public void createNewType(Type type) {
    }
    @Override
    public void updateType(Type type) {
    }
    @Override
    public void removeTypeById(String id) {
    }
    @Override
    public List<Type> getAllDefinedTypes() {
        return null;
    }
    @Override
    public Type getTypeById(String id) {
        return null;
    }
    @Override
    public void createNewDocument(Document document) {
    }
    @Override
    public void removeDocumentById(String id) {
    }
    @Override
    public void updateDocument(Document document) {
    }
    @Override
    public void updateLocationFromDocumentId(String documentId, String location) {

    }
}
