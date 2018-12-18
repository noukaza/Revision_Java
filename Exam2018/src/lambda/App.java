package lambda;

import java.util.function.Predicate;

public class App {
	
	public static void main(String[] args) {
		
		I1 i1= a->a.g(5, 7);
		I1 ii1 = Abs::fi1;
		
		I3 i3 = a->a.g(5, 7);
		I3 ii3 = Abs ::fi1;
		
		I5 i5 = (a,b)->a+b;
		I5 ii5 = Abs::fff1;
		
		I6 i6 = (a,s)->a.h(s);
	
		I6 ii6= Abs::fff2;
		
		I7 i7 = a->true;
		I7 ii7 = Abs::test;
		
	}

	
	interface I1 
	{
		int f1(Abs a);
	}
	
	interface I3 extends I1
	{
		default String f3(Abs t)
		{
			return "";
		}
	}
	
	interface I5 
	{
		default void f51(int x) {
			
		}
		
		int f52(int x, int y);
		
	}
	
	interface I6
	{
		String f6(Abs t, String s);
	}
	
  interface I7 extends Predicate<Abs>
  {
	  
  }
}
