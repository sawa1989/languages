from collections import deque
n = int(input())
v = int(input())

graph = [[] for i in range(n+1)]
visited = [0] * (n+1)

for i in range(v):
    a, b = map( int, input().split())
    # 양방향
    graph[a]+=[b] # a -> b
    graph[b]+=[a] # b -> a

visited[1]=1
q = deque([1])
while q:
    c = q.popleft()
    for n_x in graph[c]:
        if visited[n_x]==0:
            q.append(n_x)
            visited[n_x]=1

print(sum(visited)-1)
