package lambda;

public abstract class Abs {
	
	public abstract void f (int x);
	public abstract int g (int x,int y);
	public abstract String h(String s);
	
	public static Integer fi1(Abs a)
	{
		return null;
	}
	
	public static Integer fff1(int a,int b)
	{
		return a+b;
	}
	
	public static String fff2(Abs a,String b)
	{
		return a+b;
	}

	public static boolean test(Abs s)
	{
		return true;
	}
}
