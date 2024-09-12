package 그래프비용1;

/*
 *  서로소 집합(Disjoint-sets)
 *  - 상호 배타 집합 : 
 *  	- 중복 포함된 원소가 없는 집합 -> 교집합이 없음
 *  	- 각 집합은 대표자를 통해 구분
 *  - 상호 배타 집합 표현 방법
 *  	- 연결 리스트
 *  	- 트리 (배열)
 *  - 상호 배타 집합 연산
 *  	- Make-Set(x) : x를 대표로 하는 집합 생성
 *  	- Find-Set(x) : x가 속한 대표 리턴
 *  	- Union(x,y) : x와 y의 집합을 하나로. Find-Set으로 대표를 찾아서 대표를 합친다
 *  - 상호 배타 집합 표현 : 연결 리스트
 *  	- 같은 집합의 원소들은 하나의 연결 리스트로 관리
 *  	- 연결리스트의 맨 앞의 원소를 집합의 대표자로 결정
 *  	- 각 원소는 집합의 대표원소를 가리키는 링크를 갖는다
 *  - 상호 배타 집합 표현 : 트리
 *  	- 하나의 집합을 하나의 트리로 표현한다.
 *  	- 자식 노드가 부모 노드를 가리키며 루트 노드가 대표자가 된다.
 *  	ex) Make-Set(a) ~ Make-Set(f) : 대표 배열 -> {a,b,c,d,e,f}
 *  	ex) Union(c,d), Union(e,f) : {a,b,c,c,e,e}
 *  - 상호 배타 집합 연산
 *  	- Make-Set(x) : 유일한 멤버 x를 포함하는 새로운 집합을 생성하는 연산
 *  		Make-Set(x)
 *  			p[x] <- x
 *  	- Find-Set(x) : x를 포함하는 집합을 찾는 연산
 *  		if x == p[x] : return x
 *  		else return Find-Set(p[x])
 *  	- Union(x,y) : x와 y를 포함하는 두 집합을 통합하는 연산
 *  		Union(x,y)
 *  			p[find-Set(y)] <- Find-Set(x)
 * 		=> Find-Set 하면 매번 찾아가야하는 문제 있다
 *  - 연산의 효율을 높이는 방법
 *  	- Rank를 이용한 Union
 *  		- 각 노드는 자신을 루트로 하는 Subtree의 높이를 랭크(rank)라는 이름으로 저장
 *  		- 두 집합을 Union 할 때 rank가 낮은 집합을 높은 집합에 붙인다
 *  		ex) 두 대표자의 rank가 다른 경우 : rank가 낮은 대표자를 높은 대표자에 붙인다
 *  			두 대표자의 rank가 같을 경우 : 아무 대표자에 붙이고 그 대표자의 rank 1 올리기
 *  		- Make-Set()
 *  			- 유일한 멤버 x를 포함하는 새로운 집합을 생성하는 연산
 *  			- 반복문을 이용하여 간소화
 *  				p[x] : 노드 x의 부모 저장
 *  				rank[x] : 루트 노드가 x인 트리의 랭크 값 저장
 *  				
 *  				Make-Set(x)
 *  					p[x] <- x
 *  					rank[x] <- 0 : new rank = int[] 하면 매번 초기화 할 필요 없음
 *  		- Find-Set()
 *  			- Find-Set(x) : x를 포함하는 집합을 찾는 연산
 *  			- 특정 노드에서 루트 노드까지의 경로를 찾아 가면서 노드 부모의 정보를 갱신
 *  				Find-Set(x)
 *  					if x != p[x] : 
 *  						p[x] <- Find-Set(p[x])
 *  					Retrun p[x]
 *  		- Union()
 *  			- Union(x,y) : x와 y를 포함하는 두 집합을 합하는 연산
 *  				Union(x,y)
 *  					if rank[x] > rank[y] :
 *  						p[y] <- x
 *  					Else
 *  						p[x] <- y
 *  						if rank[x] == rank[y] : 
 *  							rank[y]++
 *  	- Path Compression
 *  		- Find-Set을 행하는 과정에서 만나는 모든 노드들이 직접 대표를 가리키도록 수정한다
 *  			
 */

public class 서로소집합 {

	public static void main(String[] args) {
		
		
		
		
		
	}

}
