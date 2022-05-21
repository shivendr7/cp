/*
https://practice.geeksforgeeks.org/problems/1a31d09f7b8e9c0633339df07858deb3a728fe19/1#

Given an array Arr[] of size N. For every element in the array, the task is to find the index of the farthest element in the array to the right which is smaller than the current element. If no such number exists then print -1.
Note: 0 based indexing.


Example 1:

Input: 
N=5
Arr[] = {3, 1, 5, 2, 4}
Output: 
3 -1 4 -1 -1
Explanation:
Arr[3] is the farthest smallest element
to the right of Arr[0].
Arr[4] is the farthest smallest element
to the right of Arr[2].
And for the rest of the elements, there is
no smaller element to their right.
Example 2:

Input: 
N=5
Arr[] = {1, 2, 3, 4, 0}
Output: 
4 4 4 4 -1

Your Task: 
You don't need to read input or print anything. Your task is to complete the function farNumber() which takes the N (number of elements in Array Arr) ,Arr[], and returns the array of farthest element to the right for every element of the array.


Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 1e5
0 ≤ Arr[i] ≤ 1e9 

*/
//sol
class Solution{   
  public:
    vector<int> farNumber(int N,vector<int> Arr){
        //code here
        vector<pair<int, int>> vp;
        for(int i=0;i<N;i++) {
            vp.push_back(make_pair(Arr[i], i));
        }
        sort(vp.begin(), vp.end());
        vector<int> ans(N);
        int mx = vp[0].second;
        ans[vp[0].second] = -1;
        for(int i=1;i<N;i++) {
            if(mx>vp[i].second) {
                ans[vp[i].second] = mx;
            }
            else {
                mx = vp[i].second;
                ans[vp[i].second] = -1;
            }
        }
        return ans;
    }
};
