from collections import deque

n = int(input())
area = []
maxHeight = 0

for i in range(n):
    area.append(list(map(int, input().split())))
    for j in range(n):
        if area[i][j] > maxHeight:
            maxHeight = area[i][j]

dx = [0,0,1,-1]
dy = [1, -1, 0, 0]
def bfs(start_x, start_y, height,  visited):
    q = deque()
    q.append((start_x, start_y))
    visited[start_x][start_y]=1

    while q:
        x,y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y +dy[i]

            if 0<=nx<n and 0<=ny<n:
                if area[nx][ny]> height and visited[nx][ny]==0:
                    visited[nx][ny]=1
                    q.append((nx,ny))

result=0
for h in range(maxHeight):
    visited = [[0]* n for i in range(n)]
    
    temp_cnt=0

    for i in range(n):
        for j in range(n):
            if visited[i][j] ==0 and area[i][j]>h:
                bfs(i, j, h, visited)
                temp_cnt+=1
    
    if temp_cnt > result:
        result=temp_cnt
    
    

print(result)
                

            
