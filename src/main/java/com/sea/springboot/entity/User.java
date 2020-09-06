package com.sea.springboot.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private LocalDateTime date;
}
