class Node:
    def __init__(self, i):
        self.n = i
        self.prev = i-1
        self.next = i+1
        self.state = 'O'
    

def solution(n, k, cmds):
    states = list(Node(i) for i in range(n))
    removed = list()
    
    for cmd in cmds:
        c = cmd.split()
        
        if c[0] == 'U':
            for _ in range(int(c[1])):
                k = states[k].prev
        elif c[0] == 'D':
            for _ in range(int(c[1])):
                k = states[k].next
        elif c[0] == 'C':
            prev = states[k].prev
            next = states[k].next
            
            states[k].state = 'X'
            removed.append(k)
            
            if prev >= 0:
                states[prev].next = states[k].next
            if next < n:
                states[next].prev = states[k].prev
            
            if next == n:
                k = prev
            else:
                k = next
            
        else:
            idx = removed.pop()
            states[idx].state = 'O'
            prev = states[idx].prev
            next = states[idx].next
            
            if prev >= 0:
                states[prev].next = idx
            if next < n:
                states[next].prev = idx
        
    
    res = ['O' for _ in range(n)]
    for r in removed:
        res[r] = 'X'
    
    return "".join(res)