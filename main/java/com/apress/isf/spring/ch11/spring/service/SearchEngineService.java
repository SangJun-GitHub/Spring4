package com.apress.isf.spring.ch11.spring.service;

import com.apress.isf.spring.ch11.java.model.Document;
import com.apress.isf.spring.ch11.java.model.Type;
import com.apress.isf.spring.ch11.java.service.SearchEngine;
import com.apress.isf.spring.ch11.spring.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sang Jun Park on 11/21/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Component
public class SearchEngineService implements SearchEngine {
    @Autowired
    private DocumentDAO documentDAO;

    public List<Document> findByType(Type documentType) {
        List<Document>  result = new ArrayList<Document>();
        for (Document doc : listAll()) {
            if (doc.getType().getName().equals(documentType.getName()))
                result.add(doc);
        }
        return result;
    }

    public List<Document> listAll() {
        List<Document> result = documentDAO.getAll();
        return result;
    }

    public Document findById(String id) {
        return documentDAO.findById(id);
    }

    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException("findByLocation not yet implemented.");
    }

}
