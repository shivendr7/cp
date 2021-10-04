/*
https://practice.geeksforgeeks.org/problems/size-of-array-after-repeated-deletion-of-lis4750/1/

Given an array nums[0..n-1] of positive element. The task is to find remaining elements of nums[] after repeated deletion of LIS (of size greater than 1). If there are multiple LIS with same length, we need to choose the LIS that ends first.
 

Example 1:

Input: nums = {1,2,5,3,6,4,1}
Output: {1}
Explanation: From {1,2,5,3,6,4,1}
{1,2,5,6} can be deleted. Now from
remaining {3,4,1} {3,4} can be deleted.
Example 2:

Input: nums = {1,2,3,1,5,2}
Output: {-1}
Explanation: From {1,2,3,1,5,2}
{1,2,3,5} can be deleted. Now from 
{1,2} the whole list can be deleted.
 

Your Task:
You don't need to read or print anything. your task is to complete the function minimize() which takes nums as input parameter and returns a list of elments which is remaining after repeated deletion. If all elements can be deleted then returns a list containing -1.
 

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n)
 

Constraints:
1 <= n <= 500
1 <= nums[i] <= 1000
*/
//sol
class Solution {
public:
    vector<int> findLIS(vector<int> arr)
    {
    	int n = arr.size();
        vector<vector<int>> L(n);
        L[0].push_back(arr[0]);
     
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[i] > arr[j])
                    L[i] = L[j];
            }
            L[i].push_back(arr[i]);
        }
        int maxSize = 1;
        vector<int> lis;
        for (vector<int> x : L)
        {
            if (x.size() > maxSize)
            {
                lis = x;
                maxSize = x.size();
            }
        }
        return lis;
    }
     
    vector<int> minimize(vector<int>nums)
    {
    	int n = nums.size();
        vector<int> arr(nums.begin(), nums.end());
     
        while (arr.size())
        {
            vector<int> lis = findLIS(arr);
            if (lis.size() < 2)
                break;
            for (int i=0; i<arr.size() && lis.size()>0; i++)
            {
                if (arr[i] == lis[0])
                {
                    arr.erase(arr.begin()+i) ;
                    i--;
                    lis.erase(lis.begin()) ;
                }
            }
        }
        if(arr.size() == 0)return {-1};
        return arr;
    }
};
