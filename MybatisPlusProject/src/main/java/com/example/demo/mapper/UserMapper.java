package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    public IPage<User> SelectUserOrderByName(IPage<User> page);

    public User SelectUserByName(String name);

}
