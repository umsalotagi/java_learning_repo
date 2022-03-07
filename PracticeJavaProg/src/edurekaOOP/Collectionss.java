package edurekaOOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

import org.omg.Messaging.SyncScopeHelper;


public class Collectionss {
	
	public static void main(String[] args) {
		
		// all elements are stored under one variable name
		int[] x = {2, 3, 4,5 };
		// it occupies continuous memory location
		int[] y = new int[5];
		
		String s[] = new String[4];
		// Array is not part of collection
		
		// multi value container, dynamic container
		// group multiple items in single unit
		
		// iterator : provides facility to iterating element in forward direction
		// iterable is root interface... collection is extended from it
		
		// List -> ArrayList, LinkedList, Vector (vector is similar to ArrayList byt is synchronized , thread safe)
		// all methods are same
		
		ArrayList ok = new ArrayList<>();
		ok.add("Ok");
		ok.add(10);
		ok.add(2.2);
		Exception e = new Exception();
		ok.add(e);
		
		System.out.println(ok);
		
		ArrayList<String> ss = new ArrayList<String>(Arrays.asList("ho" , "lo"));
		
		ss.add("ok");
		System.out.println(ss);
		ss.remove(0);
		System.out.println(ss);
		ss.remove("lo");
		System.out.println(ss);
		System.out.println(ss.indexOf("ho"));
		System.out.println(ss);
		ss.add(1, "kilo");
		System.out.println(ss);
		ss.addAll(0, Arrays.asList("rt", "kt"));
		System.out.println(ss);
		System.out.println(ss.contains("kilo"));
		
		Iterator it = ss.iterator();
		System.out.println(it.next());
		System.out.println(it.next());
		
		Collections.sort(ss);
		System.out.println(ss);
		System.out.println(Collections.max(ss));
		Collections.reverse(ss);
		System.out.println(ss);
		Collections.swap(ss, 0, 1);
		System.out.println(ss);
		
		System.out.println("\n\nLinkedList=========================================\n");
		
		LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(5,12 , 8, 9, 0 , -1)); // empty ArrayList is created with initial capacity of 10
		// linked list does not reserve memory. choose random blocks from heap and use it
		// Singly linked list, doubly link list (address of before and after node), circular link list (singly with head-tail)
		// not synchronized, used as stack / que and Deque interfaces implemented
		ll.add(2, 44);  // add with index, applicable to all types of list, so can also iterate through index also
		System.out.println(ll);
		ll.offer(5);
		ll.offerLast(-1);
		System.out.println(ll.offerFirst(51));
		System.out.println(ll);
		ll.addFirst(33);
		ll.addLast(44);
		System.out.println(ll);
		ll.removeFirst();
		System.out.println(ll.removeLast());
		System.out.println(ll);
		
		// stack - last in first out
		// queue - first in first out
		
		Vector<Integer> vl = new Vector<>(Arrays.asList(5,12 , 8, 9, 0 , -1));
		System.out.println(vl);
		
		Stack<Integer> st = new Stack<>();
		st.add(22);
		
