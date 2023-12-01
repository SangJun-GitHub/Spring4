package com.apress.isf.spring.ch15.spring.data;

import com.apress.isf.spring.ch15.java.model.Type;

import java.util.List;

/**
 * Created by Sang Jun Park on 12/01/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface TypeDAO {
    public List<Type> getAll();
    public Type findById(String id);
    public Type save(Type type);
}
