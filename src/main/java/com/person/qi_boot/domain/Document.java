package com.person.qi_boot.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

@Data
public class Document implements Serializable {
    private Integer id;
    private String title;
    private String filename;
    private String remark;
    private Date createdTime;
    private Integer userId;
    private MultipartFile file;
    private User user;
}
