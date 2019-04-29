package com.madlabs.rev.java8.func;

public class Apple {

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
