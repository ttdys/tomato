package com.zjh.tomato.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuJson {

    private Long menuId;
    private String menuName;
    private Integer menuSort;
    private String url;
    private String menuType;
    private String perms;
    private String remark;
    private Long parentId;
    private List<MenuJson> children = new ArrayList<MenuJson>();

}
