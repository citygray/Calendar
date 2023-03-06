package calendar;

import java.util.Scanner;

public class Prompt {
	private final static String YEAR_PROMP = "year> ";
	private final static String MONTH_PROMP = "month> ";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar calendar = new Calendar();

		int month = 1;

		while (true) {
			System.out.println("년을 입력하세요.");
			System.out.print(YEAR_PROMP);
			int year = scanner.nextInt();

			System.out.println("월을 입력하세요.");
			System.out.print(MONTH_PROMP);
			month = scanner.nextInt();

			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			calendar.printCalendar(year, month);

		}
		System.out.println("Bye~");
		scanner.close();
	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
