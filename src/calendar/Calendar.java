package calendar;

import java.util.Iterator;
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
	
	public static void printCalendar(int month) {
		Calendar calendar = new Calendar();
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		int maxDay = calendar.getMaxDaysofMonth(month);
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
		 * 월을 입력하면 해당월의 달력을 출력한다.
		 * 달력은 모양은 1단계에서 작성한 모양으로 만든다.
		 * 1일은 일요일로 정해도 무방하다
		 * -1을 입력받기 전까지 반복 입력받는다.
		 * 프롬프트를 출력한다
		 */
		
		/*입력 및 출력 예시
		 	월을 입력하세요.
			> 3
			일 월 화 수 목 금 토
			--------------------
			 1  2  3  4  5  6  7
			 8  9 10 11 12 13 14
			15 16 17 18 19 20 21
			22 23 24 25 26 27 28
			29 30 31
			월을 입력하세요.
			> -1
			Bye~
		 */
		String Promp = "cal> ";
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("월을 입력하세요.");
			System.out.print(Promp);
			int month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			printCalendar(month);

		}
		System.out.println("Bye~");
		scanner.close();
	}

}
