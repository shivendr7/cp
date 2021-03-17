/*   ****DP in O(1) space
link-https://practice.geeksforgeeks.org/problems/total-decoding-messages1235/1/?company[]=Goldman%20Sachs&company[]=Goldman%20Sachs&page=2&query=company[]Goldman%20Sachspage2company[]Goldman%20Sachs#

A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and If there are leading 0’s, extra trailing 0’s and two or more consecutive 0’s then it is an invalid string.
 

Example 1:

Input: str = "123"
Output: 3
Explanation: "123" can be decoded as "ABC"(123),
"LC"(12 3) and "AW"(1 23).
Example 2:

Input: str = "27"
Output: 1
Explanation: "27" can be decoded as "BG".
 

Your Task:
You don't need to read or print anything. Your task is to complete the function CountWays() which takes the string as str as input parameter and returns the total number of ways the string can be decoded modulo 109 + 7.
 

Expected Time Complexity: O(n)
Expected Space Complexity: O(n) where n  = |str|

Constraints:
1 <= |str| <= 104

*/
//sol
class Solution
{
    public int CountWays(String s)
    {
        // code here
        int n=s.length();
        int mod=1000000007;
        int a=1,b=1;
        if(s.charAt(0)=='0') {
            return 0;
        }
        for(int i=2;i<=n;i++) {
            int c=0;
            if(s.charAt(i-1)>'0') {
                c=b%mod;
            }
            if(s.charAt(i-2)=='1'|| (s.charAt(i-2)=='2' && s.charAt(i-1)<'7')) {
                c=(c%mod+a%mod)%mod;
            }
            a=b;
            b=c;
        }
        return b;
    }
}
