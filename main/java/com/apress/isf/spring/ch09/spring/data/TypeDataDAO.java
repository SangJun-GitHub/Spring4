package com.apress.isf.spring.ch09.spring.data;

import com.apress.isf.spring.ch09.model.Type;

public interface TypeDataDAO {
    public Type[] getAll();
    public Type findById(String id);
}
