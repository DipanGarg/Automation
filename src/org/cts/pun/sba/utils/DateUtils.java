package org.cts.pun.sba.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String parseIntoString(Date date){
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM yyyy");
		return sdf.format(date);
	}
	
	public static Date parseIntoDate(String date) throws ParseException{
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM yyyy");
		return sdf.parse(date);
	}
	
	public static String getCurrentDate(){
		Calendar cal= Calendar.getInstance();
		Date date=cal.getTime();
		return parseIntoString(date);
	}
	
	public static String getTomorrowDate(){
		return parseIntoString(getDateWrtCurrentDate(1));	
	}
	
	private static Date getDateWrtCurrentDate(int diff){
		Calendar cal= Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE,diff);
		return cal.getTime();	
	}
	
}
