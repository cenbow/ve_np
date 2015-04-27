package com.ve.marketingcenter.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Description: 日期辅助类
 */
public abstract class DateUtils {
	private static final Log logger = LogFactory.getLog(DateUtils.class);
	public static final ThreadLocal<Calendar> defaultCalender = new ThreadLocal<Calendar>() {
		@Override
		protected Calendar initialValue() {
			return Calendar.getInstance();
		}
	};

	/**
	 * 每个时间单位的毫秒数
	 */
	private static final long MS_IN_DAY = 86400000L;
	private static final long MS_IN_HOUR = 3600000L;
	private static final long MS_IN_MINUTE = 60000L;
	private static final long MS_IN_SECOND = 1000L;

	private static final int DAYS_OF_YEAR = 365;

	// 日期时间全格式 24小时制
	/**
	 * 24小时制日期时间格式 yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 24小时制日期时间格式 yyyyMMddHHmmss
	 */
	public static final String DATETIME_FORMAT2 = "yyyyMMddHHmmss";

	/**
	 * 24小时制时期时间一天开始 yyyy-MM-dd 00:00:00
	 */
	public static final String DATE_ZEROTIME_FORMAT = "yyyy-MM-dd 00:00:00";


	/**
	 * 24小时制日期时间一天开始 yyyyMMdd000000
	 */
	public static final String DATE_ZEROTIME_FORMAT2 = "yyyyMMdd000000";

	/**
	 * 24小时制日期时间一天末 yyyy-MM-dd 23:59:59
	 */
	public static final String DATE_FULLTIME_FORMAT = "yyyy-MM-dd 23:59:59";


	/**
	 * 24小时制日期时间一天末 yyyyMMdd235959
	 */
	public static final String DATE_FULLTIME_FORMAT2 = "yyyyMMdd235959";

	// 日期时间全格式 12小时制
	/**
	 * 12小时制日期时间格式 yyyy-MM-dd hh:mm:ss
	 */
	public static final String DATETIME12_FORMAT = "yyyy-MM-dd hh:mm:ss";

	/**
	 * 12小时制日期时间格式 yyyyMMddhhmmss
	 */
	public static final String DATETIME12_FORMAT2 = "yyyyMMddhhmmss";// DATE_TIME_SHORT_14

	// 日期全格式
	/**
	 * 日期格式yyyy-MM-dd
	 */
	public static final String DATE_FORMAT_CS = "yyyy-MM-dd";// DateFormats.DATE_CS
	/**
	 * 日期格式 yyyyMMdd
	 */
	public static final String DATE_FORMAT_SHORT = "yyyyMMdd";// DateFormats.DATE_SHORT

	public static final String DATE_FORMAT_UNDER_LINE = "yyyy_MM_dd_hhmmss";

	// 年月
	/**
	 * 年月 yyyy-MM
	 */
	public static final String YEAR_MONTH_FORMAT = "yyyy-MM";

	/**
	 * 年月yyyyMM
	 */
	public static final String YEAR_MONTH_FORMAT2 = "yyyyMM";// YAER_MONTH

	// 某年某月的第一天 added by zhao hong
	/**
	 * 某月的第一天 yyyy-MM-01
	 */
	public static final String YEAR_MONTH_FIRSTDAY = "yyyy-MM-01";

	/**
	 * 4位年
	 */
	public static final String YEAR_FORMAT = "yyyy";
	/**
	 * 2位月
	 */
	public static final String MONTH_FORMAT = "MM";
	/**
	 * 2位天
	 */
	public static final String DAY_FORMAT = "dd";

	// 时间全格式 24小时制
	/**
	 * 24小时制时间 时分秒 冒号分隔 HH:mm:ss
	 */
	public static final String TIME_FORMAT = "HH:mm:ss";
	/**
	 * 24小时制时间 时分秒 无分隔 HHmmss
	 */
	public static final String TIME_FORMAT2 = "HHmmss";

	/**
	 * 24小时制 年月日时分秒 yyyy/MM/dd HH:mm:ss
	 */
	public static final String DATETIME_SLASH_FORMAT = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 24小时制 年月日 yyyy/MM/dd
	 */
	public static final String DATE_SLASH_FORMAT = "yyyy/MM/dd";

