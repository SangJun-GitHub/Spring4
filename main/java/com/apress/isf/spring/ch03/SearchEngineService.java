package com.apress.isf.spring.ch03;

import com.apress.isf.spring.ch02.Document;
import com.apress.isf.spring.ch02.SearchEngine;
import com.apress.isf.spring.ch02.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sang Jun Park on 11/02/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class SearchEngineService implements SearchEngine {
    private DocumentDAO  documentDAO;
    private DocumentDAO getDocumentDAO(){
        return documentDAO;
    }
    public void setDocumentDAO(DocumentDAO documentDAO){
        this.documentDAO = documentDAO;
    }

    @Override
    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();
        for(Document document : listAll()){
            if(document.getType().getName().equals(documentType.getName()))
                result.add(document);
        }
        return result;
    }

    @Override
    public List<Document> listAll() {
        return Arrays.asList(documentDAO.getAll());
    }
}
