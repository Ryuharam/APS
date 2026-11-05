def solution(A,B):
    answer = 0
    N = len(A)
    
    A.sort()
    B.sort(reverse=True)
    
    for i in range(N):
        answer += A[i] * B[i]

    return answer