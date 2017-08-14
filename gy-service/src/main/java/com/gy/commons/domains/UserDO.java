package com.gy.commons.domains;

import com.gy.base.BaseDO;

/**
 * 用户信息表
 */
public class UserDO extends BaseDO{

    private String name; // 姓名
    private String phone;  // 联系方式
    private String account;  // 联系方式
    private String password;  // 联系方式

    private String gender;  // 性别
    private Integer age;  // 年龄
    private String birthday;  // 生日

    /**
     * 模块化String,用于检查重复性
     * @return
     */
    public String toModeString(){
        return "[userDO]{" +
                "name:" + name + ",phone:" + phone + ",account:" + account +
                ",password:" + password + ",gender:" + gender + ",age:" + age +
                ",birthday:" + birthday +
                "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}