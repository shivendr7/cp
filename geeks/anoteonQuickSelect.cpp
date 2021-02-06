/*
Given an array and a number k where k is smaller than size of array,
we need to find the k’th smallest element in the given array.
It is given that all array elements are distinct.

Must view: https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
*/
//sol
int kthSmallest(int a[], int beg, int end, int k) {
    //code here
    
    
    priority_queue<int> mxhp;
    for(int i=beg;i<=end;i++){
        mxhp.push(a[i]);
        if(mxhp.size()>k){
            mxhp.pop();
        }
    }
    return mxhp.top();
    }
