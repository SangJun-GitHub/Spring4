package com.apress.isf.spring.ch17.spring.service;

import com.apress.isf.spring.ch17.java.model.Type;
import com.apress.isf.spring.ch17.java.service.TypeService;
import com.apress.isf.spring.ch17.spring.data.TypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sang Jun Park on 01/08/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Service("typeFacade")
public class TypeServiceFacade implements TypeService {
    @Autowired
    TypeDAO typeDAO;

    @Override
    public void createNewType(Type type) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void updateType(Type type) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void removeTypeById(String id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<Type> getAllDefinedTypes() {
        return typeDAO.getAll();
    }

    @Override
    public Type getTypeById(String id) {
        return typeDAO.findById(id);
    }
}
