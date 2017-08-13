package com.cn.resource;

import java.io.File;
import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class JsoupTest {

	/**
	 * @param args
	 */
		public  Document getDocument (String url){
			         try {
			        	 Document doc = Jsoup.connect(url).get();
			        	 System.out.println(doc.html());
			        	 return doc;
			         } catch (IOException e) {
			             e.printStackTrace();
			         }
			         return null;
			     }
			 
		public static void main(String[] args) throws IOException {

//			String html = "<html> " +
//					" <head><title>First parse</title></head> " +
//					" <body> " +
//					" <p x=asd>Parsed HTML into a doc.</p>" +
//					" <p a=asd>Parsed HTML into a doc.</p> " +
//					" <p a=asdasdsaff>Parsed HTMfdaL into a dodasc.</p>  " +
//					"<rs>asfsdfsdfsdf</rs>"+
//					" </body> " +
//					" </html>  ";
//
//			Document doc = Jsoup.parse(html);  
//			Elements title = doc.select("rs");
//			System.out.println(title);
//	        Element body = doc.body();
//	        System.out.println(body.select("p").get(1).getElementsByAttribute("a"));
//			
//			
////			 String str = "<table>" +
////			 		"<tr><td>user</td><td>cc</td></tr>" +
////			 		"<tr><td>pass</td><td>123</td></tr>" +
////			 		     "</table>";
//	//
////		        Document doc = Jsoup.parse(str);
////		        Elements trs = doc.select("table").select("tr");
////		        System.out.println(trs.size());
////		        for(int i = 0;i<trs.size();i++){
////		            Elements tds = trs.get(i).select("td");
////		            for(int j = 0;j<tds.size();j++){
////		                String text = tds.get(j).text();
////		                System.out.println(text);
////		            }
////		        }
			
			String path=System.getProperty("user.dir");
			String  filepath=path+"\\file\\button.html";
			//获取DOM树
			Document doc=Jsoup.parse(new File(filepath), "UTF-8", "");
			Elements body = doc.select("td[id]");//td之后的属性
			for(Element e : body)
			System.out.println(e);
			System.out.println("asfsdfsdfsdf");
			

		}
}