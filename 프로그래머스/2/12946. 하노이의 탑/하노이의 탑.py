answer = []
def solution(n):
    
    move(1, 3, 2, n)
    
    return answer

def move(start, end, mid, n):
    global answer
    if n <= 0:
        return
    
    move(start, mid, end, n-1)
    
    answer.append([start, end])
    
    move(mid, end, start, n-1)
        
    