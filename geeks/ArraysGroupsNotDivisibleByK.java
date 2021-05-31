/*
link-https://practice.geeksforgeeks.org/problems/grouping-of-numbers0015/0/?category[]=Mathematical&category[]=Mathematical&difficulty[]=1&page=1&query=category[]Mathematicaldifficulty[]1page1category[]Mathematical#

One day Jim came across array arr[] of N numbers. He decided to divide these N numbers into different groups. Each group contains numbers in which sum of any two numbers should not be divisible by an integer K. Print the size of the group containing maximum numbers.

 

Example 1:

Input:
N = 4, K = 8
arr[] = {1, 7, 2, 6}
Output:
2
Explanation:
The  group of numbers which can be formed
are: (1),(2),(7),(6),(1,2),(1,6),(7,2),(7,6).
So,the maximum possible size of the group is 2.
Example 2:

Input:
N = 2, K = 3
arr[] = {1, 2}
Output:
1
Explanation:
The  group of numbers which can be formed
are: (1),(2). So,the maximum possible size
of the group is 1.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxGroupSize() which takes 2 Integers N, and K and also an array arr[] of N integers as input and returns the maximum group size possible.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(K)

 

Constraints:
1 ≤ N,K,arr[i] ≤ 105
*/
class Solution {
    static int maxGroupSize(int[] arr, int N, int k) {
        // code here
        int rem[]=new int[k];
        for(int i=0;i<N;i++) {
            rem[arr[i]%k]++;
        }
        int l=0;
        for(int i=1;i<=k/2;i++) {
            if(i!=k-i) {
                l+=Math.max(rem[i], rem[k-i]);
            }
            else {
                if(rem[i]!=0) l++;
            }
        }
        if(rem[0]!=0) l++;
        return l;
    }
}
