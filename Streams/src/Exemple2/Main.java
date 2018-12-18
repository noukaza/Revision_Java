package Exemple2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {


		Trader raoul = new Trader("Raoul", "Cambridge");

		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);


		List<Transaction> l1 = transactions.stream().filter(t->t.getYear()==2011)
					.sorted(Comparator.comparing(Transaction::getValue))
					.collect(Collectors.toList());
		
		System.out.println(l1);
		
		transactions.stream().map(t->t.getTrader().getCity())
		 					.distinct()
							.forEach(c->System.out.println(c));
		
		transactions.stream().map(t->t.getTrader())
							 .filter(tr->tr.getCity()=="Cambridge")
							 .distinct()
							 .sorted(Comparator.comparing(Trader::getName))
							 .forEach(c->System.out.println(c));
		
		String names = transactions.stream()
									.map(t-> t.getTrader().getName())
									.distinct()
									.sorted()
									.reduce("",(n1,n2)->n1+n2);
		
		System.out.println(names);
		
		boolean milanBased = transactions.stream()
										 .anyMatch(t->t.getTrader().getCity().equals("Milan"));
		System.out.println(milanBased);
		
		transactions.stream().filter(t->t.getTrader().getCity()
							.equals("Cambridge"))
							.map(t->t.getValue())
							.forEach(t->System.out.println(t));
												
		transactions.stream().filter(t->t.getTrader().getCity()
				.equals("Cambridge"))
				.map(Transaction::getValue)
				.forEach(System.out::println);
		
		Optional<Integer> i =transactions.stream().map(Transaction::getValue)
							.reduce(Integer::max);
		System.out.println(i.get());
		
		Optional<Transaction> smallTrans 
								= transactions.stream()
								.reduce((t1,t2)->t1.getValue()<t2.getValue()?t1:t2);
		
		System.out.println(smallTrans.get().getValue());
		
		
	}

}
