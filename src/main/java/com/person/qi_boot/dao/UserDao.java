package com.person.qi_boot.dao;

import com.person.qi_boot.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user")
    List<User> getList();

    @Select("select * from user where username like concat('%', #{key}, '%')")
    List<User> getLikeList(@Param("key") String key);

    @Select("select * from user where id = #{id}")
    User getInfoById(@Param("id") Integer id);

    @Select("select * from user where username = #{username} and password = #{password}")
    User login(@Param("username") String username, @Param("password") String password);

    @Delete("delete from user where id = #{id}")
    void deleteById(@Param("id") Integer id);

    void saveUser(User user);
    void updateUserById(User user);

}
