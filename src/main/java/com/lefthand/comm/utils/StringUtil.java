package com.lefthand.comm.utils;

public class StringUtil {
	/*
	 截取字符串要把两个英文或数字当成一个中文来算,如aa中国,截取二位结果应该是aa中
	 设计思路循环字符串用一个countWordNum变量计数,当这个变量等于我们要截取的字符长度(参数length)时,此时循环到的字符位置
	 就是要截取的字符位置.但countWordNum变量累加时要求如果是中文时直接加一,如果是英文或数字时要两个算一个中文才加一,所以
	 要用另一个wordNum变量来计数,当循环过程中有过一个英文或数字时就加一,直到wordNum变量为二时表示已经碰到两个英文或数字了
	 此时countWordNum变量才加一.
	 */
	public static String ShorterString(String s, int length){
		
		int wordNum = 0;	//是第一个字节的ascii码的计数器
		int countWordNum = 0;//应该截取字数的计数器,当是汉字时直接加一,不是汉字是要wordNum累加两次为2时再加一
		int index = 0;		//真正要截取字符串的位置
		//System.out.println("ShorterString:" + s);
		if(s.equals("") || s.length() < length){
			return s;
		}
		for(int i=0; i< s.length(); i++){
			
			index++;
			int asciiNum = (int)s.charAt(i);//取字符的ascii码值
			if(asciiNum <= 127){//字符是ascii码时,计数器加一
				wordNum++;
			}else{
				countWordNum++;
			}
			if(wordNum == 2){//当计数器是为2时,表示找到两个ascii码字符,要当成一个汉字,所以countWordNum加一
				countWordNum++;
				wordNum = 0;
			}
			if(countWordNum == length){
				break;
			}
			//System.out.println(index + " - " + wordNum + " - " + ChinaWordNum + " - " + countWordNum);
		}
		if(index >= s.length()){
			index = s.length();
			return s.substring(0, index);
		}
		
		return s.substring(0, index) + "..";
	}

}
