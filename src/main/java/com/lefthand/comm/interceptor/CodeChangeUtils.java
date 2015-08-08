package com.lefthand.comm.interceptor;

public class CodeChangeUtils {
	/** 
	    * 将字符串转成unicode 
	    * @param str 待转字符串 
	    * @return unicode字符串 
	    */ 
	    public String convert(String str) 
	    { 
	    str = (str == null ? "" : str); 
	    String tmp; 
	    StringBuffer sb = new StringBuffer(1000); 
	    char c; 
	    int i, j; 
	    sb.setLength(0); 
	    for (i = 0; i < str.length(); i++) 
	    { 
	    c = str.charAt(i); 
	    sb.append("\\u"); 
	    j = (c >>>8); //取出高8位 
	    tmp = Integer.toHexString(j); 
	    if (tmp.length() == 1) 
	    sb.append("0"); 
	    sb.append(tmp); 
	    j = (c & 0xFF); //取出低8位 
	    tmp = Integer.toHexString(j); 
	    if (tmp.length() == 1) 
	    sb.append("0"); 
	    sb.append(tmp); 

	    } 
	    return (new String(sb)); 
	    } 

	    /** 
	    * 将unicode转成字符串 
	    * @param str 待转字符串 
	    * @return 普通字符串 
	    */ 
	    public String revert(String str) 
	    { 
	    str = (str == null ? "" : str); 
	    if (str.indexOf("\\u") == -1)//如果不是unicode码则原样返回 
	    return str; 

	    StringBuffer sb = new StringBuffer(1000); 

	    for (int i = 0; i < str.length();) 
	    { 
	    String strTemp = str.substring(i, i + 6); 
	   // System.out.println(strTemp);
	    String value = strTemp.substring(2); 
	    int c = 0; 
	    for (int j = 0; j < value.length(); j++) 
	    { 
	    char tempChar = value.charAt(j); 
	    int t = 0; 
	    switch (tempChar) 
	    { 
	    case 'a': 
	    t = 10; 
	    break; 
	    case 'b': 
	    t = 11; 
	    break; 
	    case 'c': 
	    t = 12; 
	    break; 
	    case 'd': 
	    t = 13; 
	    break; 
	    case 'e': 
	    t = 14; 
	    break; 
	    case 'f': 
	    t = 15; 
	    break; 
	    default: 
	    t = tempChar - 48; 
	    break; 
	    } 

	    c += t * ((int) Math.pow(16, (value.length() - j - 1))); 
	    } 
	    sb.append((char) c); 
	    i = i + 6; 
	    } 
	    return sb.toString(); 
	    }

	    public static void main(String args[]){
	    	System.out.println(new CodeChangeUtils().convert("logElment=huangwuqun|??????|6093C67B6A9C461E8964C9DD854815E0|10.110.3.53|http://10.0.8.28/hkgai/tian/T_A_K/tak_LuRu.jsp|2012-08-30%2008:31:06"));
	    	System.out.println(new CodeChangeUtils().revert(new CodeChangeUtils().convert("logElment=huangwuqun|??????|6093C67B6A9C461E8964C9DD854815E0|10.110.3.53|http://10.0.8.28/hkgai/tian/T_A_K/tak_LuRu.jsp|2012-08-30%2008:31:06")));
	    }

}
