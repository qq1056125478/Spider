package com.cn.resource.test;

import java.io.*;


import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
/*****@author
 * */
public class Test {
	public void musicCategoriesUrl(){
		String filepath=System.getProperty("user.dir")+"\\file\\CategoriesUrl.html";
        int n = 1;
		try {
			PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter(filepath)));
			Document doc = Jsoup.connect("http://www.1ting.com").get();
			Elements url = doc.select("dd").select("ul").select("a").select("[href^=/genre/g]");
			for(Element e : url){
			e.attr("id", String.valueOf(n++));
			System.out.println(e);
			out.println(e.toString());
			} 
			out.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void getNextPage(){
		try {
			Document doc = Jsoup.connect("http://www.1ting.com/genre/g275p6/song").get();
			Element url = doc.select("div.cPages").select("li.thispage").select("a").last();
			System.out.println(url);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void getMusicNamesauthorUrl(){
		try {
			Document doc = Jsoup.connect("http://www.1ting.com/genre/g260p0/song").get();
//			Elements url = doc.select("div.songList").select("a").select("[href~=/player/\\w+?/player_\\d+?.html");
			Elements url = doc.select("div.songList").select("li").select("a");
		    for(int i=0;i<url.size();i++){
		    	Element e = url.get(i);
		    	if(i%2==0)System.out.format("%s", i/2+1+"   "+e.text());
		    	else System.out.format("-%s %s %s \n", e.text(),"_http://www.1ting.com/genre/g260p0/song/",e.attr("href"));
		    	
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws IOException {

		Test obj = new Test();
		obj.getNextPage();

	}

}
