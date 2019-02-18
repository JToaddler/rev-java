package com.madlabs.rev.java8.quiz;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.madlabs.rev.java8.modal.Trader;
import com.madlabs.rev.java8.modal.Transaction;

public class TraderQuiz {

	public static void main(String... args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 10009), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// Find all transactions in the year 2011 and sort them by value (small to
		// high).

		List<Transaction> answer1 = transactions.stream().filter(transaction -> {
			return transaction.getYear() == 2011;
		}).sorted(Comparator.comparing(Transaction::getValue)).collect(toList());

		// What are all the unique cities where the traders work?
		transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(toList());

		// Find all traders from Cambridge and sort them by name.

		traders.stream().filter(trader -> {
			return "Cambridge".equals(trader.getCity());
		}).sorted(Comparator.comparing(Trader::getName));

		// Return a string of all traders’ names sorted alphabetically

		transactions.stream().map(txn -> txn.getTrader().getName()).distinct().sorted().reduce(" ", (n1, n2) -> {
			return n1.concat(n2);
		});

		// Are any traders based in Milan?
		boolean isFromMilan = transactions.stream()
				.anyMatch(transaction -> "Milan".equalsIgnoreCase(transaction.getTrader().getName()));

		// Print all transactions’ values from the traders living in Cambridge
		transactions.stream().filter(txn -> {
			return "Cambridge".equals(txn.getTrader().getName());
		}).forEach(System.out::println);

		// What’s the highest value of all the transactions
		System.out.println("What’s the highest value of all the transactions"
				+ transactions.stream().max(Comparator.comparing(Transaction::getValue)).get().getValue());

		// Find the transaction with the smallest value
		System.out.println("Find the transaction with the smallest value"
				+ transactions.stream().min(Comparator.comparing(Transaction::getValue)));
		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
	}
}