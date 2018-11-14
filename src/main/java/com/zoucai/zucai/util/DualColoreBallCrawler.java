package com.zoucai.zucai.util;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.zoucai.zucai.model.DualColoreBall;
import com.zoucai.zucai.model.Event;
import com.zoucai.zucai.service.DualColoreBallService;
import com.zoucai.zucai.service.EventService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DualColoreBallCrawler extends BreadthCrawler {

    private DualColoreBallService dualColoreBallService;

    public DualColoreBallCrawler(){
        super("",true);
    }

    /**
     * @param crawlPath crawlPath is the path of the directory which maintains
     * information of this crawler
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract
     * links which match regex rules from pag
     */
    public DualColoreBallCrawler(String crawlPath, boolean autoParse, DualColoreBallService dc) {
        super(crawlPath, autoParse);
        dualColoreBallService = dc;
        /*start page*/
        this.addSeed("https://datachart.500.com/ssq/history/newinc/history.php?start=08000&end=18133");

        /*fetch url like http://news.hfut.edu.cn/show-xxxxxxhtml*/
//        this.addRegex("http://news.hfut.edu.cn/show-.*html");
            this.addRegex("https://datachart.500.com/ssq/history/newinc/history.php*");
//        this.addRegex("http://info.sporttery.cn/football/match_result.php?page=.*&search_league=0&start_date=2001-01-01&end_date=2018-10-31");
        /*do not fetch jpg|png|gif*/
        this.addRegex("-.*\\.(jpg|png|gif).*");
        /*do not fetch url contains #*/
        this.addRegex("-.*#.*");
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        String url = page.url();
        System.out.println(url);
        /*if page is news page*/
        if (url.contains("https://datachart.500.com/ssq/history/newinc/history.php")) {
            /*we use jsoup to parse page*/
            Document doc = page.doc();

            /*extract title and content of news by css selector*/
            Elements elements = doc.select("#tdata");
            Elements trs = elements.select("tr");
            for(Element tr : trs){
                Elements tds = tr.select("td");
                DualColoreBall event = new DualColoreBall();
                if(tds.size() == 16){
                    event.setEventNum(tds.get(0).text());
                    event.setRedBall1(tds.get(1).text());
                    event.setRedBall2(tds.get(2).text());
                    event.setRedBall3(tds.get(3).text());
                    event.setRedBall4(tds.get(4).text());
                    event.setRedBall5(tds.get(5).text());
                    event.setRedBall6(tds.get(6).text());
                    event.setBlueBall1(tds.get(7).text());
                    event.setEventDate(tds.get(15).text());
                    dualColoreBallService.insertData(event);
                }
                for(Element td : tds){
                    System.out.println(td.text());
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        NewsCrawler crawler = new NewsCrawler("crawl", true);
//        crawler.setThreads(50);
////        crawler.setTopN(100);
//        //crawler.setResumable(true);
//        /*start crawl with depth of 4*/
//        crawler.start(99);
    }

}
