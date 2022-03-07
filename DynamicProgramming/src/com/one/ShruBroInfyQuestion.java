package com.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;


public class ShruBroInfyQuestion {
	
	public static void main(String[] args) {
		//System.out.println(canSum(12, 3));
		//optimalGemsInBox(2, 1, new int[] {1, 3, 5, 5, 1} );
		//System.out.println(canSumOptimized(8, new int[] {1, 2, 2, 4, 3, 5, 4, 2}, 8));
		System.out.println(mobileTower(new int[] {42, 31, 5, 19} , 10));
		System.out.println(crazyString3());
	}
	

	public static int canSum (int x, int y ) {
		
		int out = 0;
		ArrayList<Integer> range = new ArrayList<Integer> ();
		for (int i =1; i<=(x+y)/2 ; i++) {
			out += i;
			range.add(i);
			if (out==(x+y)) {
				break;
			}
			if (out>(x+y)) {
				return -1;
			}
		}
		//Integer[] xu = range.toArray();
		System.out.println(x + " "+range);
		ArrayList<Integer> output = minPoss2(x,range.toArray() );
		System.out.println(output);
		return output.size();
		
	}
	
	public static ArrayList<Integer> minPoss2(int x, Object[] y) {
		if (x==0) return new ArrayList<Integer> ();
		if (x<0) return null;
		
		ArrayList<Integer> out = null;
		//System.out.println(x + " ____________________" + y);
		for (int j =0; j<y.length; j++) {
			int i = (int) y[j];
			if (i>0) {
				int remainder = x - i;
				int temp = (int) y[j];
				y[j]=0;
				//System.out.println(remainder + " " + i + " "+Arrays.toString(y));			
				ArrayList<Integer> output = minPoss2(remainder, y);
				//System.out.println(output + " .... "+i + " "+Arrays.toString(y));
				y[j] = temp; // no need to send clone as we are corrcting the state of array
				if (output!=null) {
					output.add(i);
					if (out == null || output.size() < out.size()) {
						out = output;
					}
				}
			}
		}
		return out;
	}
	
	
//	public static ArrayList<Integer> optimalGemsInBox(int noOfBox, int valueDiff, int[] gemsValue, int currentIndex, int currentNo) {
//		if (currentNo>0 && currentNo<=valueDiff && currentNo < ) return new ArrayList<Integer> ();
//		
//		ArrayList<Integer> output = null;
//		for (int i=currentIndex; i<gemsValue.length; i++) {
//			int diff = gemsValue[currentIndex] - gemsValue[i];
//			ArrayList<Integer> ok = optimalGemsInBox(noOfBox, valueDiff, gemsValue, i+1, diff);
//			
//			if (ok!=null) {
//				ok.add(gemsValue[i]);
//				if (output==null) {
//					output = ok;
//				}
//			}
//		}
//	}
	// largest sum whose sum is +x , taken first M boxes. 
	public static ArrayList<Integer> cangetMaxDiffSet( int [] gemValue, int xDiff, int inputIndex) {
		
//		for ( int i=0; i<gemValue.length; i++) {
//			int lowest = gemValue[i];
//			ArrayList<Integer> one = new ArrayList<Integer>();
//			for ( int j=0; j<gemValue.length; j++) {
//				
//				if (gemValue[j]-lowest <= xDiff) {
//					
//				}
//			}
//		}
//		//NodeList
//		ListNode
//		for ( int j=0; j<gemValue.length; j++) {
//			int diff = gemValue[inputIndex] - gemValue[j];
//			if (diff<=xDiff) {
//				int temp = gemValue[j];
//				gemValue[j] = 0;
//				ArrayList<Integer> ok = cangetMaxDiffSet(gemValue, xDiff, );
//				gemValue[j] = temp;
//				return ok;
//			}
//		}
		return null;
		
		
	}
	
	// instead of using targetSum as base, we will use array int as base.
	// instead of reducing targetSum to get reduced problem (where we also needed to reduce array , here we will only reduce array
	// so we have two choice for each element of array. either to include it or exclude it.
	public static ArrayList<Integer> canSum2(int targetSum, int[] array, int index) {
		if (targetSum==0) return new ArrayList<Integer> ();
		if (targetSum<0) return null;
		if (index<=0) return null;
		System.out.println( " ..............." + index + " " + targetSum);
		ArrayList<Integer> one = canSum2(targetSum-array[index-1], array, index-1);
		ArrayList<Integer> two = canSum2(targetSum, array, index-1);
		System.out.println(one + " " + two + " " + index + " " + targetSum);
		
		if (one!=null && two!=null) {
			if (one.size()+1>two.size()) {
				//two.add(array[index-1]);
				return two;
			} else {
				one.add(array[index-1]);
				return one;
			}
		} else if (one==null && two==null) {
			return null;
		} else if (two==null) {
			one.add(array[index-1]);
			return one;
		} else {
			//two.add(array[index-1]);
			return two;
		}
		
		
		
	}
	
