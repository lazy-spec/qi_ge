package com.person.qi_boot.dao;

import com.person.qi_boot.domain.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptDao {
    //查询
    @Select("select * from dept")
    List<Dept> selectAllDept();
    @Select("select * from dept where name like CONCAT('%',#{key},'%')")
    List<Dept> selectLikeAllDept(String key);
    @Select("select * from dept where id = #{id}")
    Dept getInfoById(Integer id);

    void save(Dept dept);

    void updateInfoById(Dept dept);
    @Delete("delete from dept where id = #{id} ")
    void deletedById(Integer id);


}
