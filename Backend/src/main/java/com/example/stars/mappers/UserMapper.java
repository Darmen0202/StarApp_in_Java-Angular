package com.example.stars.mappers;

import com.example.stars.models.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public  interface UserMapper{

    @Select("select * from users")
    List<Users> findAll();

    @Select("select username, password from users where id=#{id}")
    Users getUserById(Long id);

    @Select("select username, password, role from users where username=#{username}")
    Optional<Users> getUserByUsername(String username);

    @Insert("insert into users(username, password, email, role) values( #{username},#{password},#{email},#{role})")
    void register(Users users);

    @Update("update stars set username=#{username}, email=#{email} where id=#{id}")
    void update(Users users);

    @Delete("delete from users where id=#{id}")
    void deleteUser(Long id);

}
