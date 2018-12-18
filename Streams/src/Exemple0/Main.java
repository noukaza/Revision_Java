package Exemple0;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		IntStream evenNumbers = IntStream.rangeClosed(1,100);
		evenNumbers.forEach(t->System.out.println(t));


		Stream<int[]> pythagoremTriples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a->IntStream.rangeClosed(a, 100)
						.filter(b->Math.sqrt(a*a+b*b)%1==0)
						.mapToObj(b-> new int[]{a,b,(int)Math.sqrt(a*a+b*b)})
						);
		
		Stream<int[]> pythagoremTriples2 = IntStream.rangeClosed(1,100).boxed()
						.flatMap(a->IntStream.rangeClosed(a, 100).
								filter(b->Math.sqrt(a*a+b*b)%1==0)
								.mapToObj(b->new int[] {a,b,(int)Math.sqrt(a*a+b*b)}));
		
		pythagoremTriples.limit(5).forEach(t->System.out.println("( "+t[0]+","+t[1]+","+t[2]+")"));
		
		
		Stream<double[]> pythagoremTriples3 = IntStream.rangeClosed(1,100).boxed()
											.flatMap(a->IntStream.rangeClosed(a, 100)
													.mapToObj(b->new double[] {a,b,Math.sqrt(a*a+b*b)})
													.filter(t->t[2]%1==0));
		
		
		// Streams from values:
		
		Stream<String> stream = Stream.of("Java 8 ","Lambada","In","Action");
		stream.map(String::toUpperCase).forEach(System.out::println);

		// Streams from arrays:
		int[] numbers= {2,3,5,7,11,13};
		int sum = Arrays.stream(numbers).sum();
		
		// Itreate
		
		Stream.iterate(0, n->n+2).limit(10).forEach(System.out::println);
		
		// Fibonacci 
		Stream.iterate(new int[] {0,1}, t->new int[] {t[1],t[0]+t[1]}).limit(20)
		.forEach(t->System.out.println("("+t[0]+","+t[1]+")"));
		
		// Generate 
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
		
	}
		
}
