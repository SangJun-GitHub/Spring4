package com.apress.isf.spring.ch17.spring.data;

import com.apress.isf.spring.ch17.java.model.Type;

import java.util.List;

/**
 * Created by Sang Jun Park on 01/03/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface TypeDAO {
    public List<Type> getAll();
    public Type findById(String id);
    public Type save(Type type);
}
