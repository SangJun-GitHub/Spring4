package com.apress.isf.spring.ch13.java.utils;

import com.thoughtworks.xstream.XStream;

/**
 * Created by Sang Jun Park on 11/26/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class XmlUtils {
    public static <T> String toXML(T object){
        XStream xStream = new XStream();
        xStream.alias(object.getClass().getSimpleName().toLowerCase(), object.getClass());
        return xStream.toXML(object);
    }

    @SuppressWarnings({"unchecked"})
    public static <T> T fromXML(String xml, Class<T> _class){
        XStream xStream = new XStream();
        xStream.alias(_class.getCanonicalName().toLowerCase(), _class.getClass());
        return (T)xStream.fromXML(xml);
    }
}
