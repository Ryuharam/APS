def solution(ingredient):
    answer = 0

    ingred = []
    
    for i in ingredient:
        ingred.append(i)
        
        if  len(ingred) >= 4 and ingred[-4:] == [1, 2, 3, 1]:
            for _ in range(4):
                ingred.pop()
            answer += 1
    
    return answer