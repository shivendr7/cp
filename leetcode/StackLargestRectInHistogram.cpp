/*
The min-product of an array is equal to the minimum value in the array multiplied by the array's sum.

For example, the array [3,2,5] (minimum value is 2) has a min-product of 2 * (3+2+5) = 2 * 10 = 20.
Given an array of integers nums, return the maximum min-product of any non-empty subarray of nums. Since the answer may be large, return it modulo 109 + 7.

Note that the min-product should be maximized before performing the modulo operation. Testcases are generated such that the maximum min-product without modulo will fit in a 64-bit signed integer.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,3,2]
Output: 14
Explanation: The maximum min-product is achieved with the subarray [2,3,2] (minimum value is 2).
2 * (2+3+2) = 2 * 7 = 14.
Example 2:

Input: nums = [2,3,3,1,2]
Output: 18
Explanation: The maximum min-product is achieved with the subarray [3,3] (minimum value is 3).
3 * (3+3) = 3 * 6 = 18.
Example 3:

Input: nums = [3,1,5,6,4,2]
Output: 60
Explanation: The maximum min-product is achieved with the subarray [5,6,4] (minimum value is 4).
4 * (5+6+4) = 4 * 15 = 60.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 107
*/
//sol
class Solution {
public:
    int maxSumMinProduct(vector<int>& nums) {
        
      int n =nums.size();
      stack<int>st1;//prev min
      stack<int>st2;//next min
      vector<int>prev(n,-1);
      vector<int>next(n,-1);
      
      vector<long long int>pre(n+1,0);
      
      for(int i=0;i<n;i++){
       
          pre[i+1]=pre[i]+nums[i];
        
        
        if(st1.empty()){
           st1.push(i);
        }else{
        while(!st1.empty() && nums[i]< nums[st1.top()]){
          st1.pop();
        }
        if(!st1.empty()){
          prev[i]=st1.top();
        }
        st1.push(i);
        }
        
        if(st2.empty()){
          st2.push(i);
        }else{
    
          while(!st2.empty() && nums[i]< nums[st2.top()]){
          next[st2.top()]=i;
          st2.pop();
        }
          st2.push(i);
        
        
        }
        
      }
      int s,e;
      long long int ans=0;
      for(int i=0;i<n;i++){
        if(next[i]==-1){
          e=n-1;
        }else{
          e=next[i]-1;
        }
        
        if(prev[i]==-1){
          s=0;
        }else{
          s=prev[i]+1;
        }
        
        ans= max(ans, 1ll*nums[i] * (pre[e+1]-pre[s]) );
   
        
      }
    
      return ans%1000000007;
      
    }
};

/*
https://leetcode.com/problems/min-stack/

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.

*/
//sol   https://leetcode.com/problems/min-stack/discuss/49031/Share-my-Java-solution-with-ONLY-ONE-stack
