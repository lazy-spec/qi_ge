package com.person.qi_boot.dao;

import com.person.qi_boot.domain.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoticeDao {

    @Select("select * from notice")
    List<Notice> getList();
    @Select("select * from notice  where title like CONCAT('%',#{key},'%')")
    List<Notice> getLikeList(String key);

    void save(Notice notice);
    void updateById(Notice notice);


    @Select("select * from notice where id = #{id}")
    Notice getInfoById(Integer id);

    // 根据id删除部门
    @Delete(" delete from notice where id = #{id} ")
    void deleteById(Integer id);
}
