package calendar;

import java.util.Scanner;

public class Calendar {
	private final int[] maxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int[] leapMaxDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public boolean isLeapYear(int year) {
		if ( (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ) {
			return true;
		}else {
			return false;
		}
	}

	public int getMaxDaysofMonth(int year,int month) {
		if(isLeapYear(year)) {
			return leapMaxDays[month - 1];
		}else {
			return maxDays[month - 1];
		}
	}

	public static void printSampleCalendar() {
		System.out.println(" 일 월 화 수 목 금 토");
		System.out.println("------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}
	
	public static void printCalendar(int year,int month) {
		Calendar calendar = new Calendar();
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		int maxDay = calendar.getMaxDaysofMonth(year,month);
		for (int i = 1; i < maxDay+1; i++) {
			System.out.printf("%3d",i);
			if(i%7==0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		//가상의 달력 찍기
		/* 요구사항 
		 * 윤년을 적용한다.
		 */
		String yearPromp = "year> ";
		String monthPromp = "month> ";
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("년을 입력하세요.");
			System.out.print(yearPromp);
			int year = scanner.nextInt();
			
			System.out.println("월을 입력하세요.");
			System.out.print(monthPromp);
			int month = scanner.nextInt();
			
			if (month == -1 ) {
				break;
			}
			if (month > 12) {
				continue;
			}
			printCalendar(year,month);

		}
		System.out.println("Bye~");
		scanner.close();
	}

}
