package com.apress.isf.spring.ch17.spring.service;

import com.apress.isf.spring.ch17.java.model.Type;
import com.apress.isf.spring.ch17.java.model.Document;
import com.apress.isf.spring.ch17.java.service.DocumentService;
import com.apress.isf.spring.ch17.spring.data.DocumentDAO;
import com.apress.isf.spring.ch17.spring.social.DocumentTweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sang Jun Park on 01/08/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Service("documentFacade")
public class DocumentServiceFacade implements DocumentService {


    @Autowired
    DocumentDAO documentDAO;

    @Autowired
    DocumentTweet documentTweet;


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
        Document documentResult = documentDAO.save(id, document);

        if("WEB".equals(documentResult.getType().getName())){
            StringBuilder tweetText = new StringBuilder("My Documents App - A Book update: ");
            tweetText.append(documentResult.getName());
            tweetText.append(". Check it out: ");
            tweetText.append(documentResult.getLocation());
            documentTweet.tweet(tweetText.toString());
        }
        return documentResult;
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
        if(null == document)
            return false;
        document.setLocation(location);
        saveDocument(documentId, document);
        return true;
    }
}
