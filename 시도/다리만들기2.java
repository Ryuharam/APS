// 2차원 배열 순회하면서 섬을 만날 때마다 count : 2 ~ 저장해주기
// -> 섬은 1로 표현되는데 각 섬을 구분하기 위해 같은 섬은 22222... , 33333... 이런식으로 써주기
// 최종 count-2 가 섬의 개수
// 각 열, 행 순회하면서 그 행(열)이 다리가 될 수 있는지 판단하고, 최소 길이 저장
// 다리들 다 저장하고 최소비용신장트리
