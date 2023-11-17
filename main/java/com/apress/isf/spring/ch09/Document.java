package com.apress.isf.spring.ch09;

import com.apress.isf.spring.ch09.Type;

import java.util.Date;

/**
 * Created by Sang Jun Park on 11/16/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class Document {
    private String documentId;
    private String name;
    private Type type;
    private String location;
    private String description;
    private Date created;
    private Date modified;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Documents(");
        sb.append("id: ");
        sb.append(documentId);
        sb.append("name: ");
        sb.append(name);
        sb.append(", type: ");
        sb.append(type);
        sb.append(", location: ");
        sb.append(location);
        sb.append(")");
        return sb.toString();
    }
}
