/*
https://practice.geeksforgeeks.org/problems/maximum-gap3845/1/

Given an unsorted array Arr of length N. Your task is to find the maximum difference between the successive elements in its sorted form.
Return 0 if the array contains less than 2 elements.

Example 1:

Input:
N = 3
Arr[] = {1, 10, 5}
Output: 5
Explanation: The maximum difference
between  successive elements of array
is 5(abs(5-10)).
Your Task:
Complete the function maxSortedAdjacentDiff() which takes array arr and size n, as input parameters and returns an integer representing the answer. You don't to print answer or take inputs.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 106
1 ≤ Arr[i] ≤ 106
*/
//sol
class Solution{
public:
	int maxSortedAdjacentDiff(int* arr, int n) {
	    // code here
	    if(n<2)
    	    return 0;
    	int mx = *max_element(arr, arr+n);
    	vector <int> res(mx+1, 0);
    	for(int i=0; i<n; i++)
    	    res[arr[i]]++;
    	int ans  = INT_MIN, i = 0, first = -1, second = -1;
    	while(i <= mx){
    	    while(i <= mx && res[i] == 0)
    	        i += 1;
    	    if(i <= mx)
    	        first = i;
    	    i += 1;
    	    while(i <= mx && res[i] == 0)
    	        i += 1;
    	    if(i <= mx)
    	        second = i;
    	    ans = max(ans, abs(first-second));
    	}
    	return ans;
	}
};
