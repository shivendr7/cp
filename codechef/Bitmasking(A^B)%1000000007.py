mod=1000000007

def power(a, b):
    res=1
    while b>0:
        if b&1:
            res*=a
            res%=mod
        a*=a
        a%=mod
        b//=2
    return res
    
for t in range(int(input())):
    N=int(input())-1
    
    print(power(2, N))
