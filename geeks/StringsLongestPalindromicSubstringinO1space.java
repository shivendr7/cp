/*
link-https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string1956/1/?category[]=Strings&category[]=Strings&difficulty[]=1&page=1&query=category[]Stringsdifficulty[]1page1category[]Strings
Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index ).


Example 1:

Input:
S = "aaaabbaa"
Output:
aabbaa
Explanation:
The longest palindrome string present in
the given string is "aabbaa".

Your Task:  
You don't need to read input or print anything. Your task is to complete the function longestPalindrome() which takes string S as input parameters and returns longest pallindrome present in string.


Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ |S| ≤ 104
*/
//sol
class Solution{
    String longestPalindrome(String S){
        // code here
        String longest="";
        int L=-1;
        int n=S.length();
        for(int i=0;i<n-1;i++) {
            int ei=i,ej=i+1;
            String longest_e="";
            while(ei>=0&&ej<n&&S.charAt(ei)==S.charAt(ej)) {
                longest_e=S.charAt(ei)+longest_e+S.charAt(ej);
                if(ej-ei>L) {
                    longest=longest_e;
                    L=ej-ei;
                }
                ei--;
                ej++;
            }
        }
        for(int i=1;i<n-1;i++) {
            int ei=i-1,ej=i+1;
            String longest_o=""+S.charAt(i);
            while(ei>=0&&ej<n&&S.charAt(ei)==S.charAt(ej)) {
                longest_o=S.charAt(ei)+longest_o+S.charAt(ej);
                if(ej-ei>L) {
                    longest=longest_o;
                    L=ej-ei;
                }
                ei--;
                ej++;
            }
        }
        if(longest.length()==0) {
            longest=S.charAt(0)+"";
        }
        return longest;
    }
}
