package com.apress.isf.spring.ch09.spring.jdbc;

import com.apress.isf.spring.ch09.model.Document;
import com.apress.isf.spring.ch09.spring.data.DocumentDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Sang Jun Park on 11/19/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class DocumentJdbcTemplateRepository implements DocumentDAO {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private String query;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public void setQuery(String query){
        this.query = query;
    }
    @Override
    public List<Document> getAll() {
        return jdbcTemplate.query(query, new DocumentRowMapper());
    }
}
