package com.apress.isf.spring.ch09.spring.annotated.data;

import com.apress.isf.spring.ch09.model.Document;
import com.apress.isf.spring.ch09.spring.data.DocumentDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/18/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */
@Repository("documentDAO")
public class AnnotatedDocumentRepository implements DocumentDAO {
    @Override
    public List<Document> getAll() {
        return null;
    }
}
