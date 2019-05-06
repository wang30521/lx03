package io.cjf.lx03.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.cjf.lx03.dao.TestMapper;
import io.cjf.lx03.po.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@EnableAutoConfiguration
@CrossOrigin
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("/getWithPageAndName")
    public PageInfo<Test> getWithPageAndName(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                             @RequestParam(required = false,defaultValue = "") String  test_name) {
        PageHelper.startPage(pageNum,2);
        Page<Test> tests = testMapper.selectWithPageAndName(test_name);
        PageInfo<Test> testPageInfo = tests.toPageInfo();
        return testPageInfo;
    }


    @GetMapping("/getByid")
    public Test getByid(@RequestParam Integer testId) {
        Test test = testMapper.selectByPrimaryKey(testId);
        return test;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody Test test) {
        testMapper.insert(test);
        Integer testId = test.getTestId();
        return testId;
    }

    @PostMapping("/update")
    public void update(Test test){
        testMapper.updateByPrimaryKey(test);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer testId) {
        testMapper.deleteByPrimaryKey(testId);
    }







}
