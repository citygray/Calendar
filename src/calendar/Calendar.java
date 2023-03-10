package calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {
	private final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final String SAVE_FILE = "calendar.dat";
	
	private HashMap<Date, PlanItem> planMap;

	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
		File f = new File(SAVE_FILE);
		if(!f.exists()) return;
		
		
		try {
			//FileInputStream myObj = new FileInputStream("filename.txt");
			Scanner fr = new Scanner(f);
			while (fr.hasNext()) {
				String line = fr.nextLine();
				String[] words = line.split(",");
				String date = words[0];
				String detail = words[1].replace("\"", "");
				PlanItem p = new PlanItem(date,detail);
				planMap.put(p.getDate(), p);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 
	 * @param date ex:"2017-06-20"
	 * @param plan
	 */
	public void registerPlan(String sDate, String plan) {
		PlanItem p = new PlanItem(sDate, plan);
		planMap.put(p.getDate(), p);
		
		File f = new File(SAVE_FILE);
		String data = p.getStringPlan();
		try {
			FileWriter fw = new FileWriter(f,true);
			fw.write(data);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public PlanItem searchPlan(String sDate) {
		return planMap.get(PlanItem.getDateformString(sDate));
	}

	public boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysofMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}

	public int getStartWeekDay(int year, int month) {

		final int SYEAR = 1583;
		final int STANDARD_WEEKDAY = 6; // 1583/Jan/1st = Saturday
		int sumLeapYear = 0;
		int sumCommYear = 0;

		for (int i = SYEAR; i < year; i++) {
			if (isLeapYear(i)) {
				sumLeapYear++;
			} else {
				sumCommYear++;
			}
		}

		int thisYearStartWeekDay = (STANDARD_WEEKDAY + ((sumCommYear * 1 + sumLeapYear * 2) % 7)) % 7;
		int thisMonthStartWeekDay = thisYearStartWeekDay;
		for (int i = 1; i < month; i++) {
			thisMonthStartWeekDay += getMaxDaysofMonth(year, i);
		}
		thisMonthStartWeekDay = thisMonthStartWeekDay % 7;

		return thisMonthStartWeekDay;
	}

	public void printCalendar(int year, int month, int weekDay) {
		System.out.printf("    <<%4d년%3d월>>%n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		int maxDay = getMaxDaysofMonth(year, month);
		for (int i = 1; i < maxDay + 1 + weekDay; i++) {
			if (i - weekDay < 1) {
				System.out.print("   ");
			} else {
				System.out.printf("%3d", i - weekDay);
			}

			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("----------------------");
	}

}
