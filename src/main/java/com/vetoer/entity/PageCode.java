package com.vetoer.entity;

public class PageCode {
    private int page;
    private String classType;

    public PageCode() {
    }

    public PageCode(int page, String classType) {

        this.page = page;
        this.classType = classType;
    }

    public int getPage() {

        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    @Override
    public String toString() {
        return "PageCode{" +
                "page=" + page +
                ", classType='" + classType + '\'' +
                '}';
    }
}
