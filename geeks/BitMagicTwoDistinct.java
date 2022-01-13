/*
https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1/

Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas the other two number occur exactly once and are distinct. Find the other two numbers.


Example 1:

Input: 
N = 2
arr[] = {1, 2, 3, 2, 1, 4}
Output:
3 4 
Explanation:
3 and 4 occur exactly once.
Example 2:

Input:
N = 1
arr[] = {2, 1, 3, 2}
Output:
1 3
Explanation:
1 3 occur exactly once.

Your Task:
You do not need to read or print anything. Your task is to complete the function singleNumber() which takes the array as input parameter and returns a list of two numbers which occur exactly once in the array. The list must be in ascending order.


Expected Time Complexity: O(N)
Expected Space Complexity: O(1)


Constraints:
1 <= length of array <= 106 
1 <= Elements in array <= 5 * 106

*/
//sol
class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here 
        
        int num = 0;
        for(int a : nums){
            num  = num ^ a;
        }
      
      /*
      need to find any set bit
      can also b done by: 
      
      for( auto it : nums )
            val ^= it ;

        set_bit = val - (val & val - 1) ;
    
        for( auto it : nums )
            if( it & set_bit )
                    a ^= it ;
        
        b = a ^ val ;
      */
      
      
        int res = -1;
        int i = 0;
        while(num > 0){
            if(num % 2 == 1){
                res = i;
                break;
            }
            num/= 2;
            i++;
        }
      
      
        int n1 = 0;
        int n2 = 0;
        for(int a : nums){
            if(((a >> i) & 1)==1)
                n1 = n1 ^ a;
            else
                n2 = n2 ^ a;
        }
        int ret[]={n1<n2?n1:n2, n1>n2?n1:n2};
        //sort(ret.begin(),ret.end());
        return ret;
        
    }
}


/*
https://practice.geeksforgeeks.org/problems/two-numbers-with-odd-occurrences5846/1/

Given an unsorted array, arr[] of size N and that contains even number of occurrences for all numbers except two numbers. Find the two numbers in decreasing order which has odd occurrences.

Example 1:

Input:
N = 8
Arr = {4, 2, 4, 5, 2, 3, 3, 1}
Output: {5, 1} 
Explaination: 5 and 1 have odd occurrences.

Example 2:

Input:
N = 6
Arr = {1 7 5 5 4 4}
Output: {7, 1}
Explaination: 7 and 1 have odd occurrences.

Your Task:
You don't need to read input or print anything. Your task is to complete the function twoOddNum() which takes the array Arr[] and its size N as input parameters and returns the two numbers in decreasing order which have odd occurrences.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ Arri ≤ 108



*/
class Solution{
    public:
    vector<int> twoOddNum(int Arr[], int N)  
    {
        // code here
         int Xor = 0, res1 = 0, res2 = 0;
       
       for(int i = 0; i < N; i++)
          Xor ^= Arr[i];
       
       int r_most_setBit = Xor & (~(Xor-1));      //to get rightmost set-bit 
       
       for(int i = 0; i < N; i++)
       {
           if((r_most_setBit & Arr[i]) != 0)      // group1 = corresponding bit as 1
              res1 = res1 ^ Arr[i];
           else                                        // group2 = corresponding bit as 0
              res2 = res2 ^ Arr[i];
       }
       
       if(res1 > res2)
          return {res1, res2};
       else
          return {res2, res1};

    }
};
