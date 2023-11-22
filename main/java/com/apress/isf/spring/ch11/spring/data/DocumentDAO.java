package com.apress.isf.spring.ch11.spring.data;

import com.apress.isf.spring.ch11.java.model.Document;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/21/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface DocumentDAO {
    public List<Document> getAll();
    public void save(Document document);
    public Document findById(String id);
}
