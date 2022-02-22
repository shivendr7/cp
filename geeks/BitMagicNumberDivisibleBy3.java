/*
https://practice.geeksforgeeks.org/problems/is-binary-number-multiple-of-30654/1/

Given a binary number, Find, if given binary number is a multiple of 3. The given number can be big upto 2^10000. It is recommended to finish the task using one
traversal of input binary string.

Example 1:

Input: S = "011"
Output: 1
Explanation: "011" decimal equivalent
is 3, which is divisible by 3.
â€‹Example 2:

Input: S = "100"
Output: 0
Explanation: "100" decimal equivalent
is 4, which is not divisible by 3.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function isDivisible() which takes the string s as inputs and returns 1 if the given 
number is divisible by 3 otherwise 0.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |S| ≤ 105


*/
class Solution {
    int isDivisible(String s) {
        // code here
        int odd = 0, even = 0;
        int n = s.length();
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '1'){
                if((i+1)%2==0){
                    even++;
                }
                else{
                    odd++;
                }
            }
        }
        if((even-odd)%3 == 0)
            return 1;
        else
            return 0;

    }
}
