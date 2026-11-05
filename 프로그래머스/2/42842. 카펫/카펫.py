def solution(brown, yellow):
    for c in range(1, 5000):
        r = (brown - c*2) // 2 + 2

        if r * c == brown + yellow:
            return [r, c]
    