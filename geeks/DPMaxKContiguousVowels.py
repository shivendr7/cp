"""
https://practice.geeksforgeeks.org/problems/7b9d245852bd8caf8a27d6d3961429f0a2b245f1/1#

Find the number of unique words consisting of lowercase alphabets only of length N that can be formed with at-most K contiguous vowels. 


Example 1:

Input:
N = 2
K = 0
Output:
441
Explanation:
Total of 441 unique words are possible
of length 2 that will have K( =0) vowels
together, e.g. "bc", "cd", "df", etc are
valid words while "ab" (with 1 vowel) is
not a valid word.

Example 2:

Input:
N = 1
K = 1
Output:
26
Explanation:
All the english alphabets including
vowels and consonants; as atmost K( =1)
vowel can be taken.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function kvowelwords() which takes an Integer N, an intege K and returns the total number of words of size N with atmost K vowels. As the answer maybe to large please return answer modulo 1000000007.


Expected Time Complexity: O(N*K)
Expected Auxiliary Space: O(N*K)


Constraints:
1 ≤ N ≤ 1000
0 ≤ K ≤ N
"""
#sol

class Solution:
    def kvowelwords(self, N,K):
		# code here
		mod = 10**9 + 7
        dp = [1]
        dpp = [1]
        for _ in range(K):
            dpp.append((dpp[-1] * 5) % mod)
        for i in range(1, N + 1):
            tot = 0
            for j in range(min(i + 1, K + 1)):
                count = dpp[j]
                if i > j:
                    count = (count * 21 * dp[i - j - 1]) % mod
                tot = (tot + count) % mod
            dp.append(tot)
        return dp[-1]


"""
int kvowelwords(int n, int k)
     {
      vector<vector<ll>>dp(n+1,vector<ll>(k+1,1));
      for(int i=1;i<=n;i++)
      {
          for(int j=0;j<=k;j++)
          {
              if(j==0) dp[i][j]=21*dp[i-1][k]%mod;
              else  dp[i][j]=(5*dp[i-1][j-1]%mod+21*dp[i-1][k]%mod)%mod;
          }
      }
      return dp[n][k];
  }
"""
