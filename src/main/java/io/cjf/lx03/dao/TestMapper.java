package io.cjf.lx03.dao;

import com.github.pagehelper.Page;
import io.cjf.lx03.po.Test;

public interface TestMapper {
    int deleteByPrimaryKey(Integer testId);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer testId);

    Page<Test> selectWithPageAndName(String test_name);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}