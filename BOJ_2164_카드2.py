import sys
from collections import deque

n = int(sys.stdin.readline())
queue = deque()

for i in range(1, n+1):
    queue.append(i)
# print(queue)

while True:
    if len(queue) ==1:
        print(queue.popleft())
        break
    queue.popleft()
    x = queue.popleft()
    queue.append(x)
    #print(queue)

    

    
