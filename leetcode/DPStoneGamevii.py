"""
https://leetcode.com/problems/stone-game-vii/
https://www.youtube.com/watch?v=OETxKEIi1Gw&list=PLEvw47Ps6OBCOkEO2QrbywrfEIZ0J30N3&index=7

Alice and Bob take turns playing a game, with Alice starting first.

There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or the rightmost stone from the row and receive points equal to the sum of the remaining stones' values in the row. The winner is the one with the higher score when there are no stones left to remove.

Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's difference. Alice's goal is to maximize the difference in the score.

Given an array of integers stones where stones[i] represents the value of the ith stone from the left, return the difference in Alice and Bob's score if they both play optimally.

 

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
Like most of the Stone Game problems, this one boils down to a system of ever-repeating subproblems, as the there are many different ways to get to the same board condition as we move towards the end of the game. This naturally points to a dynamic programming (DP) solution.

In order to represent the different board positions, we'd normally build an N * N DP matrix where N is the length of the stones array (S). In this DP array, dp[i][j] would represent the best score difference with i representing the leftmost remaining stone's index and j representing the rightmost remaining stone's index.

Since we're using a top-down DP approach, we'll start at i = N - 2 and iterate backwards and start each nested for loop at j = i + 1. This ensures that we're building the pyramid of DP results downward, always starting each row with i and j next to each other.

For each row, we'll keep track of the sum total of the stones in the range [i,j] by adding S[j] at each iteration of j. Then, we can represent the current player's ideal play by choosing the best value between picking the stone at i (total - S[i]) and picking the stone at j (total - S[j]). For each option, we have to also subtract the best value that the other player will get from the resulting board position (dp[i+1][j] or dp[i][j-1]).

Since we will only be building off the current and previously-finished rows, however, we can actually eliminate the DP matrix and instead just define two N-length arrays representing the current and previous rows (dpCurr, dpLast), and swap between them at each iteration of i. This will drop the space complexity from O(N^2) to O(N).

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
