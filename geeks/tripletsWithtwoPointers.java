/*
Given an array arr of size N and an integer K. Find if there's a triplet in the array which sums up to the given integer K.

Input:
N = 6, K = 13
arr[] = [1 4 45 6 10 8]
Output:
true
Explanation:
The triplet {1, 4, 8} in 
the array sums up to 13.


Hint:
Using the two-pointer theorm, we can find out a pair with a given sum in an array in O(n) 
(start iteratijng one pointer from the beginning and other from the end). 
Can we use this idea to solve this problem in O(n2) time?
For any element arr[i], if we're able to find a pair with sum X-arr[i], we're done. How can we do this?

*/
//Sol
class TripletSum
{
    // arr[] : The input Array
    // N : Size of the Array
    // X : Sum which you need to search for 
    
    public static int find3Numbers(int a[], int N, int X) { 
    
       // Your code Here
        quicksort(a,0,N-1);
        
        int i=N-1;
        while(a[i]>X) {
            i--;
        }
        
        if(i<2) return 0;
        int j=0;
        for(j=0;j<i;j++) {
            int p=j+1,q=i;
            while(p<q) {
                //System.out.println(a[p]+" "+a[q]+" "+a[i]);
                if(a[p]+a[q]+a[j]==X) {
                    //System.out.print(a[p]+" "+a[q]+" "+a[i]);
                    return 1;
                }
                if(a[p]+a[q]+a[j]>X) q--;
                else p++;
            }
        } 
        return 0;
    }
    public static void quicksort(int a[],int beg,int end) {
        int pivot=end;int i=beg;
        if(beg>end) return;
        while(i<pivot) {
            if(a[i]>a[pivot]) {
                int temp=a[pivot];
                a[pivot]=a[i];
                a[i]=temp;
                
                temp=a[pivot-1];
                a[pivot-1]=a[i];
                a[i]=temp;
                
                pivot--;
            }
            else
            i++;
        }
        quicksort(a,pivot+1,end);
        quicksort(a,beg,pivot-1);
    }
}

/* Count Triplets
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
N = 4
arr[] = {1, 5, 3, 2}
Output: 2
Explanation: There are 2 triplets: 
1 + 2 = 3 and 3 +2 = 5 


*/
//Sol
class Solution {
    int countTriplet(int a[], int n) {
        // code here
        quicksort(a,0,n-1);
        int c=0;
        if(n<3) return 0;
        for(int i=0;i<n;i++) {
            int j=i+1;int k=i+2;
            while(j<n&&k<n) {
                //System.out.println(a[i]+" "+a[j]+" "+a[k]);
                if(a[i]+a[j]==a[k]) c++;
                if(a[i]+a[j]>a[k]) k++;
                else j++;
            }
        }
        return c;
    }
    void quicksort(int a[],int beg,int end) {
        int pivot=end; int i=beg;
        if(beg>end) return;
        while(i<pivot) {
            if(a[i]>a[pivot]) {
                int temp=a[i];
                a[i]=a[pivot];
                a[pivot]=temp;
                
                temp=a[pivot-1];
                a[pivot-1]=a[i];
                a[i]=temp;
                
                pivot--;
            }
            else i++;
            
        }
        quicksort(a,pivot+1,end);
        quicksort(a,beg,pivot-1);
    }
}
