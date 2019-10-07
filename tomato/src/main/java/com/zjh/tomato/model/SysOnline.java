package com.zjh.tomato.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zjh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysOnline implements Serializable {

    private String sessionId;
    private String ip;
    private String username;
    private String addr;
    private Date lastAccessTime;

}
