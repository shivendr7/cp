/*
https://practice.geeksforgeeks.org/problems/range-minimum-query/1/

Given an array A[ ] and its size N your task is to complete two functions  a constructST  function which builds the segment tree  and a function RMQ which finds range minimum query in a segment tree .

Input:
The task is to complete two functions constructST and RMQ .
The constructST function builds the segment tree and takes two arguments the array A[ ] and the size of the array N .
It returns a pointer to the first element of the segment tree array . 
The RMQ function takes 4 arguments the first being the segment tree st constructed, second being the size N and then third and forth arguments are the range of query a and b .The function RMQ returns the min of the elements in the array from index range a and b. There are multiple test cases. For each test case, this method will be called individually.

Output:
The function RMQ should return the min element in the array from range a to b .

Constraints:
1<=T<=100
1<=N<=10^3+1
1<=Q(no of queries)<=10000
0<=a<=b
Example:
Input (To be used only for expected output) 
1
4
1 2 3 4
2
0 2 2 3

Output
1 3

Explanation
1. For query 1 ie 0 2 the element in this range are 1 2 3 and the min element is 1  
2. For query 2 ie 2 3 the element in this range are 3 4 and the min element is 3
*/
//Basics
class GfG
{
    static int st[];
    public static void build(int a[], int ss, int se, int si) {
        if(ss==se) {
            st[si]=a[ss];
            return;
        }
        int m=(ss+se)>>1;
        build(a, ss, m, 2*si+1);
        build(a, m+1, se, 2*si+2);
        st[si]=Math.min(st[2*si+1], st[2*si+2]);
    }
    
    public static int[] constructST(int arr[], int n)
    {
        // Add your code here
        st=new int[4*n+1];
        build(arr, 0, n-1, 0);
        return st;
    }
    
    public static int query(int ss, int se, int qs, int qe, int si) {
        if(qe<ss || qs>se) {
            return Integer.MAX_VALUE;
        }
        if(ss>=qs && se<=qe) {
            return st[si];
        }
        int m=(ss+se)>>1;
        return Math.min(
            query(ss, m, qs, qe, 2*si+1),
            query(m+1, se, qs, qe, 2*si+2)
            );
    }
    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int st[], int n, int l, int r)
    {
       // Add your code here
       st=st;
       return query(0, n-1, l, r, 0);
    }
}

// In 2*N space (fastest)
#include <bits/stdc++.h>

int *constructST(int a[],int n){
    int *tree = new int[n<<1];
    for (int i=0; i<n; i++) tree[n+i] = a[i];
    for (int i=n-1; i>=0; i--) tree[i] = min(tree[i<<1], tree[(i<<1)+1]);
    return tree;
}

int query(int *t, int n, int l, int r) {
    int minimum = INT_MAX;
    for (l+=n, r+=n; l<r; l>>=1, r>>=1) {
        if (l & 1) minimum = min(minimum, t[l++]);
        if (r & 1) minimum = min(minimum, t[--r]);
    }
    return minimum;
}

int RMQ(int st[] , int n, int l, int r){
    return query(st, n, l, r+1);
}
