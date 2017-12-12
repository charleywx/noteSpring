package com.charley.spring.di.bean;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Dept {

    private String name = "开发部";
    
    public String namePub = "开发部Pub";

    public String getSomeString() {
//        return "Hello World!";
        return null;
    }

    private List<DeptGhj> list;

    public void setList() {
        if(list == null) list = new ArrayList<DeptGhj>();
        for (int i = 0; i < 5; i++) {
            DeptGhj dept = new DeptGhj();
            dept.setName("namePub-New-" + i);
            list.add(dept);
        }
    }

    public List<DeptGhj> getList() {
        setList();
        return list;
    }

}
