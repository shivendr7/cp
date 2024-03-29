"""
https://leetcode.com/problems/stone-game-vii/
https://www.youtube.com/watch?v=OETxKEIi1Gw&list=PLEvw47Ps6OBCOkEO2QrbywrfEIZ0J30N3&index=7

Alice and Bob take turns playing a game, with Alice starting first.

There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or the rightmost stone from the row and receive points
equal to the sum of the remaining stones' values in the row. The winner is the one with the higher score when there are no stones left to remove.

Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's difference. Alice's goal is to maximize the
difference in the score.

Given an array of integers stones where stones[i] represents the value of the ith stone from the left, return the difference in Alice and Bob's score if
they both play optimally.

 

Example 1:

Input: stones = [5,3,1,4,2]
Output: 6
Explanation: 
- Alice removes 2 and gets 5 + 3 + 1 + 4 = 13 points. Alice = 13, Bob = 0, stones = [5,3,1,4].
- Bob removes 5 and gets 3 + 1 + 4 = 8 points. Alice = 13, Bob = 8, stones = [3,1,4].
- Alice removes 3 and gets 1 + 4 = 5 points. Alice = 18, Bob = 8, stones = [1,4].
- Bob removes 1 and gets 4 points. Alice = 18, Bob = 12, stones = [4].
- Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = [].
The score difference is 18 - 12 = 6.
Example 2:

Input: stones = [7,90,5,1,100,10,10,2]
Output: 122
 

Constraints:

n == stones.length
2 <= n <= 1000
1 <= stones[i] <= 1000
"""
"""
Idea:
Like most of the Stone Game problems, this one boils down to a system of ever-repeating subproblems, as the there are many different ways to get to the same board
condition as we move towards the end of the game. This naturally points to a dynamic programming (DP) solution.

In order to represent the different board positions, we'd normally build an N * N DP matrix where N is the length of the stones array (S). In this DP array, dp[i][j]
would represent the best score difference with i representing the leftmost remaining stone's index and j representing the rightmost remaining stone's index.

Since we're using a top-down DP approach, we'll start at i = N - 2 and iterate backwards and start each nested for loop at j = i + 1. This ensures that we're 
building the pyramid of DP results downward, always starting each row with i and j next to each other.

For each row, we'll keep track of the sum total of the stones in the range [i,j] by adding S[j] at each iteration of j. Then, we can represent the current player's
ideal play by choosing the best value between picking the stone at i (total - S[i]) and picking the stone at j (total - S[j]). For each option, we have to also subtract
the best value that the other player will get from the resulting board position (dp[i+1][j] or dp[i][j-1]).

Since we will only be building off the current and previously-finished rows, however, we can actually eliminate the DP matrix and instead just define two N-length
arrays representing the current and previous rows (dpCurr, dpLast), and swap between them at each iteration of i. This will drop the space complexity from O(N^2) to O(N).

At the end, the solution will be the value stored in the DP array representing the board position with all stones present. We should therefore return dpCurr[N-1].

Time Complexity: O(N^2) where N is the length of S
Space Complexity: O(N) for the two dp arrays

"""
class Solution:
    def stoneGameVII(self, S: List[int]) -> int:
        N = len(S)
        dpCurr, dpLast = [0] * N, [0] * N
        for i in range(N - 2, -1, -1):
            total = S[i]
            dpLast, dpCurr = dpCurr, dpLast
            for j in range(i + 1, N):
                total += S[j]
                dpCurr[j] = max(total - S[i] - dpLast[j], total - S[j] - dpCurr[j-1])
        return dpCurr[-1]
      
      class Solution {
public:
	// BOTTOM-UP DP
    int get(int l,int r,vector<int>& stones){
        if(l)
            return stones[r]-stones[l-1];
        return stones[r];
    }
    int stoneGameVII(vector<int>& stones) {
        int n = stones.size();
        // find the prefix sum so that we can get sum in a segment easily
        for(int i=1;i<n;i++)
            stones[i]+=stones[i-1];
        int dp[n][n];
        memset(dp,0,sizeof(dp));
        for(int len=2;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                int j = i + len - 1;
                // working on segment[i,j]
                // if stones[i] is choosen
                int ans1 = get(i+1,j,stones)-dp[i+1][j];
                // if stones[j] is choosen
                int ans2 = get(i,j-1,stones)-dp[i][j-1];
                dp[i][j] = max(ans1,ans2);
            }
        }
        return dp[0][n-1];
    }
};
class Solution {
public:
	// TOP-DOWN DP
    int dp[1001][1001];
    int recurse(int l,int r,vector<int>& stones,int sum){
        if(l==r)
            return 0;
        if(dp[l][r]!=-1)
            return dp[l][r];
        // take stones[l]
        int ans1 = sum - stones[l] - recurse(l+1,r,stones,sum-stones[l]);
        // take stones[r]
        int ans2 = sum - stones[r] - recurse(l,r-1,stones,sum-stones[r]);
        return dp[l][r] = max(ans1,ans2);
    }
    int stoneGameVII(vector<int>& stones) {
        memset(dp,-1,sizeof(dp));
        int sum = accumulate(stones.begin(),stones.end(),0);
        return recurse(0,stones.size()-1,stones,sum);
    }
};

"""
https://leetcode.com/problems/stone-game/

Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.

Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.

 

Example 1:

Input: piles = [5,3,4,5]
Output: true
Explanation: 
Alex starts first, and can only take the first 5 or the last 5.
Say he takes the first 5, so that the row becomes [3, 4, 5].
If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 

Constraints:

2 <= piles.length <= 500
piles.length is even.
1 <= piles[i] <= 500
sum(piles) is odd.
"""
#sol
def stoneGame(self, p):
        n = len(p)
        dp = p[:]
        for d in range(1, n):
            for i in range(n - d):
                dp[i] = max(p[i] - dp[i + 1], p[i + d] - dp[i])
        return dp[0] > 0

/*
https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1/

You are given an array A of size N. The array contains integers and is of even length. The elements of the array represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.

In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.

You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.

Example 1:

Input:
N = 4
A[] = {5,3,7,10}
Output: 15
Explanation: The user collects maximum
value as 15(10 + 5)
Example 2:

Input:
N = 4
A[] = {8,15,3,7}
Output: 22
Explanation: The user collects maximum
value as 22(7 + 15)
Your Task:
Complete the function maximumAmount() which takes an array arr[] (represent values of N coins) and N as number of coins as a parameter and returns the maximum possible amount of money you can win if you go first.

Expected Time Complexity : O(N*N)
Expected Auxiliary Space: O(N*N)

Constraints:
2 <= N <= 103
1 <= Ai <= 106
*/
//sol
class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        // Your code here
        long me=0, opp=0;
        long dp[][]=new long[n][n];
        
        for(int i=0;i<n;i++) dp[i][i]=arr[i];
        
        for(int d=1;d<n;d++) {          //gap
            for(int i=0;i<n-d;i++) {    //iter
                int j=i+d;
                if(d==1) {
                    dp[i][j]=Math.max(arr[i], arr[j]);
                }
                else {
                    long v1=arr[i]+Math.min(dp[i+2][j], dp[i+1][j-1]);
                    long v2=arr[j]+Math.min(dp[i][j-2], dp[i+1][j-1]);
                    dp[i][j]=Math.max(v1, v2);
                }
            }
        }
        return dp[0][n-1];
    }
}
