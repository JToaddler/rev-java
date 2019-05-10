package com.madlabs.rev.java8.func;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Functions {

	public static void main(String... args) {

		IntStream.range(0, 1).map(index -> Integer.valueOf(index)).forEach(System.out::println);
		System.out.println("====");
		IntStream.range(0, 5).map(Integer::valueOf).forEach(System.out::println);
		Supplier<Apple> intSupplier = Apple::new;
		System.out.println(intSupplier.get());

		Function<Integer, Apple> appleFunc = Apple::new;
		System.out.println(appleFunc.apply(34));

		BiFunction<Integer, String, Apple> appleBiFun = Apple::new;
		appleBiFun.apply(23, "Pale Red");

		AppleFunction<Integer, String, Double, Apple> appleFun2 = Apple::new;
		System.out.println(appleFun2.apply(12, "RED", 6d));

		IntStream.range(0, 6).mapToObj(appleFunc::apply).sorted((Apple one, Apple two) -> {
			return one.getIndex().compareTo(two.getIndex());
		});
		
		System.out.println(IntStream.rangeClosed(0, 10).mapToObj(Apple::new).sorted(Comparator.comparing(Apple::getIndex)).map(Apple::getIndex).collect(Collectors.toList()));
		
		
		System.out.println(IntStream.rangeClosed(0, 10).mapToObj(Apple::new).sorted(Comparator.comparing(Apple::getIndex)).skip(5).distinct());

	}

}

@FunctionalInterface
interface AppleFunction<T, U, W, R> {

	public R apply(T t, U u, W w);

}