/*
https://practice.geeksforgeeks.org/problems/find-smallest-range-containing-elements-from-k-lists/1#

Given K sorted lists of integers, KSortedArray[] of size N each. The task is to find the smallest range that includes at least one element from each of the K lists. If more than one such range's are found, return the first such range found.

Example 1:

Input:
N = 5, K = 3
KSortedArray[][] = {{1 3 5 7 9},
                    {0 2 4 6 8},
                    {2 3 5 7 11}}
Output: 1 2
Explanation: K = 3
A:[1 3 5 7 9]
B:[0 2 4 6 8]
C:[2 3 5 7 11]
Smallest range is formed by number 1
present in first list and 2 is present
in both 2nd and 3rd list.
Example 2:

Input:
N = 4, K = 3
KSortedArray[][] = {{1 2 3 4},
                    {5 6 7 8},
                    {9 10 11 12}}
Output: 4 9
Your Task :

Complete the function findSmallestRange() that receives array , array size n and k as parameters and returns the output range (as a pair in cpp and array of size 2 in java and python)

Expected Time Complexity : O(n * k *log k)
Expected Auxilliary Space  : O(k)

Constraints:
1 <= K,N <= 500
1 <= a[ i ] <= 105

*/
//sol
class Solution
{
	class Element implements Comparable<Element>
	{
	    //add your code here
	    int val;
        int ind;
        int row;
        Element (int val, int ind, int row) {
            this.val= val;
            this.ind= ind;
            this.row= row;
        }
        public int compareTo(Element e){
            return this.val- e.val;
        }
    }
	int[] findSmallestRange(int[][] KSortedArray, int n, int k)
	{
	    int length=Integer.MAX_VALUE, low= Integer.MAX_VALUE, high= Integer.MIN_VALUE, max= Integer.MIN_VALUE;
	    PriorityQueue<Element> pq= new PriorityQueue<>();
	    for(int i=0; i<k; i++){
	        max= Math.max(max, KSortedArray[i][0]);
	        pq.add(new Element(KSortedArray[i][0], 0, i));
	    }
	    length= max - pq.peek().val;
	    low= pq.peek().val;
	    high= max;

	    boolean flag= true;
	    while(flag){
	        Element x= pq.poll();
	        int row= x.row;
	        int ind= x.ind;
	        if(!(ind+1<n)){
	            flag= false;
	            break;
	        } else {
	            Element ne= new Element(KSortedArray[row][ind+1], ind+1, row);
	            pq.add(ne);
	            max= Math.max(max, KSortedArray[row][ind+1]);
	            if(length> max- pq.peek().val){
	                length= max- pq.peek().val;
	                low= pq.peek().val;
	                high= max;
	            }
	        }
	    }
	    int arr[]= {low, high};
	    return arr;
	}
}
