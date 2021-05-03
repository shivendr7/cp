/*
Given an array of integers of size N find minimum xor of any 2 elements.


Example 1:

Input:
N = 3
arr[] = {9,5,3}
Output: 6
Explanation: 
There are 3 pairs -
9^5 = 12
5^3 = 6
9^3 = 10
Therefore output is 6.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function minxorpair() which takes the array arr[], its size N as input parameters and returns the minimum value of xor of any 2 elements.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
1 <= arr[i] <= 105
*/
// sol O(nlogn) using a[i]^a[i-1] after sort
static int minxorpair(int N, int A[])
{
    int minXOR = 1234567890;
    Arrays.sort(A);
    for (int i=1; i < N; i++)
        minXOR = Math.min(A[i-1] ^ A[i] , minXOR);
    return minXOR;
}
//sol O(n) using trie
class Node {
    Node left;
    Node right;
}

class Solution{
    static Node root;
    static void insert(int d) {
        Node temp=root;
        for(int i=31;i>=0;i--) {
            int bit=(d>>i)&1;
            if(bit==1) {
                if(temp.right==null) {
                    temp.right=new Node();
                }
                temp=temp.right;
            }
            else {
                if(temp.left==null) {
                    temp.left=new Node();
                }
                temp=temp.left;
            }
        }
    }
    static int xor_so_far(int d) {
        Node temp=root;
        int xor=0;
        for(int i=31;i>=0;i--) {
            int bit=(d>>i)&1;
            if(bit==0) {
                if(temp.left!=null) temp=temp.left;
                else {
                    temp=temp.right;
                    xor+=(1<<i);
                }
            }
            else {
                if(temp.right!=null) temp=temp.right;
                else {
                    temp=temp.left;
                    xor+=(1<<i);
                }
            }
        }
        return xor;
    }
    
    static int minxorpair(int N, int A[]){
        // code here
        root=new Node();
        int min=Integer.MAX_VALUE;
        insert(A[0]);
        int cur=0;
        for(int i=1;i<N;i++) {
            cur=xor_so_far(A[i]);
            insert(A[i]);
            min=Math.min(cur, min);
        }
        return min;
    }
}
