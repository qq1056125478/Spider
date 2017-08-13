package com.cn.spider;

import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cn.comm.Tools;

/**
 * @author 刘 训
 * @see jsoup 1.7 jar 2017年3月20日00:12:32
 * */
public class Url {
	private String Nextpageurl;
	private String CategoriesUrl;
	private static int CategoriesUrlCount = 1;
	private static int PageUrlCount = 1;

	public String getNextUrl(String url) {
		String filepath = System.getProperty("user.dir")
				+ "\\file\\MusicList.txt";
		PrintWriter out = null;
		Document doc = null;
		try {
			out = Tools.getPrintWriter(filepath, true);
			doc = Jsoup.connect(url).timeout(5000).get(); // 5秒
			Element Nextpageurl = doc.select("div.cPages").select("li")
					.select("a").last();
			if (Nextpageurl.hasAttr("href")) {
				System.out.format("%-35s page:%3d\n", Nextpageurl,
						PageUrlCount++);
				if (out.checkError())
					out.flush();
				out.format("%-35s page:%3d \n", Nextpageurl, PageUrlCount);
				this.Nextpageurl = "http://www.1ting.com"
						+ Nextpageurl.attr("href");
			} else
				Nextpageurl = null;
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}

		return Nextpageurl;

	}

	public String musicCategoriesUrl() {
		String filepath = System.getProperty("user.dir")
				+ "\\file\\CategoriesUrl.html";
		PrintWriter out = null;
		Document doc = null;
		File f = new File(System.getProperty("user.dir")
				+ "\\file\\MusicList.txt");
		saveAllCategoriesUrl(filepath, doc);
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			out = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
			doc = Jsoup.parse(new File(filepath), "utf-8");
			Element e = doc.select("[id=" + CategoriesUrlCount++ + "]").first();
			if (e == null)
				return CategoriesUrl = null;

			CategoriesUrl = new StringBuilder("http://www.1ting.com").append(
					e.attr("href").replaceAll(".html", "/song")).toString();
			if (out.checkError())
				out.flush();
			out.format("%33s\n ************** %s **************\n\n", e.text(),
					CategoriesUrl);
			System.out.format("%33s\n ************** %s **************\n\n",
					e.text(), CategoriesUrl);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}

		return CategoriesUrl;
	}

	public void saveAllCategoriesUrl(String filepath, Document doc) {
		if (!new File(filepath).exists()) {
			try {
				doc = Jsoup.connect("http://www.1ting.com").timeout(5000).get();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Elements url = doc.select("div.smallnav").select("ul").select("a")
					.select("[href^=/genre/g]");
			PrintWriter out = Tools.getPrintWriter(filepath, true);
			for (Element e : url) {
				e.attr("id", String.valueOf(CategoriesUrlCount++));
				System.out.println(e);
				out.println(e.toString());
				if (out.checkError())
					out.flush();
			}
		}
	}

	public static void main(String[] args) {
		Url obj = new Url();
		obj.musicCategoriesUrl();
		// obj.getNextUrl("http://www.1ting.com/genre/g275p3/song");
	}

}
