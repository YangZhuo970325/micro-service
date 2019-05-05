package com.study.springcloud.service;

import com.study.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept getById(Long id);

    public List<Dept> getAll();
}
