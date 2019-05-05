package com.study.springcloud.dao;

import com.study.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept getById(Long id);

    public List<Dept> getAll();
}
