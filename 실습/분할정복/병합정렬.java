package 분할정복;

import java.util.Arrays;

	/*
	 * 병합 정렬 시간 복잡도가 O(NlogN)인 이유
	 * 원본 배열의 길이가 N이라 할 때,
	 * 재귀를 돌리는 횟수 logN
	 * 각 재귀마다 정렬하기 위해 조회하는 횟수 N
	 */

public class 병합정렬 {
	
	static int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};
	static int N = arr.length;
	static int[] tmp = new int[N];

	public static void main(String[] args) {
		
		mergeSort(0,N-1);
		
		System.out.println(Arrays.toString(arr));
		
	}

	private static void mergeSort(int L, int R) {
		
		if(L<R) {
			int mid = (L+R)/2;
			mergeSort(L, mid);
			mergeSort(mid+1, R);
			merge(L, mid, R);
			
		}
		
		
	}
	
	
	private static void merge(int L, int mid, int R) {
		int left = L;
		int right = mid+1;
		int idx = left;
		
		while(left<=mid && right<=R) {
			if(arr[left] < arr[right]) {
				tmp[idx++] = arr[left++];
			}else {
				tmp[idx++] = arr[right++];
			}
		}
		
		while(left<=mid) {
			tmp[idx++] = arr[left++];
		}
		while(right<=R) {
			tmp[idx++] = arr[right++];
		}
		
		
		for(int i=L ; i<=R ; i++) {
			arr[i] = tmp[i];
		}
		
	}

	

}
