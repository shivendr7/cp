/*
link-               https://practice.geeksforgeeks.org/problems/possible-groups2013/1/
similar question:   https://practice.geeksforgeeks.org/problems/number-of-pairs3422/1/

Given an array of positive integers of size N, form groups of two or three such that the sum of all elements in a group is a multiple of 3. 
Count all possible number of groups that can be generated in this way.


Example 1:

Input:
N = 5
arr[] = {3, 6, 7, 2, 9}
Output: 8
Explanation: 
Groups of two are: 
{3, 6}, {3, 9}, {9, 6}, {7, 2}.
Groups of three are: 
{3, 7, 2}, {7, 2, 6}, {7, 2, 9}, {3, 6, 9}.

Example 2:

Input:
N = 4
arr[] = {2, 1, 3, 4}
Output: 4
Explanation: Groups are {2,1}, {2,4}, 
{2,1,3}, {2,4,3}

Your Task:
You don't need to read input or print anything. Your task is to complete the function findgroups() which takes arr[] and n as input parameters and returns the number of possible groups.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106
1 ≤ arri ≤ 106
*/
//sol
class Solution {
    long findgroups(int[] a, int n) {
        // code here
        long c[] = new long[3];
        long res = 0;
        for(int i=0;i<n;i++) { c[a[i]%3]++; }
        res=res+ (long)(c[0]*(c[0]-1))/2;
        res=res+c[1]*c[2]; 
        res=res+(long)(c[0]*(c[0]-1)*(c[0]-2))/6;
        res=res+(long)(c[1]*(c[1]-1)*(c[1]-2))/6;
        res=res+(long)(c[2]*(c[2]-1)*(c[2]-2))/6;
        res=res+c[0]*c[1]*c[2]; 
        return res;
    }
}
