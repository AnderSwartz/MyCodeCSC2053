import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

// @author Ander Swartz

public class CollectionChallengesStarterCode {

	public static void removeRange(ArrayList<Integer> list, int min, int max) {
		Iterator<Integer> iter = list.listIterator();
		while(iter.hasNext()) {
			int holder = iter.next();
			if(holder<=max&&holder>=min)
				iter.remove();
		}
	}

	public static void addStars(ArrayList<String> vec) {
		ListIterator<String> iter = vec.listIterator();
		while(iter.hasNext()){
			iter.add("*");
			iter.next();
		}
		iter.add("*");
	}

	public static int wordCountInTree(List<String> words) {       
		TreeSet<String> treeset = new TreeSet<>();
		treeset.addAll(words);
		return treeset.size();
	}


	public static Map<String, String> topping1(Map<String, String> map) {
		if(map.containsKey("ice cream"))
			map.replace("ice cream", "cherry");
		map.put("bread", "butter");
		return map;
	}


	public static Map<String, Integer> wordCount(String[] strings) {
		HashMap<String, Integer> counter = new HashMap<>();
		for(String str: strings) {
			int count=0;
			if(str.equals(str)) {
				count++;
			}
			counter.put(str,count);	 
		}
		return counter; 
	}			

	public static void main(String[] args) {

		/*removeRange test*/
		Integer[] removeRange = {7, 9, 4, 2, 7, 7, 5, 3, 5, 1, 7, 8, 6, 7};
		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(removeRange));			
		removeRange(list, 5, 7);
		//expected output [9, 4, 2, 3, 1, 8]
		System.out.println("removeRange expected "+"[9, 4, 2, 3, 1, 8]");
		System.out.println("removeRange actual   "+list);
		System.out.println();

		/*addStars test */
		//check ["*", "the", "*", "quick", "*", "brown", "*", "fox", "*"]
		String [] addStar = {"the", "quick", "brown", "fox"};
		ArrayList<String> sList = new ArrayList<>();
		sList.addAll(Arrays.asList(addStar));
		addStars(sList);
		System.out.println("addStars expected "+"[*, the, *, quick, *, brown, *, fox, *]");
		System.out.println("addStars actual   "+sList);
		System.out.println();


		/*wordCountInTrees test 
		 * should print 4*/
		System.out.println("wordCountInTrees expected "+ 4);
		ArrayList<String> list1 = new ArrayList<>();
		list1.addAll(Arrays.asList(addStar));
		list1.add("brown");
		System.out.println("wordCountInTrees actual   "+wordCountInTree(list1));
		System.out.println();

		/*
		 * test topping1 should print
		 * topping1({"ice cream": "peanuts"})  {"bread": "butter", "ice cream": "cherry"}
		 */
		Map<String, String> food = new HashMap<String, String>();
		food.put("ice cream", "peanuts");
		Map<String, String> m = topping1(food);
		System.out.println("topping1 expected "+ "{bread=butter, ice cream=cherry}");
		System.out.println("topping1 actual   "+m);
		System.out.println();

		/*wordCount should print
		 *  {"a": 2, "b": 2, "c": 1}
		 */
		String[] s = {"a", "b", "a", "c", "b"};
		Map<String, Integer> ret = wordCount(s);
		System.out.println("wordCount expected "+"{a=2, b=2, c=1}");
		System.out.println("wordCount actual   "+ret);
		System.out.println();	
	}
}
