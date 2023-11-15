package com.apress.isf.spring.ch08;

import com.apress.isf.spring.ch02.Document;
import com.apress.isf.spring.ch02.Type;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/14/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface SearchEngine {
    public List<Document> findByType(Type documentType);
    public List<Document> listAll();
    public List<Document> findByLocation(String location);
}
