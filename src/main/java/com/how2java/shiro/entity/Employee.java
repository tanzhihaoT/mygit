/**
 * 文件名:员工表
 * 版权(c) 2019-雷升公司 xxx项目组：
 * 版 本 号： 1.0
 * @Version crm1.0
 */
package com.how2java.shiro.entity;

/**
 * @author tanzhihao
 * @date 2019-11-27 11:45
 * 员工实体类
 */
public class Employee {
    /**
     * 员工id
     */
    private int employeeId;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色类型
     */
    private String roleType;
    /**
     * 是否锁定
     * 1：是
     * 0：否
     */
    private int isLock;
    /**
     * 锁定时间
     */
    private String lockTime;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String phone;
    /**
     * 传真
     */
    private String faxes;
    /**
     * 照片
     */
    private String photo;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public int getIsLock() {
        return isLock;
    }

    public void setIsLock(int isLock) {
        this.isLock = isLock;
    }

    public String getLockTime() {
        return lockTime;
    }

    public void setLockTime(String lockTime) {
        this.lockTime = lockTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaxes() {
        return faxes;
    }

    public void setFaxes(String faxes) {
        this.faxes = faxes;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 无参构造
     */
    public Employee() {
    }

    /**
     * 有参构造
     * @param employeeId
     * @param name
     * @param password
     * @param roleType
     * @param isLock
     * @param lockTime
     * @param email
     * @param phone
     * @param faxes
     * @param photo
     */
    public Employee(int employeeId, String name, String password, String roleType, int isLock, String lockTime, String email, String phone, String faxes, String photo) {
        this.employeeId = employeeId;
        this.name = name;
        this.password = password;
        this.roleType = roleType;
        this.isLock = isLock;
        this.lockTime = lockTime;
        this.email = email;
        this.phone = phone;
        this.faxes = faxes;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roleType='" + roleType + '\'' +
                ", isLock=" + isLock +
                ", lockTime='" + lockTime + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", faxes='" + faxes + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
