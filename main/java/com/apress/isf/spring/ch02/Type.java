package com.apress.isf.spring.ch02;

/**
 * Created by Sang Jun Park on 11/01/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class Type {
    private String name;
    private String desc;
    private String extension;

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
