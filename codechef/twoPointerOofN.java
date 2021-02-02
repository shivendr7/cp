/*     ********Two Pointer Approach O(n)********

https://www.geeksforgeeks.org/maximum-water-that-can-be-stored-between-two-buildings/

Geek wants to make a special space for candies on his bookshelf. 
Currently, it has N books of different heights and unit width. 
Help him select 2 books such that he can store maximum candies between
them by removing all the other books from between the selected books.
The task is to find out the area between 2 books that can hold the maximum
candies without changing the original position of selected books.

Input: N = 3, height[] = {1, 3, 4}
Output: 1
Explanation:
1. Area between book of height 1 and book of 
height 3 is 0 as there is no space between 
them.
2. Area between book of height 1 and book of 
height 4 is 1 by removing book of height 3.
3. Area between book of height 3 and book of 
height 4 is 0 as there is no space between them.

Input: N = 6, height[] = {2, 1, 3, 4, 6, 5}
Output: 8
Explanation: We remove the 4 books in the middle 
creating length = 4 for the candy dam. Height 
for dam will be min(2,5) = 2. Area between book 
of height 2 and book of height 5 is 2 x 4 = 8.


*/

class Solution 
{ 
	static int maxCandy(int a[], int n) 
	{ 
	    // Your code goes here.
	    int M=0;
	    int i=0,j=n-1;
	    while(i<j) {
	        int s=a[i]>a[j]?a[j]:a[i];
	        int area=s*(j-i-1);
	        if(M<area) M=area; 
	        if(a[i]<a[j]) i++;
	        else j--;
	    }
	    return M;
	}
}
