package com.sea.springboot.service;

import com.sea.springboot.entity.User;
import com.sea.springboot.mapper.HomeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeMapper homeMapper;

    public List<User> test() {
        return homeMapper.getUsers();
    }
}
