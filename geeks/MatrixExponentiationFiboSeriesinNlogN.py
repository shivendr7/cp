"""
https://practice.geeksforgeeks.org/problems/matrix-exponentiation2711/1/
https://www.geeksforgeeks.org/matrix-exponentiation/

Given an equation of the form f(n) = f(n-1) + f(n-2) where f(0) = 1, F(1) = 1 , the task is to find the nth term of this sequence.
 

Example 1:

Input: n = 3
Output: 3
Explanation: f(3) = f(2) + f(1) = 3

Example 2:

Input: n = 2
Output: 2
Explanation: f(2) = f(1) + f(0) = 2
 

Yout Task:
You don't need to read or print anything. Your task is to complete the function FindNthTerm() which takes n as input parameter and returns nth term mod 10^9+7 .


Expected Time Compelxity: O(log(n))
Expected Space Complexity: O(K) where K is constant.
 

Constraints:
1 <= n <= 109

"""
#sol
class Solution:
	
	
    def multiply(self, a, b):
        mod=10**9+7
        
        mul = [[0 for x in range(3)]
                  for y in range(3)]
        for i in range(3):
            for j in range(3):
                mul[i][j] = 0
                for k in range(3):
                    mul[i][j] =(mul[i][j] + (a[i][k] * b[k][j])%mod )%mod
     
        
        for i in range(3):
            for j in range(3):
                a[i][j] = mul[i][j] 
        return a
     
    
    def power(self, F, n):
        mod=10**9+7
        M = [[1, 1, 0], [1, 0, 0], [0, 1, 0]]
     
        
        if (n == 1):
            return (F[0][0]*2 + (F[0][1] + F[0][2])%mod )%mod
     
        self.power(F, int(n / 2))
     
        F = self.multiply(F, F)
     
        if (n % 2 != 0):
            F = self.multiply(F, M)
     
        
        return (F[0][0]*2 + (F[0][1] + F[0][2])%mod )%mod
    
    
    def FindNthTerm(self, n):
        if n==1 or n==2:
            return n
        F = [[1, 1, 0], [1, 0, 0], [0, 1, 0]]
        try:
            return self.power(F, n - 2)
        except Exception as e:
            print(e)
"""

JAVA
class Solution
{
    
    int mod=1000000007;
    public int FindNthTerm(int n)
    {
        // code here
        
        if(n==0) return 1;
        if(n==1||n==2) return n;
        int F[][] = {{1, 1, 0}, {1, 0, 0}, {0, 1, 0}};
     
        F=power(F, n-2);
        int f[]={2, 1, 1}; //f(2), f(1), f(0)
        int N=0;
        for(int i=0;i<3;i++) {
            N=(N+ (F[0][i]%mod*f[i]%mod)%mod )%mod;
        }
        return N;
    }
    public int[][] power(int[][] T,int n)
	{
	    if(n==1)
	    return T;
	    
	    if(n%2!=0)
	    return multiply(T, power(T, n-1));
	    else
	    {
	        int a[][]=power(T, n/2);
	        return multiply(a, a);
	    }
	}
	public int[][] multiply(int A[][], int B[][])
	{
	    int ans[][]=new int[3][3];
	    for(int i=0;i<3;i++)
	    {
	        for(int j=0;j<3;j++)
	        {
	            for(int k=0;k<3;k++)
	            {
	                ans[i][j]=(ans[i][j]+ (A[i][k]%mod*B[k][j]%mod)%mod )%mod;
	            }
	        }
	    }
	    return ans;
	}
}
"""
