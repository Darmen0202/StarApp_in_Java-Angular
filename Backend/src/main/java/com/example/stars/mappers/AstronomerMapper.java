package com.example.stars.mappers;

import com.example.stars.models.Astronomers;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AstronomerMapper {

    @Select("select * from astronomers")
    List<Astronomers> findAll();

    @Select("select * from astronomers where id=#{id}")
    Astronomers getAstronomerById(Long id);

    @Insert("insert into astronomers (fullname) values( #{fullname})")
    void add(Astronomers astronomers);

    @Update("update astronomers set fullname=#{fullname} where id=#{id}")
    void update(Astronomers astronomers);

    @Delete("delete from astronomers where id=#{id}")
    void deleteAstronomer(Long id);

}
