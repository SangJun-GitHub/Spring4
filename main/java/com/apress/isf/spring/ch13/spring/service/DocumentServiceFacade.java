package com.apress.isf.spring.ch13.spring.service;

import com.apress.isf.spring.ch13.java.model.Document;
import com.apress.isf.spring.ch13.java.model.Type;
import com.apress.isf.spring.ch13.java.service.DocumentService;
import com.apress.isf.spring.ch13.spring.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/26/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */
@Component("documentFacade")
public class DocumentServiceFacade implements DocumentService {

    @Autowired
    DocumentDAO documentDAO;
    @Override
    public List<Document> getAllDocuments() {
        return documentDAO.getAll();
    }

    @Override
    public Document findDocumentById(String id) {
        return documentDAO.findById(id);
    }

    @Override
    public Document saveDocument(String id, Document document) {
        return documentDAO.save(id, document);
    }

    @Override
    public Document removeDocumentById(String id) {
        return documentDAO.removeById(id);
    }

    @Override
    public List<Document> findByType(Type type) {
        return documentDAO.findByTypeName(type.getName());
    }

    @Override
    public boolean updateLocationFromDocumentId(String documentId, String location) {
        Document document = documentDAO.findById(documentId);
        if(document == null)
            return false;

        document.setLocation(location);
        saveDocument(documentId, document);
        return true;
    }
}
