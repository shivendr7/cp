/*
link:https://www.geeksforgeeks.org/next-smaller-element/

Professor X wants his students to help each other in the chemistry lab. He suggests that every student should help out a classmate who scored less marks than him in chemistry and whose roll number appears after him. But the students are lazy and they don't want to search too far. They each pick the first roll number after them that fits the criteria. Find the marks of the classmate that each student picks.
Note: one student may be selected by multiple classmates.

Example 1:

Input: N = 5, arr[] = {3, 8, 5, 2, 25}
Output: 2 5 2 -1 -1
Explanation: 
1. Roll number 1 has 3 marks. The first person 
who has less marks than him is roll number 4, 
who has 2 marks.
2. Roll number 2 has 8 marks, he helps student 
with 5 marks.
3. Roll number 3 has 5 marks, he helps student 
with 2 marks.
4. Roll number 4 and 5 can not pick anyone as 
no student with higher roll number has lesser 
marks than them. This is denoted by -1.
Output shows the marks of the weaker student that 
each roll number helps in order. ie- 2,5,2,-1,-1

Example 2:

Input: N = 4, a[] = {1, 2, 3, 4}
Output: -1 -1 -1 -1 
Explanation: As the marks ars in increasing order. 
None of the students can find a classmate who has 
a higher roll number and less marks than them.
Your Task:  
You don't need to read input or print anything. Complete the function help_classmate() which takes the array arr[] and size of array N as input parameters and returns a list of numbers. If a student is unable to find anyone then output is -1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 106
*/
//sol

class Solution {
	public static int[] help_classmate(int a[], int n) 
	{ 
	    // Your code goes here
	    Stack<Integer> seq=new Stack<>();
	    seq.push(0);
	    for(int i=1;i<n;i++) {
	        while(!seq.empty()&&a[i]<a[seq.peek()]) {
	            a[seq.peek()]=a[i];
	            seq.pop();
	        }
	        seq.push(i);
	    }
	    while(!seq.empty()) {
	        a[seq.peek()]=-1;
	        seq.pop();
	    }
	    return a;
	} 
}

/*
https://practice.geeksforgeeks.org/problems/mila-and-strings0435/1/

Given a string S consisting of only lowercase characters. Find the lexicographically smallest string after removing k characters from the string. But you have to correct the value of k, i.e., if the length of the string is a power of 2, reduce k by half, else multiply k by 2.
NOTE: If it is not possible to remove k (the value of k after correction) characters or if the resulting string is empty return -1.

Example 1:

Input: S = "fooland", k = 2
Output: "and" 
Explanation: As the size of the string = 7
which is not a power of 2, hence k = 4.
After removing 4 characters from the given 
string, the lexicographically smallest
string is "and".
Example 2:

Input: S = "code", k = 4
Output: "cd"
Explanation: As the length of the string = 4, 
which is 2 to the power 2, hence k = 2.
Hence, lexicographically smallest string after 
removal of 2 characters is "cd".

Your Task:  
You dont need to read input or print anything. Complete the function lexicographicallySmallest() which takes S and k as input parameters and returns the lexicographically smallest string after removing k characters.

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n)

Constraints:
1<= |S| <=1000
1<= k <= 1000
*/
class Solution {
    static String lexicographicallySmallest(String S, int k) {
        // code here
         int l=S.length();
	     if((l & (l-1))==0){
	         k=k/2;
	     }
	     else{
	         k=2*k;
	     }
	     
	     if(k>l){
	         return "-1";
	     }
	     
	     Stack<Character> stack=new Stack<Character>();
	     
	     int i=0;
	     char peek,ch;
	     while(k>0){
	         if(stack.isEmpty()){
	             stack.push(S.charAt(i));
	         }
	         else{
	             ch=S.charAt(i);
	             peek=stack.peek();
	             while(k>0 && peek > ch && !stack.isEmpty()){
	                 stack.pop();
	                 if(!stack.isEmpty()){
    	                 peek=stack.peek();
    	              }
    	             k--;
	             }
	             stack.push(ch);
	         }
	         i++;
	         if(i==l){
	             while(k>0){
	                 stack.pop();
	                 k--;
	             }
	         }
	     }
	     
	     while(i<l){
	         stack.push(S.charAt(i));
	         i++;
	     }
	     String res="";
	     while(!stack.isEmpty()){
	         res=stack.pop()+res;
	     }
	     
	     if(res.equals("")){
	         return "-1";
	     }
	     return res;
    }
}
