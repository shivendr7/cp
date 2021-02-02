/*
Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9 .

Input:
N = 9
Output:
10
Explanation:
After removing natural numbers which contains
digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10
and 9th number is 10.

Solution-(base-9)
*/
class Solution {
    long findNth(long N)
    {
        //code here
        
        long rem=N,q=N;
        long t=1;
        long ans=0;
        while(q>=9) {
            
            rem=q%9;
            q/=9;
            ans=rem*t+ans;
            t*=10;
        }
        ans=q*t+ans;
        //System.out.println(q+" "+rem);
        return(ans);
    }
}
