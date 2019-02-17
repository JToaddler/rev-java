package com.madlabs.rev.java8.modal;

public class Dish {
	public enum Type {
		FISH, MEAT, OTHER
	}

	private final int calories;
	private final String name;
	private final Type type;
	private final boolean vegetarian;

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public int getCalories() {
		return calories;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + "]";
	}

}
