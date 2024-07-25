# 아 ... 시간초과 계속 나서 찾아봤더니... sys.stdin.readline였음...^^;;
import sys
input = sys.stdin.readline

N, C = map(int, input().split())
x_axis = [int(input()) for i in range(N)]
x_axis.sort()

start =1
end = x_axis[-1] - x_axis[0]
result =0

# 공유기 거리가 이분탐색이라니... 이분탁샘은 쉬운데, 아이디어를 생각도 못했다..
while ( start <= end):
    mid = (start + end)//2
    current_x = x_axis[0]
    count =1

    for i in range(1, len(x_axis)):
        if x_axis[i] >= current_x + mid :
            count+=1
            current_x = x_axis[i]
    
    if count >= C:
        start = mid+1
        result = mid
    else: 
        end = mid-1

print(result)
