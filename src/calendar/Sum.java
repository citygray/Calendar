package calendar;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		//입력: 키보드로 두수의 입력을 받는다
		//출력: 화면에 두 수의 합을 출력한다.
		System.out.println("합을 구할 첫번째 수를 입력하세요");
		Scanner scanner = new Scanner(System.in);
		int firstNum = scanner.nextInt();
		System.out.println("합을 구할 두번째 수를 입력하세요");
		int secondNum = scanner.nextInt();
		
		//System.out.println(firstNum+"+"+secondNum+"="+(firstNum+secondNum));
		System.out.printf("%d + %d = %d",firstNum,secondNum,firstNum+secondNum);
		
		scanner.close(); //Resource leak
	}

}
