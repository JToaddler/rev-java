package com.madlabs.rev.java8.func;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Functions {

	public static void main(String... args) {

		IntStream.range(0, 5).map(index -> Integer.valueOf(index)).forEach(System.out::println);
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

		IntStream.range(0, 6).mapToObj(appleFunc::apply).sorted(Comparator.comparing(Apple::getIndex));

	}

}

class Apple {

	private Integer index;
	private String color;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	private Double weight;

	public Apple(Integer id) {
		this.index = id;
	}

	public Apple() {
		this.index = 0;
	}

	public Apple(int index, String color) {
		this.index = index;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Apple [index=" + index + ", color=" + color + ", weight=" + weight + "]";
	}

	public Apple(Integer index, String color, Double weight) {
		this.index = index;
		this.color = color;
		this.weight = weight;
	}
}

@FunctionalInterface
interface AppleFunction<T, U, W, R> {

	public R apply(T t, U u, W w);

}