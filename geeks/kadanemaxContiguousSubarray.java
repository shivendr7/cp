/*
First see
: https://www.geeksforgeeks.org/almost-prime-numbers/

Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
*/
class Kadane{
    
    // Function to find subarray with maximum sum
    // arr: input array
    // n: size of array
    int maxSubarraySum(int a[], int n){
        
        // Your code here
    int tillnow = a[0];
    int curr = a[0];

    for (int i = 1; i < n; i++)
    {
    curr = a[i]>a[i]+curr?a[i]:a[i]+curr;
    tillnow = tillnow>curr?tillnow:curr;
    }
    return tillnow;

    }
    
}
