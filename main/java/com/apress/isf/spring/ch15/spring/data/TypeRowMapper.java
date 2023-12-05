package com.apress.isf.spring.ch15.spring.data;

import com.apress.isf.spring.ch15.java.model.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sang Jun Park on 12/04/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class TypeRowMapper implements RowMapper<Type> {
    @Override
    public Type mapRow(ResultSet rs, int rowNum) throws SQLException {
        Type type = new Type(rs.getString("typeId"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("extension"));
        return type;
    }
}
