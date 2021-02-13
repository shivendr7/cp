/*
link-https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram/1/?undefined#

Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have the same width and the width is 1 unit.

Example 1:

Input:
N = 7
arr[] = {6,2,5,4,5,1,6}
Output: 12
Explanation: 


Example 2:

Input:
N = 8
arr[] = {7 2 8 9 1 3 6 5}
Output: 16
Explanation: Maximum size of the histogram 
will be 8  and there will be 2 consecutive 
histogram. And hence the area of the 
histogram will be 8x2 = 16.
Your Task:
The task is to complete the function getMaxArea() which takes the array arr[] and its size N as inputs and finds the largest rectangular area possible and returns the answer.

Expected Time Complxity : O(N)
Expected Auxilliary Space : O(N)

Constraints:
1 <= N <= 106

*/
//sol
def firstMinRight(h):
    stack=[0]
    top=0
    ans=[0 for i in range(len(h))]
    for i in range(1,len(h)):
        while top>=0 and h[stack[top]]>h[i]:
            ans[stack[top]]=i
            top-=1
        if top==len(stack)-1:
            stack.append(i)
            top+=1
        else:
            stack[top+1]=i
            top+=1
    while top>=0 and len(stack)>0:
        ans[stack[top]]=-1
        top-=1 
    return(ans)    

def firstMinLeft(h):
    stack=[len(h)-1]
    top=0
    ans=[0 for i in range(len(h))]
    for i in range(len(h)-1,-1,-1):
        while top>=0 and h[stack[top]]>h[i]:
            ans[stack[top]]=i
            top-=1
        if top==len(stack)-1:
            stack.append(i)
            top+=1
        else:
            stack[top+1]=i
            top+=1
    while top>=0 and len(stack)>0:
        ans[stack[top]]=-1
        top-=1
    return(ans)   

def getMaxArea(h):
    #code here
    minR=firstMinRight(h)
    minL=firstMinLeft(h)
    maxar=0
    #print(minL,minR)
    for i in range(len(h)):
        if minR[i]>-1 and minL[i]>-1:
            #height=max(h[minR[i]],h[minL[i]])
            width=minR[i]-minL[i]-1
            maxar=max(maxar,h[i]*width)
            
        else:
            if minR[i]==-1 and minL[i]==-1:
                width=len(h)
                maxar=max(maxar,h[i]*width)
            elif minR[i]==-1:
                width=len(h)-minL[i]-1
                maxar=max(maxar,h[i]*width)
                #print(maxar)
            else:
                width=minR[i]
                maxar=max(maxar,h[i]*width)
                
    return maxar
