package com.zoucai.zucai.util;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.zoucai.zucai.model.ElevenSelectedFive;
import com.zoucai.zucai.model.Event;
import com.zoucai.zucai.service.ElevenSelectedFiveService;
import com.zoucai.zucai.service.EventService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ElevenSelectedFiveCrawler extends BreadthCrawler {

    private ElevenSelectedFiveService elevenSelectedFiveService;

    public ElevenSelectedFiveCrawler(){
        super("",true);
    }

    /**
     * @param crawlPath crawlPath is the path of the directory which maintains
     * information of this crawler
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract
     * links which match regex rules from pag
     */
    public ElevenSelectedFiveCrawler(String crawlPath, boolean autoParse, ElevenSelectedFiveService es) {
        super(crawlPath, autoParse);
        elevenSelectedFiveService = es;
        /*start page*/
        for(int i=1;i<10000;i++){
            this.addSeed("http://info.sporttery.cn/football/match_result.php?page="+i+"&search_league=0&start_date=2001-01-01&end_date=2009-04-27");
        }


        /*fetch url like http://news.hfut.edu.cn/show-xxxxxxhtml*/
//        this.addRegex("http://news.hfut.edu.cn/show-.*html");
            this.addRegex("http://info.sporttery.cn/football/match_result.php?page=.*&search_league=0&start_date=2001-01-01&end_date=2009-04-27.*");
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
        if (page.matchUrl("http://info.sporttery.cn/football/match_result.php.*")) {
            /*we use jsoup to parse page*/
            if(!url.contains("search_league=0&start_date=")){
                return;
            }
            Document doc = page.doc();

            /*extract title and content of news by css selector*/
            Elements elements = doc.select("table.m-tab");
            Elements trs = elements.select("tr");
            for(Element tr : trs){
                Elements tds = tr.select("td");
                ElevenSelectedFive event = new ElevenSelectedFive();
                if(tds.size() == 12){
                    event.setEventDate(tds.get(0).text());
                    elevenSelectedFiveService.insertData(event);
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
