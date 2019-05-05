package com.study.springcloud.service.Impl;

import com.study.springcloud.dao.DeptDao;
import com.study.springcloud.entities.Dept;
import com.study.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept getById(Long id) {
        return deptDao.getById(id);
    }

    @Override
    public List<Dept> getAll() {
        return deptDao.getAll();
    }
}
