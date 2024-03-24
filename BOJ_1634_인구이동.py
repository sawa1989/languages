import sys
from collections import deque

n, l, r = map(int, sys.stdin.readline().split())
graph = []
for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(a, b):
    queue = deque()
    union = []
    queue.append((a,b))
    union.append((a,b))

    while queue:
        y, x = queue.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0<=nx<n and 0<=ny<n and visited[ny][nx]==0:
                if l<=abs(graph[ny][nx]-graph[y][x])<=r:
                    visited[ny][nx]=1
                    queue.append((ny,nx))
                    union.append((ny,nx))
                    
    return union

result =0
while True:
    visited = [[0 for _ in range(n)] for _ in range(n)]
    flag = 0
    for i in range(n):
        for j in range(n):
            if visited[i][j]==0:
                visited[i][j]=1
                set_union = bfs(i, j)
                
                if len(set_union) > 1:
                    flag=1
                    # //를 사용하면 소수점 이하를 버림, /를 사용하면 부동 소수점 결과를 얻음.
                    # 해당 부분을 몰라서 한참 헤맸다..ㅠㅠ
                    avg = sum(graph[y][x] for y,x in set_union) // len(set_union)
                    for y,x in set_union:
                        graph[y][x] = avg
    if flag==0:
        break
    result+=1
print(result)


