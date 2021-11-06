/*
https://leetcode.com/problems/single-number-iii/

Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

 

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]
 

Constraints:

2 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each integer in nums will appear twice, only two integers will appear once.

*/
//sol
class Solution {
    public int[] singleNumber(int[] nums) {
        int axorb=0;
        for(int i:nums) {
            axorb^=i;
        }
        //int i1=(int)(Math.log(axorb)/Math.log(2));
        int rightset=axorb & -axorb; //right most set bit
        int a=0;
        for(int i:nums) {
            if((i&rightset)!=0)
                a^=i;    
                //System.out.println(i);
            
        }
        //System.out.println(axorb+" "+ i1+" "+a);
        int ans[]={a, axorb^a};
        return ans;
    }
}
