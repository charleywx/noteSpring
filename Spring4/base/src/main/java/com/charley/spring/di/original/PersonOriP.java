package com.charley.spring.di.original;

import java.util.List;

/**
 * 原始的BEAN，使用XML注入
 */
public class PersonOriP {

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

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setpAge(String pAge) {
        this.pAge = pAge;
    }

    public void setpList(List<String> pList) {
        this.pList = pList;
    }
}
