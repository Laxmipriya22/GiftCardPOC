package com.giftcard.commonutility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class GiftCardCommonUtility {

	public static void convertDateToString() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		System.out.println("Date Format with MM/dd/yyyy : " + strDate);

		formatter = new SimpleDateFormat("dd MMMM yyyy");
		strDate = formatter.format(date);
		System.out.println("Date Format with dd MMMM yyyy : " + strDate);

		formatter = new SimpleDateFormat("dd MMMM yyyy zzzz");
		strDate = formatter.format(date);
		System.out.println("Date Format with dd MMMM yyyy zzzz : " + strDate);
	}

	public static void convertDateToDate(String dateStr) throws ParseException {

		DateFormat srcDf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = srcDf.parse(dateStr);
		DateFormat destDf = new SimpleDateFormat("MM-dd-yyyy");
		dateStr = destDf.format(date);
		System.out.println("Converted date is : " + dateStr);
	}

	public static void convertDateToTimeInMilliseconds() {
		Date date = new Date();
		System.out.println("Date is : " + date);
		System.out.println("Milliseconds since " + date + +date.getTime());
	}

	public static void roundOffValue(double a) {
		double roundOff = Math.round(a * 100) / 100.00;
		System.out.println(roundOff);
	}

	public static void diffBetweenTwoDates(String startDate, String stopDate) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = format.parse(startDate);
			d2 = format.parse(stopDate);
			long diff = d2.getTime() - d1.getTime();
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchGivenStringFromTheList(String value) {
		List<String> arr = new ArrayList<String>();
		arr.add("Raj Kumar");
		arr.add("Sai Kumar");
		arr.add("Rohit Sharma");
		arr.add("Rahul Kapoor");
		/*
		 * boolean ans = arr.contains(value); if (ans)
		 * System.out.println("The list contains "+value); else
		 * System.out.println("The list does not contains "+value);
		 */
		List<String> matches = arr.stream().filter(it -> it.contains(value)).collect(Collectors.toList());

		System.out.println("Matched List : " + matches);
	}

	public static void getCurrencybasedOnCountry() {
		/*
		 * Currency c1 = Currency.getInstance("USD");
		 * System.out.println(c1.getSymbol());
		 */
		Currency c1 = Currency.getInstance("AUD"); // Australian Dollar
		Currency c2 = Currency.getInstance("JPY"); // Japan Yen
		Currency c3 = Currency.getInstance("USD");

		// Use of getCurrencyCode() method
		String cCode1 = c1.getCurrencyCode();
		String cCode2 = c2.getCurrencyCode();
		System.out.println("Australian Dollar code : " + cCode1);
		System.out.println("Japan Yen code : " + cCode2);
		System.out.println("");

		// Use of getDefaultFractionDigits() method
		int D1 = c1.getDefaultFractionDigits();
		System.out.println("AUD Fraction digits : " + D1);

		int D2 = c2.getDefaultFractionDigits();
		System.out.println("JPY fraction digits : " + D2);
		System.out.println("");

		// Use of getDisplayName() method
		System.out.println("AUD Display : " + c1.getDisplayName());
		System.out.println("JPY Display : " + c2.getSymbol());
		System.out.println("");

		// Use of getSymbol() method
		System.out.println("JPY Symbol : " + c2.getSymbol());
		System.out.println("USD Symbol : " + c3.getSymbol());

	}

	public static void appendCurrency(String country) {
		Map<Currency, Locale> map = getCurrencyLocaleMap();
		/*
		 * String [] countries = { "US", "CA", "MX", "GB", "DE", "PL", "JP", "CN" }; for
		 * (String countryCode : countries) {
		 */
		Locale locale = new Locale("EN", country);
		Currency currency = Currency.getInstance(locale);
		String symbol = currency.getSymbol(map.get(currency));
		System.out.println("For country " + country + "currency symbol is " + symbol);
		// }
	}

	public static Map<Currency, Locale> getCurrencyLocaleMap() {
		Map<Currency, Locale> map = new HashMap<>();
		for (Locale locale : Locale.getAvailableLocales()) {
			try {
				Currency currency = Currency.getInstance(locale);
				map.put(currency, locale);
			} catch (Exception e) {
				// skip strange locale
			}
		}
		return map;
	}

	public static boolean isEmpty(Collection<?> collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Map<?, ?> map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Object[] array) {
		if (array == null || array.length == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String string) {
		if (string == null || string.trim().length() == 0) {
			return true;
		}
		return false;
	}

	static int first(int arr[], int low, int high, int x, int n) {
		if (high >= low) {
			/* (low + high)/2; */
			int mid = low + (high - low) / 2;

			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
				return mid;
			if (x > arr[mid])
				return first(arr, (mid + 1), high, x, n);
			return first(arr, low, (mid - 1), x, n);
		}
		return -1;
	}

	// Sort A1[0..m-1] according to the order
	// defined by A2[0..n-1].

	static void sortAccording(int A1[], int A2[], int m, int n) {
		// The temp array is used to store a copy of A1[] and visited[] is used to mark
		// the
		// visited elements in temp[].
		int temp[] = new int[m], visited[] = new int[m];
		for (int i = 0; i < m; i++) {
			temp[i] = A1[i];
			visited[i] = 0;
		}

		// Sort elements in temp
		Arrays.sort(temp);

		// for index of output which is sorted A1[]
		int ind = 0;

		// Consider all elements of A2[], find them
		// in temp[] and copy to A1[] in order.
		for (int i = 0; i < n; i++) {
			// Find index of the first occurrence
			// of A2[i] in temp
			int f = first(temp, 0, m - 1, A2[i], m);

			// If not present, no need to proceed
			if (f == -1)
				continue;

			// Copy all occurrences of A2[i] to A1[]
			for (int j = f; (j < m && temp[j] == A2[i]); j++) {
				A1[ind++] = temp[j];
				visited[j] = 1;
			}
		}

		// Now copy all items of temp[] which are
		// not present in A2[]
		for (int i = 0; i < m; i++)
			if (visited[i] == 0)
				A1[ind++] = temp[i];
	}

	// Utility function to print an array
	static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	/*public static void main(String args[]) throws ParseException {
		convertDateToString();
		convertDateToDate("02/04/1949");
		convertDateToTimeInMilliseconds();
		roundOffValue(123.13698);
		diffBetweenTwoDates("22/11/1995 19:45:00", "05/08/2019 11:26:00");
		searchGivenStringFromTheList("Kumar"); // getCurrencybasedOnCountry();
		appendCurrency("GB");
		int A1[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
		int A2[] = { 2, 1, 8, 3 };
		int m = A1.length;
		int n = A2.length;
		System.out.println("Sorted array is ");
		sortAccording(A1, A2, m, n);
		printArray(A1, m);
	}
*/
}