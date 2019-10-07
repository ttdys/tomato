package com.zjh.tomato.dao;

import com.zjh.tomato.model.SysOperLog;
import com.zjh.tomato.model.SysOperLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOperLogMapper {
    int countByExample(SysOperLogExample example);

    int deleteByExample(SysOperLogExample example);

    int deleteByPrimaryKey(Long operId);

    int insert(SysOperLog record);

    int insertSelective(SysOperLog record);

    List<SysOperLog> selectByExample(SysOperLogExample example);

    SysOperLog selectByPrimaryKey(Long operId);

    int updateByExampleSelective(@Param("record") SysOperLog record, @Param("example") SysOperLogExample example);

    int updateByExample(@Param("record") SysOperLog record, @Param("example") SysOperLogExample example);

    int updateByPrimaryKeySelective(SysOperLog record);

    int updateByPrimaryKey(SysOperLog record);
}