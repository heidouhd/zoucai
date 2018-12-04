package com.zoucai.zucai.controller;


import com.google.gson.Gson;
import com.zoucai.zucai.model.DualColoreBall;
import com.zoucai.zucai.service.DualColoreBallService;
import com.zoucai.zucai.service.ElevenSelectedFiveService;
import com.zoucai.zucai.service.EventService;
import com.zoucai.zucai.service.SuperLottoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "queryData", tags = {"queryData"})
@RequestMapping(value = "/queryData")
@RestController
public class QueryDataController {

    @Autowired
    private EventService eventService;
    @Autowired
    private DualColoreBallService dualColoreBallService;
    @Autowired
    private SuperLottoService superLottoService;
    @Autowired
    private ElevenSelectedFiveService elevenSelectedFiveService;

    @ApiOperation(value = "抓取数据", notes = "抓取数据")
    @RequestMapping(value = "/queryZuCaiData", method = RequestMethod.GET)
    public void queryZuCaiData() {
        List<EventService> date = eventService.queryZuCaiData();

    }

    @ApiOperation(value = "抓取数据", notes = "抓取数据")
    @RequestMapping(value = "/queryDualColoreBallData", method = RequestMethod.GET)
    public String queryDualColoreBallData(@RequestParam("callback") String callback) {
        List<DualColoreBall> dualColoreBalls = dualColoreBallService.queryDualColoreBallData();
        List<String> numbers = new ArrayList<String>();
        List<Integer> redBall1 = new ArrayList<Integer>();
        List<Integer> redBall2 = new ArrayList<Integer>();
        List<Integer> redBall3 = new ArrayList<Integer>();
        List<Integer> redBall4 = new ArrayList<Integer>();
        List<Integer> redBall5 = new ArrayList<Integer>();
        List<Integer> redBall6 = new ArrayList<Integer>();
        List<Integer> blueBalls = new ArrayList<Integer>();
        for (int i = (dualColoreBalls.size()-1);i>=0;i--) {
            DualColoreBall dualColoreBall = dualColoreBalls.get(i);
            numbers.add(dualColoreBall.getEventNum());
            redBall1.add(Integer.valueOf(dualColoreBall.getRedBall1()));
            redBall2.add(Integer.valueOf(dualColoreBall.getRedBall2()));
            redBall3.add(Integer.valueOf(dualColoreBall.getRedBall3()));
            redBall4.add(Integer.valueOf(dualColoreBall.getRedBall4()));
            redBall5.add(Integer.valueOf(dualColoreBall.getRedBall4()));
            redBall6.add(Integer.valueOf(dualColoreBall.getRedBall6()));
            blueBalls.add(Integer.valueOf(dualColoreBall.getBlueBall1()));
        }
        Map map = new HashMap();
        map.put("numbers", numbers);
        map.put("redBall1", redBall1);
        map.put("redBall2", redBall2);
        map.put("redBall3", redBall3);
        map.put("redBall4", redBall4);
        map.put("redBall5", redBall5);
        map.put("redBall6", redBall6);
        map.put("blueBalls", blueBalls);

        String str = callback + "(" + (new Gson()).toJson(map) + ")";
        return str;
    }

    @ApiOperation(value = "抓取数据", notes = "抓取数据")
    @ApiParam
    @RequestMapping(value = "/queryDualColoreBallDataBy", method = RequestMethod.GET)
    public String queryDualColoreBallDataBy(@RequestParam("callback") String callback,@RequestParam("startTime") String startTime,
                                            @RequestParam("endTime") String endTime) {
        List<DualColoreBall> dualColoreBalls = dualColoreBallService.queryDualColoreBallData();
        List<List> ballList = new ArrayList();
        for (DualColoreBall dualColoreBall : dualColoreBalls) {
            List list = new ArrayList();
            list.add(Integer.valueOf(dualColoreBall.getEventNum()));
            list.add(Integer.valueOf(dualColoreBall.getRedBall1()));
            ballList.add(list);
        }
        String str = callback + "(" + (new Gson()).toJson(ballList) + ")";
        return str;
    }


    @ApiOperation(value = "抓取数据", notes = "抓取数据")
    @RequestMapping(value = "/queryDualColoreBallDataByBall", method = RequestMethod.GET)
    public String queryDualColoreBallDataByBall(@RequestParam("callback") String callback,@RequestParam("ball") String ball) {
        List<DualColoreBall> dualColoreBalls = dualColoreBallService.queryDualColoreBallData();
        List<List> ballList = new ArrayList();
        for (DualColoreBall dualColoreBall : dualColoreBalls) {
            if(Integer.valueOf(dualColoreBall.getEventNum()) < 18001){
                continue;
            }
            List list = new ArrayList();
            if("redBall1".equals(ball)){
                list.add(Integer.valueOf(dualColoreBall.getRedBall1()));
            }else if("redBall2".equals(ball)){
                list.add(Integer.valueOf(dualColoreBall.getRedBall2()));
            }else if("redBall3".equals(ball)){
                list.add(Integer.valueOf(dualColoreBall.getRedBall3()));
            }else if("redBall4".equals(ball)){
                list.add(Integer.valueOf(dualColoreBall.getRedBall4()));
            }else if("redBall5".equals(ball)){
                list.add(Integer.valueOf(dualColoreBall.getRedBall5()));
            }else if("redBall6".equals(ball)){
                list.add(Integer.valueOf(dualColoreBall.getRedBall6()));
            }else if("blueBall1".equals(ball)){
                list.add(Integer.valueOf(dualColoreBall.getBlueBall1()));
            }
            list.add(Integer.valueOf(dualColoreBall.getEventNum()));
            ballList.add(list);
        }
        String str = callback + "(" + (new Gson()).toJson(ballList.toArray()) + ")";
        return str;
    }


}
