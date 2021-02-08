package com.person.qi_boot.service;

import com.person.qi_boot.domain.PunchClock;

import java.util.List;

public interface PunchClockService {

    /** 签退*/
    int upOut(PunchClock punchClock);
    /** 打卡  */
    int addIn(PunchClock punchClock);

    List<PunchClock> selectAll();

}
