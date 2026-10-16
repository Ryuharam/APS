def solution(numbers):
    n = len(numbers)
    
    answer = [-1 for _ in range(n)]
    
    stack = []
    
    for idx1, num in enumerate(numbers):
        while stack and stack[-1][1] < num:
            idx2, prev = stack.pop()
            answer[idx2] = num
        stack.append([idx1, num])
            
    
    return answer