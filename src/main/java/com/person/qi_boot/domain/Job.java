package com.person.qi_boot.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Job implements Serializable {
    private Integer id;
    private String name;
    private String remark;
}
