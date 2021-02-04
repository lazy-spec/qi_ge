package com.person.qi_boot.service.impl;

import com.person.qi_boot.dao.NoticeDao;
import com.person.qi_boot.domain.Notice;
import com.person.qi_boot.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<Notice> getNoticeList() {
        return noticeDao.getList();
    }

    @Override
    public List<Notice> getNoticeLikeList(String key) {
        return noticeDao.getLikeList(key);
    }

    @Override
    public Notice getNoticeInfo(Integer id) {
        return noticeDao.getInfoById(id);
    }

    @Override
    public void updateNoticeInfo(Notice notice) {
        noticeDao.updateById(notice);
    }

    @Override
    public void insertNoticeInfo(Notice notice) {
        noticeDao.save(notice);
    }

    @Override
    public void deletedById(Integer id) {
        noticeDao.deleteById(id);
    }
}
