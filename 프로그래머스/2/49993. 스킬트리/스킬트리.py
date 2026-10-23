def solution(skill, skill_trees):
    answer = 0
    
    for skill_tree in skill_trees:
        word = [s for s in skill_tree if s in skill]
        
        idx = 0
        flag = True
        
        while idx < len(skill) and idx < len(word):
            if word[idx] != skill[idx]:
                flag = False
                break
            idx += 1
        
        if flag:
            answer += 1
    
    return answer