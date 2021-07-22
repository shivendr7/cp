/*
https://practice.geeksforgeeks.org/problems/element-left-after-performing-alternate-or-xor-operation5106/1/

Given an array A of N integers and a 2D matrix denoting q queries. Each query consists of two elements, index and value. Update value at index in A for each query and then perform the following operations to get the result for that query.
1. Perform bitwise OR on each pair 
2. Perform bitwise XOR on each pair 
Do this alternately till you are left with only a single element in A. 


Example 1:

Input: 
N = 4
A = {1, 4, 5, 6}
q = 2
query = {{0, 2}, {3, 5}}

Output: 1 3

Explaination: 
1st query: 
Update the value of A[0] to 2 as given in 
the query pair.The array becomes {2, 4, 5, 6}.
1st iteration: Perform bitwise OR on pairs 
{2,4} and {5,6}. The array becomes {6,7}.
2nd iteration: Perform bitwise XOR on pairs 
{6,7}. The array becomes {1}.


2nd query: 
Update the value of A[3] to 5 as given in 
the query pair. The array becomes {2, 4, 5, 5}.
1st iteration: Perform bitwise OR on pairs 
{2,4} and {5,5}. The array becomes {6,5}.
2nd iteration: 6^5=3. The array becomes {3}.


Your Task:
You do not need to read input or print anything. Your task is to complete the function left() which takes N, A[], q and query as input parameters and returns a list of integers denoting the result for each query.


Expected Time Complexity:O(q*logN)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 105
1 ≤ q ≤ 104
*/
//sol
class Solution{
    
    static int st[];
    static void build(int a[], int ss, int se, int si,int level[]) {
        if(ss>se) return;
        if(ss==se) {
            st[si]=a[ss];
            level[si]=0;
            return;
        }
        int m=(ss+se)>>1;
        build(a, ss, m, 2*si+1, level);
        build(a, m+1, se, 2*si+2, level);
        level[si]=level[2*si+1]+1;
        if(level[si]%2==1) {
            st[si]=st[2*si+1]|st[2*si+2];
        }
        else {
            st[si]=st[2*si+1]^st[2*si+2];
        }
    }
    static void update(int ss, int se, int si, int i, int v, int level[]) {
        if(ss==se) {
            st[si]=v;
            return;
        }
        int m=(ss+se)>>1;
        if(m<i) {
            update(m+1, se, 2*si+2, i, v, level);
        }
        else {
            update(ss, m, 2*si+1, i, v, level);
        }
        
        if(level[si]%2==1) {
            st[si]=st[2*si+1]|st[2*si+2];
        }
        else {
            st[si]=st[2*si+1]^st[2*si+2];
        }
    }
    static List<Integer> left(int N, int A[], int q, int query[][])
    {
        // code here
        st=new int[4*N+1];
        int level[]=new int[4*N+1];
        build(A, 0, N-1, 0, level);
        
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<q;i++) {
            update(0, N-1, 0, query[i][0], query[i][1], level);
            ans.add(st[0]);
        }
        return ans;
    }
}
