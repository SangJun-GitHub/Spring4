package com.apress.isf.spring.ch11.spring.data;

import com.apress.isf.spring.ch11.java.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

/**
 * Created by Sang Jun Park on 11/21/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Repository("documentDAO")
public class DocumentRepository implements DocumentDAO {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private String query;
    @Autowired
    private String insert;
    @Autowired
    private String find;
    @Autowired
    private String update;

    @Override
    public List<Document> getAll() {
        return new JdbcTemplate(dataSource).query(query, new DocumentRowMapper());
    }

    @Override
    public void save(Document document) {
        try{
            JdbcTemplate template = new JdbcTemplate(dataSource);
            if(null == findById(document.getDocumentId()))
                template.update(insert, new Object[]{
                        document.getDocumentId(),
                        document.getName(),
                        document.getLocation(),
                        document.getDescription(),
                        document.getType().getTypeId(),
                        document.getCreated(),
                        document.getModified()});
            else
                template.update(update, new Object[]{
                        document.getName(),
                        document.getLocation(),
                        document.getDescription(),
                        document.getType().getTypeId(),
                        new Date(),
                        document.getDocumentId()});
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Document findById(String id) {
        Document updateDocument = null;
        JdbcTemplate template = new JdbcTemplate(dataSource);
        try{
            updateDocument = template.queryForObject(find, new Object[] {id}, new DocumentRowMapper());
        }catch (EmptyResultDataAccessException e){}

        return updateDocument;
    }
}
