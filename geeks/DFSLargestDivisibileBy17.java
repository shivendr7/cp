/*
https://practice.geeksforgeeks.org/problems/largest-divisibility-test3444/1/
Must see- Comments in question and "http://www.savory.de/maths1.htm"

Babul’s favourite number is 17. He likes the numbers which are divisible by 17. This time what he does is that he takes a number n and tries to find the largest number which is divisible by 17, by rearranging the digits. As the number increases he gets puzzled with his own task. So you as a programmer have to help him to accomplish his task.

Note: If the number is not divisible by rearranging the digits, then return “Not Possible”. n may have leading zeros.

Example 1:

Input: n = 17
Output: 17
Explanation: 17 is the largest number 
which is also divisible by 17. 

Example 2:

Input: n = 15
Output: 51
Explanation: 51 is the largest number
which is also divisible by 17.

Your Task:  
You dont need to read input or print anything. Complete the function largestDivisible() which takes n as input parameter and returns the largest number which is divisible by 17.

Expected Time Complexity: O(|n|*|n|!), where |n| denoting length of n.
Expected Auxiliary Space: O(1)

Constraints:
1<= n <=1010
*/
//sol
class Solution {
    
    Integer max = Integer.MIN_VALUE;//global
    
    String largestDivisible(String n){ //O(n*n!)
        
        getPermutations(n,0); //O(n!) --- n factorial
        
        return max == Integer.MIN_VALUE ? "Not Possible" : max.toString();
    }
    
    void getPermutations(String s,int index){
        
        if(index >= s.length()){
            Integer t = Integer.parseInt(s); //O(n)
            if(t%17 == 0){
                max = Math.max(max,t);
            }
            return;
        }
        
        for(int i=index;i<s.length();i++){
            s = swap(s,index,i);
            getPermutations(s,index+1);
            s = swap(s,i,index);
        }
    }
    
    String swap(String s,int index,int i){
        
        char[] arr = s.toCharArray();
        char t = arr[index];
        arr[index] = arr[i];
        arr[i] = t;
        return new String(arr);
    }
}
