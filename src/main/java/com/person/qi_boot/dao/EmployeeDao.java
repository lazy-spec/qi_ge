package com.person.qi_boot.dao;

import com.person.qi_boot.domain.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeDao {

    @Select("select * from employee")
    List<Employee> getList();
    @Select("select * from employee where name like CONCAT('%',#{key},'%')")
    List<Employee> getLikeList(String key);


    void save(Employee employee);

    @Select("select * from employee where id = #{id}")
    Employee getInfoById(Integer id);

    void updateById(Employee employee);
    // 根据id删除部门
    @Delete(" delete from employee where id = #{id} ")
    void deleteById(Integer id);

    @Select("select * from employee where card_id=#{cardId} and password=#{password} and role_id = #{roleId}")
    Employee login(@Param("cardId") String cardId, @Param("password") String password, @Param("roleId") Integer roleId);

}
