package com.zoucai.zucai.controller;

import com.alibaba.fastjson.JSON;
import com.zoucai.zucai.model.BookWithBLOBs;
import com.zoucai.zucai.model.BorrowIntent;
import com.zoucai.zucai.service.BorrowIntenetInfoService;
import com.zoucai.zucai.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "springboot",tags = {"springboot"})
@RequestMapping(value = "/test")
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private BorrowIntenetInfoService orderService;

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
    String index(@PathVariable Long id){
        BookWithBLOBs bookWithBLOBs = testService.getBook(id);
        if(bookWithBLOBs == null){
            return "";
        }
        return bookWithBLOBs.toString();
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",defaultValue = "123", value = "用户ID", required = true, dataType = "long", paramType = "query")
    @RequestMapping(value = "/getBorrowIntenetById", method = RequestMethod.POST)
    public String getBorrowIntenetById(@RequestParam(value = "id",defaultValue = "123") long id) {
        BorrowIntent order= orderService.get(id);
        if(order == null){
            return "";
        }
        return JSON.toJSONString(order);
    }
}
