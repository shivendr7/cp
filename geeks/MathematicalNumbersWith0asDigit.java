/*
https://practice.geeksforgeeks.org/problems/numbers-with-0-as-a-digit1336/1/

Given an integer N. The task is to count the number of integers from 1 to N(inclusive) which contain 0’s as a digit.


Example 1:

Input: N = 21
Output: 2
Explanation: All numbers are 10,20.

â€‹Example 2:

Input: N = 101
Output: 11
Explanation: All numbers are 10,20
30,40,50,60,70,80,90,100,101.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function countZero() which takes N as inputs and returns the answer.

Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N≤ 106
*/
//sol
class Solution{
    
    int count(int c){
        int i=c-2,j=1;
        int ans=0;
        while(i>=0){
            ans+=(int)(Math.pow(10,i) * Math.pow(9,j));
            i--;
            j++;
        }
        return ans;
    }
    
    int countZero(int n){
        //complete the function here
        int c=0;
        int m=n;
        while(m!=0){
            c++;
            m=m/10;
        }
        int ans=0;
        int nn=c;
        c--;
        while(c!=0){
            ans+=count(c);
            c--;
        }
        for(int i=nn;i>0;i--){
            int temp=count(i)/9;
            int a=(int)(n/Math.pow(10,i-1))%10 - 1;
            temp*=a;
            
            if(a>=0) 
                ans+=temp;
            else 
                ans+=0;
            if(i!=nn && a!=-1) 
                ans+=(int)Math.pow(10,i-1);
                
            if(a==-1){
                int p=(int)Math.pow(10,i-1);
                int t=n-(n/p)*p;
                ans+=t+1;
                break;
            }
        }
        return ans;
    }
}
