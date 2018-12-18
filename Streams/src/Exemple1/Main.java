package Exemple1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {

	public static void main(String[] args) {

		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );

		Comparator<Dish> dishCalories = Comparator.comparingInt(Dish::getCalories);

		Optional<Dish> mostCalorieDish = menu.stream().collect(minBy(dishCalories));
		System.out.println(mostCalorieDish.get().getCalories());


		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

		double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));

		IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));

		System.out.println(menuStatistics.getAverage());

		String shortMenu = menu.stream().map(Dish::getName).collect(joining());
		System.out.println(shortMenu);
		String shortMenu2 = menu.stream().collect(reducing("",Dish::getName,(s1,s2)->s1+s2));
		System.out.println(shortMenu2);

		// Grouping bu=y type

		Map<Dish.Type,List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
		System.out.println(dishesByType);


 
		Map<CaloricLevel,List<Dish>> dishesByCaloricLevels=
				menu.stream().collect(groupingBy(dish->{ 
					if(dish.getCalories()<400) return CaloricLevel.DIET;
					else if(dish.getCalories()<=700) return CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;
				}));

		System.out.println(dishesByCaloricLevels);

		// Multilevel grouping

		Map<Dish.Type,Map<CaloricLevel,List<Dish>>> dishesByTypeCalricLevel=
				menu.stream().collect(groupingBy(Dish::getType,groupingBy(dish->{ 
					if(dish.getCalories()<400) return CaloricLevel.DIET;
					else if(dish.getCalories()<=700) return CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;
				})));
		System.out.println(dishesByTypeCalricLevel);

		// Collecting data in subgroups
		Map<Dish.Type,Long> typesCount = menu.stream().collect(groupingBy(Dish::getType,counting()));
		System.out.println(typesCount);

		Map<Dish.Type,Optional<Dish>> mostCaloricByType =menu.stream().collect(
				groupingBy(Dish::getType,maxBy(Comparator.comparingInt(Dish::getCalories))));
		System.out.println(mostCaloricByType);

	}
	public enum CaloricLevel {DIET,NORMAL,FAT}
}
