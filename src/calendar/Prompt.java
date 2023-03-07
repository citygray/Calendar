package calendar;

import java.util.Scanner;

public class Prompt {
	private final static String YEAR_PROMP = "year> ";
	private final static String MONTH_PROMP = "month> ";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar calendar = new Calendar();

		int month = 1;
		int year = 0;
		int weekDay = 0;

		while (true) {
			System.out.println("년을 입력하세요.(exit:-1)");
			System.out.print(YEAR_PROMP);
			year = scanner.nextInt();
			if (year == -1) {
				break;
			}

			System.out.println("월을 입력하세요.");
			System.out.print(MONTH_PROMP);
			month = scanner.nextInt();

			// getStartWeekDay
			weekDay = calendar.getStartWeekDay(year, month);

			if (month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			calendar.printCalendar(year, month, weekDay);

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
