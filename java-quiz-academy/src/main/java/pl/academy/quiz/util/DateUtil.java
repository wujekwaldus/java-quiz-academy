package pl.academy.quiz.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	private static final SimpleDateFormat FULL_FORMATTER = new SimpleDateFormat("EEEE, yyyy-MM-dd, HH:mm", new Locale("pl", "PL"));

	public static String formatFullDate(Date date) {
		return FULL_FORMATTER.format(date);
	}
}
