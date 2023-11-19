package com.apress.isf.spring.ch09.spring.data;

import com.apress.isf.spring.ch09.model.Document;

import java.util.List;

public interface DocumentDAO {
    public List<Document> getAll();
}
