package com.apress.isf.spring.ch08;

import com.apress.isf.spring.ch02.Document;
import com.apress.isf.spring.ch02.Type;
import com.apress.isf.spring.ch03.DocumentDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sang Jun Park on 11/14/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class SearchEngineService implements SearchEngine{
    private DocumentDAO documentDAO;
    public SearchEngineService(){}

    public DocumentDAO getDocumentDAO(){
        return documentDAO;
    }
    public void setDocumentDAO(DocumentDAO documentDAO){
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
        List<Document> result = Arrays.asList(documentDAO.getAll());
        return result;
    }

    @Override
    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException(
                "findByLocation not yet implemented."
        );
    }
}
