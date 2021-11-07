"""
A rabbit is initially at 0 on the number line. Now it starts jumping. if it is at position X then a jump takes it to position X+K on the number line. 
The rabbit is going to jump N times. You need to print M numbers A0, A1, A2, A3...AM-1, where Ai is the number of times it will be at position X where X%M=i


INPUT
first line has T as no. of test cases.
1<=T<=100

each test case contains three integers N, K, M
1<=N<=10^12
1<=K, M<=1000


OUTPUT
For each test case, printa single line containing M space-separated integers A0, A1, A2..AM-1

"""

n,k,m=map(int,input().split())
ans=[0]*m
if(n<m):
    for i in range(n+1):
        ans[(i*k)%m]+=1
    print(ans)
else:
    #taking m steps
    for i in range(m):
        ans[(i*k)%m]+=1
        
    #repeating m steps
    for i in range(m):
        ans[i]=ans[i]*(n//m)
        
    #taking n%m steps
    for i in range((n%m)+1):
        ans[(i*k)%m]+=1
    print(ans)
