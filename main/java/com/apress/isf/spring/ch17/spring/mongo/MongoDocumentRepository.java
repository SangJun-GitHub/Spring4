package com.apress.isf.spring.ch17.spring.mongo;

import com.apress.isf.spring.ch17.java.model.Document;
import com.apress.isf.spring.ch17.spring.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by Sang Jun Park on 01/04/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Repository("mongoDocumentDAO")
public class MongoDocumentRepository implements DocumentDAO {

    @Autowired
    private MongoOperations mongoTemplate;

    @Override
    public List<Document> getAll() {
        return mongoTemplate.findAll(Document.class);
    }

    @Override
    public Document save(String id, Document document) {
        Document _documentUpdate = findById(id);
        if(_documentUpdate == null){
            mongoTemplate.insert(document);
        } else {
            Query query = query(where("documentId").is(id));

            Update update = new Update();
            update.set("name", document.getName() == null ? _documentUpdate.getName() : document.getName());
            update.set("location", document.getLocation() == null ? _documentUpdate.getLocation() : document.getLocation());
            update.set("description", document.getDescription() == null ? _documentUpdate.getDescription() : document.getDescription());
            update.set("type", document.getType() == null ? _documentUpdate.getType() : document.getType());
            update.set("modified", new Date());

            mongoTemplate.updateFirst(query, update, Document.class);
            document = findById(id);
        }
        return document;
    }

    @Override
    public Document findById(String id) {
        Query query = query(where("documentId").is(id));
        return mongoTemplate.findOne(query, Document.class);
    }

    @Override
    public Document removeById(String id) {
        Document document = findById(id);
        if(document != null){
            mongoTemplate.remove(document);
        }
        return document;
    }

    @Override
    public List<Document> findByTypeName(String name) {
        Query query = query(where("documentId.type.name").is(name));
        return mongoTemplate.find(query, Document.class);
    }
}
