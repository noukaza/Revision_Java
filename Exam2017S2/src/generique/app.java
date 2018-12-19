package generique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class app {


	// Examen Deuxième Session  28/06/2017

	//une méthode qui prend en argument deux listes l1, l2 d'objets Comparable entre eux et
	//qui remplace chaque élément l1 par l'élément à la même position en l2, si ce dernier est
	//plus grand (on suppose que les deux listes aient la même taille) ;

	public <T extends Comparable<T> > void question1(List<? super T > listdst ,List<? extends T> listsrc)
	{
		for(int i=0;i<listdst.size();i++)
		{
			listdst.set(i, listsrc.get(i));
		}
		
		
	}


	

	//une méthode qui prend en argument une liste l de Supplier et qui renvoie la liste qui
	//contient, pour chaque element s de l, les trois premiers éléments produits par s ;

	public <T> List<T> question2(List<Supplier<? extends T>> l)
	{

		List<T> newlist = new ArrayList<T>();
		for (Supplier<? extends T> s: l)
		{
			newlist.add(s.get());
			newlist.add(s.get());
			newlist.add(s.get());
		}
		return newlist;

	}

	//une méthode qui prend en argument une liste de listes l, et un élément e. On dit qu'un liste
	//est "bonne" si elle contient e. La méthode doit renvoyer l'ensemble de tous les éléments
	//qui appartiennent à au moins une bonne liste de l.

	public <T> List<T> question3(List<? extends List<? extends T>> l,  T e)
	{
		List<T> newlist = new ArrayList<>();

		for( List<? extends T> ll : l) {

			if(ll.contains(e))
				newlist.addAll(ll);
		}

		return newlist;
	}


	//Examen Première Session   14/12/2016

	// une méthode qui prend en entrée deux Supplier d'objets Comparable et qui renvoie le
	//plus petits élément produit par les deux suppliers ;

	public <T  extends Comparable<T>> T MinSupplier(Supplier<? extends T> sup1,Supplier<? extends T> sup2)
	{
		T element1 = sup1.get();
		T element2 = sup1.get();
		if(element1.compareTo(element2)>0)
			return sup2.get();
		else 
			return sup1.get();
	}

	//une méthode qui prend en entrée une List ls et un Comparator et qui renvoie une List
	//qui contient les trois plus petits éléments de ls ;

	public static  <T extends Comparable<T>> List<T> petitElm(List<? extends T> ls,Comparator<T> cmp)
	{
		List<T> newlist = new ArrayList<T>();
		ls.sort(ls,cmp);
		newlist.add(ls.get(0));
		newlist.add(ls.get(1));
		newlist.add(ls.get(2));

		return newlist;
	}


	//une méthode qui prend en entrée une Collection c de List et qui renvoie une List qui
	//contient tous les éléments qui apparaissent dans toutes les listes de c ;

	public static <T> List<T> includeLists(Collection<List<? extends T>> c)
	{
		List<T> ll = new ArrayList<>();

		for (List<? extends T> l : c)
		{
			ll.addAll(l);
		}

		return ll;

	}



	//Examen Première Session   20/12/2017

	// une methode qui prend en entréé deux List et un comarator et qui renvoie une list qui contient les elements
	// des deux listes triés en ordre croissant
	public static <T extends Comparable<T> > List<T> ListTrie(List<? extends T> l1,List< ?  extends T> l2, Comparator<T> cmp)
	{
		List<T> ll = new ArrayList<>();

		ll.addAll(l1);
		ll.addAll(l2);

		ll.sort(cmp); 

		return ll;


	}


	//une méthode qui prend en entrée une list l de Map, et un object k, et qui renvoie une List qui contient tous les élements
	// qui sont associés à k par une des maps de la list l.

	public static <K,T> List<T> AssocieMap(List<? extends Map< K,T>> listOfMap, K k)
	{
		List<T> ll = new ArrayList<>();
		for(Map<K,T> mymap :listOfMap )
		{
			if(mymap.containsKey(k)) ll.add(mymap.get(k));
		}
		return ll;
	}



	// une méthode qui prend en entrée un BiPredicate p d'objets Comparable et qui renvoie le BiPredicate qui test 
	// si p est vrai et si le premier argument est plus petit que le deuxieme

	public static <T extends Comparable<T>>  BiPredicate<T,T> TestPredicate(BiPredicate<T,T> p)
	{
		return p.and((a,b)->{ if(a.compareTo(b)>0)

			return false;
		else
			return true;
		});
	}

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1,2,5);
		List<Integer> l2 = Arrays.asList(9,8,0);
		
		List<Integer> ll = ListTrie(l1,l2,Integer::compareTo);
		
		System.out.println(ll);
		
		ArrayList<B> ll1 = new ArrayList<>();
		ArrayList<B> ll2 = new ArrayList<>();
		
		List<B> lll = ListTrie(ll1,ll2,null);
		
		System.out.println(lll);
	
		
	}


}
