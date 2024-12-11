package com.madlabs.rev.java8.quiz;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserSubscriber {

	public static void main(String[] args) {

		List<User> userList = List.of(new User(1, List.of(1, 2, 3, 0)), new User(2, List.of(1, 3, 6, 0)),
				new User(3, List.of(1, 5, 0)), new User(4, List.of(4, 0)), new User(5, List.of(1, 2, 3, 0)));
		getFamousUser(userList);

		Map<Integer, Long> map = userList.stream().map(user -> user.getSubscriptions()).flatMap(List::stream)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(map);
		System.out.println(Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey());
	}

	public static int getFamousUser(List<User> userList) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (User user : userList) {
			user.getSubscriptions().forEach(userId -> {
				int count = countMap.getOrDefault(userId, 0);
				countMap.put(userId, count + 1);
			});
		}
		int famUserId = 0;
		int maxCount = 0;
		System.out.println(countMap);
		for (Integer userId : countMap.keySet()) {
			if (countMap.get(userId) > maxCount) {
				famUserId = userId;
				maxCount = countMap.get(userId);
			}
		}
		System.out.println("fam user id " + famUserId);
		return 0;
	}
}

class User {
	private Integer userId;
	private List<Integer> subscriptions;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Integer> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Integer> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public User(Integer userId, List<Integer> subscriptions) {
		super();
		this.userId = userId;
		this.subscriptions = subscriptions;
	}

}