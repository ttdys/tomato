package com.zjh.tomato.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjh.tomato.dao.SysLoginLogMapper;
import com.zjh.tomato.dao.SysOperLogMapper;
import com.zjh.tomato.model.SysLoginLog;
import com.zjh.tomato.model.SysLoginLogExample;
import com.zjh.tomato.model.SysOperLog;
import com.zjh.tomato.model.SysOperLogExample;
import com.zjh.tomato.utils.LocationUtils;
import com.zjh.tomato.utils.SystemUtils;
import nl.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author zjh
 */
@Service
public class SysOperLogService {
    @Autowired
    private SysOperLogMapper mapper;

    @Autowired
    private SysLoginLogMapper loginLogMapper;
    public void save(SysOperLog sysLog) {

        mapper.insertSelective(sysLog);
    }
    public PageInfo<SysOperLog> getAllSysOperLog(int page, int size) {
        PageHelper.startPage(page,size);
        SysOperLogExample example = new SysOperLogExample();
        example.setOrderByClause(" oper_time  desc");
        List<SysOperLog> sysOperLogs = mapper.selectByExample(example);
        PageInfo<SysOperLog> pageInfo = new PageInfo<>(sysOperLogs);
        return pageInfo;
    }

    public PageInfo<SysLoginLog> getAllSysLoginLog(int page, int size) {
        PageHelper.startPage(page,size);
        SysLoginLogExample example = new SysLoginLogExample();
        example.setOrderByClause("login_time desc");
        List<SysLoginLog> sysLoginLogs = loginLogMapper.selectByExample(example);
        PageInfo<SysLoginLog> sysLoginLogPageInfo = new PageInfo<>(sysLoginLogs);
        return sysLoginLogPageInfo;
    }


    public void addSysLoginLog(HttpServletRequest request,String username) {
       // String ip = request.getRemoteAddr();// todo  暂时不用网络数据
        String addr= LocationUtils.getAddr("115.60.94.212");
        Date date = new Date();
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        String browser = userAgent.getBrowser() + ":" + userAgent.getBrowserVersion();

        String systemInfo = SystemUtils.getRequestSystemInfo(request);
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setLoginUsername(username);
        sysLoginLog.setLoginTime(date);
        sysLoginLog.setLoginBrowser(browser);
        sysLoginLog.setLoginSystem(systemInfo);
        sysLoginLog.setLoginAddr(addr);  // todo  暂时不用网络数据
        loginLogMapper.insertSelective(sysLoginLog);
    }
}
