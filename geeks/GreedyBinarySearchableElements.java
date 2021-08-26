/*
https://practice.geeksforgeeks.org/problems/binary-searchable-elements/1/

Binary search is a search algorithm usually used on a sorted sequence to quickly find an element with a given value. In this problem we will evaluate how binary search performs on data that isn't necessarily sorted. An element is said to be binary searchable if, regardless of how the pivot is chosen the algorithm returns true.
For example:

[2, 1, 3, 4, 6, 5] and target = 5, we cannot find 5. Because when the pivot is 4, we get element 6, then right pointer will move left, so we'll lose the opportunity to find target 5.
[2, 1, 3, 4, 5, 6] and target = 5, we can find 5. Because wherever we choose the pivots, we'll find target at last.
Given an unsorted array of n distinct integers, return the number of elements that are binary searchable.

 

Example 1:

Input:
N = 3
arr[] = {1, 3, 2}
Output: 1
Explanation: However we choose the 
pivots, we will always find the 
number 1 when looking for it. 
This does not hold for 3 and 2.
Example 2:

Input:
N = 6
arr[] = {2, 1, 3, 5, 4, 6}
Output: 2
Explanation: 3 and 6 are the numbers 
guaranteed to be found in the same way.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function binarySearchable() which takes an integer n and an array Arr of size n as input and return the number of elements that are binary searchable.


Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ N ≤ 105
1 ≤ arr[i] ≤ 105


*/
//sol
class Solution {
    static int binarySearchable(int[] Arr, int n) {
        // code here
        if(n==1) return 1;
        int maxL[]=new int[n];
        int minR[]=new int[n];
        maxL[0]=Arr[0];
        minR[n-1]=Arr[n-1];
        for(int i=1;i<n;i++) {
            //n-i-1
            minR[n-i-1]=Math.min(minR[n-i], Arr[n-i-1]);
            maxL[i]=Math.max(maxL[i-1], Arr[i]);
        }
        int c=0;
        if(Arr[0]<minR[1]) c++;
        if(Arr[n-1]>maxL[n-2]) c++;
        for(int i=1;i<n-1;i++) {
            if(Arr[i]>maxL[i-1] && Arr[i]<minR[i+1]) c++;
        }
        return c;
    }
};
