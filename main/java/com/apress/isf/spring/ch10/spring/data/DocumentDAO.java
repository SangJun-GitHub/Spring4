package com.apress.isf.spring.ch10.spring.data;

import com.apress.isf.spring.ch10.java.model.Document;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/20/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface DocumentDAO {
    public List<Document> getAll();
}
