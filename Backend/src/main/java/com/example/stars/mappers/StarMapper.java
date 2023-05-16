package com.example.stars.mappers;


import com.example.stars.models.Stars;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StarMapper {

    @Select("SELECT name, ra, dec, color, astronomer from stars")
    List<Stars> findAll();

    @Select("select * from stars where id=#{id}")
    Stars getStarById(Long id);

    @Select("select color from stars where id=#{id}")
    Stars getStarColor(Long id);

    @Insert("insert into stars(name, dec, ra, color, astronomer) values(#{name}, #{dec}, #{ra}, #{color}, #{astronomer})")
    void insert(Stars stars);

    @Update("update users set name=#{name}, dec=#{dec}, ra=#{ra}, color=#{color}, astronomer=#{astronomer} where id=#{id}")
    void update(Stars stars, Long id);

    @Delete("delete from stars where id=#{id}")
    void deleteStar(Long id);
}

