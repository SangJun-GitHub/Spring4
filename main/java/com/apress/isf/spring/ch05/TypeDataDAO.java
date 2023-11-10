package com.apress.isf.spring.ch05;

import com.apress.isf.spring.ch02.Type;

/**
 * Created by Sang Jun Park on 11/09/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface TypeDataDAO {
    public Type[] getAll();
    public Type[] findById(String id);
}
