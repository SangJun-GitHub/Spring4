package com.apress.isf.spring.ch09;

/**
 * Created by Sang Jun Park on 11/16/2023.
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
        StringBuilder sb = new StringBuilder("Type(");
        sb.append("id: ");
        sb.append(typeId);
        sb.append("name: ");
        sb.append(name);
        sb.append(", description: ");
        sb.append(desc);
        sb.append(", extension: ");
        sb.append(extension);
        sb.append(")");
        return sb.toString();
    }
}
