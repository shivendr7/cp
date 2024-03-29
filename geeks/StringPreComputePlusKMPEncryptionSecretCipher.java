/*
https://practice.geeksforgeeks.org/problems/7a28dab3cd1a41839ca28cc33f05963c2654e9ff/1#
https://practice.geeksforgeeks.org/problems/cd4b48615a30999443b728a72de6cd5addbd0501/1/

Geek wants to send an encrypted message in the form of string S to his friend Keeg along with instructions on how to decipher the message. To decipher the message, his friend needs to iterate over the message string from left to right, if he finds a '*', he must remove it and add all the letters read so far to the string. He must keep on doing this till he gets rid of all the '*'.
Can you help Geek encrypt his message string S? 

Note: If the string can be encrypted in multiple ways, find the smallest encrypted string. 

Example 1:

Input: S = "ababcababcd"
Output: ab*c*d
Explanation: We can encrypt the string 
in following way : "ababcababcd" -> 
"ababc*d" -> "ab*c*d"
Example 2:

Input: S = "zzzzzzz"
Output: z*z*z
Explanation: The string can be encrypted 
in 2 ways: "z*z*z" and "z**zzz". Out of 
the two "z*z*z" is smaller in length.
Your Task: 
You don't need to read input or print anything. Complete the function secretCipher() which takes the message string S as input parameter and returns the shortest possible encrypted string.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints: 
1 ≤ |S| ≤ 105

*/
//sol
class Solution {
	public String compress(String s) {
		// Your code goes  here 
		int l=s.length();
		int kmp[]=new int[l]; 
		
		for(int i=1;i<l;i++) {
		    int j=kmp[i-1];
		    while(j>0 && s.charAt(i)!=s.charAt(j)) {
		        j=kmp[j-1];
		    }
		    if(s.charAt(i)==s.charAt(j)) {
		        j++;
		    }
		    kmp[i]=j;
		}
		
		String ans="";
		while(l>0) {
		    if(l%2==0) {
		        if(kmp[l-1]>=l/2 && l%(l-kmp[l-1])==0) {
		            ans="*"+ans;
		            l/=2;
		        }
		        else {
		            ans=s.charAt(l-1)+ans; // O(n*n) due to this *****
		            l--;
		        }
		    }
		    else {
		        ans=s.charAt(l-1)+ans;
		        l--;
		    }
		}
		return ans;
	}
}
