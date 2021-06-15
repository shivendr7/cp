/*
Comments needed to be seen
link-https://practice.geeksforgeeks.org/problems/player-with-max-score/1/
variant- DPstonegamevii.py in the leetcode folder
https://uploads.disquscdn.com/images/0c34568e3ca545fa40b68facf0fb7c5fd4f40656c7b0c9175c239d8f82c22fa0.png
https://uploads.disquscdn.com/images/aa8f735c609add718ead5c1a300736cc00beef5672bc6b20e2379a5a31447506.png
https://uploads.disquscdn.com/images/f00a857d8e5718f41bace0fab2566ccf2e9362c4c374982caeb819a0ccf32526.png

Given an array arr of non-negative integers of size N, 2 players are playing a game. In each move, a player chooses an element from either end of the array, and the size of the array shrinks by one. Both players take alternate chances and the game continues until the size of the array becomes 0. Every time a player chooses an array element the array value is added to the player's score. At the end player with maximum score wins.
You have to predict whether player 1 will win the game or not. Both players will play optimally.
 

Example 1:

Input:
N = 3
arr[] = {2,6,3}
Output:
0 
Explanation:
Initially, player 1 can choose between 2 and 3. 
If he chooses 3 (or 2), then player 2 can choose 
from 2 (or 3) and 6. If player 2 chooses 6,
then player 1 will be left with 2 (or 3). 
So, final score of player 1 is 2 + 3 = 5,
and player 2 is 6. 
Hence, player 1 will never be the winner and 
output is 0.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function is1winner() which takes the array arr[], its size N and returns true if player 1 is the winner and false otherwise.
The driver code itself prints 1 if returned value is true and 0 otherwise.


Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N)


Constraints:
1 <= N <= 1000
0<= arr[i] <= 105
*/
//sol
class Solution{
    
    static Boolean is1winner(int N, int arr[]){
        int dp[][]=new int[N][N];
        for(int i=0;i<N;i++) dp[i][i]=arr[i];
        boolean minFirst=false;
        if(N%2==0) minFirst=true;
        for(int l=2;l<=N;l++) {
            for(int i=0;i<=N-l;i++) {
                int j=i+l-1;
                if(minFirst && l%2==0) {
                    dp[i][j]=Math.max(arr[i]+dp[i+1][j], arr[j]+dp[i][j-1]);
                }
                else if(!minFirst && l%2==1) {
                    dp[i][j]=Math.max(arr[i]+dp[i+1][j], arr[j]+dp[i][j-1]);
                }
                else {
                    dp[i][j]=Math.min(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        int s=0;
        for(int i=0;i<N;i++)    
            s+=arr[i];
        return dp[0][N-1]*2>=s;
    }
}
