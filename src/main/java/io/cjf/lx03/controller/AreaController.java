package io.cjf.lx03.controller;

import io.cjf.lx03.dao.AreaMapper;
import io.cjf.lx03.vo.AreaNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
@EnableAutoConfiguration
@CrossOrigin
public class AreaController {

    @Autowired
    private AreaMapper areaMapper;

    @GetMapping("/getTree")
    public List<AreaNode> getTree(@RequestParam Integer areaId){
        List<AreaNode> areaNodes = areaMapper.selectChildren(areaId);
        return areaNodes;
    }

}
