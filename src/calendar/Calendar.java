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
		/*
		 * 요구사항 
		 * 전 단계와 비슷하게 반복입력을 받을 수 있게 구현한다. 
		 * 입력하는 곳 앞에 프롬프트를 출력한다. 
		 * -1일 입력받을 경우 프로그램을 종료한다.
		 */
		/*
		 * 입력 및 출력 예시 월을 입력하세요. > 3 3월은 31일까지 있습니다. 월을 입력하세요. > 2 2월은 28일까지 있습니다. 월을
		 * 입력하세요. > -1 
		 * Have a nice day!
		 */
		String Promp = "cal> ";
		Calendar calendar = new Calendar();
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
			System.out.printf("%d월의 최대일수는 %d입니다.%n", month, calendar.getMaxDaysofMonth(month));
		}
		System.out.println("Have a nice day!");
		scanner.close();
	}

}
