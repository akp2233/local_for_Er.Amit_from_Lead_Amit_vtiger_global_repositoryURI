package com.crm.genericUtility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * @author dk
	 * this method is used to fetch the random number within the range of 1000
	 * @return int
	 */
	 public int getRandomNumber(int range) {
		Random ran=new Random();
		int randomnum = ran.nextInt(range);
		return randomnum;
	}
	 /**
	  * @author dk
	  * this method is used to  current system date 
	  * @return
	  */
	 public String getSystemDateYYYYMMDD() {
		 Date dateobj=new Date();//select java Date 
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		 String date = sdf.format(dateobj);
		 return date;
	 }
	 /**
	  * @author dk 
	  * this method is used to fetch the required date in form of YYYY_MM_DD
	  * @param days
	  * @return String
	  */
	 public String getRequiredDateYYYYMMdd(int days) {
		 SimpleDateFormat sim=new SimpleDateFormat("yyyy-mm-dd");
		 Calendar cal = sim.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH, days);
		 String realdate = sim.format(cal.getTime());
		 return realdate;
		 
	 }
	 /**
	  * @author dk
	  * this method is used to fetch the System date and time
	  * @return String
	  */
	 public String localDateTime() {
		 String time_date = LocalDateTime.now().toString().replace(":", "_");
		 return time_date;
	 }
	

}
