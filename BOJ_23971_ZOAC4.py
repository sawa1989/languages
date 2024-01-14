import math

h,w,n,m = map(int, input().split())

how_much_h = math.ceil(h/(n+1))
how_much_w = math.ceil(w/(m+1))

print(how_much_w*how_much_h)
