package com.zjh.tomato.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class SysUser implements Serializable {
    private Long userId;

    private Long deptId;

    private String loginName;

    private String username;

    private String userType;

    private String email;

    private String phone;

    private String sex;

    private String img;

    private String password;

    private String salt;

    private String status;

    private Date loginDate;

    private String operator;

    private Date operateTime;

    private String remark;

    private List<SysRole> roles;
    private List<SysMenu> menus;

    public List<SysMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<SysMenu> menus) {
        this.menus = menus;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }


    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", deptId=" + deptId +
                ", loginName='" + loginName + '\'' +
                ", username='" + username + '\'' +
                ", userType='" + userType + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", img='" + img + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                ", loginDate=" + loginDate +
                ", operator='" + operator + '\'' +
                ", operateTime=" + operateTime +
                ", remark='" + remark + '\'' +
                ", roles=" + roles +
                '}';
    }
}