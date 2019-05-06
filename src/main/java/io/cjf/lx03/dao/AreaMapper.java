package io.cjf.lx03.dao;

import io.cjf.lx03.po.Area;
import io.cjf.lx03.vo.AreaNode;

import java.util.List;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaId);

    List<AreaNode> selectChildren(Integer areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}