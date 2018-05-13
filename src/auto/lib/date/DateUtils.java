package auto.lib.date;
 

import auto.lib.random.RandomUtils;
import auto.lib.string.*;

//import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {

	public static String FORMAT_SHORT = "yyyy-MM-dd";
	public static String FORMAT_SHORT2 = "yyyy-MM-dd HH";
	public static String FORMAT_SHORT3 = "yyyy-MM-dd HH:mm";
	public static String FORMAT_SHORT4 = "yyyy-MM-dd HH:mm:ss";
	public static String FORMAT_SHORT5 = "yyyy-MM-dd HH:mm:ss.SSS";
	public static String FORMAT_SHORT6 = "yyyy-MM";
	public static String FORMAT_SHORT7 = "yyyy";
	public static String FORMAT_DATE_STRING_NO_HMS = "yyyyMMdd";
	public static String FORMAT_DATE_STRING_HAVING_HMS = "yyyyMMddHHmmss";
	public static String FORMAT_DATE_STRING_HAVING_HM = "yyyyMMddHHmm";
	public static String FORMAT_DATE_STRING_HAVING_H = "yyyyMMddHH";
	public static String FORMAT_DATE_STRING_YYYYMM = "yyyyMM";
	public static String FORMAT_DATE_STRING_YYYY = "yyyy";
	public static String FORMAT_DATE_TIME_STRING_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static String FORMAT_DATE_STRING_yyyyMMdd = "yyyyMMdd";
	public static String FORMAT_FULL_DATE_STRING_yyyyMMddHHmmssS = "yyyyMMddHHmmssSSS";
	public static String FORMAT_DATE_01 = "yyyyMM";
	public static String FORMAT_DATE_02 = "yyyyMMdd";
	public static String FORMAT_DATE_03 = "yyyyMMddHH";
	public static String FORMAT_DATE_04 = "yyyyMMddHHmm";
	public static String FORMAT_DATE_05 = "yyyyMMddHHmmss";
	public static String FORMAT_DATE_06 = "yyyyMMddHHmmssSSS";
	public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss"; //Ӣ��ȫ�� �磺2010-12-01 23:15:06
	public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.SSS";//Ӣ��ȫ�� �磺2010-12-01 23:15:06.323
	public static String FORMAT_SHORT_CN = "yyyy��MM��dd";//���ļ�д �磺2010��12��01��
	public static String FORMAT_LONG_CN = "yyyy��MM��dd��  HHʱmm��ss��";//����ȫ�� �磺2010��12��01�� 23ʱ15��06��
	public static String FORMAT_FULL_CN = "yyyy��MM��dd��  HHʱmm��ss��SSS����";//����ȫ�� �磺2010��12��01�� 23ʱ15��06��323����
	
	
	/**
	 * ʹ���û���ʽ��ʽ������
	 * 
	 * @param date
	 *            ����
	 * @param pattern
	 *            ���ڸ�ʽ
	 * @return
	 */
	public static String format(Date date, String pattern) {
		String returnValue = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}
		return (returnValue);
	}
	
	
	public static String getDateString(String format){
		String temp = format.toUpperCase();
		String ret = "";
		switch(temp){
		case "YYYY-MM-DD":
			ret = format(new Date(), FORMAT_SHORT);break;
		case "YYYY-MM-DD HH":
			ret = format(new Date(), FORMAT_SHORT2);break;
		case "YYYY-MM-DD HH:MM":
			ret = format(new Date(), FORMAT_SHORT3);break;
		case "YYYY-MM-DD HH:MM:SS":
			ret = format(new Date(), FORMAT_SHORT4);break;
		case "YYYY-MM-DD HH:MM:SS.SSS":
		case "YYYY-MM-DD HH:MM:SS.S":
			ret = format(new Date(), FORMAT_SHORT5);break;
		case "YYYY-MM":
			ret = format(new Date(), FORMAT_SHORT6);break;
		case "YYYY":
			ret = format(new Date(), FORMAT_SHORT7);break;
		case "YYYYMM":
			ret = format(new Date(), FORMAT_DATE_01);break;
		case "YYYYMMDD":
			ret = format(new Date(), FORMAT_DATE_02);break;
		case "YYYYMMDDHH":
			ret = format(new Date(), FORMAT_DATE_03);break;
		case "YYYYMMDDHHMM":
			ret = format(new Date(), FORMAT_DATE_04);break;
		case "YYYYMMDDHHMMSS":
			ret = format(new Date(), FORMAT_DATE_05);break;
		case "YYYYMMDDHHMMSSSSS":
		case "YYYYMMDDHHMMSSS":
			ret = format(new Date(), FORMAT_DATE_06);break;
		}
		return ret;
	}
	
	public static String getDateStringByPrefix(String prefix, String format){
		return prefix+getDateString(format);
	}
	
	public static String getFutureDateByMonths(int n){
		Date dt = addMonth(new Date(), n);
		return format(dt,FORMAT_SHORT4);
	}
	public static String getFutureDateByWeeks(int n){
		Date dt = addDay(new Date(), n*7);
		return format(dt,FORMAT_SHORT4);
	}
	public static String getFutureDateByDays(int n){
		Date dt = addDay(new Date(), n);
		return format(dt,FORMAT_SHORT4);
	}
	public static String getFutureDateByDays(String str, int n){
		Date dtt = new Date();
		try{
			Date dt = format2Date(str);
			dtt = addDay(dt, n);
			
		} catch (ParseException e) {  
            e.printStackTrace();  
        }
		return format(dtt,FORMAT_SHORT4); 
	}
	public static String getFutureDateByWorkDays(int n){
		Date dt = addWorkDay(new Date(), n);
		return format(dt,FORMAT_SHORT4);
	}
	public static String getFutureDateByMins(int n){
		Date dt = addMinute(new Date(), n);
		return format(dt,FORMAT_SHORT4);
	}
	public static String getFutureDateByMins(String str, int n) {
		Date dtt = new Date();
		try{
			Date dt = format2Date(str);
			dtt = addMinute(dt, n);
			
		} catch (ParseException e) {  
            e.printStackTrace();  
        }
		return format(dtt,FORMAT_SHORT4);
	}
	
	public static String getPreviousDateByDays(int n){
		Date dt = reverseDay(new Date(), n);
		return format(dt,FORMAT_SHORT4);
	}
	public static String getPreviousDateByDays(String str, int n){
		Date dtt = new Date();
		try{
			Date dt = format2Date(str);
			dtt = reverseDay(dt, n);
			
		} catch (ParseException e) {  
            e.printStackTrace();  
        }
		return format(dtt,FORMAT_SHORT4);
	}
	public static String getPreviousDateByWeeks(int n){
		Date dt = reverseDay(new Date(), n*7);
		return format(dt,FORMAT_SHORT4);
	}
	public static String getPreviousDateByWorkDays(int n){
		Date dt = reverseWorkDay(new Date(), n);
		return format(dt,FORMAT_SHORT4);
	}
	public static String getPreviousDateByMonths(int n){
		Date dt = reverseMonth(new Date(), n);
		return format(dt,FORMAT_SHORT4);
	}
	public static String getPreviousDateByHours(int n){
		Date dt = reverseHour(new Date(), n);
		return format(dt,FORMAT_SHORT4);
	}
	public static String getPreviousDateByMins(int n){
		Date dt = reverseMin(new Date(), n);
		return format(dt,FORMAT_SHORT4);
	}
	public static String getPreviousDateByMins(String str, int n){
		Date dtt = new Date();
		try{
			Date dt = format2Date(str);
			dtt = reverseMin(dt, n);
			
		} catch (ParseException e) {  
            e.printStackTrace();  
        }
		return format(dtt,FORMAT_SHORT4);
	}
	
	public static String getDateStringHavingH(Date date){
		return format(date, FORMAT_DATE_STRING_HAVING_H);
	}
	public static String getDateStringHavingHM(Date date){
		return format(date, FORMAT_DATE_STRING_HAVING_HM);
	}
	public static String getDateStringHavingHMS(Date date){
		return format(date, FORMAT_DATE_STRING_HAVING_HMS);
	}
	public static String getDateStringHavingYM(Date date){
		return format(date, FORMAT_DATE_STRING_YYYYMM);
	}
	public static String getDateStringHavingY(Date date){
		return format(date, FORMAT_DATE_STRING_YYYY);
	}
	public static String getDateTimeStringNoSeparator(){
		return format(new Date(), FORMAT_DATE_TIME_STRING_yyyyMMddHHmmss);
	}
	public static String getDateTimeStringNoSeparator(Date date){
		return format(date, FORMAT_DATE_TIME_STRING_yyyyMMddHHmmss);
	}
	public static String getDateStringNoSeparator(){
		return format(new Date(), FORMAT_DATE_STRING_yyyyMMdd);
	}
	public static String getFullDateStringNoSeparator(){
		return format(new Date(), FORMAT_FULL_DATE_STRING_yyyyMMddHHmmssS);
	}
	public static String getFullDateTimeStringNoSeparator(){
		return format(new Date(), FORMAT_FULL_DATE_STRING_yyyyMMddHHmmssS);
	}
	public static String getFullDateStringNoSeparator(Date date){
		return format(date, FORMAT_FULL_DATE_STRING_yyyyMMddHHmmssS);
	}
	public static String getFullDateTimeStringNoSeparator(Date date){
		return format(date, FORMAT_FULL_DATE_STRING_yyyyMMddHHmmssS);
	}

	/**
	 * ���Ĭ�ϵ� date pattern
	 */
	public static String getDatePattern() {
		return FORMAT_LONG;
	}

	/**
	 * ����Ԥ���ʽ���ص�ǰ����
	 * 
	 * @return
	 */
	public static String getNow() {
		return format(new Date());
	}

	/**
	 * �����û���ʽ���ص�ǰ����
	 * 
	 * @param format
	 * @return
	 */
	public static String getNow(String format) {
		return format(new Date(), format);
	}

	/**
	 * ʹ��Ԥ���ʽ��ʽ������
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format(date, getDatePattern());
	}

	

	public static Date toObject(String dateStr) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		if(dateStr.length() == 10){
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		}else if(dateStr.length() == 19){
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else if(dateStr.length() == 23){
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		}else{
			return new Date();
		}
        Date date = null;
        date = dateFormat.parse(dateStr);
        return date;
	}
	
	public static Date format2Date(String dateStr) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		if(dateStr.length() == 10){
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		}else if(dateStr.length() == 19){
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else if(dateStr.length() == 23){
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		}else{
			return new Date();
		}
        Date date = null;
        date = dateFormat.parse(dateStr);
        return date;
	}
	/**
	 * ʹ��Ԥ���ʽ��ȡ�ַ�������
	 * 
	 * @param strDate
	 *            �����ַ���
	 * @return
	 */
	public static Date parse(String strDate) {
		return parse(strDate, getDatePattern());
	}

	/**
	 * ʹ���û���ʽ��ȡ�ַ�������
	 * 
	 * @param strDate
	 *            �����ַ���
	 * @param pattern
	 *            ���ڸ�ʽ
	 * @return
	 */
	public static Date parse(String strDate, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ��������������������
	 * 
	 * @param date
	 *            ����
	 * @param n
	 *            Ҫ���ӵ�����
	 * @return
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * �������ϼ���������
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date reverseMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -n);
		return cal.getTime();
	}
	
	/**
	 * ����������������
	 * 
	 * @param date
	 *            ����
	 * @param n
	 *            Ҫ���ӵ�����
	 * @return
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}

	public static String addWorkDay(String str, int n) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(format2Date(str));
		for(int i = 1; i <= n; i++){
			cal.add(Calendar.DATE, 1);
			if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				cal.add(Calendar.DATE, 1);
			}else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
				cal.add(Calendar.DATE, 2);
			}
		}
		return format(cal.getTime(),"yyyy-MM-dd");
	}
	public static Date addWorkDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		for(int i = 1; i <= n; i++){
			cal.add(Calendar.DATE, 1);
			if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				cal.add(Calendar.DATE, 1);
			}else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
				cal.add(Calendar.DATE, 2);
			}
		}
		return cal.getTime();
	}
	
	/**
	 * �������ϼ�����
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date reverseDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -n);
		return cal.getTime();
	}
	
	public static Date reverseWorkDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//System.out.println(n);
		//System.out.println(cal.getTime()+"-start");
		cal.add(Calendar.DATE, -1);
		for(int i = 1; i <= n; i++){
			if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				//System.out.println(cal.getTime()+"-1");
				cal.add(Calendar.DATE, -2);i--;
			}else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
				//System.out.println(cal.getTime()+"-2");
				cal.add(Calendar.DATE, -1);i--;
			}else{
				//System.out.println(cal.getTime()+"-3");
				cal.add(Calendar.DATE, -1);
			}
		}
		cal.add(Calendar.DATE, 1);
		//System.out.println(cal.getTime()+"-end");
		return cal.getTime();
	}
	/**
	 * �����������ӷ���
	 * 
	 * @param date
	 *            ����
	 * @param n
	 *            Ҫ���ӵ�����
	 * @return
	 */
	public static Date addMinute(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, n);
		return cal.getTime();
	}

	/**
	 * �������ϼ�����Сʱ
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date reverseHour(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, -n);
		return cal.getTime();
	}
	
	/**
	 * �������ϼ�������
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date reverseMin(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, -n);
		return cal.getTime();
	}
	/**
	 * ��ȡʱ���
	 */
	public static String getTimeString() {
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
		Calendar calendar = Calendar.getInstance();
		return df.format(calendar.getTime());
	}

	/**
	 * ��ȡ�������
	 * 
	 * @param date
	 *            ����
	 * @return
	 */
	public static String getYear(Date date) {
		return format(date).substring(0, 4);
	}

	/**
	 * ��Ĭ�ϸ�ʽ���ַ���������������
	 * 
	 * @param date
	 *            �����ַ���
	 * @return
	 */
	public static int countDays(String date) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * ���û���ʽ�ַ���������������
	 * 
	 * @param date
	 *            �����ַ���
	 * @param format
	 *            ���ڸ�ʽ
	 * @return
	 */
	public static int countDays(String date, String format) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date, format));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * ����������������
	 *
	 * @param date
	 *            Date ����
	 * @return �����·�
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * ����������������
	 *
	 * @param date
	 *            Date ����
	 * @return �����շ�
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ��������������С
	 *
	 * @param date
	 *            ����
	 * @return ����Сʱ
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * �������������ط�
	 *
	 * @param date
	 *            ����
	 * @return ���ط���
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * ��������
	 *
	 * @param date
	 *            Date ����
	 * @return ��������
	 */
	public static int getSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * �������������غ�
	 *
	 * @param date
	 *            ����
	 * @return ���غ�
	 */
	public static long getMillis(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	public static String secToHMS(long seconds){
		String timeStr = seconds + "��";    
        if (seconds > 60) {    
            long second = seconds % 60;    
            long min = seconds / 60;    
            timeStr = min + "��" + second + "��";    
            if (min > 60) {    
                min = (seconds / 60) % 60;    
                long hour = (seconds / 60) / 60;    
                timeStr = hour + "Сʱ" + min + "��" + second + "��"; 
            }    
        }    
       return (timeStr);
	}
	public static String secToDHMS(long seconds){
		String timeStr = seconds + "��";    
        if (seconds > 60) {    
            long second = seconds % 60;    
            long min = seconds / 60;    
            timeStr = min + "��" + second + "��";    
            if (min > 60) {    
                min = (seconds / 60) % 60;    
                long hour = (seconds / 60) / 60;    
                timeStr = hour + "Сʱ" + min + "��" + second + "��";    
                if (hour > 24) {    
                    hour = ((seconds / 60) / 60) % 24;    
                    long day = (((seconds / 60) / 60) / 24);    
                    timeStr = day + "��" + hour + "Сʱ" + min + "��" + second + "��";    
                }    
            }    
        }    
       return (timeStr);
	}
	
	public static String secToHHMMSS2(long seconds){
		String timeStr = null; 
		long hour = 0; 
		long minute = 0; 
		long second = 0; 
		if (seconds <= 0) 
			timeStr = "00:00:00";
		else { 
			minute = seconds / 60; 
			if (minute < 60) { 
				second = seconds % 60; 
				timeStr = unitFormat(minute) + "'" + unitFormat(second) + "\""; 
			} else { 
				hour = minute / 60; 
				minute = minute % 60; 
				second = seconds - hour * 3600 - minute * 60; 
				timeStr = unitFormat(hour) + "h" + unitFormat(minute) + "'" + unitFormat(second) + "\""; 
			} 
		} 
		return timeStr;
	}
	public static String secToHHMMSS(long seconds){
		String timeStr = null; 
		long hour = 0; 
		long minute = 0; 
		long second = 0; 
		if (seconds <= 0) 
			timeStr = "00:00:00";
		else { 
			minute = seconds / 60; 
			if (minute < 60) { 
				second = seconds % 60; 
				timeStr = "00:" + unitFormat(minute) + ":" + unitFormat(second); 
			} else { 
				hour = minute / 60; 
				minute = minute % 60; 
				second = seconds - hour * 3600 - minute * 60; 
				timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second); 
			} 
		} 
		return timeStr;
	}
	
	public static String unitFormat(long i) {
		 String retStr = null; 
		 if (i >= 0 && i < 10) 
			retStr = "0" + Long.toString(i); 
		 else 
			retStr = "" + i; 
		 return retStr; 
	}
	
	public static long hms2Seconds(String hms){
		String[] str = new String[3];
		str = hms.split(":");
		if(str.length<3)
			return 0;
		else{
			long hour_ = Long.valueOf(str[0])*60*60;
			long min_ = Long.valueOf(str[1])*60;
			long sec_ = Long.valueOf(str[2]);
			return (hour_+min_+sec_);
		}
	}
	
	public static boolean isWeekDay(String str) throws ParseException{
		Calendar cal = Calendar.getInstance();
		if(str.length() == 10 || str.length() == 19){
			cal.setTime(format2Date(StringUtils.strSub(str, 1, 10)));
		}else
		{
			return false;
		}
		if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||   
				cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){ 
			cal.add(Calendar.DATE, -1);
			return true;
		}else{
			return false;
		}
	}
	public static String getWhatDay(String date) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(format2Date(StringUtils.strSub(date, 1, 10)));
		switch(cal.get(Calendar.DAY_OF_WEEK)){
		case Calendar.MONDAY:
			return "����һ";
		case Calendar.TUESDAY:
			return "���ڶ�";
		case Calendar.WEDNESDAY:
			return "������";
		case Calendar.THURSDAY:
			return "������";
		case Calendar.FRIDAY:
			return "������";
		case Calendar.SATURDAY:
			return "������";
		case Calendar.SUNDAY:
			return "������";
		default:
			return "ʱ������";
		}
	}

	public static String getTimestamp() throws InterruptedException{
		Thread.sleep(1);
		Date date = new Date();
		return String.valueOf(date.getTime());
	}
	
	public static String nextWeek(Date date, int n){
		Date dt = addDay(date,n*7);
		return format(dt);
	}
	public static String prevWeek(Date date, int n){
		Date dt = reverseDay(date,n*7);
		return format(dt);
	}
	public static String nextMonth(Date date, int n){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return format(cal.getTime());
	}
	public static String prevMonth(Date date, int n){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -n);
		return format(cal.getTime());
	}
	//���δ��n���ڵ�ĳһ��
	public static String getFutureDate(int n){
		Date dt = DateUtils.addDay(new Date() ,Integer.parseInt(RandomUtils.getRandomNum(0,n)));
		return DateUtils.format(dt);

	}
	public static String getDateStringNoHMS(Date date){
		return format(date, FORMAT_DATE_STRING_NO_HMS);
	}
	
	public static String getFullDateTime(){
		return format(new Date(), FORMAT_FULL);
	}
	public static String getFullTime(){
		return format(new Date(), FORMAT_FULL_DATE_STRING_yyyyMMddHHmmssS);
	}
	public static void main(String[] args) throws Exception{
		//System.out.println(prevMonth(new Date(),2));
		//System.out.println(DateUtils.getDateString("yyyy-mm-dd hh:mm:ss.s"));
		//System.out.println(DateUtils.getDateStringByPrefix("Test","yyyymmddhhmmss"));
		
		//System.out.println(DateUtils.getFutureDateByDays("2018-03-20 10:32:34",1));
		//System.out.println(DateUtils.getFutureDateByDays("2018-03-20 10:32:34",2));
	}
}