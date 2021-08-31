/*
https://www.interviewbit.com/problems/maximum-consecutive-gap/

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.

*/
//sol
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        
        if (A.size() < 2) {
            return 0;
        }
        int min = A.get(0);
        int max = A.get(0);
        
        for (int i = 0; i < A.size(); i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }
        
        double gap = (double) A.size() / (max - min);
        
        if (gap == 0) {
            return (max-min);
        }
        
        //System.out.println("gap is: " + gap);
        
        ArrayList<Integer> minList = new ArrayList<Integer>();
        ArrayList<Integer> maxList = new ArrayList<Integer>();
        for (int i = 0; i < A.size()+1; i++) {
            minList.add(-1);
            maxList.add(-1);
        }
        
        for (int i = 0; i < A.size(); i++) {
            int curr = A.get(i);
            int index = (int) ((curr - min)* gap);
           
            if (minList.get(index) == -1) {
                minList.set(index, curr);
            }   
            else {
                minList.set(index, Math.min(curr, minList.get(index)));
            }
            maxList.set(index, Math.max(maxList.get(index), curr));
        }
        int result = 0;
        int start = 0;
        
        while (start < A.size()+1) {
            
            if (minList.get(start) == -1 && maxList.get(start) == -1) {
                start++;
            }
            
            else {
                int currDiff = maxList.get(start) - minList.get(start);
                result = Math.max(result,currDiff);
                
                int j = start + 1;
                int t_max = maxList.get(start);
                
                while (j < A.size() + 1 && minList.get(j) == -1) {
                    j++;
                }
                
                if (j < A.size()+1) {
                    int n_diff = minList.get(j) - t_max;
                    result = Math.max(result, n_diff);
                }
                
                start = j;
            }
        }
        
        return result; 
    }
}
