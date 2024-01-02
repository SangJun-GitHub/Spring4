package com.apress.isf.spring.ch16.java.utils;

import com.thoughtworks.xstream.XStream;

/**
 * Created by Sang Jun Park on 12/07/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class XmlUtils {
    public static <T> String toXML(T object){
        XStream xstream = new XStream();
        xstream.alias(object.getClass().getSimpleName().toLowerCase(), object.getClass());
        return xstream.toXML(object);
    }

    @SuppressWarnings({ "unchecked"})
    public static <T> T fromXML(String xml, Class<T> _class){
        XStream xstream = new XStream();
        xstream.alias(_class.getSimpleName().toLowerCase(), _class);
        return (T)xstream.fromXML(xml);
    }
}
