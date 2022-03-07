package com.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreeCanCountAllConstruct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(canConstruct("abcdef" , new String[] {"ab", "abc", "cd", "def", "abcd"}));
		System.out.println(canConstruct("skateboard" , new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
		System.out.println(canConstruct("enterapotentpot" , new String[] {"a", "p", "ent", "enter", "o", "ot", "t"}));
		//System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" , new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee","eeeeeee" }));
		
		Map<String, Boolean> memo = new HashMap<String, Boolean>();
		System.out.println(canConstructMemo("abcdef" , new String[] {"ab", "abc", "cd", "def", "abcd"}, memo));
		System.out.println(canConstructMemo("skateboard" , new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}, memo));
		System.out.println(canConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" , new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee","eeeeeee" }, memo));
		
		System.out.println("-------------------------------------- Count number of ways the string can be constructed");
		Map<String, Integer> memo2 = new HashMap<String, Integer>();
		System.out.println(countConstruct("abcdef" , new String[] {"ab", "abc", "cd", "def", "abcd"}, memo2));
		System.out.println(countConstruct("skateboard" , new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}, memo2));
		System.out.println(countConstruct("enterapotentpot" , new String[] {"a", "p", "ent", "enter", "o", "ot", "t"}, memo2));
		System.out.println(memo2);
		System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" , new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee","eeeeeee" }, memo2));
		
		System.out.println("----------------------------------------------- list all the ways");
		Map<String, ArrayList<ArrayList<String>>> memo3 = new HashMap<String, ArrayList<ArrayList<String>>>();
		System.out.println(allConstruct("abcdef" , new String[] {"ab", "abc", "cd", "def", "abcd", "ef", "c"}, memo3));
		//memo3.clear();
		System.out.println(allConstruct("enterapotentpot" , new String[] {"a", "p", "ent", "enter", "o", "ot", "t"}, memo3));
		System.out.println(memo3);
		memo3.clear();
		System.out.println(".."+ allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" , new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee","eeeeeee" }, memo3));
		
	}
	
	// m = target.length , n=wordBank.length     time complexity : o(n^m)    space complexity:  o(m^2)
	// branching factor to the height power.
	// in worst case, we need to call same function m times if wordbank has only one character. with only we need to craete a new string
	// and store that again. o(m*m)
	public static boolean canConstruct(String targetString, String[] wordBank) {
		// base case
		if (targetString.isEmpty()) return true;
		
		for (String word: wordBank) {
			if (targetString.startsWith(word)) {
				// starts with given string
				String suffix = targetString.replaceFirst(word, "");
				//System.out.println(suffix);
				if( canConstruct(suffix, wordBank) ) {
					// only when we can construct , we need to return true,
					// otherwise do no return anything as it will finish proramme, we need to continue
					// searching in that case....
					return true;
				}
			}
		}
		return false;
	}
	
	// time complexity o(n*m)  polynomial is better then exponential
	// space complexity o(m*m)
	public static boolean canConstructMemo(String targetString, String[] wordBank, Map<String, Boolean> memo) {
		if(memo.containsKey(targetString)) return memo.get(targetString);
		// base case
		if (targetString.isEmpty()) return true;
		
		for (String word: wordBank) {
			if (targetString.startsWith(word)) {
				String suffix = targetString.replaceFirst(word, "");
				//System.out.println(suffix);
				if( canConstructMemo(suffix, wordBank, memo) ) {
					
					// add to memo before each return
					memo.put(targetString, true);
					return true;
				}
			}
		}
		memo.put(targetString, false);
		return false;
	}
	
	// m = targetString.length , n = wordBank.length
	// Brute force : time complexity : o(n^m*m)  space complexity : o(m*m)   // *m is for some processes / storage done in programme
	// memo : time complexity o(n*m^2) , space complexity o(m*m)
	public static int countConstruct( String targetString, String[] wordBank, Map<String, Integer> memo) {
		if (memo.containsKey(targetString)) return memo.get(targetString);
		if (targetString.isEmpty()) return 1;
		int out = 0;
		for (String word : wordBank) {
			if (targetString.startsWith(word)) {
				String suffix = targetString.replaceFirst(word, "");
				int output = countConstruct(suffix, wordBank, memo);
				out = out+output;
			}
		}
		
		memo.put(targetString, out);
		return out;
	}
	
	
	// n : wordBank.length , m = targetString.length
	// brute force time complexity o(n^m) space complexity o(m)
	public static ArrayList<ArrayList<String>> allConstruct( String targetString, String[] wordBank, Map<String, ArrayList<ArrayList<String>>> memo) {
		if (memo.containsKey(targetString)) return memo.get(targetString);
		if (targetString.isEmpty()) return new ArrayList<ArrayList<String>> (Arrays.asList(new ArrayList<String>() ));
		
		ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
		for (String word : wordBank) {
			if (targetString.startsWith(word)) {
				String suffix = targetString.replaceFirst(word, "");
				// i need to clone here, as it may 
				ArrayList<ArrayList<String>> output = allConstruct(suffix, wordBank, memo);
				
				if (output!=null) {
					//System.out.println(output + " **"+ (output!=null)  );
					//ArrayList<String> temp = new ArrayList<String>();
					for (ArrayList<String> one : output) {
						//temp = (ArrayList<String>) one.clone();
						ArrayList<String> temp = new ArrayList<String>(one);
						temp.add(0, word);
						//System.out.println(" .... " + one);
						all.add(temp);
					}
					//System.out.println(" ***** " + output);
					//all.addAll(output);
				}				
			}
		}
		
//		if (all.isEmpty()) {
//			memo.put(targetString, null);
//			return null;
//		} else {
//			memo.put(targetString, all);
//			return all;
//		}
		memo.put(targetString, all);
		return all;
	}
	
	
	

}
