/*
Given a set of m distinct positive integers and a value ‘N’. Count the total number of ways we can form ‘N’ by  adding the array elements. Repetitions and different arrangements are allowed.
Note: Answer can be quite large output the answer modulo 109+7.

Example 1:

Input:
m = 3 , N = 7
Arr[] = {1,5,6}
Output: 6
Explanation: The different ways are:
1+1+1+1+1+1+1
1+1+5
1+5+1
5+1+1
1+6
6+1

â€‹Example 2:

Input: 
m = 3 , N = 3
Arr[] = {1,2,3}
Output: 4
Explanation: The different ways are:
1+1+1
1+2
2+1
3  

Your Task:
You don't need to read input or print anything. Your task is to complete the function countWays() which accepts array arr[], its size m and integer N and returns the total number of ways we can form ‘N’ by adding array elements.


Expected Time Complexity: O(N*m)
Expected Auxiliary Space: O(N)


Constraints:
1 <= N , m <= 103
*/
//sol
class Solution
{
    public int countWays(int arr[], int m, int n) 
    { 
       //code here..
        int dp[]=new int[n+1];
        dp[0]=1;
        //coin loop inside sum loop suggests for how many times a coin can be used in a sum
        for(int i=1;i<=n;i++) {
            for(int j=0;j<m;j++) {
                if(i>=arr[j])
                dp[i]=(dp[i]+dp[i-arr[j]])%1000000007;
            }
        }
        return dp[n];
    } 
}
