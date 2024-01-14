from collections import deque

n, k = map(int, input().split())
flag = 0
answer=0

for i in range(1, n+1):
    if n % i == 0:
        flag+=1
    if flag == k:
        answer=i
        #print("%d %d" %(flag, i))
        break

if flag >= k:
    print(answer)
else:
    print(0)
