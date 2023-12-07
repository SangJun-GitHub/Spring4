package com.apress.isf.spring.ch16.java.service;

import com.apress.isf.spring.ch16.java.model.Type;

import java.util.List;

/**
 * Created by Sang Jun Park on 12/06/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface TypeService {
    public void createNewType(Type type);
    public void updateType(Type type);
    public void removeTypeById(String id);
    public List<Type> getAllDefinedTypes();
    public Type getTypeById(String id);
}
