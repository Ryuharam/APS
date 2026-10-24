def solution(s):
    s = '#'+'#'.join(s)+'#'
    n = len(s)
    p = [0] * n
    
    answer = 0

    C = 0
    R = 0
    
    for i in range(n):
        if i < R:
            m_i = 2 * C - i
            p[i] = min(p[m_i], R - i)
        
        left = i - p[i] - 1
        right = i + p[i] + 1
        
        while 0 <= left and right < n and s[left] == s[right]:
            p[i] += 1
            left -= 1
            right += 1
            
        if answer <= p[i]:
            C = i
            R = i + p[i]
            answer = p[i]
    return answer