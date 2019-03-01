package com.madlabs.rev.java8.quiz;

import java.util.function.Function;
import java.util.stream.IntStream;

public class ParallelQuiz {

	public static void main(String[] args) {
		System.out.println(1_00_000);
		System.out.println(System.getProperty(
				"Runtime.getRuntime().availableProcessors() :" + Runtime.getRuntime().availableProcessors()));

		System.out.println(IntStream.range(0, 10).parallel().reduce(0, Integer::sum));

	}

	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
			System.out.println("Result: " + sum);
			if (duration < fastest)
				fastest = duration;
		}
		return fastest;
	}

}