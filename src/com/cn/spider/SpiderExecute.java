package com.cn.spider;

import java.io.*;
/**@author 刘 训
 * 
 * 2017年3月20日00:12:32
 * 主要的一个执行类, 目前未采用异步的方式, 所以是单线程执行.
 * 
 * 爬取的 music 资源都被存放在 file/MusicList.txt .
 * 
 * 注:categoriesUrl 来自于 CategoriesUrl.html 文件, 若file 中没有这个文件,
 * 需要执行两次 main 方法, 
 * 一次用来生成 CategoriesUrl.html,
 * 一次用来进行资源爬取.
 * */
public class SpiderExecute implements Runnable{
 static Object o = new Object();
	@Override
	public void run() {
		Url url = new Url();
		ResourceStransfer rt = new ResourceStransfer();//资源处理类, HTML(解析出有用的东西) -> TXT
		
		String nextPage ="",tempurl="",CategoriesUrl;
		while(true){//首先解析种类 URL
			CategoriesUrl =url.musicCategoriesUrl();
			if(CategoriesUrl.equals("")||CategoriesUrl.length()==0)break;//判断种类有无.
			nextPage = CategoriesUrl.toString();// 种类首页为要被解析第一个page
		
			while(true){// 若种类URL有, 则循环判断这一个种类中并解析出 pageURL, 直至这一种类的所有页面全部获取完毕.
			if(nextPage.length()==0||nextPage.equals("")||(nextPage.equals(tempurl)))break;//判断有无 nextpage
			rt.getMusicNamesAuthOrUrl(nextPage);//获取这一页的有用的资源.
//			tempurl = nextPage;
//			System.out.println("tempurl******"+tempurl);		
			nextPage = url.getNextUrl(nextPage);
//			System.out.println("nextpage******"+nextpage);
			
		}
		}
		
	}
	public static void main(String[] args) throws IOException {
		//Spiderexecute obj = new Spiderexecute();
		for(int i=1;i<2;i++){
			SpiderExecute obj = new SpiderExecute();
			Thread t1 = new Thread(obj);
			t1.start();
		}

	}

}