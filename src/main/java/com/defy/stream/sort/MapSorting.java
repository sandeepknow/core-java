package com.defy.stream.sort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class MapSorting {

//	Map<K, V>.Entry<K, V>put(1, "one");

	public static void main(String[] arg) {
		Map<Integer, String> randomMap = new LinkedHashMap<>();

		MapSorting mapSort = new MapSorting();
		mapSort.addToMap(randomMap);

	}

	void addToMap(Map<Integer, String> randomMap) {
		randomMap.put(10, "Ten");
		randomMap.put(7, "Seven");
		randomMap.put(2, "Two");
		randomMap.put(4, "Four");
		randomMap.put(1, "One");
		randomMap.put(8, "Eight");

		System.out.println("=======Un-sorted Map=========");
		randomMap.entrySet().stream().forEach(x -> printKeyValue(x));
		System.out.println("=======Sorted Map=========");
		
		//Only printing the key, value after sorting the map using key
		randomMap.entrySet().stream().sorted((x, y) -> x.getKey().compareTo(y.getKey())).forEach(x -> printKeyValue(x));
		
		//Here LinkedHashMap is returned after sorting Map based on Key
		LinkedHashMap<Integer, String> linkedMap = randomMap.entrySet().stream()
				.sorted((x, y) -> x.getKey().compareTo(y.getKey()))
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(), (a, b) -> b, LinkedHashMap::new));
		System.out.println(linkedMap);
		List<Map.Entry<Integer, String>> list = randomMap.entrySet().stream()
				.sorted((x, y) -> x.getKey().compareTo(y.getKey())).collect(Collectors.toList());
		System.out.println(list);
	}

	void printKeyValue(Entry<Integer, String> entry) {
		System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
	}
}
