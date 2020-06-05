package com.tss.sample.snippet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommonUtils {
	public static <T> List<T> safeList(List<T> list) {
		return list == null ? Collections.emptyList() : list;
	}

	public static <K, V> Map<K, V> safeMap(Map<K, V> map) {
		return map == null ? Collections.emptyMap() : map;
	}

	public static <T> List<T> removeNullsAndDuplicates(List<T> input) {

		return safeList(input).stream().filter(Objects::nonNull).distinct().collect(Collectors.toList());

	}

	public static List<Integer> getIntegerListFromString(String commaSepratedVal) {
		List<Integer> valueList = new ArrayList<>();
		if (commaSepratedVal != null) {
			List<String> valueString = Arrays.asList(commaSepratedVal.split("\\s*,\\s*"));
			for (String val : valueString) {
				Integer value = getInt(val);
				valueList.add(value);
			}
			return valueList;
		}
		return valueList;
	}

	public static Long getLong(String input) {
		if (input != null) {
			try {
				return Long.parseLong(input.trim());
			} catch (NumberFormatException e) {
				System.err.println("Exception occured while getting Long from String " + input + ", " + e.getMessage());

			}
		}
		return null;
	}

	public static Integer getInt(String input) {
		if (input != null) {
			try {
				return Integer.parseInt(input.trim());
			} catch (NumberFormatException e) {
				System.err.println(
						"Exception occured while getting Integer from String " + input + ", " + e.getMessage());
			}
		}
		return null;
	}
}
