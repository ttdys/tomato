package com.zjh.tomato.model.dto;

import lombok.*;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysMenuDto implements Serializable {

    String name;
    Integer status;
    String permissionValue;
    Integer pid;

}
