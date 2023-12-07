package com.apress.isf.spring.ch16.spring.data;

import com.apress.isf.spring.ch16.java.model.Document;

import java.util.List;

/**
 * Created by Sang Jun Park on 12/06/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface DocumentDAO {
    public List<Document> getAll();
    public Document save(String id, Document document);
    public Document findById(String id);
    public Document removeById(String id);
    public List<Document> findByTypeName(String name);
}
