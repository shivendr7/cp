/*
https://practice.geeksforgeeks.org/problems/55dbfdc246f3f62d6a7bcee7664cacf6be345527/1

Given a string str, find the minimum characters to be added at front of the string to make it a palindrome.


Example 1:

Input:
str = ABCD
Output: 3
Explanation: The resultant string 
after adding 3 characters is DCBABCD.
The minimum possible answer is 3.
Example 2:

Input:
str = ABA
Output: 0
Explanation: The given string
is already a palindrome.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function addMinChar() which takes the string str as input parameters and returns the minimum number of characters to be added to make it a palindrome.


Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)


Constraints:
1 ≤  |str| ≤ 105
str contains only uppercase english alphabets


*/
// sol
class Solution
{
	public static int addMinChar(String str){
		//code here 
		int c = 0, i = 0, j = str.length()-1;
		while (i<j) {
		    if (str.charAt(i) == str.charAt(j)) {
		        i++; j--;
		    } else {
		        c++;
		        i=0;
		        j = str.length()-1-c;
		    }
		}
		return c;
	}
}
