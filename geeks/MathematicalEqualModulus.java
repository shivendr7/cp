/*
https://practice.geeksforgeeks.org/problems/k-modulus-array-element0255/1

Given an array of n integers. We need to count all values of ‘k’ such that

arr[0] % k = arr[1] % k = ....... = arr[n-1] % k 
 

Example 1:

Input:
N=3
arr[] = {38, 6, 34} 
Output: 3
Explanation:
We can have values of k as 
1, 2 and 4.  

Example 2:

Input:
N=2
arr[] = {3, 2} 
Output: 1

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function printEqualModNumbers() that takes array arr and integer n as parameters and returns the desired output.
Note- If values of k are infinite return -1.

 

Expected Time Complexity: O(N3/2).
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ N ≤ 105

*/
//sol
class Solution
{ 
    static int printEqualModNumbers (int arr[], int n) 
    { 
        if(n==1)  return -1;
        
          int min=arr[0];
          int max=arr[0];
          
          for(int i=1;i<n;i++)
          {
              min=Math.min(min,arr[i]);
              max=Math.max(max,arr[i]);
              
          }
          
          ArrayList<Integer>ans=new ArrayList<>();
          
          for(int i=1;i*i<=max-min;i++)
          {
              if(((max-min)%i)==0)
                {
                    ans.add(i);
                    if(i!=(max-min)/i)
                    ans.add((max-min)/i);
                }
              
          }
          
          int r=0;
          
          for(int e:ans)
          {
              boolean is=true;
              for(int i=1;i<n;i++)
              {
                  if((arr[i-1]%e)!=(arr[i]%e))
                  {
                      is=false;
                      break;
                  }      
                    
              }
              if(is)
                 r++;
          }
          
          return r;
    }
}
