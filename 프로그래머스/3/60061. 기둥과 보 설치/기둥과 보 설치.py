# input
# 5 <= n <= 100
# 1 <= len(build_frame) <= 1000
# len(build_frame[0]) = 4
# [x, y, a, b]
# a -> 0: 기둥, 1: 보
# b -> 0: 삭제, 1: 설치

def solution(n, build_frame):
    # 기둥
    columns = [[False for _ in range(n+1)] for _ in range(n+1)]
    # 보
    beams = [[False for _ in range(n+1)] for _ in range(n+1)]
    
    for x, y, a, b in build_frame:
        if b == 0:
            # 삭제
            if a == 0:
                # 기둥 삭제
                # 위에 기둥 있지만 연결된 보가 없을때
                if (y<n and columns[x][y+1]) and ((x==0 or y==n or not beams[x-1][y+1]) and (y==n or not beams[x][y+1])):
                    continue
                # 왼쪽 위에 보가 있는데 다른 쪽 끝에 기둥이 없거나 양 끝이 보랑 연결이 안되어 있을때
                elif (x>0 and y<n and beams[x-1][y+1]) and (not columns[x-1][y] and (x<=1 or not beams[x-2][y+1] or not beams[x][y+1])):
                    continue
                # 위에 보가 있는데 다른쪽 끝에 기둥이 없거나 양 끝이 보랑 연결이 안되어 있을때
                elif (y<n and beams[x][y+1]) and ((x>=n or not columns[x+1][y]) and ((x<=0 or not beams[x-1][y+1]) or (x+1 >= n or not beams[x+1][y+1]))):
                    continue
                else:
                    columns[x][y] = False
            else:
                # 보 삭제
                # 보 위에 기둥이 존재하는데 아래 기둥이 없고 왼쪽에 보가 없을떄
                if (y<n and columns[x][y]) and not columns[x][y-1] and (x==0 or not beams[x-1][y]):
                    continue
                # 보 오른쪽 옆의 위에 기둥이 존재하는데 아래 기둥이 없고 오른쪽에 보가 없을때
                elif (y<n and columns[x+1][y]) and not columns[x+1][y-1] and (x+2>n or not beams[x+1][y]):
                    continue
                # 보 왼쪽에 보가 존재하는데 양쪽 밑에 기둥이 없을떄
                elif (x>0 and beams[x-1][y]) and not columns[x-1][y-1] and not columns[x][y-1]:
                    continue
                # 보 오른쪽에 보가 존재하는데 양쪽 밑에 기둥이 없을때
                elif (x+2 <= n and beams[x+1][y]) and not columns[x+1][y-1] and not columns[x+2][y-1]:
                    continue
                else:
                    beams[x][y] = False
        else:
            # 설치
            if a == 0:
                # 기둥 설치
                # 바닥 위 or 기둥 위 or 보의 한 쪽 끝
                if y == 0 or (y>0 and columns[x][y-1]) or (x>0 and beams[x-1][y]) or beams[x][y]:
                    columns[x][y] = True
            else:
                # 보 설치
                # 한쪽 끝 기둥 위 or 양쪽 끝이 다른 보와 동시에 연결
                if (y>0 and columns[x][y-1]) or (x<n and y>0 and columns[x+1][y-1]) or (x>0 and beams[x-1][y] and x<n and beams[x+1][y]):
                    beams[x][y] = True
    
    
    answer = []
    
    for i in range(n+1):
        for j in range(n+1):
            if columns[i][j]:
                answer.append([i,j,0])
            if beams[i][j]:
                answer.append([i,j,1])
    return answer