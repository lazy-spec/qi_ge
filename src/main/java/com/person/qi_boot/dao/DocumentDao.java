package com.person.qi_boot.dao;

import com.person.qi_boot.domain.Document;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DocumentDao {

    @Select("select * from document ")
    List<Document> getList();
    @Select("select * from document where title like CONCAT('%',#{key},'%')")
    List<Document> getLikeList(String key);


    void save(Document document);

    @Select("select * from document where id = #{id}")
    Document getInfoById(Integer id);

    void updateInfoById(Document document);
    // 根据id删除部门
    @Delete("delete from document where id = #{id} ")
    void deleteById(Integer id);

}
