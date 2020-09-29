package com.defy.stream.sort;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapSorting2 {
	public static void main(String[] arg) {
		Map<Integer, String> randomMap = new LinkedHashMap<>();

		MapSorting2 mapSort = new MapSorting2();
		mapSort.addToMap(randomMap);

	}

	void addToMap(Map<Integer, String> randomMap) {
		randomMap.put(10, "Ten");
		randomMap.put(7, "Seven");
		randomMap.put(2, "Two");
		randomMap.put(4, "Four");
		randomMap.put(1, "One");
		randomMap.put(8, "Eight");
		
		
		randomMap.entrySet().stream().sorted((x, y) ->x.getValue().compareTo(y.getValue())).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(), (a,b)->b, LinkedHashMap::new));
		
		
		

		LinkedHashMap<Integer, String> newMap = randomMap.entrySet().stream()
				.sorted((x, y) -> x.getValue().compareTo(y.getValue()))
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(), (a, b) -> b, LinkedHashMap::new));

		Set<String> resultValues = randomMap.entrySet().stream().sorted((x, y) -> x.getValue().compareTo(y.getValue()))
				.map(x -> x.getValue()).collect(Collectors.toSet());
		resultValues.forEach(System.out::println);
	}
}
