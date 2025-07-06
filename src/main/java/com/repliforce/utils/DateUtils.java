package com.repliforce.utils;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;

public class DateUtils {
	
	/**
	 * Return a new date with the number of days added to the given date.
	 * 	the Date can stay in future (days > 0) or in past (days < 0)
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	
	/**
	 * Returns the current date with the difference in days sent as a parameter
	 * The date can be in the future (positive parameter) or in the past (negative parameter)
	 * 
	 * @param days Quantity of days to be added to the current date
	 * @return Updated date
	 */
	public static Date obtainDateWithDifferenceOfDays(int days) {
		return addDays(new Date(), days);
	}
	
	/**
	 * Obtains a date based on the day, month and year passed as parameters.
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static Date obtainDate(int day, int month, int year){
		Calendar calendar = Calendar.getInstance();
		calendar.set(DAY_OF_MONTH, day);
		calendar.set(MONTH, month - 1);
		calendar.set(YEAR, year);
		return calendar.getTime();
	}
	
	/**
	 * Verify if two dates are the same, considering only day, month and year.
	 * 	This method ignores the time part of the date.
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDate(Date date1, Date date2) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		return (calendar1.get(DAY_OF_MONTH) == calendar2.get(DAY_OF_MONTH))
				&& (calendar1.get(MONTH) == calendar2.get(MONTH))
				&& (calendar1.get(YEAR) == calendar2.get(YEAR));
	}
	
	/**
	 * Verifies if the given date is a specific day of the week.
	 * 
	 * @param date Date to be verified
	 * @param weekDay <code>true</code> if the date is a specific day of the week, <code>false</code> otherwise.
	 * @return
	 */
	public static boolean verifyWeekDay(Date date, int weekDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(DAY_OF_WEEK) == weekDay;
	}
}
