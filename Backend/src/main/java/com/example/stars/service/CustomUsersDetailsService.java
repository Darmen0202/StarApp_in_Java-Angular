package com.example.stars.service;

import com.example.stars.mappers.UserMapper;
import com.example.stars.models.Users;
import com.example.stars.security.CustomUserDetails;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class CustomUsersDetailsService implements UserDetailsService {

    private final UserMapper userMapper;
    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public CustomUsersDetailsService(UserMapper userMapper, SqlSessionFactory sqlSessionFactory) {
        this.userMapper = userMapper;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Optional<Users> users = userMapper.getUserByUsername(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }

        return new CustomUserDetails(users.get());
    }


}

