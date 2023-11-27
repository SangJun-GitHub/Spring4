package com.apress.isf.spring.ch13.java.model;

/**
 * Created by Sang Jun Park on 11/26/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class Type {
    private String typeId;
    private String name;
    private String desc;
    private String extension;

    public Type(){}

    public Type(String name, String extension){
        this.name = name;
        this.extension = extension;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("Type(");
        builder.append("id: ");
        builder.append(typeId);
        builder.append(", name: ");
        builder.append(name);
        builder.append(", description: ");
        builder.append(desc);
        builder.append(", extension: ");
        builder.append(extension);
        builder.append(")");
        return builder.toString();
    }
}
