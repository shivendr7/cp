/**
https://practice.geeksforgeeks.org/problems/3d49e4cce2820a813da02d1587c2dd9c542ce769/1

You are given an array arr[ ] of size N consisting of only positive integers. Your task is to find the count of special numbers in the array. A number is said to be a special number if it is divisible by at least 1 other element of the array.

Example 1:

Input:
N = 3
arr[] = {2, 3, 6}
Output:
1
Explanation:
The number 6 is the only special number in the
array as it is divisible by the array elements 2 
and 3. Hence, the answer is 1 in this case.
Example 2:

Input: 
N = 4
arr[] = {5, 5, 5, 5}
Output:
4
Explanation: 
All the array elements are special. Hence, 
the answer is 4 in this case.
Your Task:
You don't need to read input or print anything. Complete the function countSpecialNumbers() which takes the integer N and the array arr[ ] as the input parameters, and returns the count of special numbers in the array. 


Expected Time Complexity: O(N*root(M)) where M = max(arr[i])
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105 
1 ≤ arr[i] ≤ 106 


**/

class Solution {
  public:
    int countSpecialNumbers(int N, vector<int> arr) {
        // Code here 
        int mx=*max_element(arr.begin(),arr.end());
        int ans=0;
        vector<int> seive(mx+1,0);
        for(int i=0;i<N;i++){
            if(seive[arr[i]]<=1){
                for(int j=arr[i];j<=mx;j+=arr[i]) 
                    seive[j]++;
            }
        } 
        for(int i=0;i<N;i++){
            if(seive[arr[i]]>1) 
                ans++;
        }
        return ans;
    }
};
