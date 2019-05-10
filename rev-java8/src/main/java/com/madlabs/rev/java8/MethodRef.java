package com.madlabs.rev.java8;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import com.madlabs.rev.java8.func.Apple;

public class MethodRef {

	public static void main(String... args) {

		Function<String, String> intConverter = (var) -> {
			return var.toUpperCase(); 
		};

		System.out.println(intConverter.apply("100"));

		BiFunction<Integer, String, Apple> appleCreator = Apple::new;
		
		intConverter.andThen(intConverter).andThen(intConverter).compose(intConverter);

		System.out.println(appleCreator.apply(10, "Green"));

		Predicate<Apple> isRedApple = (Apple apple) -> {
			return "red".equals(apple);
		};
		
		
	}

}
