/*
https://practice.geeksforgeeks.org/problems/element-appearing-once2552/1/

Given a sorted array A[] of N positive integers having all the numbers occurring exactly twice, except for one number which will occur only once. Find the number occurring only once.

Example 1:

Input:
N = 5
A = {1, 1, 2, 5, 5}
Output: 2
Explanation: 
Since 2 occurs once, while
other numbers occur twice, 
2 is the answer.
Example 2:

Input:
N = 7
A = {2, 2, 5, 5, 20, 30, 30}
Output: 20
Explanation:
Since 20 occurs once, while
other numbers occur twice, 
20 is the answer.
Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes two arguments(array A and integer N) and returns the number occurring only once.

Expected Time Complexity: O(Log(N)).
Expected Auxiliary Space: O(1).

Constraints
0 <   N  <= 10^6
0 <= A[i] <= 10^9
*/
//sol
class Sol
{
    public static int search(int a[], int n)
    {
        // your code here
        if(n == 1)
        return a[0];
        int mid,begin=0,end=n-1;

        while(begin<=end)
        {
            mid=begin+(end-begin)/2;
            if(mid!=n-1 && mid%2==0 && a[mid]==a[mid+1] || mid!=0 && mid%2!=0 && a[mid]==a[mid-1])
            begin=mid+1;
            else
            end=mid-1;
        }
        return a[begin];
    }
}
