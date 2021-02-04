package com.person.qi_boot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Notice implements Serializable {

    private Integer id;
    private String title;
    private String content;
    private Date createdTime;
    private Integer userId;
    private User user;
}
