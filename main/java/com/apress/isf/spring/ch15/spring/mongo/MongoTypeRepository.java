package com.apress.isf.spring.ch15.spring.mongo;

import com.apress.isf.spring.ch15.java.model.Type;
import com.apress.isf.spring.ch15.spring.data.TypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by Sang Jun Park on 12/01/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Repository("mongoTypeDAO")
public class MongoTypeRepository implements TypeDAO {

    @Autowired
    private MongoOperations mongoTemplate;
    @Override
    public List<Type> getAll() {
        return mongoTemplate.findAll(Type.class);
    }

    @Override
    public Type findById(String id) {
        Query query = query(where("typeId").is(id));
        return mongoTemplate.findOne(query, Type.class);
    }

    @Override
    public Type save(Type type) {
        mongoTemplate.insert(type);
        return type;
    }
}
