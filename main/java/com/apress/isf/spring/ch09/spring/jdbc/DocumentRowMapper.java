package com.apress.isf.spring.ch09.spring.jdbc;

import com.apress.isf.spring.ch09.model.Document;
import com.apress.isf.spring.ch09.model.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sang Jun Park on 11/19/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class DocumentRowMapper implements RowMapper<Document> {
    @Override
    public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
        Document document = new Document();
        document.setDocumentId(rs.getString("documentId"));
        document.setName(rs.getString("name"));
        document.setLocation(rs.getString("location"));
        document.setCreated(rs.getDate("created"));
        document.setModified(rs.getDate("modified"));
        document.setDescription("doc_desc");

        Type type = new Type();
        type.setTypeId(rs.getString("typeId"));
        type.setName(rs.getString("type_name"));
        type.setDesc(rs.getString("type_desc"));
        type.setExtension(rs.getString("extension"));
        document.setType(type);

        return document;
    }
}
