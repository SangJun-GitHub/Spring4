package com.apress.isf.spring.ch07;

import com.apress.isf.spring.ch02.Document;
import com.apress.isf.spring.ch02.SearchEngine;
import com.apress.isf.spring.ch02.Type;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/13/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Component
@Profile("qa")
public class FileSearchEngineService implements SearchEngine{

    @Override
    public List<Document> findByType(Type documentType) {
        throw new UnsupportedOperationException(
                "QA Environment. Not yet implemented operation."
        );
    }

    @Override
    public List<Document> listAll() {
        throw new UnsupportedOperationException(
                "QA Environment. Not yet implemented operation."
        );
    }
}
