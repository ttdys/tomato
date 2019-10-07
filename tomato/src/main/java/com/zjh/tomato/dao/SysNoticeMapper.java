package com.zjh.tomato.dao;

import com.zjh.tomato.model.SysNotice;
import com.zjh.tomato.model.SysNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNoticeMapper {
    int countByExample(SysNoticeExample example);

    int deleteByExample(SysNoticeExample example);

    int deleteByPrimaryKey(Integer noticeId);

    int insert(SysNotice record);

    int insertSelective(SysNotice record);

    List<SysNotice> selectByExample(SysNoticeExample example);

    SysNotice selectByPrimaryKey(Integer noticeId);

    int updateByExampleSelective(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    int updateByExample(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    int updateByPrimaryKeySelective(SysNotice record);

    int updateByPrimaryKey(SysNotice record);
}