package com.zoucai.zucai.controller;


import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.zoucai.zucai.service.EventService;
import com.zoucai.zucai.util.NewsCrawler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "fetchingData",tags = {"fetchingData"})
@RequestMapping(value = "/fetchingData")
@RestController
public class FetchingDataController {

    @Autowired
    private EventService eventService;

    @ApiOperation(value="抓取数据", notes="抓取数据")
    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public void insertEventData(){
        try {
            NewsCrawler crawler = new NewsCrawler("crawl", true,eventService);
            crawler.setThreads(50);
            crawler.start(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