	public static final String DATE_DOT_FORMAT_1 = "yyyy.MM.dd";

	public static final String DATE_DOT_FORMAT_2 = "dd.MM.yyyy";

	/**
	 * 不能实例化
	 */
	private DateUtils() {
	}

	/**
	 * 返回当前时间<br/>
	 * 这里返回当前服务器的虚拟时间
	 * 
	 * @return 当前时间
	 */
	public static Date getCurrentDate() {
		// return new VirtualDate();
		return new Date();
	}

	/**
	 * 用毫秒表示的时间 <br/>
	 * 这里返回当前服务器的虚拟时间
	 * 
	 * @return 毫秒数表示的虚拟时间值
	 */
	public static long currentTimeMillis() {
		// return VirtualTime.getVirtualTime();
		return System.currentTimeMillis();
	}

	/**
	 * 计算两个时间相隔的月数
	 * 
	 * @param date1
	 *            时间点1
	 * @param date2
	 *            时间点2
	 * @return date2 -date1 的月数查
	 */
	public static int monthsBetween(int paramInt1, int paramInt2) {
		return paramInt2 / 100 * 12 + paramInt2 % 100
				- (paramInt1 / 100 * 12 + paramInt1 % 100);
	}

	/**
	 * 计算两个时间相隔的月数
	 * 
	 * @param date1
	 *            时间点1
	 * @param date2
	 *            时间点2
	 * @return date2 -date1 的月数查
	 */
	public static int monthsBetween(Date paramDate1, Date paramDate2) {
		return monthsBetween(getYM(paramDate1).intValue(), getYM(paramDate2)
				.intValue());
	}

	private static Integer getYM(java.util.Date paramDate) {
		if (paramDate == null) {
			return null;
		}
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(paramDate);
		int i = localCalendar.get(1);
		int j = localCalendar.get(2) + 1;
		return (i * 100 + j);
	}

	/**
	 * 计算两个时间相隔的月数
	 * 
	 * @param date1
	 *            时间点1
	 * @param date2
	 *            时间点2
	 * @return date2 -date1 的年数查
	 */
	@SuppressWarnings("deprecation")
	public static int yearBetween(Date date1, Date date2) {
		return date2.getYear() - date1.getYear();
	}

	/**
	 * 计算两个时间相隔的天数,不足一天不算一天
	 * 
	 * @param date1
	 *            时间点1
	 * @param date2
	 *            时间点2
	 * @return date2 -date1 的天数查
	 */
	public static long daysBetween(Date date1, Date date2) {

		return (date2.getTime() - date1.getTime()) / MS_IN_DAY;
	}

	public static long daysBetweenForAis(Date date1, Date date2) {
		date1 = startOfDay(date1);
		date2 = startOfDay(date2);
		return daysBetween(date1, date2) + 1;
	}

	/**
	 * 在原有的时间上加上某个值
	 * 
	 * @param aDate
	 *            指定时间
	 * @param days
	 *            要变更的量，可以为负数，
	 * @return 返回变更后的日期
	 * @see VirtualDate
	 */
	public static Date addDays(Date aDate, long days) {
		long timeInMs = aDate.getTime() + days * MS_IN_DAY;
		return new Date(timeInMs);
	}

	/**
	 * 增加
	 * 
	 * @param aDate
	 *            指定时间
	 * @param delta
	 *            要变更的量，可以为负数，
	 * @param timeUnit
	 *            delta参数的时间单位
	 * @return 返回变更后的日期
	 * @see TimeUnit
	 * @see VirtualDate
	 */
	public static Date addMonths(Date aDate, int delta) {
		Date newDate = org.apache.commons.lang.time.DateUtils.addMonths(aDate,
				delta);
		return new Date(newDate.getTime());
	}

	/**
	 * 在原有的时间上加上某个值
	 * 
	 * @param aDate
	 *            指定时间
	 * @param delta
	 *            要变更的量，可以为负数，
	 * @param timeUnit
	 *            delta参数的时间单位
	 * @return 返回变更后的日期
	 * @see TimeUnit
	 * @see VirtualDate
	 */
	public static Date addYears(Date aDate, int delta) {
		Date newDate = org.apache.commons.lang.time.DateUtils.addYears(aDate,
				delta);
		return new Date(newDate.getTime());
	}

