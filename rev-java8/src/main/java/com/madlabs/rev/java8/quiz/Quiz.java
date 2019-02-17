package com.madlabs.rev.java8.quiz;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class Quiz {

	public static void main(String[] args) {

		// 5.2 - squares of array element
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> squares = numbers.stream().map(n -> n * n).collect(toList());

		System.out.println("Square element :" + squares);

		// 5.4 array a : [1,2,3] array b : [3,4] => [[1,3][1,4][2,3][2,4][3,3][3,4]]

		List<Integer> matrixA = Arrays.asList(1, 2, 3);
		List<Integer> matrixB = Arrays.asList(3, 4);

		List<int[]> result = matrixA.stream().flatMap(i -> matrixB.stream().map(j -> {
			return new int[] { i, j };
		})).collect(toList());

		System.out.println("Flat map : matrix " + result);

		result = matrixA.stream().flatMap(i -> matrixB.stream().filter(j -> {
			return (i + j) % 3 == 0;
		}).map(j -> new int[] { i, j })).collect(toList());

		System.out.println("Flat map divisible by 3: matrix " + result);

	}

}
