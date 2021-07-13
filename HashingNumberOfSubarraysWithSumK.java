/*
https://practice.geeksforgeeks.org/problems/subarrays-with-sum-k/1

Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.


Example 1:

Input:
N = 5
Arr = {10 , 2, -2, -20, 10}
k = -10
Output: 3
Explaination: 
Subarrays: arr[0...3], arr[1...4], arr[3..4]
have sum exactly equal to -10.

Example 2:

Input:
N = 6
Arr = {9, 4, 20, 3, 10, 5}
k = 33
Output: 2
Explaination: 
Subarrays : arr[0...2], arr[2...4] have sum
exactly equal to 33.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findSubArraySum() which takes the array Arr[] and its size N and k as input parameters and returns the count of subarrays.


Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 2*104
-103 ≤ Arr[i] ≤ 103
-107 ≤ k ≤ 107
*/
//sol
class Solution
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
        int cs=0;
        int c=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<N;i++) {
            cs+=Arr[i];
            if(cs==k) {
                c++;
            }
            if(map.get(cs-k)!=null) {
                c+=map.get(cs-k);
            }
            if(map.get(cs)==null) {
                map.put(cs, 1);
            }
            else {
                map.put(cs, map.get(cs)+1);
            }
        }
        return c;
    }
}
