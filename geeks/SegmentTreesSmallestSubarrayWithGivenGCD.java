/*
https://practice.geeksforgeeks.org/problems/smallest-sub-array4107/1/


Given an integer G and an array arr[] of size N, find the length of the minimum subarray whose Greatest Common Divisor equals to G.

Example 1:

Input:
N = 8
arr[] = {6, 9, 7, 10, 12, 24, 36, 27}
G = 3
Output: 2
Explanation: GCD of subarray {6,9} is 3.
GCD of subarray {24, 36, 27} is also 3,
but {6, 9} is the smallest.

Example 2:

Input:
N = 6
Arr[] = {9, 12, 15, 24, 36, 27}
G = 2
Output: -1
Explanation: GCD 2 is not possible from 
any subarray from the given array.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findSmallestSubArr() which takes arr[], n and g as input parameters and returns length of minimum subarray. Return -1 if no such subarray is possible.


Expected Time Complexity: O(N * (logN)2)
Expected Auxiliary Space: O(N * logN) 


Constraints:
1 <= N <= 104
1 <= arr[i] <= 105
1 <= G <= 100
*/
//sol
class Solution {
    int gcd(int a,int b){
         if(b==0)
            return a;
         return gcd(b,a%b);
     }
     int find(int st[],int s,int e,int qs,int qe,int index){
         if(s>qe || e<qs)
            return 0;
         if(qs<=s && qe>=e)
            return st[index];
         int mid=(s+e)/2;
         return gcd(find(st,s,mid,qs,qe,2*index+1),find(st,mid+1,e,qs,qe,2*index+2));
     }
     
     void construct(int arr[],int st[],int s,int e,int index){
         if(s==e){
             st[index]=arr[s];
             return;
         }
         int mid=(s+e)/2;
         construct(arr,st,s,mid,2*index+1);
         construct(arr,st,mid+1,e,2*index+2);
         st[index]=gcd(st[2*index+1],st[2*index+2]);
     }
    int findSmallestSubArr(int[] arr, int n, int g) {
        // code here
        if(n==1){
            if(arr[0]==g){
                return 1;
            }
            else{
                return -1;
            }
        }
        else{
            int flag=0;
            int res=n+1;
            for(int i=0;i<n;i++){
                if(arr[i]==g){
                    return 1;
                }
            }
            for(int i=0;i<n;i++){
                if(arr[i]%g==0)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                return -1;
            else{
                int x=(int)Math.ceil(Math.log(n)/Math.log(2));
                int m=(int)(2*Math.pow(2,x))-1;
                int st[]=new int[m];
                
                construct(arr,st,0,n-1,0);
                for(int i=0;i<n-1;i++){
                    if(arr[i]%g!=0)
                        continue;
                    int low=i+1;
                    int high=n-1;
                    int closest=0;
                    while(true){
                        int mid=(low+high)/2;
                        int gcd=find(st,0,n-1,i,mid,0);
                        if(gcd>g)
                        low=mid;
                        else if(gcd==g)
                        {
                            high=mid;
                            closest=mid;
                            break;
                        }
                        else{
                            high=mid;
                        }
                        if(Math.abs(high-low)<=1){
                             if(find(st,0,n-1,i,low,0) == g) 
                              closest = low; 
                             else if(find(st,0,n-1,i,high,0)==g) 
                              closest = high; 
                              break; 
                        }
                    }
                    if(closest != 0) 
                   res = Math.min(res, closest - i + 1);
                }
                return (res == n+1) ? -1 : res; 
            }
        }
    }
}
