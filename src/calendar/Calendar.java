package calendar;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		System.out.println(" 일 월 화 수 목 금 토");
		System.out.println("------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		
		//숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		System.out.println("월을 입력하시요");
		int month,maxDay;
		
		Scanner scanner = new Scanner(System.in);
		month = scanner.nextInt();
		scanner.close();
		
		switch (month) {
		case 2:
			maxDay = 28;
			break;
		case 4:case 6:case 9:case 11:
			maxDay = 30;
			break;
		default:
			maxDay = 31;
			break;
		}
		
		System.out.printf("%d달의 최대일수는 %d입니다",month,maxDay);
		
	}

}
