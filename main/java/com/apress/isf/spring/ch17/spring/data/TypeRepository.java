package com.apress.isf.spring.ch17.spring.data;

import com.apress.isf.spring.ch17.java.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Sang Jun Park on 01/03/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Repository("typeDAO")
public class TypeRepository implements TypeDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Type> getAll() {
        return new JdbcTemplate(dataSource).query("select * from types",
                new TypeRowMapper());
    }

    @Override
    public Type findById(String id) {
        return new JdbcTemplate(dataSource).queryForObject("select * from types where typeId = ?", new Object[] {id},
                new TypeRowMapper());
    }

    @Override
    public Type save(Type type){
        throw new UnsupportedOperationException("Not yet implemented.");
    }
}
