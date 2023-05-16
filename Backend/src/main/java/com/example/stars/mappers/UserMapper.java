package com.example.stars.mappers;

import com.example.stars.models.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public  interface UserMapper{

    @Select("select * from users")
    List<Users> findAll();

    @Select("select login, password from users where id=#{id}")
    Users getUserById(Long id);

    @Select("select login, password, role from users where login=#{login}")
    Optional<Users> getUserByLogin(String login);

    @Insert("insert into users(login, password, email, role) values( #{login},#{password},#{email},#{role})")
    void register(Users users);

    @Update("update stars set name=#{name}, name=#{name}, name=#{name}, name=#{name}, where id=#{id}")
    void update(Users users);

    @Delete("delete from users where id=#{id}")
    void deleteUser(Long id);

}
