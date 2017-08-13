package com.cn.resource;

import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resource {

	/**
	 * @param args
	 */
	
	public void urlresource(String urls){
		String filepath=System.getProperty("user.dir")+"\\file\\CategoriesUrl.html";

		try{
			URL url = new URL(urls);
			URLConnection urlconn=url.openConnection();
			
			InputStream is=urlconn.getInputStream();
			BufferedReader bf=new BufferedReader(new InputStreamReader(is));
			FileOutputStream fs=new FileOutputStream("F:/workspace/web spider/file/resource.txt");
			System.out.println("生成与URL连接的输入流成功");
			String record=null;
			Pattern p1=Pattern.compile("<.*?>.*?<.*?>");
			Pattern p=Pattern.compile("text=\".+?\"");
			while((record=bf.readLine())!=null){
				//System.out.println("record :"+record);
				Matcher m=p.matcher(record);
				//fs.write(record.getBytes());
				while(m.find()){
				System.out.println("  :"+m.group());
				fs.write(m.group().getBytes());
				fs.write(0x0a);}
			}
			fs.close();
			bf.close();

		}catch(Exception o){o.printStackTrace();}		
	}
	public static void main(String[] args) {
		File f=new File("F:/workspace/web spider/file");
		//f.mkdir();
		String url="http://s.music.so.com/s?src=relation_music&q=%E6%B5%81%E8%A1%8C";
		new Resource().urlresource(url);
		
		
		
		
		
		
		
		
		
		
/*		String test="<head> <safdsafds> <!meta http-equiv=content-type content=text/html;charset=utf-8><meta http-equiv=X-UA-Compatible content=IE=Edge><meta content=always name=referrer><link rel=stylesheet type=text/css href=http://s1.bdstatic.com/r/www/cache/bdorz/baidu.min.css><title>百度一下，你就知道</title></head> <body link=#0000cc> <div id=wrapper> <div id=head> <div class=head_wrapper> <div class=s_form> <div class=s_form_wrapper> ";
		Pattern p=Pattern.compile("<.*?>");
		Matcher m=p.matcher(test);
		while(m.find()){
			System.out.println(m.group());
		}

*/
	}

}
