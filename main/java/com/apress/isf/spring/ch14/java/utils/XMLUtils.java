package com.apress.isf.spring.ch14.java.utils;

import com.thoughtworks.xstream.XStream;

/**
 * Created by Sang Jun Park on 11/30/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class XMLUtils {
    public static <T> String toXML(T object){
        XStream xStream = new XStream();
        xStream.alias(object.getClass().getSimpleName().toLowerCase(), object.getClass());
        return xStream.toXML(object);
    }
    @SuppressWarnings({"unchecked"})
    public static <T> T fromXML(String xml, Class<T> _class){
        XStream xStream = new XStream();
        xStream.alias(_class.getSimpleName().toLowerCase(), _class);
        return (T)xStream.fromXML(xml);
    }
}
