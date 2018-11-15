package com.zoucai.zucai.controller;


import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.zoucai.zucai.model.SuperLotto;
import com.zoucai.zucai.service.DualColoreBallService;
import com.zoucai.zucai.service.ElevenSelectedFiveService;
import com.zoucai.zucai.service.EventService;
import com.zoucai.zucai.service.SuperLottoService;
import com.zoucai.zucai.util.DualColoreBallCrawler;
import com.zoucai.zucai.util.ElevenSelectedFiveCrawler;
import com.zoucai.zucai.util.NewsCrawler;
import com.zoucai.zucai.util.SuperLottoCrawler;
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
    @Autowired
    private DualColoreBallService dualColoreBallService;
    @Autowired
    private SuperLottoService superLottoService;
    @Autowired
    private ElevenSelectedFiveService elevenSelectedFiveService;

    @ApiOperation(value="抓取数据", notes="抓取数据")
    @RequestMapping(value = "/fetchZuCai", method = RequestMethod.GET)
    public void insertEventData(){
        try {
            NewsCrawler crawler = new NewsCrawler("crawl", true,eventService);
            crawler.setThreads(50);
            crawler.start(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value="抓取双色球数据", notes="抓取双色球数据")
    @RequestMapping(value = "/fetchDualColoreBall", method = RequestMethod.GET)
    public void insertDualColoreBallData(){
        try {
            DualColoreBallCrawler crawler = new DualColoreBallCrawler("crawl", true,dualColoreBallService);
            crawler.setThreads(50);
            crawler.start(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value="抓取大乐透数据", notes="抓取大乐透数据")
    @RequestMapping(value = "/fetchSuperLotto", method = RequestMethod.GET)
    public void insertSuperLottoData(){
        try {
            SuperLottoCrawler crawler = new SuperLottoCrawler("crawl", true,superLottoService);
            crawler.setThreads(50);
            crawler.start(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value="抓取十一选五数据", notes="抓取十一选五数据")
    @RequestMapping(value = "/fetchelevenSelectedFive", method = RequestMethod.GET)
    public void insertelevenSelectedFiveData(){
        try {
            ElevenSelectedFiveCrawler crawler = new ElevenSelectedFiveCrawler("crawl", true,elevenSelectedFiveService);
            crawler.setThreads(50);
            crawler.start(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
