package com.sea.springboot.mapper;

import com.sea.springboot.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeMapper {

    List<User> getUsers();
}
