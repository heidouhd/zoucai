package com.zoucai.zucai.controller;

import com.zoucai.zucai.model.BookWithBLOBs;
import com.zoucai.zucai.model.BorrowIntent;
import com.zoucai.zucai.service.BorrowIntenetInfoService;
import com.zoucai.zucai.service.TestService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return bookWithBLOBs.toString();
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/getBorrowIntenetById/{id}", method = RequestMethod.GET)
    public String getBorrowIntenetById(@PathVariable long id) {
        List<BorrowIntent> order= orderService.get(id);
        if(order == null){
            return "";
        }
        return order.toString();
    }
}
