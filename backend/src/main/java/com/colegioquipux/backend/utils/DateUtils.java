package com.colegioquipux.backend.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static LocalDateTime dateTime() {
		return LocalDateTime.now();
	}

	public static String formatDate(LocalDateTime date, String patron) {
		return DateTimeFormatter.ofPattern(patron).format(date);
	}

	public static String getDate() {
		return formatDate(dateTime(), "yyyy-MM-dd HH:mm:ss");
	}

	public static String getDate(String patron) {
		return formatDate(dateTime(), patron);
	}

	private DateUtils() {
	}

}
