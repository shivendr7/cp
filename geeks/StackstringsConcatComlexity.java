/*
*****Normal concat operation takes O(n) time....

Given a string S and an integer K, the task is to reduce the string by applying the following operation:
Choose a group of K consecutive identical characters and remove them. The operation can be performed any number of times until it is no longer possible.

Example 1:

Input:
K = 2
S = "geeksforgeeks"
Output:
gksforgks
Explanation:
Modified String after each step: 
"geegsforgeeks" -> "gksforgks"
Example 2:

Input:
K = 2
S = "geegsforgeeeks" 
Output:
sforgeks
Explanation:
Modified String after each step:
"geegsforgeeeks" -> "ggsforgeks" -> "sforgeks"
Your Task:  
You don't need to read input or print anything. Complete the function Reduced_String() which takes integer K and string S as input parameters and returns the reduced string.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

Constraints:
1 ≤ |S| ≤ 105
1 ≤ K ≤ |S|


*/
//sol

class Solution
{
    public static String reduced_String(int k, String s)
    {
        // Your code goes here
        Stack<Character> chstack=new Stack<>();
        Stack<Integer> f=new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if(chstack.empty()) {
                chstack.push(ch);
                f.push(1);
                continue;
            }
            if(f.peek()==k) {
                chstack.pop();
                f.pop();
            }
            if(chstack.empty()) {
                chstack.push(ch);
                f.push(1);
                continue;
            }
            if(ch==chstack.peek()) {
                int top=f.pop();
                top++;
                f.push(top);
            }
            else {
                chstack.push(ch);
                f.push(1);
            }
        }
        if(!f.empty()&&f.peek()==k) {
            f.pop();
            chstack.pop();
        }
        char ans[]=new char[s.length()];
        int ind=0;
        while(!f.empty()) {
            char ch=chstack.pop();
            int top=f.pop();
            int i=0;
            while(i<top) {
                ans[ind++]=ch;
                i++;
            }
        }
        char fin[]=new char[ind];
        int ind1=0;
        for(int i=ind-1;i>=0;i--) {
            fin[ind1++]=ans[i];
        }
        return String.valueOf(fin);
    }
    
}
