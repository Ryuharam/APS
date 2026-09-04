from itertools import permutations
# n : 외벽의 둘레
# weak : 취약점 위치 배열, 오름차순
#   - 1 <= len(weak) <= 15
#   - 0 <= weak[i] <= n-1
# dist : 친구들이 이동 할 수 있는 거리
#   - 1 <= len(dist) <= 8
#   - 1 <= dist[i] <= 100

def solution(n, weak, dist):
    W = len(weak)
    D = len(dist)
    
    dist = sorted(dist, reverse=True)
    weak += [n+w for w in weak]
    
    # f_max : 최대 동원할 친구 수
    for f_max in range(1, D+1):
        for friend in list(permutations(dist, f_max)):
        
            # start : 점검 시작할 weak 인덱스
            for start in range(W):
                # f_idx : 친구 인덱스
                f_idx = 0

                # end : f_idx 번째 친구가 멈출 위치
                end = weak[start] + friend[f_idx]

                # i 번째 weak 가 점검 가능한 지 확인 -> 범위 주의
                # 시작점(start) 부터 +W 만큼만 고려하면 됨
                for i in range(start, start + W):
                    if end < weak[i]:
                        # 점검 불가, 다음 친구
                        f_idx += 1

                        # 최대 동원 가능 친구 수를 초과 or 다음 친구 없음
                        if f_idx + 1 > f_max or f_idx >= D:
                            break

                        # 새 친구가 멈출 위치
                        end = weak[i] + friend[f_idx]


                if f_idx + 1 <= f_max:
                    return f_max
                    
    return -1