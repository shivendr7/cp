/*
Given an array A[] of N positive integers which can contain integers
from 1 to N where elements can be repeated or can be absent from the array. 
Your task is to count the frequency of all elements from 1 to N.

Input:
N = 5
A[] = {2,3,2,3,5}
Output:
0 2 2 0 1
Explanation: 
Counting frequencies of each array element
We have:
1 occurring 0 times.
2 occurring 2 times.
3 occurring 2 times.
4 occurring 0 times.
5 occurring 1 time.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 4*104 
1 <= A[i] <= N

link:https://practice.geeksforgeeks.org/problems/frequency-of-array-elements/1/?category[]=two-pointer-algorithm&category[]=two-pointer-algorithm&difficulty[]=1&page=1&query=category[]two-pointer-algorithmdifficulty[]1page1category[]two-pointer-algorithm#
*/

//sol
class Frequency{
    public static void frequencycount(int a[], int n)
    {
        // code here
        for(int i=0;i<n;i++) {
            a[i]--;
        }
        for(int i=0;i<n;i++) {
            a[a[i]%n]+=n;
        }
        for(int i=0;i<n;i++) {
            a[i]/=n;
        }
        
    }
}
