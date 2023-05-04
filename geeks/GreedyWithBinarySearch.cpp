/*
https://practice.geeksforgeeks.org/problems/111fb97b983399c0ee9f34b7bae18ac76bf6f07a/1

You are given a 2D integer array ranges whose length is n where ranges[i]=[starti, end,coinsi] means all integers from starti to endi inclusive starti and endi are present and we get coinsi amount of coins when we select this ith range. You can select at most two intervals so as to collect maximum coins but if you select two ranges then those two ranges should not intersect or overlap but can touch each other.

Note: You can select at max 2 ranges and they should not intersect with each other but they can touch themselves.

Example 1:

Input :
n=3
ranges={{1,3,4},{2,3,5},{3,4,2}}
Output: 7
Explanation:
We can see that we can take 2nd and 
3rd ranges as they are not intersecting
(only touching) we get maximum Coins by 
taking these ranges(5+2=7).
Example 2:

Input :
n=5
ranges={{1,3,4},{2,3,5},{3,4,2},{5,8,9},{2,8,10}}
Output: 14
Explanation:
We can see that we can take 2nd and 
4th ranges as they are not intersecting 
we get maximum Coins(5+9=14) by taking 
these ranges.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxCoins() which takes an integer n(length of ranges), integer 2D integer array ranges, and you have to return the maximum number of coins you got after selecting at most two ranges that are not intersecting.

Expected Time Complexity: O(nlogn)
Expected Space Complexity: O(n)

Constraints:
1<=n<=105
0<=ranges[i][0]<=ranges[i][1]<=109
0<=ranges[i][2](coins)<=106
The sum of n over all test cases won't exceed 106


*/
//sol
class Solution{
public:
    int maxCoins(int n,vector<vector<int>> &ra){
        // Code here 
        sort(begin(ra), end(ra), [](auto & a , auto & b ){
            if(a[0]==b[0])
                return a[1]<b[1];
            return a[0]<b[0];
        }); 
        vector<int>suff(n ,0); 
        suff[n-1] =ra[n-1][2] ;
        for(int i =n-2 ;i>=0 ;i-- ) {
            suff[i] = max(suff[i+1] , ra[i][2]) ;
        }
        
        int maxi = suff[0];
        for(int i =0 ; i<n;i++ ) {
            int x = ra[i][0] , y =ra[i][1] ,cost =ra[i][2] ;
            int l= i+1 ,r = n-1  , ind =-1 , mm =0 ;
            while(l<=r) {
                int mid =  (r+l)/2; 
                if(ra[mid][0]>=y) {
                    mm = max(mm , suff[mid]);
                    r=mid-1;
                }
                else
                    l=mid+1; 
            }
            maxi=max(maxi, cost+mm);
        }
       
      return maxi;
    }
};
