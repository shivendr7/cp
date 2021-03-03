//sol
class Solution 
{ 
    static int Search(int a[], int target)
	{
	    // code here
	    int i=binarySearch(a,0,a.length-1,target);
	    return i;
	    
	}
	static int binarySearch(int a[],int start,int end,int key) {
	    int mid=(start+end)>>1;
	    
	    boolean leftsorted=false,rightsorted=false;
	    if(start>end) return -1;
	    
	    if(a[mid]>a[start]) leftsorted=true;
	    if(a[mid]<a[end]) rightsorted=true; 
	    
	    if(a[mid]==key) return mid;
	    if(rightsorted) {
	        if(a[mid]<key && a[end]>=key) {
	            return binarySearch(a,mid+1,end,key);
	        }
	        else {
	            return binarySearch(a,start,mid-1,key);
	        }
	    }
	    else if(leftsorted) {
	        if(a[mid]>key && a[start]<=key) {
	            return binarySearch(a,start,mid-1,key);
	        }
	        else {
	            return binarySearch(a,mid+1,end,key);
	        }
	    }
	    else {
	        return -1;
	    }
	}
} 
