from collections import deque
n = int(input())
q_A, q_B =map(int, input().split())
m = int(input())
result = []

graph = [[] for i in range(n+1)]
visited=[0]*(n+1)

for i in range(m):
    a, b = map(int, input().split())
    graph[a]+=[b]
    graph[b]+=[a]

def dfs(v, num):
    num += 1
    visited[v] = 1

    if v==q_B:
        result.append(num)

    for i in graph[v]:
        if visited[i]==0:
            dfs(i, num)
    

dfs(q_A, 0)
if len(result)==0:
    print(-1)
else:
    print(result[0]-1)
