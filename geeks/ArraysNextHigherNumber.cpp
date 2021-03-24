/*
Given a palindromic number N in the form of string. The task is to find the smallest palindromic number greater than N using the same set of digits as in N.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains a number N as input.

Output:
For each test case, print the next higher palindromic number possible. If no such number can be formed then print "-1".

Constraints:
1<=T<=500
1<=|Number length |<=104

Example:
Input:
2
35453
33

Output:
53435
-1
*/
//sol
#include<bits/stdc++.h>
using namespace std;
string nextPalindrome(string v){
    
    int n=v.length();
    int mid=(n/2)-1;
    int pos=-1;
    
    // Find a no that is less than it's next starting from mid
    for(int i=mid;i>=1;i--){
        
        if(v[i-1]<v[i]){
            pos=i-1;
            break;
        }
        
    }
    if(pos==-1){
        return "-1";
    }
    
    // Find a least no from pos+1 to mid that is greater than no at the pos
    int numPos=-1;
    for(int i=pos+1;i<=mid;i++){
        if(v[i]>v[pos]){
           
           if(numPos==-1){
               numPos=i;
           }
           else{
               if(v[i]<v[numPos]){
                   numPos=i;
               }
           }
           
        }
    }
    // Swap the numbers at pos and numPos
    swap(v[pos],v[numPos]);
    
    // Now sort the numbers from pos+1 to mid
    sort(v.begin()+pos+1,v.begin()+mid+1);
    
    // Now mirror the same no from 0 to mid ---> to depends on length odd or even
    int i=0;
    int j=n-1;
    while(i<=mid){
        v[j]=v[i];
        i++;
        j--;
    }
    return v;
}
int main(){

    int t;
    cin>>t;
    while(t--){
    
       string s;
       cin>>s;
       cout<<nextPalindrome(s)<<endl;
    }
}
