package com.cn.spider;

import java.io.*;
/**@author 刘 训
 * 
 * 2017年3月20日00:12:32
 * */
public class Spiderexecute implements Runnable{
 static Object o = new Object();
	@Override
	public void run() {
		Url url = new Url();
		Resourcestransfer rt = new Resourcestransfer();
		String nextpage ="",tempurl="",CategoriesUrl;
		while(true){
			CategoriesUrl =url.musicCategoriesUrl();
			if(CategoriesUrl.equals("")||CategoriesUrl.length()==0)break;
			nextpage = CategoriesUrl.toString();
		
			while(true){
			if(nextpage.length()==0||nextpage.equals("")||(nextpage.equals(tempurl)))break;
			rt.getMusicNamesauthorUrl(nextpage);
			tempurl = nextpage;
//			System.out.println("tempurl******"+tempurl);		
			nextpage = url.getNextUrl(nextpage);
//			System.out.println("nextpage******"+nextpage);
			
		}
		}
		
	}
	public static void main(String[] args) throws IOException {
		//Spiderexecute obj = new Spiderexecute();
		for(int i=1;i<2;i++){
			Spiderexecute obj = new Spiderexecute();
			Thread t1 = new Thread(obj);
			t1.start();
		}

	}

}