/*
https://practice.geeksforgeeks.org/problems/1df2447c003940512562d766cf0583bbdc7a75ed/1#

Given an array numbers[] of N positive integers and a positive integer X, The task is to find the number of ways that X can be obtained by writing pair of integers in the array numbers[] next to each other. In other words, find the number of ordered pairs (i,j) such that i != j and X is the concatenation of numbers[i] and numbers[j]

Example 1:

Input:
N = 4 
numbers[] = {1, 212, 12, 12}
X = 1212
Output:
3
Explanation:
We can obtain X=1212 by concatenating:
numbers[0] = 1 with numbers[1] = 212
numbers[2] = 12 with numbers[3] = 12
numbers[3] = 12 with numbers[2] = 12
Example 2:

Input: 
N = 3
numbers[] = {11, 11, 110}
X = 11011
Output:
2
Explanation:
We can obtain X=11011 by concatenating:
numbers[2] = 110 with numbers[0] = 11
numbers[2] = 110 with numbers[1] = 11
Your Task:
You dont need to read input or print anything. Your task is to complete the function countPairs() which takes the integer N , the integer X, and the array numbers[] as the input parameters, and returns the number of pairs which satisfies the above condition.

Expected Time Complexity: O(N*Log10(A[i]) + (Log10X)2)
Expected Auxiliary Space: O(N*Log10(A[i]))

Constraints:
1 ≤ N ≤ 5*104 
1 ≤ numbers[] ≤ 109
1 ≤ X ≤ 109
*/
//sol
class Solution 
{ 
    long countPairs(int N, int x, int numbers[]) 
    { 
        // code here 
        Map<String, Integer> mp=new HashMap<>();
        for(int i: numbers){
            mp.put(Integer.toString(i), mp.getOrDefault(Integer.toString(i), 0)+1);
        }
        String st=Integer.toString(x);
        long cnt=0;
        
        for(int i=1; i<st.length(); i++){
            String fs=st.substring(0, i);
            String ss=st.substring(i);
            if(mp.containsKey(fs) && mp.containsKey(ss)){
                if(fs.equals(ss)){
                    int k=mp.get(fs);
                    cnt+=(long)(k*(k-1));
                }else{
                    cnt+=(long)(mp.get(fs)*mp.get(ss));
                }
            }
        }
        return cnt;
    }
} 
