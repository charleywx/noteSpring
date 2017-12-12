package com.charley.spring.di.original;

/**
 * 原始的BEAN，使用XML注入
 */
public class PersonOriC {

    private DeptOri deptOri;

    public String pName;

    public String pAge;

    public DeptOri getDeptOri() {
        return deptOri;
    }

    public void setDeptOri(DeptOri deptOri) {
        this.deptOri = deptOri;
    }

    PersonOriC(DeptOri dept, String name, String age) {
        this.deptOri = dept;
        this.pName = name;
        this.pAge = age;
    }

}
