/*   NOTE:REVERSE APPROACH IS IMPORTant
link:https://practice.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1/?category[]=Arrays&category[]=Arrays&problemStatus=unsolved&difficulty[]=0&difficulty[]=1&page=2&query=category[]ArraysproblemStatusunsolveddifficulty[]0difficulty[]1page2category[]Arrays#

Given an unsorted array arr[] of n positive integers. Find the number of triangles that can be formed with three different array elements as lengths of three sides of triangles. 

Example 1:

Input: 
n = 3
arr[] = {3, 5, 4}
Output: 
1
Explanation: 
A triangle is possible 
with all the elements 5, 3 and 4.
Example 2:

Input: 
n = 5
arr[] = {6, 4, 9, 7, 8}
Output: 
10
Explanation: 
There are 10 triangles
possible  with the given elements like
(6,4,9), (6,7,8),...

Your Task: This is a function problem. You only need to complete the function findNumberOfTriangles() that takes arr[] and N as input parameters and returns the count of total possible triangles.

Expected Time Complexity: O(N2).
Expected Space Complexity: O(1).

Constraints:
3 <= N <= 103
1 <= arr[i] <= 103
*/
//sol
class Solution
{
    public:
    int findNumberOfTriangles(int arr[], int n)
    {
        // code here
        
        // code here
        sort(arr,arr+n);
        int c=0;
        int C=0;
        for(int i=2;i<n;i++){
            int k=0;
            int l=i-1;
            while(k<l) {
                if(arr[l]+arr[k]>arr[i]) {
                    c+=l-k;
                    l--;
                }
                else {
                    k++;
                }
            }
            
        }
        return c;
    
    }
};
