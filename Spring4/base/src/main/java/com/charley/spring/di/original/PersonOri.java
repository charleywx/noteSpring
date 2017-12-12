package com.charley.spring.di.original;

import java.util.List;

/**
 * 原始的BEAN，使用XML注入
 */
public class PersonOri {

    private DeptOri deptOri;

    public String pName;

    public String pAge;

    public List<String> pList;
    
    public DeptOri getDeptOri() {
        return deptOri;
    }

    public void setDeptOri(DeptOri deptOri) {
        this.deptOri = deptOri;
    }

    PersonOri(DeptOri dept, String name, String age, List<String> list) {
        this.deptOri = dept;
        this.pName = name;
        this.pAge = age;
        this.pList = list;
    }

}
