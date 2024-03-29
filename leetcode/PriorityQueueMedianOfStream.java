/*
https://www.youtube.com/watch?v=EcNbRjEcb14
https://leetcode.com/problems/find-median-from-data-stream/
https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1/

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 

Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
*/
//sol
class MedianFinder {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    /** initialize your data structure here. */
    public MedianFinder() {
        max=new PriorityQueue<>(Collections.reverseOrder());
        min=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max.isEmpty()||max.peek()>num) {
            max.add(num);
        }
        else {
            min.add(num);
        }
        if(max.size()>min.size()+1) {
            min.add(max.poll());
        }
        else if(min.size()>max.size()+1) {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size()==min.size()) {
            return (max.peek()+min.peek())/2.0;
        }
        else if(max.size()>min.size()) {
            return 1.0*(max.peek());
        }
        else {
            return 1.0*min.peek();
        }
    }
}
//sol2 same thing! complicated XD
class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    public MedianFinder() {
    }
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        return (minHeap.peek() + maxHeap.peek()) / 2.0d;
    }
}
