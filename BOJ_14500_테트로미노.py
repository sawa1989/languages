import sys
input = sys.stdin.readline

# - ㅁ ㄴ 번개모양은 depth가 4인 dfs로 해결 가능
# 문제 바로 풀지말고, 생각하고 풀자...
def dfs(a, b, score, depth):
    global max_score
    if depth==4:
        if max_score <score:
            max_score=score
        return
    
    for k in range(4):
        ny = a + dy[k]
        nx = b + dx[k]

        if 0<=ny<n and 0<=nx<m and visited[ny][nx]==0:
            if depth==2:
                visited[ny][nx]=1
                dfs(ny, nx, score+graph[ny][nx], depth+1)
                visited[ny][nx]=0
                
            visited[ny][nx]=1
            dfs(a, b, score+graph[ny][nx], depth+1)
            visited[ny][nx]=0

# 노가다보다 더 좋은 방법이 있더라고....
# def dfs_except(a, b):
#     global max_score
#     temp=graph[a][b]

#     for k in range(4):
#         if k==0:
#             continue
#         ny = a + dy[k]
#         nx = b + dx[k]
#         if 0<=ny<n and 0<=nx<m:
#             temp+=graph[ny][nx]
#     if temp>max_score:
#         max_score=temp
    
#     temp=graph[a][b]
#     for k in range(4):
#         if k==1:
#             continue
#         ny = a + dy[k]
#         nx = b + dx[k]
#         if 0<=ny<n and 0<=nx<m:
#             temp+=graph[ny][nx]
#     if temp>max_score:
#         max_score=temp

#     temp=graph[a][b]
#     for k in range(4):
#         if k==2:
#             continue
#         ny = a + dy[k]
#         nx = b + dx[k]
#         if 0<=ny<n and 0<=nx<m:
#             temp+=graph[ny][nx]
#     if temp>max_score:
#         max_score=temp

#     temp=graph[a][b]
#     for k in range(4):
#         if k==3:
#             continue
#         ny = a + dy[k]
#         nx = b + dx[k]
#         if 0<=ny<n and 0<=nx<m:
#             temp+=graph[ny][nx]
#     if temp>max_score:
#         max_score=temp
            
n, m = map(int, sys.stdin.readline().split())
graph = []
for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
visited = [[0] * m for _ in range(n) ]
max_score = 0

for i in range(n):
    for j in range(m):
        visited[i][j]=1 # 시작점 제거... 이것때문에 또 한세월보냄...
        dfs(i, j, graph[i][j], 1)
        # dfs_except(i, j)
        visited[i][j]=0 # 시작점 제거및 풀어주기... 이것때문에 또 한세월보냄...

print(max_score)
