package com.person.qi_boot.dao;

import com.person.qi_boot.domain.PunchClock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface PunchClockDao {

    /** 打卡 */
    int addIn(PunchClock punchClock);
    /** 签退 */
    int upOut(PunchClock punchClock);

    List<PunchClock> selectAll();

    int countNoUp(@Param("empId") Integer empId);
    int countNoAdd(@Param("empId") Integer empId);

    PunchClock selectByEmpId(@Param("empId") Integer empId, @Param("start") Date start, @Param("end") Date end);
}
