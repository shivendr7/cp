//sol
/*
stragegy : https://www.educative.io/courses/grokking-coding-interview-patterns-java/N0J0qzNQ1X2

Things to note: 
1. Array will either be left sorted or right sorted
2. We will move either in left half or right half
3. We move in any half only if target lies in that half


*/
class Solution 
{ 
    public static int binarySearchRotated(List<Integer> nums, int target) {
      
      // Write your code here
      int lo = 0, hi = nums.size()-1;
      while (lo<=hi) {
         int mid = (lo + hi)>>1;
         if (nums.get(mid) == target) 
            return mid;
         if (nums.get(lo) < nums.get(mid)) { // left sorted
            if (nums.get(lo) <= target && nums.get(mid) > target) { // in range and mid > target
               hi = mid-1;
            } else {
               lo = mid+1;
            }
         } else { // right sorted
            if (nums.get(hi) >= target && nums.get(mid) < target) { // in range and mid < target
               lo = mid+1;
            } else {
               hi = mid-1;
            }
         }
      }
      
      return -1;
   }
} 
