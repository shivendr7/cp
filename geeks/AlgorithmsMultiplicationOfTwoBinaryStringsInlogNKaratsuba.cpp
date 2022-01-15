/*
https://practice.geeksforgeeks.org/problems/karatsuba-algorithm0135/1/

Given two binary strings that represent value of two integers, find the product of two strings. For example, if the first bit string is "1100" and second 
bit string is "1010", output should be 120.




For simplicity, let the length of two strings be same and be n.




A Naive Approach is to follow the process we study in school. One by one take all bits of second number and multiply it with all bits of first number. 
Finally add all multiplications. This algorithm takes O(n^2) time.

Using Divide and Conquer, we can multiply two integers in less time complexity. We divide the given numbers in two halves. Let the given numbers be X and Y.




For simplicity let us assume that n is even 


X =  Xl*2n/2 + Xr    [Xl and Xr contain leftmost and rightmost n/2 bits of X]

Y =  Yl*2n/2 + Yr    [Yl and Yr contain leftmost and rightmost n/2 bits of Y]


The product XY can be written as following. 


XY = (Xl*2n/2 + Xr)(Yl*2n/2 + Yr)

   = 2n XlYl + 2n/2(XlYr + XrYl) + XrYr

If we take a look at the above formula, there are four multiplications of size n/2, so we basically divided the problem
of size n into four sub-problems of size n/2. But that doesn't help because solution of recurrence T(n) = 4T(n/2) + O(n) is O(n^2).
The tricky part of this algorithm is to change the middle two terms to some other form so that only one extra multiplication would
be sufficient. The following is tricky expression for middle two terms.  


XlYr + XrYl = (Xl + Xr)(Yl + Yr) - XlYl- XrYr

So the final value of XY becomes  


XY = 2n XlYl + 2n/2 * [(Xl + Xr)(Yl + Yr) - XlYl - XrYr] + XrYr

With above trick, the recurrence becomes T(n) = 3T(n/2) + O(n) and solution of this recurrence is O(n1.59).




What if the lengths of input strings are different and are not even? To handle the different length case, we append 0's in the beginning.
To handle odd length, we put floor(n/2) bits in left half and ceil(n/2) bits in right half. So the expression for XY changes to following.  


XY = 22ceil(n/2) XlYl + 2ceil(n/2) * [(Xl + Xr)(Yl + Yr) - XlYl - XrYr] + XrYr

The above algorithm is called Karatsuba algorithm and it can be used for any base. 


*/
//  code:  https://github.com/uysalemre/Analysis-of-Algorithms2/tree/master/Binary%20Multiplication
//  article: https://www.cdn.geeksforgeeks.org/multiply-large-numbers-represented-as-strings/
/*
References

http://en.wikipedia.org/wiki/Karatsuba_algorithm
http://www.flipkart.com/algorithms-1st-edition/p/itmczynvb7p2zacz?pid=9780070636613&affid=sandeepgfg (Algorithms 1st Edition by Sanjoy Dasgupta, Christos Papadimitriou and Umesh Vazirani )
http://courses.csail.mit.edu/6.006/spring11/exams/notes3-karatsuba
http://www.cc.gatech.edu/~ninamf/Algos11/lectures/lect0131.pdf
