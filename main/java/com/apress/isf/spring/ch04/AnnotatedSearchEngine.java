package com.apress.isf.spring.ch04;

import com.apress.isf.spring.ch02.Document;
import com.apress.isf.spring.ch02.SearchEngine;
import com.apress.isf.spring.ch02.Type;
import com.apress.isf.spring.ch03.DocumentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sang Jun Park on 11/07/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Service("engine")
@Scope("prototype")
public class AnnotatedSearchEngine implements SearchEngine {
    private static final Logger log = LoggerFactory.getLogger(SearchEngineService.class);

    @Autowired
    private DocumentDAO documentDAO;

    public AnnotatedSearchEngine(){
        if(log.isDebugEnabled())
            log.debug("AnnotatedSearchEngine created: " + this);
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
