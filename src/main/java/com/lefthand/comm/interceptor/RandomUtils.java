package com.lefthand.comm.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomUtils {
	private static String[] randomValues = new String[] {"0","1","2","3","4","5","6","7","8","9",
		"a","b","c","d","e","f","g","h","i","j","k","l","m","n","u","t","s","o","x","v","p","q","r","w","y","z"};
	public static String getRandomValue(int lenght) {
		StringBuffer str = new StringBuffer();
		for(int i = 0;i < lenght; i++){
			Double number = Math.random()*(randomValues.length-1);
			str.append(randomValues[number.intValue()]);
		}
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String formattedDate = formatter.format(today);
		str.append(formattedDate);
		return str.toString();
	}
}
