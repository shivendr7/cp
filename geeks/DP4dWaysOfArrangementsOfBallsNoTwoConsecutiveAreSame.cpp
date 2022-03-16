/*
https://practice.geeksforgeeks.org/problems/arrange-balls0052/1/

There are p balls of type P, q balls of type Q and r balls of type R. Using the balls we want to create a straight line such that no two balls of same type are adjacent.
 

Example 1:

Input: p = 2, q = 2, r = 2
Output: 30
Explanation: There are 30 possible arrangements
of balls. Some of them are PQR, PRQ, PRP, PRQ,
PQR,...
Example 2:

Input: p = 1, q = 1, r = 1
Output: 6
Explanation: There are 6 possible arrangements
and these are PQR, PRQ, QPR, QRP, RPQ, RQP.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function CountWays() which takes count of P type balls, Q type balls and R type balls and returns total number of possible arrangements such that no two balls of same type are adjacent modulo 109 + 7.
 

Expected Time Complexity: O(N3) where N = max(p, q, r)
Expected Space Complexity: O(N3)
 

Constranits: 
1 <= p, q, r <= 100
*/
//sol

#define max 101
#define mod 1000000007
long long int dp[max][max][max][3];
class Solution{
	public:
	 
long long int count(int p,int q,int r,int last){
	    if(p<0|| q<0 || r<0)return 0;
	    if(p==1 && q==0 && r==0 && last==0)return 1;
	    if(p==0 && q==1 && r==0 && last==1)return 1;
	    if(p==0 && q==0 && r==1 && last==2)return 1;
	    if(dp[p][q][r][last]!=-1)return dp[p][q][r][last];
	    if(!last)
	     dp[p][q][r][last]=(count(p-1,q,r,1)%mod+count(p-1,q,r,2)%mod)%mod;
	     else if(last==1)
	     dp[p][q][r][last]=(count(p,q-1,r,0)%mod+count(p,q-1,r,2)%mod)%mod;
	     else 
	     dp[p][q][r][last]=(count(p,q,r-1,0)%mod+count(p,q,r-1,1)%mod)%mod;
	     return  dp[p][q][r][last]%mod;
	}
	
long long int CountWays(int p, int q, int r) {
	   
	    memset(dp,-1,sizeof(dp));
	    return (count(p,q,r,0)%mod+count(p,q,r,1)%mod+count(p,q,r,2)%mod)%mod;
	}
};


/*
https://practice.geeksforgeeks.org/problems/geek-and-its-colored-strings1355/1/

Find the count of all possible strings of size n.Each character of the string is either ‘R’, ‘B’ or ‘G’. In the final string there needs to be at least r number of ‘R’, at least b number of ‘B’ and at least g number of ‘G’ (such that r + g + b <= n). 

Example 1:

Input: n = 4, r = 1, g = 1, b = 1
Output: 36 
Explanation: No. of 'R' >= 1, 
No. of ‘G’ >= 1, No. of ‘B’ >= 1 
and (No. of ‘R’) + (No. of ‘B’) 
+ (No. of ‘G’) = n then 
following cases are possible: 
1. RBGR and its 12 permutation 
2. RBGB and its 12 permutation 
3. RBGG and its 12 permutation 
Hence answer is 36.
Example 2:

Input: n = 4, r = 2, g = 0, b = 1
Output: 22
Explanation: No. of 'R' >= 2,
No. of ‘G’ >= 0, No. of ‘B’ >= 1
and (No. of ‘R’) + (No. of ‘B’)
+ (No. of ‘G’) <= n then 
following cases are possible:
1. RRBR and its 4 permutation
2. RRBG and its 12 permutation
3. RRBB and its 6 permutation
Hence answer is 22.

Your Task:  
You dont need to read input or print anything. Complete the function possibleStrings() which takes n, r, g, b as input parameter and returns the count of number of all possible strings..

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n)

Constraints:
1<= n <=20
1<= r+b+g <=n
*/
//sol
class Solution:
    def possibleStrings(ob, n, r, b, g):
        # code here 
        fact = [0 for i in range(n+1)]
        fact[0]=1
        for i in range (1,n+1,1):
            fact[i]=fact[i-1]*i
        left = n-(r+g+b)
        sum=0
        for i in range(0, left + 1, 1):
            for j in range(0, left - i + 1, 1):
                k = left - (i + j)
                sum = (sum + fact[n] // (fact[i + r] * fact[j + b] * fact[k + g]))
        return sum
