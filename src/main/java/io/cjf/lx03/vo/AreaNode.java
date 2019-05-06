package io.cjf.lx03.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AreaNode {

    private Integer areaId;

    private String areaName;

    private Integer parentId;

    private List<AreaNode> subAreaNode;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<AreaNode> getSubAreaNode() {
        return subAreaNode;
    }

    public void setSubAreaNode(List<AreaNode> subAreaNode) {
        this.subAreaNode = subAreaNode;
    }
}
