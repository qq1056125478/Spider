package com.cn.comm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Tools {
/*认为没有用的不能作为查询条件的是空的*/
public  static boolean  isNotEmpty(Object obj){
	if(null==obj||"".equals(obj)||obj.toString().length()==0){
		return false;
	}else{
		return true;
	}
}
public  static boolean  isNum(String str){
	
	if(str.matches("[-+]?\\d+?\\.?\\d+?")) return true;
	return false;
    }
public static PrintWriter getPrintWriter(String filepath,boolean isappend){
	PrintWriter  out = null;
	try {
		out = new PrintWriter(new BufferedWriter(new FileWriter(filepath,isappend)));		
	} catch (IOException e) {
		e.printStackTrace();
	}
	return out;
	
}

public static void main(String[] args) {
	System.out.println(isNum("13123213.45"));
	
	
}
}

