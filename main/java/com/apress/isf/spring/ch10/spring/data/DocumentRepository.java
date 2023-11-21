package com.apress.isf.spring.ch10.spring.data;

import com.apress.isf.spring.ch10.java.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Sang Jun Park on 11/20/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Repository("DocumentDAO")
public class DocumentRepository implements DocumentDAO{

    @Autowired
    private DataSource dataSource;
    @Autowired
    private String query;
    @Override
    public List<Document> getAll() {
        return new JdbcTemplate(this.dataSource).query(query, new DocumentRowMapper());
    }
}
