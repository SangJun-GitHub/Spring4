package com.apress.isf.spring.ch09.spring.data;

import com.apress.isf.spring.ch09.model.Type;

import java.util.Map;

/**
 * Created by Sang Jun Park on 11/18/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class TypeDataRepository implements TypeDataDAO{
    private Map<String, Type> types = null;

    public Map<String, Type> getTypes() {
        return types;
    }

    public void setTypes(Map<String, Type> types) {
        this.types = types;
    }

    @Override
    public Type[] getAll() {
        return types.values().toArray(new Type[types.values().size()]);
    }

    @Override
    public Type findById(String id) {
        Type type = types.get(id);
        return type;
    }
}
