package com.apress.isf.spring.ch05;

import com.apress.isf.spring.ch02.Document;
import com.apress.isf.spring.ch03.DocumentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/09/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class DocumentRepository implements DocumentDAO {
    private static final Logger log = LoggerFactory.getLogger(DocumentRepository.class);
    private List<Document> documents = null;

    public List<Document> getDocuments(){
        return documents;
    }
    public void setDocuments(List<Document> documents){
        this.documents = documents;
    }

    @Override
    public Document[] getAll() {
        if(log.isDebugEnabled())
            log.debug("Start <getAll> Params: ");
        Document[] result = documents.toArray(new Document[documents.size()]);

        if(log.isDebugEnabled())
            log.debug("End <getAll> Result: " + result);
        return result;
    }
}
