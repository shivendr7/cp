/*

Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 

Follow up: Can you solve it in O(n) time complexity?


Solution using Stack
The idea behind this approach is also based on selective sorting. We need to determine the correct position of the minimum and the maximum element in the unsorted subarray to determine the boundaries of the required unsorted subarray.

To do so, in this implementation, we make use of a stackstack. We traverse over the numsnums array starting from the beginning. As we go on facing elements in ascending order(a rising slope), we keep on pushing the elements' indices over the stackstack. This is done because such elements are in the correct sorted order(as it seems till now). As soon as we encounter a falling slope, i.e. an element nums[j]nums[j] which is smaller than the element on the top of the stackstack, we know that nums[j]nums[j] isn't at its correct position.

In order to determine the correct position of nums[j]nums[j], we keep on popping the elemnents from the top of the stackstack until we reach the stage where the element(corresponding to the index) on the top of the stackstack is lesser than nums[j]nums[j]. Let's say the popping stops when the index on stackstack's top is kk. Now, nums[j]nums[j] has found its correct position. It needs to lie at an index k + 1k+1.

We follow the same process while traversing over the whole array, and determine the value of minimum such kk. This marks the left boundary of the unsorted subarray.

Similarly, to find the right boundary of the unsorted subarray, we traverse over the numsnums array backwards. This time we keep on pushing the elements if we see a falling slope. As soon as we find a rising slope, we trace forwards now and determine the larger element's correct position. We do so for the complete array and thus, determine the right boundary.

We can look at the figure below for reference. We can observe that the slopes directly indicate the relative ordering. We can also observe that the point bb needs to lie just after index 0 marking the left boundary and the point aa needs to lie just before index 7 marking the right boundary of the unsorted subarray.



Without Stack
The idea behind this method is that the correct position of the minimum element in the unsorted subarray helps to determine the required left boundary. Similarly, the correct position of the maximum element in the unsorted subarray helps to determine the required right boundary.

Thus, firstly we need to determine when the correctly sorted array goes wrong. We keep a track of this by observing rising slope starting from the beginning of the array. Whenever the slope falls, we know that the unsorted array has surely started. Thus, now we determine the minimum element found till the end of the array numsnums, given by minmin.

Similarly, we scan the array numsnums in the reverse order and when the slope becomes rising instead of falling, we start looking for the maximum element till we reach the beginning of the array, given by maxmax.

Then, we traverse over numsnums and determine the correct position of minmin and maxmax by comparing these elements with the other array elements. e.g. To determine the correct position of minmin, we know the initial portion of numsnums is already sorted. Thus, we need to find the first element which is just larger than minmin. Similarly, for maxmax's position, we need to find the first element which is just smaller than maxmax searching in numsnums backwards.

We can take this figure for reference again:

Unsorted_subarray

We can observe that the point bb needs to lie just after index 0 marking the left boundary and the point aa needs to lie just before index 7 marking the right boundary of the unsorted subarray.

*/

//mysol
class Solution {
    public int findUnsortedSubarray(int[] n) {
        int l=n.length;
        int start=0,end=l-1;
        int s=-1;
        for(int i=1;i<l;i++) {
            if(n[i-1]>n[i]) {
                if(s==-1) {
                    s=i-1;
                }
                start=s;
                while(start>=0&&n[start]>n[i]) {
                    start--;
                }
                if(s!=start) {
                    s=start+1;
                }
            }
        }
        int e=l;
        for(int i=l-2;i>=0;i--) {
            if(n[i+1]<n[i]) {
                if(e==l) {
                    e=i+1;
                }
                end=e;
                while(end<l&&n[end]<n[i]) {
                    end++;
                }
                if(e!=end) {
                    e=end-1;
                }
            }
        }
        System.out.println(s+" "+e);
        if(e-s+1>l) return 0; 
        return e-s+1;
    }
}


/*
Python SOl
class Solution:
    def findUnsortedSubarray(self, a: List[int]) -> int:
        l=0;r=len(a)-1
        m=max(a);M=min(a)
        st=0;nd=-1
        
        while r>=0:
            if a[l]>=M:
                M=a[l]
            else:
                nd=l
            
            if a[r]<=m:
                m=a[r]
            else:
                st=r
            
            l+=1
            r-=1
            
        return nd-st+1
*/
