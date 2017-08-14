package com.cn.spider;

import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cn.comm.Tools;
/**@author 刘 训
 * @see jsoup 1.7 jar
 * 2017年3月20日00:12:32
 * */
public class ResourceStransfer {
	
	public void getResources(){
	}
	public void getMusicNamesAuthOrUrl(String songurl){
		String filePath=System.getProperty("user.dir")+"\\file\\MusicList.txt";
		PrintWriter  out = null;
		try {
			out = Tools.getPrintWriter(filePath, true);
			Document doc = Jsoup.connect(songurl).timeout(5000).get();//5秒
//			Elements url = doc.select("div.songList").select("a").select("[href~=/player/\\w+?/player_\\d+?.html");
			Elements url = doc.select("div.songList").select("li").select("a");
			for(int i=0;i<url.size();i++){
		    	Element e = url.get(i);
		    	if(out.checkError()) out.flush();
		    	if(i%2==0){    		
		    		out.format("%-3s http://www.1ting.com%s %15s", i/2+1,e.attr("href"),e.text());
		    		System.out.format("%-3s http://www.1ting.com%s %15s", i/2+1,e.attr("href"),e.text());	
		    	}
		    	else {
		    		out.format("-%s \n", e.text());
		    		System.out.format("-%s \n", e.text());
		    		}	
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
	}
	

	public static void main(String[] args) {
		ResourceStransfer obj = new ResourceStransfer();
		obj.getMusicNamesAuthOrUrl("http://www.1ting.com/genre/g75p1/song/");
	}

}
