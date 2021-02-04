package com.person.qi_boot.service;


import com.person.qi_boot.domain.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> getNoticeList();

    List<Notice> getNoticeLikeList(String key);

    Notice getNoticeInfo(Integer id);

    void updateNoticeInfo(Notice notice);

    void insertNoticeInfo(Notice notice);

    void deletedById(Integer id);

}
