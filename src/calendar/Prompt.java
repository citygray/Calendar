package calendar;

import java.util.Scanner;

public class Prompt {
	private final static String YEAR_PROMP = "year> ";
	private final static String MONTH_PROMP = "month> ";
	private final static String WEEK_DAY = "weekday> ";
	
	/**
	 * 
	 * @param week 요일명
	 * @return -1 = 잘못된 입력, 0~6 = SU~SA
	 */
	
	private int parseDay(String week) {
		String[] weeks = {"SU", "MO", "TU","WE", "TH", "FR", "SA"};
		for (int i = 0; i < weeks.length; i++) {
			if(week.equals(weeks[i])) {
				return i;
			}
		}
		return -1;
	}


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
			if (year==-1) {break;}

			System.out.println("월을 입력하세요.");
			System.out.print(MONTH_PROMP);
			month = scanner.nextInt();
			
			System.out.println("첫번째 요일을 입력하세요. (SU MO TU WE TH FR SA)");
			System.out.print(WEEK_DAY);
			String week = scanner.next();
			weekDay = parseDay(week);
			if(weekDay==-1) {
				System.out.println("SU MO TU WE TH FR SA 중 입력해주세요");
				System.out.print(WEEK_DAY);
				
				weekDay = parseDay(scanner.next());
			}

			if (month > 12 || month<1) {
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
