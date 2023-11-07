package com.apress.isf.spring.ch04;

import com.apress.isf.spring.ch02.Document;
import com.apress.isf.spring.ch02.SearchEngine;
import com.apress.isf.spring.ch02.Type;
import com.apress.isf.spring.ch03.DocumentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sang Jun Park on 11/06/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class SearchEngineService implements SearchEngine {

    private static final Logger log = LoggerFactory.getLogger(SearchEngineService.class);
    private DocumentDAO documentDAO;

    public SearchEngineService(){
        if(log.isDebugEnabled())
            log.debug("SearchEngineService created: " + this);
    }

    public DocumentDAO getDocumentDAO(){
        return documentDAO;
    }
    public void setDocumentDAO(DocumentDAO documentDAO){
        if(log.isDebugEnabled())
            log.debug("Document DAO set: " + documentDAO);
        this.documentDAO = documentDAO;
    }
    @Override
    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();
        for(Document doc : listAll()){
            if(doc.getType().getName().equals(documentType.getName()))
                result.add(doc);
        }
        return result;
    }

    @Override
    public List<Document> listAll() {
        return Arrays.asList(documentDAO.getAll());
    }
}
