def solution(a, b, n):
    tmp = 0
    
    while n >= a:
        tmp += (n//a)*b
        n = (n//a)*b + n%a

    return tmp