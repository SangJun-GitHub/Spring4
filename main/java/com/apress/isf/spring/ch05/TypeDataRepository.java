package com.apress.isf.spring.ch05;

import com.apress.isf.spring.ch02.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by Sang Jun Park on 11/10/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class TypeDataRepository implements TypeDataDAO{

    private static final Logger log = LoggerFactory.getLogger(TypeDataRepository.class);
    private Map<String, Type> types = null;

    public Map<String, Type> getTypes(){
        return types;
    }
    public void setTypes(Map<String, Type> types){
        this.types = types;
    }
    @Override
    public Type[] getAll() {
        return types.values().toArray(new Type[types.size()]);
    }

    @Override
    public Type findById(String id) {
        if(log.isDebugEnabled())
            log.debug("Start <findById> Params: " + id);

        Type type = types.get(id);

        if(log.isDebugEnabled())
            log.debug("End <findById> Params : " + id);

        return type;
    }
}
