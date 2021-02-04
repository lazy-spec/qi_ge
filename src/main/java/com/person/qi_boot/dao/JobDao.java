package com.person.qi_boot.dao;

import com.person.qi_boot.domain.Job;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobDao {

    @Select("select * from job")
    List<Job> getList();
    @Select("select * from job where name like CONCAT('%',#{key},'%')")
    List<Job> getLikeList(String key);


    void save(Job job);
    void updateById(Job job);


    @Select("select * from job where id = #{id}")
    Job getInfoById(Integer id);

    // 根据id删除部门
    @Delete(" delete from job where id = #{id} ")
    void deleteById(Integer id);

}
