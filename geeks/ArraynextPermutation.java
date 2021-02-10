/*

link: https://practice.geeksforgeeks.org/problems/next-permutation5226/1#


Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.

Example 1:

Input: N = 6
arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explaination: The next permutation of the 
given array is {1, 2, 4, 3, 5, 6}.
Example 2:

Input: N = 3
arr = {3, 2, 1}
Output: {1, 2, 3}
Explaination: As arr[] is the last permutation. 
So, the next permutation is the lowest one.
Your Task:
You do not need to read input or print anything. Your task is to complete the function nextPermutation() which takes N and arr[ ] as input parameters and returns a list of numbers containing the next permutation.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 100 
*/
//sol
class Solution{
    static List<Integer> nextPermutation(int N, int a[]){
        // code here
        int k=a.length-2;
        for(;k>=0;k--) {
            if(a[k]<a[k+1]) break;
        }
        
        if(k<0) {
            rev(a,0,a.length-1);
            ArrayList<Integer> ans=new ArrayList<>();
            for(int i=0;i<a.length;i++) {
                ans.add(a[i]);
            }
            return ans;
        }
        int l=a.length-1;
        for(;l>=0;l--) {
            if(a[k]<a[l]) break;
        }
        
        int temp=a[k];
        a[k]=a[l];
        a[l]=temp;
        
        rev(a,k+1,a.length-1);
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<a.length;i++) {
            ans.add(a[i]);
        }
        return ans;
    }
    static void rev(int a[],int start,int end) {
        if(start>=end) return;
        for(int i=0;i<(start+end)/2+1-start;i++) {
            try {
            int temp=a[start+i];
            a[start+i]=a[end-i];
            a[end-i]=temp;
            }
            catch(Exception e) {
                System.out.println(i+" "+start+" "+end);
            }
        }
    }
}
