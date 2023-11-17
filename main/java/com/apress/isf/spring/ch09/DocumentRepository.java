package com.apress.isf.spring.ch09;

import com.apress.isf.spring.ch02.Document;
import com.apress.isf.spring.ch03.DocumentDAO;

/**
 * Created by Sang Jun Park on 11/17/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class DocumentRepository implements DocumentDAO {
    @Override
    public Document[] getAll() {
        return new Document[0];
    }
}
