package com.apress.isf.spring.ch16.spring.mongo;

import com.apress.isf.spring.ch16.java.model.Document;
import com.apress.isf.spring.ch16.spring.data.DocumentDAO;
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
 * Created by Sang Jun Park on 12/10/2023.
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
        if(null==_documentUpdate){
            mongoTemplate.insert(document);
        }else{
            Query query = query(where("documentId").is(id));
            Update update = new Update();
            update.set("name",null == document.getName() ?
                    _documentUpdate.getName():document.getName());
            update.set("location",null == document.getLocation() ?
                    _documentUpdate.getLocation():document.getLocation());
            update.set("description",null == document.getDescription() ?
                    _documentUpdate.getDescription() : document.getDescription());
            update.set("type",null == document.getType() ?
                    _documentUpdate.getType() : document.getType());
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
        if(document!=null)
            mongoTemplate.remove(document);
        return document;
    }

    @Override
    public List<Document> findByTypeName(String name) {
        Query query = query(where("documentId.type.name").is(name));
        return mongoTemplate.find(query, Document.class);
    }

}
