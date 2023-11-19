package com.apress.isf.spring.ch09.spring.service;

import com.apress.isf.spring.ch09.model.Document;
import com.apress.isf.spring.ch09.model.Type;
import com.apress.isf.spring.ch09.service.SearchEngine;
import com.apress.isf.spring.ch09.spring.data.DocumentDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sang Jun Park on 11/18/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class SearchEngineService implements SearchEngine {
    private DocumentDAO documentDAO;

    public SearchEngineService(){}

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    @Override
    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();
        for(Document doc: listAll()){
            if(doc.getType().getName().equals(documentType.getName()))
                result.add(doc);
        }
        return result;
    }

    @Override
    public List<Document> listAll() {
        List<Document> result = documentDAO.getAll();
        return result;
    }

    @Override
    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException("findByLocation not yet implemented.");
    }
}
