"""
Reduce an array of size N to an array of size K using following operation.
In each reduction, two consecutive array elements are added to form a new element in their place.

Cost of each N to K reduction is the max element in resulting array.
Minimise the cost and output the least cost possible.

Eg1
N=5
a[]=7,2,6,4,5
K=4

7,2,6,4,5 => 9,6,4,5 => 9
7,2,6,4,5 => 7,8,4,5 => 8
7,2,6,4,5 => 7,2,10,5 =>10
7,2,6,4,5 => 7,2,6,9 => 9

output=8

Eg2
N=5
a[]=6,1,5,3,7
K=3

6,1,5,3,7 => 7,5,3,7 => 12,3,7 => 12 cost
6,1,5,3,7 => 7,5,3,7 => 7,8,7 => 8 cost
6,1,5,3,7 => 7,5,3,7 => 7,5,10 => 10 cost
6,1,5,3,7 => 6,6,3,7 => 6,9,7 => 9
6,1,5,3,7 => 6,1,8,7 => 6,1,15 => 15 cost

ans=8
"""

n=int(input())
a=list(map(int, input().split()))
k=int(input())
print(a)
dp=[[[-1 for k in range(100)] for i in range(100)] for j in range(100)]

def DP(a, i, k, s):
    n=len(a)
    if i==n-k or k==0:
        return 0
    try:
        if i>=0 and n-k>=0 and dp[i][k][k]!=-1:
            return dp[i][k][k]
    except Exception as e:
        print(e, i, n-k, n)
        return 0
    res=10**9
    for itr in range(i, k):
        if itr==i:
            res=min(res, max(a[itr]+a[itr+1], DP(a, itr+1, k-1, a[itr+1]+s)))
        else:
            res=min(res, max(a[itr]+a[itr+1], DP(a, itr+1, k-1, a[itr]+a[itr+1])))
        #print(i, itr, res, n-k)
    dp[i][k][k]=res
    return res

print(DP(a, 0, k, 0))
