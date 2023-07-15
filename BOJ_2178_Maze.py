from collections import deque

N, M = map(int, input().split())
maze =[]
dx = [ 0, 0,1,-1]
dy = [1, -1, 0, 0]

for i in  range(N):
    maze.append(list(map(int, input())))

queue = deque([(0,0)])

while queue:
    x, y = queue.popleft()
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if 0 <= nx < N and 0 <= ny <M:
            if maze[nx][ny] ==1:
                queue.append((nx, ny))
                maze[nx][ny] =maze[x][y]+1

print(maze[N-1][M-1])
