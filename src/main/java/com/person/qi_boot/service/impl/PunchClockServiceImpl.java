package com.person.qi_boot.service.impl;

import com.person.qi_boot.consts.Const;
import com.person.qi_boot.dao.PunchClockDao;
import com.person.qi_boot.domain.Employee;
import com.person.qi_boot.domain.PunchClock;
import com.person.qi_boot.service.PunchClockService;
import com.person.qi_boot.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class PunchClockServiceImpl implements PunchClockService {

    @Autowired
    private PunchClockDao punchClockDao;
    @Autowired
    private HttpSession session;

    @Override
    public int upOut(PunchClock punchClock) {
        Employee employee = (Employee) checkLogin();
        punchClock.setEmpId(employee.getId());
        PunchClock clock = punchClockDao.selectByEmpId(employee.getId(),
                new Date(TimeUtils.getWorkStartTime()),
                new Date(TimeUtils.getEndTime()));
        if (null == clock) {
            throw new RuntimeException("你还没上班打卡呢~~");
        }
        return punchClockDao.upOut(punchClock);
    }

    @Override
    public int addIn(PunchClock punchClock) {
        Employee employee = (Employee) checkLogin();
        punchClock.setEmpId(employee.getId());

        Date start = new Date(TimeUtils.getStartTime());
        Date end = new Date(TimeUtils.getEndTime());
        PunchClock clock = punchClockDao.selectByEmpId(employee.getId(), start, end);
        if (clock == null) {
            return punchClockDao.addIn(punchClock);
        }
        throw new RuntimeException("你已经打过卡了");
    }

    private Object checkLogin() {
        Object loginEmp = session.getAttribute(Const.EMP_SESSION);
        if (Objects.isNull(loginEmp)) {
            throw new RuntimeException("当前没有登录无法签到");
        }
        return loginEmp;
    }

    @Override
    public List<PunchClock> selectAll() {
        List<PunchClock> punchClocks = punchClockDao.selectAll();
        for (PunchClock punchClock : punchClocks) {

            long time = punchClock.getPunchOutTime().getTime() - punchClock.getPunchInTime().getTime();
            double attendanceTime = time * 1.0 / 1000 / 3600;
            punchClock.setAttendanceTime(String.format("%.2f", attendanceTime));
        }
        return punchClocks;
    }
}