	// i dont think in this method we can actually use memoisation. no not possible.
	public static ArrayList<Integer> canSumOptimized (int targetSum, int[] array, int index) {
		if (targetSum==0) return new ArrayList<Integer> ();
		if (targetSum<0 || index<=0) return null;
		//System.out.println( " ..............." + index + " " + targetSum);
		ArrayList<Integer> one = canSum2(targetSum-array[index-1], array, index-1);
		ArrayList<Integer> two = canSum2(targetSum, array, index-1);
		//
		// instead of concentrating number of conditions and covering each condition
		// concentrate on outcomes that you want to give and collect every condition that will point to that outcome under one if
		if (two==null || ( (one!=null && two!=null) && (one.size()+1<=two.size()) ) ) {
			one.add(array[index-1]);
			return one;
		}
		if (one==null || ( (one!=null && two!=null) && (one.size()+1>two.size()) ) ) {
			return two;
		}
		return null;
		
		
	}
	
	
	public static Vector<Integer> mobileTower(int[] cities, int range) {
		
		int length = cities.length;
		
		Arrays.sort(cities);
		int citiCovered = 0;
		int towerPosition = 0;
		Vector<Integer> allTowerPosition = new Vector<Integer>();
		//towerPosition = cities[0];
		//for (int i=0; i<cities[length-1]; i++) {
			for (int j=0; j<cities.length; j++) {
				// j is uncovered city
				if (!allTowerPosition.isEmpty()) {
					if (towerPosition-range <= cities[j] && towerPosition+range >= cities[j]) {
						// city is within range
						System.out.println(" covered ....." + cities[j]);
						continue;
					}
				}
				System.out.println("now ....." + cities[j]);
				citiCovered=0;
				while (true) {
					System.out.println("checking for " + cities[j] + " " + (towerPosition) );
					if (towerPosition-range <= cities[j] && towerPosition+range >= cities[j]) {
						System.out.println("given tower still in range ..." + cities[j]);
						for (int k=0; k<cities.length; k++) {
							if (towerPosition-range <= cities[k] && towerPosition+range >= cities[k]) {
								// city within range
								System.out.println("given tower still in range ..." + cities[k] + " " + k);
								citiCovered++;
							}
						}
					} else {
						System.out.println(towerPosition + " tower return ....." + citiCovered);
						if (citiCovered==1) {
							allTowerPosition.add(cities[j]);
							break;
						}
							
						else if (citiCovered>1) {
							allTowerPosition.add(towerPosition-1);
							break;
						} 							
						
					}
					System.out.println(towerPosition + " tower .....");
					towerPosition++;
				}
				
			}
			return allTowerPosition;
		//}
	}
	
	
	public static int crazyString(String input, int length, int minChar, int startIndex, int len) {
		if (len>=minChar) return 0;
		int minCostFInal=0;
		int i=startIndex;
		//for (int i=startIndex; i<input.length(); i++) {
			int minCost=0;
			int cost1 = -1;
			int cost2=-1;
			if (i+len <input.length()) {
				cost1 = Math.abs(input.charAt(i+len)-input.charAt(i));
			}
			if (i-1>=0) {
				
				cost2 = Math.abs(input.charAt(i-1)-input.charAt(i));
			}
			//System.out.println("cist allllll and " + cost1 + " " + cost2 + " " + i);
			StringBuilder ok = new StringBuilder(input);
			if (cost1==-1 || ( (cost1!=-1 && cost2!=-1) && cost1>cost2)) {
				//System.out.println("min cost os cost2 "+cost2);
				ok.setCharAt(i-1, ok.charAt(i));
				startIndex--;
				minCost=cost2;
			}
			if (cost2==-1 || ( (cost1!=-1 && cost2!=-1) && cost1<=cost2)) {
				//System.out.println("min cost os "+cost1 + " i " + i);
				ok.setCharAt(i+len, ok.charAt(i));
				minCost=cost1;
			}
			len++;
			System.out.println(input + " " + ok.toString() + " " + minCost + " " + startIndex + " len:" + len);
			int allCost = minCost+crazyString(ok.toString(), length, minChar, startIndex, len);
			
			return allCost;
		//}
		
	}
	
	public static int crazyString1(String input, int length, int minChar) {
		int minCost=-1;
		for (int i=0; i<input.length(); i++) {
			
			int cost = crazyString(input, length, minChar, i, 1);
			System.out.println("---------------------------------------------------" + cost);
			if (minCost==-1) {
				minCost=cost;
			} else if (minCost>cost){
				minCost=cost;
			}
		}
		return minCost;
	}
	
	private static int crazyString3() {
		// TODO Auto-generated method stub
		String ok = "aabcd";
		return crazyString1(ok, ok.length(), 3);
	}
	
	

}