		System.out.println("\n\nQueue=========================================\n");
		// Queue : first in first out approach
		// Priority queue even sorts data for us
		// we can also add comparator to it for sorting
		Queue<String> q = new PriorityQueue<>();
		// default initial capacity of 11
		q.addAll(Arrays.asList("a", "b", "z", "y", "t", "a", "d"));
		System.out.println(q);
		System.out.println(q.contains(6));
		// data in queue is already sorted but it will not display data in sorted form when printed, but poll and pick will work better
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q);
		System.out.println(q.peek());
		q.add("z"); // no adding by index, so no getting by index, so only iterable trough iterator
		
		Integer[] u = {90, 8, -1, 67, 0, 4};
		Queue<Integer> q1 = new PriorityQueue<>(Arrays.asList(u));
		System.out.println(q1);  // here also not properly ordered
		
		
		System.out.println("\n\nSet=========================================\n");
		// set -cannot contain duplicate element
		// we get hashcode for element added
		// HashSet - use hashing element to store elements
		// linkedHashSet
		// TreeSet - unique and stored in ascending order
		Integer [] p = {2, 78, 4, 90, 2, -1, 0, 5, 4, 2};
		ArrayList<Integer> lll = new ArrayList<>(Arrays.asList(p));  // if list was int[] p , this will not work, then we need to use Collectins.addAll ...
		int[] p1 = {4 , 6};
		// Collections.addAll(lll, Arrays.asList(p1))  // not working
		System.out.println(lll);
		// initial capacity of 16 and load factor of 0.6
		HashSet<Integer> hs = new HashSet<>(Arrays.asList(p));  // new HashSet<>(lll);
		
		System.out.println(hs);
		System.out.println(hs.contains(90));
		hs.remove(4);
		hs.add(-11);
		System.out.println(hs);
		//  Collections.sort(hs);   compile error, not applicable for hashSet
		HashSet<Integer> hs1 = hs;
		hs1.remove(5); // this will remove from both hs1 and hs as both are pointing to same collection
		// use clone in such cases
		System.out.println(hs1);
		System.out.println(hs);
		
		LinkedHashSet<Integer> lhs = new LinkedHashSet<>(Arrays.asList(p));
		// here the sequence of array will be retrained. means that elements are ordered by their insertion order
		System.out.println(lhs);
		// all methods are same as HashSet
		
		// similar to queue, all elements are sorted natural order (ascending) in TreeSet with unique values
		// similar to Queue but with unique values only
		TreeSet<Integer> ts = new TreeSet<>(Arrays.asList(p));
		System.out.println(ts);
		System.out.println(ts.ceiling(7) + " " + ts.floor(7) + " " + ts.size() + " " + ts.first() + " " + ts.last() + " " + ts.higher(7) + " "+ts.subSet(5, 90));
		ts.pollFirst();
		ts.pollLast();
		System.out.println(ts);
		Iterator its = ts.iterator();
		System.out.println(its.next());
		System.out.println(its.next());
		
		
		System.out.println("\n\nHashMap=========================================\n");
		// hashing is technique of converting large string to small string that represent same string, so indexing and search is fast and easy
		// it is unsynchronized and permits null key and value
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("One", 1);
		hm.put("One", 2); // updates the value
		hm.put("Three", 3);
		hm.put("Four", 4);
		hm.put(null, null);
		System.out.println(hm + " " + hm.get("Four") + " " + hm.size() + " " +hm.containsKey("One") + hm.containsValue("6"));
		hm.remove("Four");
		hm.remove("Three", 5);
		hm.remove("Siz");
		hm.replace("One", 12);
		hm.replace("Seven", 12);
		System.out.println(hm);
		System.out.println(hm.keySet() + " " + hm.entrySet());
		
		Map<String, Integer> shm = Collections.synchronizedMap(hm);
		
		Hashtable<String, Integer> ht = new Hashtable<>();
		ht.put("One", 1);
		ht.put("One", 2); // updates the value
		ht.put("Three", 3);
		ht.put("Four", 4);
		// ht.put("Six", null); // null pointer exception when trying to add null key OR value OR both 
		System.out.println(ht);
		
		// iterating through Map
		for (String key: ht.keySet()) {
			System.out.println(key + ht.get(key));
		}
		
		Set<Entry<String, Integer>> hte = ht.entrySet();
		for (Entry<String, Integer> entry: hte) {
			System.out.println(entry.getKey() + entry.getValue());
		}
		
		System.out.println("\n\nComparator=========================================\n");
		ArrayList<Student> als = new ArrayList<>(Arrays.asList(new Student("Anna", 790), new Student("Banana", 450), new Student("Cat", 800), new Student("Don", 500), new Student("Eaden", 790)));
		
		
		Comparator<Student> cmpByMarks = new Comparator<Student>() {
			@Override
			// it should return either -1,0 or +1 depending on whether first arguement is small, eual , large than second
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.marks-o2.marks;
			}
		};
		
		Collections.sort(als, cmpByMarks);
		
		als.forEach(n -> System.out.println(n.name + " " + n.marks));
		
		// Comparator and Comparable are interfaces
		Comparator<Student> sortByName = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				String StudentName1 = o1.name.toUpperCase();
			   String StudentName2 = o2.name.toUpperCase();

			   //ascending order
			   return StudentName1.compareTo(StudentName2);

			   //descending order
			   //return StudentName2.compareTo(StudentName1);
			}
		};
		System.out.println("\n\n");
		List<Student> stuL = Arrays.asList(new Student("Cat", 790), new Student("Mat", 450), new Student("Aat", 800), new Student("Bat", 500), new Student("Eat", 790));
		Queue<Student> stuQ = new PriorityQueue<Student>(sortByName);
		stuQ.addAll(stuL);
		stuQ.add(new Student("Dat", 680));
		System.out.println(stuQ.peek().name);
		
		ArrayList<StudentS> als2 = new ArrayList<>(Arrays.asList(new StudentS("Cat", 790), new StudentS("Don", 450), new StudentS("Anna", 800), new StudentS("Eaden", 500), new StudentS("Banana", 790)));
		Collections.sort(als2);
		als2.forEach(n -> System.out.println(n.name + " " + n.marks));
		
		
	}
	
	// inner class can be static
	private static class Student {
		String name;
		int marks;
		Student (String name, int marks) {
			this.name = name;
			this.marks = marks;
		}
	}
	
	private static class StudentS implements Comparable<StudentS> {
		
		String name;
		int marks;
		StudentS (String name, int marks) {
			this.name = name;
			this.marks = marks;
		}
		
		@Override
		public int compareTo(StudentS s) {
			// TODO Auto-generated method stub
			return this.name.compareTo(s.name);
		}
		
	}

}
