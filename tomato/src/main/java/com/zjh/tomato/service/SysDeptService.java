package com.zjh.tomato.service;

import com.zjh.tomato.dao.SysDeptMapper;
import com.zjh.tomato.model.SysDept;
import com.zjh.tomato.model.SysDeptExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDeptService {
    @Autowired
    private SysDeptMapper mapper;

    public List<SysDept> getAllDept() {
        return mapper.selectByExample(new SysDeptExample());
    }

    public void addDept(SysDept dept) {
        mapper.insertSelective(dept);
    }

    public void updateDept(SysDept dept) {
        mapper.updateByPrimaryKeySelective(dept);
    }

    public void removeDept(Long deptId) {
        mapper.deleteByPrimaryKey(deptId);
    }
}
