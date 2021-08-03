"""
https://practice.geeksforgeeks.org/problems/pairs-of-non-coinciding-points4141/1/

In a given cartesian plane, there are N points. We need to find the Number of Pairs of  points(A, B) such that

Point A and Point B do not coincide.
Manhattan Distance and the Euclidean Distance between the points should be equal.
Note: Pair of 2 points(A,B) is considered same as Pair of 2 points(B ,A).
Manhattan Distance = |x2-x1|+|y2-y1|
Euclidean Distance   = ((x2-x1)^2 + (y2-y1)^2)^0.5, where points are (x1,y1) and (x2,y2).

 

Example 1:

Input:
N = 2
X = {1, 7}
Y = {1, 5}
Output:
0
Explanation:
None of the pairs of points have
equal Manhatten and Euclidean distance.
Example 2:

Input:
N = 3
X = {1, 2, 1}
Y = {2, 3, 3}
Output:
2
Explanation:
The pairs {(1,2), (1,3)}, and {(1,3), (2,3)}
have equal Manhatten and Euclidean distance.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numOfPairs() which takes an Integer N and two arrays X, and Y of length N as input and returns the number of pairs with equal Manhattan and Euclidean Distance. (X[i], Y[i]) denotes a point.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
 -10^9 <= X[i], Y[i] <= 10^9

"""
#sol
from collections import defaultdict
class Solution:
    def numOfPairs(self, x, y, n):
        # code here 
        X = defaultdict(lambda:0) 

        # To store Frequency of all distinct Yi 
        Y = defaultdict(lambda:0) 
    
        # To store Frequency of all distinct 
        # points (Xi, Yi) 
        XY = defaultdict(lambda:0) 
        
        for i in range(0, n): 
            xi = x[i]
            yi = y[i] 
    
            # Hash xi coordinate 
            X[xi] += 1
    
            # Hash yi coordinate 
            Y[yi] += 1
    
            # Hash the point (xi, yi) 
            XY[(xi, yi)] += 1
        
        xAns, yAns, xyAns = 0, 0, 0
        
        # find pairs with same Xi 
        for xCoordinatePair in X: 
            xFrequency = X[xCoordinatePair]
    
            # calculate ((xFrequency) C2) 
            sameXPairs = (xFrequency * 
                         (xFrequency - 1)) // 2
            xAns += sameXPairs 
        
        # find pairs with same Yi 
        for yCoordinatePair in Y: 
            yFrequency = Y[yCoordinatePair] 
    
            # calculate ((yFrequency) C2) 
            sameYPairs = (yFrequency * 
                         (yFrequency - 1)) // 2
            yAns += sameYPairs 
    
        # find pairs with same (Xi, Yi) 
        for XYPair in XY: 
            xyFrequency = XY[XYPair] 
            
            # calculate ((xyFrequency) C2) 
            samePointPairs = (xyFrequency * 
                             (xyFrequency - 1)) #// 2
            xyAns += samePointPairs
        #print(xAns, yAns, xyAns)
        return (xAns + yAns - xyAns) 
