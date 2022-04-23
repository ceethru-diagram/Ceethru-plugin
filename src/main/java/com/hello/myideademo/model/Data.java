package com.hello.myideademo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Data {
    @Id
    private int id;
    private String folderpath;
    private String filename;
    private int line;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFolderpath() {
        return folderpath;
    }

    public void setFolderpath(String folderpath) {
        this.folderpath = folderpath;
    }
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getLine() {
        return line;
    }
    public void setLine(int line) {
        this.line = line;
    }


//    @Override
//    public String toString() {
//        return "Alien [aid=" + aid + ", aname=" + aname + "]";
//    }

}
