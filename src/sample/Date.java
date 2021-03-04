package sample;

/**
 * Creates a Date object based on specified string or today's date.
 * Checks specified Date to determine whether or not it is valid.
 * @author Bhavika Teli, Eduardo Alba
 */

import java.util.Calendar;
import java.util.StringTokenizer;

public class Date implements Comparable<Date>{
	private int year;
	private int month;
	private int day;

	public static final int QUADRENNIAL = 4;
	public static final int CENTENNIAL = 100;
	public static final int QUATERCENTENNIAL = 400;

	public static final int MIN_YEAR = 1900;
	public static final int MONTH_DIFFERENCE = 1;
	public static final int MAX_MONTH = 11;
	public static final int NON_LEAP_YEAR = 28;
	public static final int LEAP_YEAR = 29;
	public static final int THIRTY_DAY_MONTH = 30;
	public static final int THIRTY_ONE_DAY_MONTH = 31;

	public static final int COMES_BEFORE = -1;
	public static final int COMES_AFTER = 1;
	
	private Calendar cal = Calendar.getInstance();
	
	/**
	 * Method to compare two dates
	 * @param date to compare with
	 * @return  0 if dates are equal, -1 if this.date comes before date paramter, and 1 if this.date comes after date parameter
	 */
	public int compareTo(Date date){
		//dates are equal
		if(this.year == date.year && this.month == date.month && this.day == date.day) return 0;

		if(this.year < date.year){
			return COMES_BEFORE;
		}

		if(this.year == date.year){
			if(this.month < date.month){
				return COMES_BEFORE;
			}
			else if(this.month == date.month){
				if(this.day < date.day){
					return COMES_BEFORE;
				}
			}
		}
		
		return COMES_AFTER;
	}

	/**
	 * Takes string in format mm/dd/yyyy and creates a Date Object
	 * @param date date to format
	 */
	public Date(String date) {
		StringTokenizer st = new StringTokenizer(date, "/");
		
		this.month = Integer.parseInt(st.nextToken());
		this.day = Integer.parseInt(st.nextToken());
		this.year = Integer.parseInt(st.nextToken());
	} 

	/**
	 * Creates an object with today's date
	 */
	public Date() { 
		this.year = cal.get(Calendar.YEAR);
		this.month = cal.get(Calendar.MONTH);
		this.day = cal.get(Calendar.DAY_OF_MONTH);
	} 

	/**
	 * Helper function to convert date into string
	 * @return converted string
	 */
	public String toString(){
		String result = month + "/" + day + "/" + year;
		return result;
	}

	/**
	 * Checks if given date is valid
	 * @return true is date is valid, false otherwise
	 */
	public boolean isValid() {

		int tempMonth = this.month-MONTH_DIFFERENCE;
		
		Date currDate = new Date(); //today's date
		currDate.month += MONTH_DIFFERENCE;

		//if the date is beyond today's date
		if(this.compareTo(currDate) == 1){
			return false;
		}

		if(tempMonth > MAX_MONTH || tempMonth < 0){
			return false;
		}

		if(this.year < MIN_YEAR || this.year > currDate.year){
			return false;
		} 

		//If month has 31 days, check if date is valid
		if(tempMonth == Calendar.JANUARY || tempMonth == Calendar.MARCH 
			|| tempMonth == Calendar.MAY || tempMonth == Calendar.JULY| tempMonth == Calendar.AUGUST 
			|| tempMonth == Calendar.OCTOBER || tempMonth == Calendar.DECEMBER)
		{
			if(this.day > THIRTY_ONE_DAY_MONTH) return false;
		}

		//If month has 30 days, check if date is valid
		if(tempMonth == Calendar.APRIL || tempMonth == Calendar.JUNE || tempMonth == Calendar.SEPTEMBER 
			|| tempMonth== Calendar.NOVEMBER)
		{
			if(this.day > THIRTY_DAY_MONTH) return false;
		}

		//If month is February, check if date is valid
		if(tempMonth == Calendar.FEBRUARY){
			if(this.year % QUADRENNIAL == 0){
				if(this.year % CENTENNIAL == 0){
					if(this.year % QUATERCENTENNIAL == 0){
						if(this.day > LEAP_YEAR) return false;
					}
					else{
						if(this.day > NON_LEAP_YEAR) return false;
					}
				} 
				else{
					if(this.day > LEAP_YEAR) return false;
				}
			} 
			else{
				if(this.day > NON_LEAP_YEAR) return false;
			}
		}

		return true;
	}

}