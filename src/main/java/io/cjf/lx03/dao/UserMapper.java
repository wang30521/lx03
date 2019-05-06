package io.cjf.lx03.dao;

import io.cjf.lx03.po.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    User selectByUsername(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}