	/**
	 * 将时间截取到指定时间的当天的0时0分0秒
	 * <p/>
	 * 例如 传入的时间是2011-06-21 10:19:13， 结果得到 2011-06-21 00:00:00
	 * 
	 * @param aDate
	 *            指定时间
	 * @return 返回变更后的日期
	 * @see VirtualDate
	 */
	public static Date startOfDay(Date aDate) {
		return org.apache.commons.lang.time.DateUtils.truncate(aDate,
				Calendar.DATE);
	}

	/**
	 * 将时间截取到指定时间的当天的23时59分59秒
	 * <p/>
	 * 例如 传入的时间是2011-06-21 10:19:13， 结果得到 2011-06-21 23:59:59.999
	 * 
	 * @param aDate
	 *            指定时间
	 * @return 返回变更后的日期
	 * @see VirtualDate
	 */
	public static Date endOfDay(Date aDate) {
		Date newDate = org.apache.commons.lang.time.DateUtils.truncate(aDate,
				Calendar.DATE);
		long timeImMs = newDate.getTime() + MS_IN_DAY - 1;
		return new Date(timeImMs);
	}

	/**
	 * 当前日期所在月最后一天的23:59:59.0
	 */
	public static Date endOfMonth(Date ts) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(ts.getTime());
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 0);

		return new Date(c.getTimeInMillis());
	}

	/**
	 * 获得所在月的第一天
	 * 
	 * @param ts
	 * @return
	 */
	public static Date startOfMonth(Date ts) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(ts.getTime());
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return new Date(c.getTimeInMillis());
	}

	/**
	 * 获得所在年的第一天
	 * 
	 * @param ts
	 * @return
	 */
	public static Date startOfYear(Date ts) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(ts.getTime());
		c.set(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return new Date(c.getTimeInMillis());

	}

	/**
	 * 获得所在年的最后一天
	 * 
	 * @param ts
	 * @return
	 */
	public static Date endOfYear(Date ts) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(ts.getTime());
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DAY_OF_MONTH, 31);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 0);

		return new Date(c.getTimeInMillis());

	}

	/**
	 * 获得上一年的时间
	 * 
	 * @return 上一年的时间
	 * @see #getCurrentDate()
	 */
	public static Date getLastYearDate() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getCurrentDate().getTime());
		c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 将字符串解析为短整型
	 * 
	 * @param data
	 *            短整型字符串
	 * @return 返回短整型 ,NOTE:如果出错返回0
	 */
	public static short stringToShort(String data) {
		short ret = (short) 0;
		try {
			ret = Short.parseShort(data);
		} catch (NumberFormatException ex) {
			if (null != data && !"".equals(data.trim())) {
				logger.info("DataFormat.stringToShort方法错误提示：该关键字[" + data
						+ "]不是短整数类型!");
			}
		}
		return ret;
	}

	/**
	 * 将字符串解析为整型
	 * 
	 * @param data
	 *            整型字符串
	 * @return 返回整型 ,NOTE:如果出错返回0
	 */
	public static int stringToInt(String data) {
		int keyId = 0;
		try {
			keyId = Integer.parseInt(data);
		} catch (NumberFormatException ex) {
			if (null != data && !"".equals(data.trim())) {
				logger.info("DataFormat.stringToInt方法错误提示：该关键字[" + data
						+ "]不是整数类型!");
			}
		}
		return keyId;
	}

	/**
	 * 将字符串解析为长整型
	 * 
	 * @param data
	 *            长整型字符串
	 * @return 返回长整型 ,NOTE:如果出错返回0
	 */
	public static long stringToLong(String data) {
		long keyId = 0l;
		try {
			keyId = Long.parseLong(data);
		} catch (NumberFormatException ex) {
			if (null != data && !"".equals(data.trim())) {
				logger.info("DataFormat.stringToLong方法错误提示：该关键字[" + data
						+ "]不是长整数类型!");
			}
		}
		return keyId;
	}

	/**
	 * 将字符串解析为双精度浮点
	 * 
	 * @param data
	 *            双精度浮点字符串
	 * @return 返回双精度浮点 ,NOTE:如果出错返回0.0
	 */
	public static double stringToDouble(String data) {
		double ret = 0.0;
		try {
			ret = Double.parseDouble(data);
		} catch (NumberFormatException ex) {
			String errMsg = "该字段不是double类型!" + ex.getMessage();
			logger.error(errMsg);
		}
		return ret;
	}

	/**
	 * 将字符串解析为浮点
	 * 
	 * @param data
	 *            浮点字符串
	 * @return 返回浮点 ,NOTE:如果出错返回0.0
	 */
	public static float stringToFloat(String data) {
		float ret = 0;
		try {
			ret = Float.parseFloat(data);
		} catch (NumberFormatException ex) {
			String errMsg = "该字段不是float类型!" + ex.getMessage();
			logger.error(errMsg);
		}
		return ret;
	}

	/**
	 * Adds the specified (signed) amount of time to the given time field
	 * 
	 * @param original
	 * @param field
	 *            year:Calendar.YEAR; month:Calendar.MONTH; date:Calendar.DATE;
	 *            hour:Calendar.HOUR; minute:Calendar.MINUTE;
	 *            second:Calendar.SECOND
	 * 
	 * @param original
	 * @param field
	 * @param amount
	 * @return
	 */
	public static Date addDateTime(Date original, int field, int amount) {
		Calendar calOriginal = Calendar.getInstance();
		calOriginal.setTime(original);

		// +1900
		GregorianCalendar calendar = new GregorianCalendar(
				calOriginal.get(Calendar.YEAR),
				calOriginal.get(Calendar.MONTH),
				calOriginal.get(Calendar.DAY_OF_MONTH),
				calOriginal.get(Calendar.HOUR_OF_DAY),
				calOriginal.get(Calendar.MINUTE),
				calOriginal.get(Calendar.SECOND));
		calendar.add(field, amount);
		return new Date(calendar.getTime().getTime());
	}

	/**
	 * 返回指定月的月末信息
	 * 
	 * @param ts
	 *            指定时间
	 * @return 月末
	 */
	public static Date endOfAMonth(Date ts) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(ts.getTime());
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 0);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 获得所在月的第一天
	 * 
	 * @param ts
	 * @return
	 */
	public static Date startOfAmonth(Date ts) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(ts.getTime());
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return new Date(c.getTimeInMillis());

	}

	/**
	 * 校验字符串是否为合法日期格式
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static boolean isValidDate(String dateStr, String pattern) {
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(pattern);
		try {
			df.setLenient(false);
			df.parse(dateStr);
			return true;
		} catch (ParseException e) {
			return false;

		}
	}

	/**
	 * 
	 * @param periodType
	 *            周期类型 0-指定 1-年 2-月 3-周 4-日
	 * @param periodUnit
	 *            周期单位，日的时候无效
	 * @param offerDay
	 *            偏移天数
	 * @param validDate
	 *            生效期
	 * @param expireDate
	 *            失效期
	 * @return 第一个有效时间
	 */
	public static Date getNextDay(int periodType, int periodUnit, int offerDay,
			Date validDate, Date expireDate) {
		Date targetDate = null;
		Date today = DateUtils.getCurrentDate();
		if (validDate != null && today.before(validDate)) {
			today = validDate;
		}
		offerDay--;
		if (periodType == 1) {// 年
			if (offerDay + 1 >= DAYS_OF_YEAR) {
				offerDay = DAYS_OF_YEAR - 1;
			}
			targetDate = org.apache.commons.lang.time.DateUtils.addDays(
					org.apache.commons.lang.time.DateUtils.truncate(today,
							Calendar.YEAR), offerDay);
			if (targetDate.before(today)) {// 表示今年已经过了
				targetDate = org.apache.commons.lang.time.DateUtils.addDays(
						org.apache.commons.lang.time.DateUtils.truncate(
								org.apache.commons.lang.time.DateUtils
										.addYears(today, periodUnit),
								Calendar.YEAR), offerDay);
			}
		} else if (periodType == 2) {// 月
			int dayOfMonth = 28;// 当前月天数
			if (dayOfMonth - 1 <= offerDay) {
				offerDay = dayOfMonth - 1;
			}
			targetDate = org.apache.commons.lang.time.DateUtils.addDays(
					org.apache.commons.lang.time.DateUtils.truncate(today,
							Calendar.MONTH), offerDay);
			if (targetDate.before(today)) {// 表示当前月已经过了
				targetDate = org.apache.commons.lang.time.DateUtils.addDays(
						org.apache.commons.lang.time.DateUtils.truncate(
								org.apache.commons.lang.time.DateUtils
										.addMonths(today, periodUnit),
								Calendar.MONTH), offerDay);
			}
		} else if (periodType == 3) {// 周
			Calendar calendar = Calendar.getInstance();
			if (offerDay >= Calendar.DAY_OF_WEEK) {
				offerDay = Calendar.DAY_OF_WEEK - 1;
			}
			calendar.setFirstDayOfWeek(Calendar.SUNDAY);
			calendar.setTime(today);
			calendar.add(Calendar.DATE, 1 - calendar.get(Calendar.DAY_OF_WEEK));
			targetDate = org.apache.commons.lang.time.DateUtils.addDays(
					org.apache.commons.lang.time.DateUtils.truncate(
							calendar.getTime(), Calendar.DATE), offerDay);
			if (targetDate.before(today)) {// 表示当前周已经过了
				targetDate = org.apache.commons.lang.time.DateUtils.addDays(
						org.apache.commons.lang.time.DateUtils.addWeeks(
								org.apache.commons.lang.time.DateUtils
										.truncate(calendar.getTime(),
												Calendar.DATE), periodUnit),
						offerDay);
			}
		} else if (periodType == 4) {// 日
			Calendar calendar = Calendar.getInstance();
			targetDate = org.apache.commons.lang.time.DateUtils.addDays(
					org.apache.commons.lang.time.DateUtils.truncate(
							calendar.getTime(), Calendar.DATE), ++offerDay);
		}
		return expireDate != null && targetDate.after(expireDate) ? null
				: targetDate;
	}

	/**
	 * 秒数转化为时间
	 * 
	 * @param seconds
	 */
	public static Date secToDate(long second) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(second * 1000);
		return c.getTime();
	}

	/**
	 * 毫秒数转时长
	 * 
	 * @param seconds
	 */
	public static String msToDuration(long mss) {
		StringBuffer str = new StringBuffer();
		long days = mss / MS_IN_DAY;
		if (days != 0) {
			str.append(days);
		}
		long hours = (mss % MS_IN_DAY) / MS_IN_HOUR;
		if (str.length() == 0) {
			if (hours != 0) {
				str.append(hours);
			}
		} else {
			str.append(" days ").append(hours);
		}
		long minutes = (mss % MS_IN_HOUR) / MS_IN_MINUTE;
		if (str.length() == 0) {
			if (minutes != 0) {
				str.append(minutes);
			}
		} else {
			str.append(" hours ").append(minutes);
		}
		long seconds = (mss % MS_IN_MINUTE) / MS_IN_SECOND;
		if (str.length() == 0) {
			if (seconds != 0) {
				str.append(seconds);
			}
		} else {
			str.append(" minutes ").append(seconds);
		}
		long millseconds = mss % 1000;
		if (str.length() == 0) {
			str.append(millseconds);
		} else {
			str.append(" seconds ").append(millseconds);
		}
		str.append(" millseconds");
		return str.toString();
	}

	/**
	 * 个时间相减
	 * 
	 * @param beginDate
	 * @param endDate
	 */
	public static long getDaySub(Date beginDate, Date endDate) {
		long day = 0;
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	/**
	 * 
	 * @param i
	 *            -1上一个月, -2上2个月, 0当前月, 1下一个月....
	 * @param formatMonth
	 *            yyyy-MM yyyyMM yyyy/MM
	 * @return
	 */
	public static String getFormatMonth(int i, String formatMonth) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		SimpleDateFormat format = new SimpleDateFormat(formatMonth);
		return format.format(c.getTime());
	}

	public static String cvtUTCDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.format(date);
	}

	public static Date addSecond(Date date, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, second);
		return calendar.getTime();
	}

}
