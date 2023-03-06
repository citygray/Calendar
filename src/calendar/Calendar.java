package calendar;

import java.util.Scanner;

public class Calendar {
	private final int[] maxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysofMonth(int month) {
		return maxDays[month - 1];
	}

	public static void printSampleCalendar() {
		System.out.println(" 일 월 화 수 목 금 토");
		System.out.println("------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}

	public static void main(String[] args) {
		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		/* 출력예시
		 * 반복횟수를 입력하세요. 3 (엔터)
		 * 
		 * 월을 입력하세요. 1(엔터) 2(엔터) 3(엔터)
		 * 
		 * 1월은 31일까지 있습니다. 2월은 28일까지 있습니다. 3월은 31일까지 있습니다.
		 */
		
		System.out.println("반복횟수를 입력하세요");
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		int[] months = new int[count];

		Calendar calendar = new Calendar();
		
		System.out.printf("월을 %d번 입력하세요%n",count);
		for(var i = 0; i<months.length; i++) {
			months[i] = scanner.nextInt();
			System.out.printf("%d월의 최대일수는 %d입니다.%n", months[i], calendar.getMaxDaysofMonth(months[i]));
		}
		scanner.close();	

	
	}

}
