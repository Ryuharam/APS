def solution(s):
    answer = 1
    n = len(s)
    
    def check(left, right, cnt):
        
        while 0 <= left and right < n and s[left] == s[right]:
            cnt += 2
            left -= 1
            right += 1
        
        return cnt
    
    for i in range(n):
        answer = max(answer, check(i-1, i+1, 1))
        answer = max(answer, check(i, i+1, 0))
        
        
    return answer

