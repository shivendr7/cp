/*
Given a string S, the task is to count number of subsequences of the form aibjck, where i >= 1, j >=1 and k >= 1.

Note: 
1. Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.
2.  For large test cases, output value will be too large, return the answer MODULO 10^9+7

 

Example 1:

Input:
S = "abbc"
Output: 3
Explanation: Subsequences are abc, abc and abbc.
â€‹
Example 2:

Input: 
S = "abcabc"
Output: 7
Explanation: Subsequences are abc, abc,
abbc, aabc abcc, abc and abc.

Your Task:
You don't need to read input or print anything. Your task is to complete the function fun() which takes the string S as input parameter and returns the number of subsequences which follows given condition.


Expected Time Complexity: O(Length of String).
Expected Auxiliary Space: O(1) .


Constraints:
1 <= |S| <= 105

*/
/*
Approach
We traverse given string. For every character encounter, we do the following:

1) Initialize counts of different subsequences caused by different combination of ‘a’. Let this count be aCount.

2) Initialize counts of different subsequences caused by different combination of ‘b’. Let this count be bCount.

3) Initialize counts of different subsequences caused by different combination of ‘c’. Let this count be cCount.

4) Traverse all characters of given string. Do following for current character s[i]
    If current character is ‘a’, then there are following possibilities :
    a) Current character begins a new subsequence.
    b) Current character is part of aCount subsequences.
    c) Current character is not part of aCount subsequences.
    Therefore we do aCount = (1 + 2 * aCount);

    If current character is ‘b’, then there are following possibilities :
    a) Current character begins a new subsequence of b’s with aCount subsequences.
    b) Current character is part of bCount subsequences.
    c) Current character is not part of bCount subsequences.
    Therefore we do bCount = (aCount + 2 * bCount);

    If current character is ‘c’, then there are following possibilities :
    a) Current character begins a new subsequence of c’s with bCount subsequences.
    b) Current character is part of cCount subsequences.
    c) Current character is not part of cCount subsequences.
    Therefore we do cCount = (bCount + 2 * cCount);

5) Finally we return cCount;
*/
//sol
public int fun(String s)
    {
        // Write your code here
        long ac=0,bc=0,cc=0;
        for(long i=0;i<s.length();i++) {
            char ch=s.charAt((int)i);
            if(ch=='a') {
                ac=1+2*ac;
            }
            if(ch=='b') {
                bc=ac+2*bc;
            }
            if(ch=='c') {
                cc=bc+2*cc;
            }
        }
        long mod=(long)1e9+7;
        return ((int)(cc%mod));
    }
