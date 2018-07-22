package random.programs.postmsft;

import java.time.LocalDate;

public class DateComparison {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now().withDayOfMonth(26).withYear(2018).withMonth(1);// 01-26-2018
		System.out.println(compareDate(ld, ld.withMonth(2).withDayOfMonth(26)));// 02-26-2018
		System.out.println(compareDate(ld, ld.withMonth(2).withDayOfMonth(22)));// 02-22-2018
		System.out.println(compareDate(ld, ld.withMonth(2).withDayOfMonth(27)));// 02-27-2018
		System.out.println(compareDate(ld, ld.withMonth(1).withDayOfMonth(28)));// 01-28-2018
		System.out.println(compareDate(ld, ld.withYear(2017).withMonth(12).withDayOfMonth(26)));// 12-26-2017
		System.out.println(compareDate(ld, ld.withYear(2017).withMonth(2).withDayOfMonth(26)));// 02-26-2017
		System.out.println(compareDate(ld, ld.withYear(2017).withMonth(1).withDayOfMonth(26)));// 01-26-2017
		System.out.println(compareDate(ld, ld.withYear(2017).withMonth(2).withDayOfMonth(26)));// 01-26-2017
		System.out.println(compareDate(ld, ld.withYear(2017).withMonth(12).withDayOfMonth(29)));// 01-29-2017
	}

	private static int compareDate(LocalDate d1, LocalDate d2) {
		int c = d2.compareTo(d1);
		if (c < 0)
			return compareDate(d2, d1);
		if (d2.getYear() - d1.getYear() <= 1 && (d2.getMonth().getValue() - d1.getMonth().getValue() % 12 == 1))
			return Integer.compare(d2.getDayOfMonth(), d1.getDayOfMonth());
		else if (d2.getYear() - d1.getYear() == 0 && d2.getMonth().equals(d1.getMonth()))
			return -1;
		else
			return 1;
	}
}
