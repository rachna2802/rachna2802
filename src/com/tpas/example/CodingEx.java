package com.tpas.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodingEx {

	public CodingEx() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		// remove Duplicates

		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
		// remove Duplicates 1
		// List<String>
		// listunique=listOfStrings.stream().distinct().collect(Collectors.toList());
		// listunique.stream().forEach(System.out::println);

		// find Duplicates 2
		Set<String> set = new HashSet<String>();
		Set<String> uniqueList = listOfStrings.stream().filter(x -> !set.add(x)).collect(Collectors.toSet());
		uniqueList.stream().forEach(System.out::println);

		// evennumbers andoodNumbers
		List<Integer> evenNumbers = listOfIntegers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		evenNumbers.stream().forEach(System.out::println);
		List<Integer> oddNumbers = listOfIntegers.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
		System.out.print("oddNumber");
		oddNumbers.stream().forEach(System.out::println);

		// listOfIntegers.stream().collect(Collectors.partitioningBy(x ->x%2==0));

		// frequency of eachcharacter in string
		String inputString = "Java Concept Of The Day";
		Map<Character, Long> frequencyMap = inputString.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		frequencyMap.entrySet().forEach(e -> System.out.print(e.getKey() + " " + e.getValue()));

		// find frequency of each element in an array or a list
		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler",
				"Note Book", "Pencil");
		Map<String, Long> map = stationeryList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.print("frequency of each element in an array or a list\n");
		map.entrySet().forEach(e -> System.out.print(e.getKey() + " " + e.getValue()));

		// merge two unsorted arrays into one
		int[] a = new int[] { 4, 2, 7, 1 };

		int[] b = new int[] { 8, 3, 9, 5 };
		int[] mergedArray = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
		System.out.println("\nmergedArray::" + Arrays.toString(mergedArray));

		// check if two strings are anagrams or not?
		String s1 = "RaceCar";
		String s2 = "CarRace";
		String o1 = s1.chars().mapToObj(c -> (char) c).sorted().toList().stream().map(String::valueOf)
				.collect(Collectors.joining());

		String o2 = s2.chars().mapToObj(c -> (char) c).sorted().toList().stream().map(String::valueOf)
				.collect(Collectors.joining());
		if (o1.equals(o2)) {
			System.out.println("Two strings are anagrams" );
		} else {
			System.out.println("Two strings are not anagrams" );
		}
		
		//sum of all digits of a number in Java 8?
		
		int i = 15623;
		
		//second largest number in an integer array
		List<Integer> listOfInts = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		
		//a list of strings, sort them according to increasing order of their length
		 
	  List<String> lstOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
	  
	  //find common elements between two arrays
		List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        
       List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
       list1.stream().filter(list2::contains).collect(Collectors.toList()).stream().forEach(System.out::print);
       
       //Reverse each word of a string
       String str = "Java Concept Of The Day";
       
       //isPalindrome
       //String str = "ROTATOR";
	}

}
