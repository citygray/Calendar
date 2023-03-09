package calendar;

import java.util.Scanner;

public class Prompt {
	private final static String YEAR_PROMP = "year> ";
	private final static String MONTH_PROMP = "month> ";

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");

	}

	/**
	 * 1. Switch case - String 2. PlanItem class 적용
	 */

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar calendar = new Calendar();
		printMenu();

		// Unreachable Code 처리
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			switch (cmd) {
			case "1":
				cmdRegister(scanner, calendar);
				break;
			case "2":
				cmdSearch(scanner, calendar);
				break;
			case "3":
				cmdCal(scanner, calendar);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}
		}
		System.out.println("Bye~");
		scanner.close();
	}

	private void cmdCal(Scanner scanner, Calendar calendar) {
		int month = 1;
		int year = 0;
		int weekDay = 0;

		System.out.println("년을 입력하세요.");
		System.out.print(YEAR_PROMP);
		year = scanner.nextInt();

		System.out.println("월을 입력하세요.");
		System.out.print(MONTH_PROMP);
		month = scanner.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		}

		// getStartWeekDay
		weekDay = calendar.getStartWeekDay(year, month);

		calendar.printCalendar(year, month, weekDay);
	}

	private void cmdSearch(Scanner scanner, Calendar calendar) {
		System.out.println("[일정 조회]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = scanner.next();
		PlanItem plan;
		plan = calendar.searchPlan(date);
		if (plan != null) {
			System.out.println(plan.detail);
		} else {
			System.out.println("일정이 없습니다.");
		}

	}

	private void cmdRegister(Scanner scanner, Calendar calendar) {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = scanner.next();
		String text = "";
		scanner.nextLine(); // ignore one newline
		System.out.println("일정을 입력해 주세요.");
		text = scanner.nextLine();

		calendar.registerPlan(date, text);

	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

		// test
//		Calendar cal = new Calendar();
//		cal.registerPlan("2023-03-12","일정등록 테스트");
//		System.out.println(cal.searchPlan("2023-03-12").equals("일정등록 테스트"));
	}

}
