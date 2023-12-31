package com.apress.isf.spring.ch02;

/**
 * Created by Sang Jun Park on 11/01/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class Document {
    private String name;
    private Type type;
    private String location;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Type getType(){
        return type;
    }
    public void setType(Type type){
        this.type = type;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }
}
