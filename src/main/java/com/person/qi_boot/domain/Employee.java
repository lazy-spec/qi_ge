package com.person.qi_boot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Employee implements Serializable {

    private Integer id;
    private Integer jobId;
    private Integer deptId;

    private Dept dept;
    private Job job;
    private String name;
    private String cardId;
    private String address;
    private String postCode;
    private String tel;
    private String phone;
    private String qqNum;
    private String email;
    private Integer sex;
    private String party;

    private String birthday;
    private String race;
    private String education;
    private String speciality;
    private String hobby;
    private String remark;
    private Date createdTime;
    private String password;

}
