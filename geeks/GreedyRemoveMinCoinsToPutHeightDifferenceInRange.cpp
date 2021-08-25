/*
https://practice.geeksforgeeks.org/problems/coin-piles5152/1/

There are N piles of coins each containing  Ai (1<=i<=N) coins. Find the minimum number of coins to be removed such that the absolute difference of coins in any two piles is at most K.
Note: You can also remove a pile by removing all the coins of that pile.


Example 1:

Input:
N = 4, K = 0
arr[] = {2, 2, 2, 2}
Output:
0
Explanation:
For any two piles the difference in the
number of coins is <=0. So no need to
remove any coins. 
Example 2:
Input:
N = 6, K = 3
arr[] = {1, 5, 1, 2, 5, 1} 
Output :
2
Explanation:
If we remove one coin each from both
the piles containing 5 coins , then
for any two piles the absolute difference
in the number of coins is <=3. 


Your Task:  
You don't need to read input or print anything. Your task is to complete the function minSteps() which takes 2 integers N, and K and an array A of size N as input and returns the minimum number of coins that need to be removed.


Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
0 ≤ K ≤ 103
1 ≤ A[i] ≤ 103
*/
//sol
/*
In order to find the minimum number of coins to be added,
we iterate over all the coin pile sizes,and for the rest of the piles
if the pile size is less than the current size then remove that pile
entirely otherwise if the pile size is greater than current pile size
plus K then remove the excess coins. The minimum number of coins removed
in any of the turns is the answer.  
*/
class Solution {
  public:
    int minSteps(int A[], int n, int k) {
        // code here
        sort(A,A+n);
        vector<int>v(n),v1(n);
        v[0]=A[0];
        for(int i=1;i<n;i++)
        v[i]=v[i-1]+A[i];
        for(int i=0;i<n;i++)
        v1[i]=A[i];
       
        int c=INT_MAX;
        for(int i=0;i<n;i++){
            int h=upper_bound(A,A+n,A[i]+k)-A-1;
          // cout<<h<<endl;
            c=min(c, (v[n-1]-v[h]-(n-1-h)*(A[i]+k)+(i>0?v[i-1]:0)) );
        }
        return c;
    }
};
