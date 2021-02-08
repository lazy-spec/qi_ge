package com.person.qi_boot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 打卡
 */
@Data
public class PunchClock {

    private Integer id;
    private Integer empId;
    /** 打卡时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date punchInTime;
    /** 签退时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date punchOutTime;
    /** 迟到原因 */
    private String remark;
    /** 用户IP */
    private String ip;


    private Integer noIn;
    private Integer noOut;
    /** 考勤时间 */
    private String attendanceTime;

}
