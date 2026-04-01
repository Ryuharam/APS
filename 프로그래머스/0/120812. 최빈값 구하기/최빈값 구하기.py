def solution(array):
    max = 0
    ans = 0
    cnts = {};
    
    for a in array:
        cnts[a] = cnts.get(a, 0) + 1
        
        if(cnts[a] > max):
            max = cnts[a]
            ans = a
        elif(cnts[a] == max and a != ans):
            ans = -1
            
    return ans